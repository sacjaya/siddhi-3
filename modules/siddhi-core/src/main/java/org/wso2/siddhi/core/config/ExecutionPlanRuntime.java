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

package org.wso2.siddhi.core.config;

import org.wso2.siddhi.core.exception.DifferentDefinitionAlreadyExistException;
import org.wso2.siddhi.core.query.ExecutionRuntime;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.input.InputHandler;
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
    private ConcurrentMap<String, Partition> partitionMap = new ConcurrentHashMap<String,Partition>();
    private ConcurrentMap<String, StreamJunction> streamJunctionMap = new ConcurrentHashMap<String, StreamJunction>(); //contains definition
    private List<Partition> partitionList = new ArrayList<Partition>();


    private SiddhiContext siddhiContext;
//    private ConcurrentMap<String, Callback> callBck = new ConcurrentHashMap<String,Partition>();

   public ExecutionPlanRuntime(SiddhiContext siddhiContext){
       this.siddhiContext = siddhiContext;
   }



    public void shutdown() {

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
        //TODO: for a lis of queries
        Query query = partition.getQuery();
        if(query !=null){
            addQuery(query,partition);
        }

    }

    public String addQuery(Query query) {
        ExecutionRuntime executionRuntime = new ExecutionRuntime(query, streamDefinitionMap, streamJunctionMap, null,siddhiContext);
        queryProcessorMap.put(executionRuntime.getQueryId(), executionRuntime);
        return executionRuntime.getQueryId();
    }


    public String addQuery(Query query, Partition partition) {
        ExecutionRuntime executionRuntime = new ExecutionRuntime(query, streamDefinitionMap, streamJunctionMap, partition,siddhiContext);
        queryProcessorMap.put(executionRuntime.getQueryId(), executionRuntime);
        return executionRuntime.getQueryId();
    }

}
