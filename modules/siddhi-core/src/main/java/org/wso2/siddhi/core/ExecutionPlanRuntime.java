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
import org.wso2.siddhi.core.exception.QueryNotExistException;
import org.wso2.siddhi.core.query.PartitionRuntime;
import org.wso2.siddhi.core.query.QueryRuntime;
import org.wso2.siddhi.core.query.output.callback.InsertIntoStreamCallback;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.output.StreamCallback;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.query.Query;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ExecutionPlanRuntime {
    private ConcurrentMap<String, AbstractDefinition> streamDefinitionMap = new ConcurrentHashMap<String, AbstractDefinition>(); //contains stream definition
    private ConcurrentMap<String, InputHandler> inputHandlerMap = new ConcurrentHashMap<String, InputHandler>();
    private ConcurrentMap<String, QueryRuntime> queryProcessorMap = new ConcurrentHashMap<String, QueryRuntime>();
    private ConcurrentMap<String, StreamJunction> streamJunctionMap = new ConcurrentHashMap<String, StreamJunction>(); //contains stream junctions
    private ConcurrentMap<String, PartitionRuntime> partitionMap = new ConcurrentHashMap<String, PartitionRuntime>(); //contains partitions
    private SiddhiContext siddhiContext;

    public ExecutionPlanRuntime(SiddhiContext siddhiContext) {
        this.siddhiContext = siddhiContext;
    }

    public InputHandler defineStream(StreamDefinition streamDefinition) {
        if (inputHandlerMap.get(streamDefinition.getId()) == null) {
            streamDefinitionMap.put(streamDefinition.getId(), streamDefinition);
            StreamJunction streamJunction = streamJunctionMap.get(streamDefinition.getId());
            if (streamJunction == null) {
                streamJunction = new StreamJunction(streamDefinition.getId(), siddhiContext.getExecutorService());
                streamJunctionMap.put(streamDefinition.getId(), streamJunction);
            }
            InputHandler inputHandler = new InputHandler(streamDefinition.getId(), streamJunction, siddhiContext);
            inputHandlerMap.put(streamDefinition.getId(), inputHandler);
            return inputHandler;
        } else {
            return inputHandlerMap.get(streamDefinition.getId());
        }

    }

    public void addPartition(Partition partition) {
        PartitionRuntime partitionRuntime = new PartitionRuntime(this,partition, streamDefinitionMap,streamJunctionMap,inputHandlerMap,siddhiContext);
        partitionMap.put(partitionRuntime.getPartitionId(), partitionRuntime);
    }

    public String addQuery(Query query) {
        QueryRuntime queryRuntime = new QueryRuntime(query, streamDefinitionMap, streamJunctionMap, null, siddhiContext, null);
        queryProcessorMap.put(queryRuntime.getQueryId(), queryRuntime);
        OutputCallback outputCallback = queryRuntime.getOutputCallback();
        if (outputCallback != null && outputCallback instanceof InsertIntoStreamCallback) {
            defineStream(((InsertIntoStreamCallback) outputCallback).getOutputStreamDefinition());
        }
        return queryRuntime.getQueryId();
    }




    public void addCallback(String streamId, StreamCallback streamCallback) {
        streamCallback.setStreamId(streamId);
        StreamJunction streamJunction = streamJunctionMap.get(streamId);
        if (streamJunction == null) {
            streamJunction = new StreamJunction(streamId, siddhiContext.getExecutorService());
            streamJunctionMap.put(streamId, streamJunction);
        }
        streamJunction.addEventFlow(streamCallback);
    }

    public void addCallback(String queryName, QueryCallback callback) {

        QueryRuntime queryRuntime = queryProcessorMap.get(queryName);
        if (queryRuntime == null) {
            throw new QueryNotExistException("No query fund for " + queryName);
        }
        callback.setStreamDefinition(queryRuntime.getOutputStreamDefinition());
        queryRuntime.addCallback(callback);

    }

    public InputHandler getInputHandler(String streamId) {
        return inputHandlerMap.get(streamId);
    }

    public void removeQuery(Query query) {
//        QueryRuntime queryRuntime = queryProcessorMap.remove(query.getPropertyValue("name"));
//        if (queryRuntime != null) {
//            queryRuntime.removeQuery(streamJunctionMap, streamDefinitionMap);
//        }
    }

    public void removeStreams() {
        for(String streamId:streamJunctionMap.keySet()){
            streamJunctionMap.get(streamId).removeEventFlows();
        }
        streamDefinitionMap.clear();
        streamJunctionMap.clear();
        inputHandlerMap.clear();

    }

    public void removePartition(Partition partition){
//        PartitionRuntime partitionRuntime = partitionMap.remove(partition.getPropertyValue("name"));
//        if (partitionRuntime != null) {
//            partitionRuntime.removePartition(streamJunctionMap, streamDefinitionMap);
//        }
    }
}
