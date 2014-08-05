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

package org.wso2.siddhi.core.query;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.DifferentDefinitionAlreadyExistException;
import org.wso2.siddhi.core.query.output.callback.InsertIntoStreamCallback;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.PartitionHandlerProcessor;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.definition.TableDefinition;
import org.wso2.siddhi.query.api.partition.Partition;
import org.wso2.siddhi.query.api.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PartitionRuntime {
    private String partitionId;
    private List<QueryRuntime> partitionedQueryRuntimeList = new CopyOnWriteArrayList<QueryRuntime>();
    private ConcurrentMap<String, StreamJunction> localStreamJunctionMap = new ConcurrentHashMap<String, StreamJunction>(); //contains definition
    private ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap = new ConcurrentHashMap<String, AbstractDefinition>(); //contains stream definition
    private SiddhiContext siddhiContext;
    private ConcurrentMap<String, AbstractDefinition> streamDefinitionMap;
    private ConcurrentMap<String, StreamJunction> streamJunctionMap;
    private ConcurrentMap<String,QueryRuntime> metaQueryProcessorMap = new ConcurrentHashMap<String, QueryRuntime>();
    private ConcurrentMap<String, InputHandler> inputHandlerMap;
    private ConcurrentMap<String,PartitionInstanceRuntime> partitionInstanceRuntimeMap = new ConcurrentHashMap<String, PartitionInstanceRuntime>();
    private List<HandlerProcessor> handlerProcessors = new ArrayList<HandlerProcessor>();
    private Partition partition;


    public PartitionRuntime(Partition partition, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, StreamJunction> streamJunctionMap, ConcurrentMap<String, InputHandler> inputHandlerMap, SiddhiContext siddhiContext) {
        if (partition.getPropertyValue("name") == null) {
           partition.property("name", UUID.randomUUID().toString());
        }

        this.partitionId = partition.getPropertyValue("name");
        this.streamDefinitionMap = streamDefinitionMap;
        this.streamJunctionMap = streamJunctionMap;
        this.inputHandlerMap = inputHandlerMap;
        this.partition = partition;
        this.siddhiContext = siddhiContext;
        for (Query query : partition.getQueryList()) {
            addQuery(query);
        }
    }


    private QueryRuntime addQuery(Query query) {

        QueryRuntime queryRuntime = new QueryRuntime(query, streamDefinitionMap, streamJunctionMap, partition, siddhiContext, this);
        metaQueryProcessorMap.put(queryRuntime.getQueryId(), queryRuntime);
        OutputCallback outputCallback = queryRuntime.getOutputCallback();
        if (queryRuntime.isToLocalStream()) {
            if (outputCallback != null && outputCallback instanceof InsertIntoStreamCallback) {
                defineLocalStream(((InsertIntoStreamCallback) outputCallback).getOutputStreamDefinition());
            }
        } else {
            if (outputCallback != null && outputCallback instanceof InsertIntoStreamCallback) {
               defineStream(((InsertIntoStreamCallback) outputCallback).getOutputStreamDefinition());
            }

        }
        return queryRuntime;
    }


    public PartitionInstanceRuntime getPartitionInstanceRuntime(String key){
        return partitionInstanceRuntimeMap.get(key);
    }

    public void addPartitionInstance(String queryId,PartitionInstanceRuntime partitionInstanceRuntime){
          partitionInstanceRuntimeMap.put(queryId,partitionInstanceRuntime);
    }

    public void addStreamJunction(String key,StreamJunction streamJunction){
        localStreamJunctionMap.put(key, streamJunction);
    }

    public StreamJunction getStreamJunction(String key){
        return localStreamJunctionMap.get(key);
    }

    public String getPartitionId() {
        return partitionId;
    }

    public ConcurrentMap<String, StreamJunction> getLocalStreamJunctionMap(){
        return localStreamJunctionMap;

    }

    public ConcurrentMap<String, AbstractDefinition> getLocalStreamDefinitionMap(){
        return localStreamDefinitionMap;

    }

    public void addHandlerProcessors(HandlerProcessor handlerProcessor){
        handlerProcessors.add(handlerProcessor);
        streamJunctionMap.get(handlerProcessor.getStreamId()).addEventFlow(handlerProcessor);
    }

    public void defineLocalStream(StreamDefinition streamDefinition) {
        if (!checkEventStreamExist(streamDefinition,localStreamDefinitionMap)) {
            localStreamDefinitionMap.put(streamDefinition.getId(), streamDefinition);
            StreamJunction streamJunction = localStreamJunctionMap.get(streamDefinition.getId());
            if (streamJunction == null) {
                streamJunction = new StreamJunction(streamDefinition.getId(), siddhiContext.getThreadPoolExecutor());
                localStreamJunctionMap.putIfAbsent(streamDefinition.getId(), streamJunction);
            }
        }
    }


    public InputHandler defineStream(StreamDefinition streamDefinition) {
        if (!checkEventStreamExist(streamDefinition,streamDefinitionMap)) {
            streamDefinitionMap.put(streamDefinition.getId(), streamDefinition);
            StreamJunction streamJunction = streamJunctionMap.get(streamDefinition.getId());
            if (streamJunction == null) {
                streamJunction = new StreamJunction(streamDefinition.getId(), siddhiContext.getThreadPoolExecutor());
                streamJunctionMap.putIfAbsent(streamDefinition.getId(), streamJunction);
            }
            InputHandler inputHandler = new InputHandler(streamDefinition.getId(), streamJunction, siddhiContext);
            inputHandlerMap.put(streamDefinition.getId(), inputHandler);
            return inputHandler;
        } else {
            return inputHandlerMap.get(streamDefinition.getId());
        }

    }



    private boolean checkEventStreamExist(StreamDefinition newStreamDefinition, ConcurrentMap<String, AbstractDefinition>  streamDefinitionMap ) {
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

    /**
     * clone all the queries of the partition for a given partition key
     * @param key
     * @return
     */
    public List<QueryRuntime> clone(String key) {
        List<QueryRuntime> queryRuntimeList = new ArrayList<QueryRuntime>();
        for(QueryRuntime queryRuntime:metaQueryProcessorMap.values()){
            if(queryRuntime.isFromLocalStream()){
                queryRuntimeList.add( queryRuntime.clone(queryRuntime.getInputStreamId().get(0),key));
            } else{
                QueryRuntime qRuntime = queryRuntime.clone(null,key);
                queryRuntimeList.add(qRuntime);
                partitionedQueryRuntimeList.add(qRuntime);
            }

        }

        addPartitionInstance(key, new PartitionInstanceRuntime(key,queryRuntimeList));
        updateHandlers(key);
        return partitionedQueryRuntimeList;
    }

    public List<QueryRuntime> test(){
        return partitionedQueryRuntimeList;
    }

    public void updateHandlers(String key){
        for(HandlerProcessor handlerProcessor :handlerProcessors){
            if(handlerProcessor instanceof PartitionHandlerProcessor){
                ((PartitionHandlerProcessor) handlerProcessor).addStreamJunction(key,partitionedQueryRuntimeList);
            }
        }

    }

}
