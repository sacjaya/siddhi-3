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
import org.wso2.siddhi.core.query.processor.handler.BasicHandlerProcessor;
import org.wso2.siddhi.query.api.exception.DuplicateAnnotationException;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.query.creator.QueryCreator;
import org.wso2.siddhi.core.query.creator.QueryCreatorFactory;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.PartitionHandlerProcessor;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.query.api.util.AnnotationHelper;
import org.wso2.siddhi.core.util.parser.QueryOutputParser;
import org.wso2.siddhi.query.api.annotation.Element;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.stream.JoinInputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.SingleInputStream;
import org.wso2.siddhi.query.api.execution.query.output.stream.InsertIntoStream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class QueryRuntime {
    private String queryId;
    private Query query;
    private StreamDefinition outputStreamDefinition;
    private OutputCallback outputCallback = null;
    private OutputRateManager outputRateManager;
    private List<BasicHandlerProcessor> handlerProcessors = new ArrayList<BasicHandlerProcessor>();
    private boolean toLocalStream;
    private SiddhiContext siddhiContext;
    private ConcurrentMap<String, StreamJunction> localStreamJunctionMap;
    private QueryPartitioner queryPartitioner;

    private QueryRuntime() {

    }

    public QueryRuntime(Query query, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, StreamJunction> streamJunctionMap, Partition partition, SiddhiContext siddhiContext, PartitionRuntime partitionRuntime) {
        try {
            Element element = AnnotationHelper.getAnnotationElement("info", "name", query.getAnnotations());
            if (element != null) {
                this.queryId = element.getValue();

            }
        } catch (DuplicateAnnotationException e) {
            throw new QueryCreationException(e.getMessage() + " for the same Query " + query.toString());
        }
        if (queryId == null) {
            this.queryId = UUID.randomUUID().toString();
        }
        this.query = query;
        this.siddhiContext = siddhiContext;
        outputRateManager = QueryOutputParser.constructOutputRateManager(query.getOutputRate());

        ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap = null;
        if (partitionRuntime != null) {
            localStreamDefinitionMap = partitionRuntime.getLocalStreamDefinitionMap();
            localStreamJunctionMap = partitionRuntime.getLocalStreamJunctionMap();
        }

        QueryCreator queryCreator = QueryCreatorFactory.constructQueryCreator(queryId, query, streamDefinitionMap, localStreamDefinitionMap, outputRateManager, siddhiContext);

//        QueryPartitioner queryPartitioner = new QueryPartitioner(partition, queryCreator, siddhiContext);
        queryPartitioner = new QueryPartitioner(partition, queryCreator, siddhiContext);
        List<BasicHandlerProcessor> handlerProcessorList = queryPartitioner.constructPartition(outputRateManager);

        outputStreamDefinition = queryCreator.getOutputStreamDefinition();
        if (query.getOutputStream() instanceof InsertIntoStream && ((InsertIntoStream) query.getOutputStream()).isInnerStream()) {
            toLocalStream = true;
            outputCallback = QueryOutputParser.constructOutputCallback(query.getOutputStream(), localStreamJunctionMap, siddhiContext, outputStreamDefinition);
            outputRateManager.setOutputCallback(outputCallback);

        } else {
            outputCallback = QueryOutputParser.constructOutputCallback(query.getOutputStream(), streamJunctionMap, siddhiContext, outputStreamDefinition);
            outputRateManager.setOutputCallback(outputCallback);
        }

        if (partitionRuntime == null) {
            handlerProcessors = handlerProcessorList;
            for (HandlerProcessor handlerProcessor : handlerProcessors) {
                streamJunctionMap.get(handlerProcessor.getStreamId()).addEventFlow(handlerProcessor);
            }
        } else if (((SingleInputStream) query.getInputStream()).isInnerStream() /*TODO: for joins*/) {
            handlerProcessors = handlerProcessorList;
        } else {
            List<List<PartitionExecutor>> partitionExecutors = queryPartitioner.getPartitionExecutors();
            for (int i = 0; i < handlerProcessorList.size(); i++) {
                HandlerProcessor queryStreamProcessor = handlerProcessorList.get(i);
                partitionRuntime.addHandlerProcessors(new PartitionHandlerProcessor(siddhiContext, queryStreamProcessor.getStreamId(), queryPartitioner, i, partitionExecutors.get(i), partitionRuntime));
            }
        }


    }


    public OutputCallback getOutputCallback() {
        return outputCallback;
    }

    public String getQueryId() {
        return queryId;
    }

    public void addCallback(QueryCallback callback) {
        outputRateManager.addQueryCallback(callback);
    }

//    public void removeQuery(ConcurrentMap<String, StreamJunction> streamJunctionMap, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap) {
//        for (HandlerProcessor queryStreamProcessor : handlerProcessors) {
//            StreamJunction junction = streamJunctionMap.get(queryStreamProcessor.getId());
//            if (junction != null) {
//                junction.removeEventFlow(queryStreamProcessor);
//            }
//        }
//        streamDefinitionMap.remove(query.getOutputStream().getId());
//    }

    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }

    public List<String> getInputStreamId() {
        return query.getInputStream().getStreamIds();
    }

    public boolean isToLocalStream() {
        return toLocalStream;
    }

    public boolean isFromLocalStream() {
        if (query.getInputStream() instanceof SingleInputStream) {
            return ((SingleInputStream) query.getInputStream()).isInnerStream();
        } else if (query.getInputStream() instanceof JoinInputStream) {
            //TODO for join ,pattern and sequence streams
        }
        return false;
    }

    public QueryRuntime clone(String streamId, String key) {
        QueryRuntime queryRuntime = new QueryRuntime();
        queryRuntime.queryId = this.queryId + key;
        queryRuntime.outputRateManager = QueryOutputParser.constructOutputRateManager(query.getOutputRate());
        queryRuntime.toLocalStream = this.toLocalStream;
        queryRuntime.query = this.query;
        queryRuntime.outputStreamDefinition = this.outputStreamDefinition;

        if (!toLocalStream) {
            queryRuntime.outputRateManager.setOutputCallback(outputCallback);
            queryRuntime.outputCallback = this.outputCallback;

        } else {
            OutputCallback outputCallback = QueryOutputParser.constructOutputCallback(query.getOutputStream(), key, localStreamJunctionMap, siddhiContext, outputStreamDefinition);
            queryRuntime.outputRateManager.setOutputCallback(outputCallback);
            queryRuntime.outputCallback = outputCallback;

        }

        if (this.isFromLocalStream()) {
            List<BasicHandlerProcessor> handlerProcessorList = queryPartitioner.cloneHandlerProcessors(queryRuntime.outputRateManager);
            queryRuntime.handlerProcessors = handlerProcessorList;
            for (HandlerProcessor handlerProcessor : handlerProcessorList) {
                StreamJunction streamJunction = localStreamJunctionMap.get(streamId + key);
                if (streamJunction == null) {
                    streamJunction = new StreamJunction(streamId + key, siddhiContext.getExecutorService());
                    localStreamJunctionMap.putIfAbsent(streamId + key, streamJunction);
                }
                streamJunction.addEventFlow(handlerProcessor);

            }

        }
        return queryRuntime;

    }

    public OutputRateManager getOutputRateManager() {
        return this.outputRateManager;
    }

    public void removeQuery(ConcurrentMap<String, StreamJunction> streamJunctionMap,
                            ConcurrentMap<String, AbstractDefinition> streamDefinitionMap) {
        for (HandlerProcessor queryStreamProcessor : handlerProcessors) {
            StreamJunction junction = streamJunctionMap.get(queryStreamProcessor.getStreamId());
            if (junction != null) {
                junction.removeEventFlow(queryStreamProcessor);
            }
        }
        streamDefinitionMap.remove(query.getOutputStream().getId());
    }

}
