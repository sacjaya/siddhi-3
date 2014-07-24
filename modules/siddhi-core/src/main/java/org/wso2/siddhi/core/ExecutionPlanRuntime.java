/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.DifferentDefinitionAlreadyExistException;
import org.wso2.siddhi.core.exception.QueryNotExistException;
import org.wso2.siddhi.core.query.ExecutionRuntime;
import org.wso2.siddhi.core.query.output.callback.InsertIntoStreamCallback;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.output.StreamCallback;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.definition.TableDefinition;
import org.wso2.siddhi.query.api.partition.Partition;
import org.wso2.siddhi.query.api.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ExecutionPlanRuntime {
    private ConcurrentMap<String, AbstractDefinition> streamDefinitionMap = new ConcurrentHashMap<String, AbstractDefinition>(); //contains stream definition
    private ConcurrentMap<String, InputHandler> inputHandlerMap = new ConcurrentHashMap<String, InputHandler>();
    private ConcurrentMap<String, ExecutionRuntime> queryProcessorMap = new ConcurrentHashMap<String, ExecutionRuntime>();
    private ConcurrentMap<String, StreamJunction> streamJunctionMap = new ConcurrentHashMap<String, StreamJunction>(); //contains definition
    private List<Partition> partitionList = new ArrayList<Partition>();


    private SiddhiContext siddhiContext;

   public ExecutionPlanRuntime(SiddhiContext siddhiContext){
       this.siddhiContext = siddhiContext;
   }

    public InputHandler defineStream(StreamDefinition streamDefinition) {
        if (!checkEventStreamExist(streamDefinition)) {
            streamDefinitionMap.put(streamDefinition.getId(), streamDefinition);
            StreamJunction streamJunction = streamJunctionMap.get(streamDefinition.getId());
            if (streamJunction == null) {
                streamJunction = new StreamJunction(streamDefinition.getId(), siddhiContext.getThreadPoolExecutor());
                streamJunctionMap.put(streamDefinition.getId(), streamJunction);
            }
            InputHandler inputHandler = new InputHandler(streamDefinition.getId(), streamJunction, siddhiContext);
            inputHandlerMap.put(streamDefinition.getId(), inputHandler);
            return inputHandler;
        } else {
            return inputHandlerMap.get(streamDefinition.getId());
        }

    }

    public void removeStream(String streamId) {
        AbstractDefinition abstractDefinition = streamDefinitionMap.get(streamId);
        if (abstractDefinition != null && abstractDefinition instanceof StreamDefinition) {
            streamDefinitionMap.remove(streamId);
            streamJunctionMap.remove(streamId);
            inputHandlerMap.remove(streamId);
        }
    }

    private boolean checkEventStreamExist(StreamDefinition newStreamDefinition) {
        AbstractDefinition definition = streamDefinitionMap.get(newStreamDefinition.getId());
        if (definition != null) {
            if (definition instanceof TableDefinition) {
                throw new DifferentDefinitionAlreadyExistException("Table " + newStreamDefinition.getId() + " is already defined as " + definition + ", hence cannot define " + newStreamDefinition);
            } else if (!definition.getAttributeList().equals(newStreamDefinition.getAttributeList())) {
                throw new DifferentDefinitionAlreadyExistException("Stream " + newStreamDefinition.getId() + " is already defined as " + definition + ", hence cannot define " + newStreamDefinition);
            } else {
                return true;
            }
        }
        return false;
    }

    public void definePartition(Partition partition) {
        partitionList.add(partition);
        //TODO: for a list of queries
        Query query = partition.getQuery();
        if(query !=null){
            addQuery(query,partition);
        }

    }

    public String addQuery(Query query) {
        ExecutionRuntime executionRuntime = new ExecutionRuntime(query, streamDefinitionMap, streamJunctionMap, null,siddhiContext);
        queryProcessorMap.put( executionRuntime.getQueryId(), executionRuntime);
        OutputCallback outputCallback = executionRuntime.getOutputCallback();
        if (outputCallback != null && outputCallback instanceof InsertIntoStreamCallback) {
            defineStream(((InsertIntoStreamCallback) outputCallback).getOutputStreamDefinition());
        }
        return executionRuntime.getQueryId();
    }


    private String addQuery(Query query, Partition partition) {
        ExecutionRuntime executionRuntime = new ExecutionRuntime(query, streamDefinitionMap, streamJunctionMap, partition,siddhiContext);
        queryProcessorMap.put(executionRuntime.getQueryId(), executionRuntime);
        OutputCallback outputCallback = executionRuntime.getOutputCallback();
        if (outputCallback != null && outputCallback instanceof InsertIntoStreamCallback) {
            defineStream(((InsertIntoStreamCallback) outputCallback).getOutputStreamDefinition());
        }
        return executionRuntime.getQueryId();
    }

    public void removeQuery(String queryName) {
        ExecutionRuntime executionRuntime = queryProcessorMap.remove(queryName);
        if (executionRuntime != null) {
            executionRuntime.removeQuery(streamJunctionMap, streamDefinitionMap);
        }
    }

    public void addCallback(String streamId, StreamCallback streamCallback) {
        streamCallback.setStreamId(streamId);
        StreamJunction streamJunction = streamJunctionMap.get(streamId);
        if (streamJunction == null) {
            streamJunction = new StreamJunction(streamId, siddhiContext.getThreadPoolExecutor());
            streamJunctionMap.put(streamId, streamJunction);
        }
        streamJunction.addEventFlow(streamCallback);
    }

    public void addCallback(String queryName, QueryCallback callback) {

        ExecutionRuntime executionRuntime = queryProcessorMap.get(queryName);
        if (executionRuntime == null) {
            throw new QueryNotExistException("No query fund for " + queryName);
        }
        callback.setStreamDefinition(executionRuntime.getOutputStreamDefinition());
        executionRuntime.addCallback(callback);

    }

    public InputHandler getInputHandler(String streamId) {
        return inputHandlerMap.get(streamId);
    }

    public StreamDefinition getStreamDefinition(String streamId) {
        AbstractDefinition abstractDefinition = streamDefinitionMap.get(streamId);
        if (abstractDefinition instanceof StreamDefinition) {
            return (StreamDefinition) abstractDefinition;
        } else {
            return null;
        }
    }

    public List<StreamDefinition> getStreamDefinitions() {
        List<StreamDefinition> streamDefinitions = new ArrayList<StreamDefinition>(streamDefinitionMap.size());
        for (AbstractDefinition abstractDefinition : streamDefinitionMap.values()) {
            if (abstractDefinition instanceof StreamDefinition) {
                streamDefinitions.add((StreamDefinition) abstractDefinition);
            }
        }
        return streamDefinitions;
    }



}
