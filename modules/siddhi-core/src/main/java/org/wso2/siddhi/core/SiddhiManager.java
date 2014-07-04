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

import org.wso2.siddhi.core.config.SiddhiConfiguration;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.DifferentDefinitionAlreadyExistException;
import org.wso2.siddhi.core.exception.QueryNotExistException;
import org.wso2.siddhi.core.query.QueryRuntime;
import org.wso2.siddhi.core.query.output.callback.InsertIntoStreamCallback;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.snapshot.SnapshotService;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.output.StreamCallback;
import org.wso2.siddhi.core.util.SiddhiThreadFactory;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.definition.TableDefinition;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.compiler.SiddhiCompiler;
import org.wso2.siddhi.query.compiler.exception.SiddhiParserException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class SiddhiManager {

    private SiddhiContext siddhiContext;
    private ConcurrentMap<String, StreamJunction> streamJunctionMap = new ConcurrentHashMap<String, StreamJunction>(); //contains definition
    private ConcurrentMap<String, AbstractDefinition> streamDefinitionMap = new ConcurrentHashMap<String, AbstractDefinition>(); //contains stream definition
    private ConcurrentMap<String, InputHandler> inputHandlerMap = new ConcurrentHashMap<String, InputHandler>();
    private ConcurrentMap<String, QueryRuntime> queryProcessorMap = new ConcurrentHashMap<String, QueryRuntime>();


    public SiddhiManager() {
        this(new SiddhiConfiguration());
    }

    public SiddhiManager(SiddhiConfiguration siddhiConfiguration) {


        this.siddhiContext = new SiddhiContext(siddhiConfiguration.getExecutionPlanIdentifier(), SiddhiContext.ProcessingState.DISABLED);
        this.siddhiContext.setEventBatchSize(siddhiConfiguration.getEventBatchSize());
        this.siddhiContext.setSiddhiExtensions(siddhiConfiguration.getSiddhiExtensions());
        this.siddhiContext.setThreadPoolExecutor(new ThreadPoolExecutor(siddhiConfiguration.getThreadExecutorCorePoolSize(),
                siddhiConfiguration.getThreadExecutorMaxPoolSize(),
                50,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new SiddhiThreadFactory("Executor")));
        this.siddhiContext.setScheduledExecutorService(Executors.newScheduledThreadPool(siddhiConfiguration.getThreadSchedulerCorePoolSize(), new SiddhiThreadFactory("Scheduler")));
        this.siddhiContext.setSnapshotService(new SnapshotService(siddhiContext));
    }


    public InputHandler defineStream(StreamDefinition streamDefinition) {
        if (!checkEventStreamExist(streamDefinition)) {
            streamDefinitionMap.put(streamDefinition.getStreamId(), streamDefinition);
            StreamJunction streamJunction = streamJunctionMap.get(streamDefinition.getStreamId());
            if (streamJunction == null) {
                streamJunction = new StreamJunction(streamDefinition.getStreamId(), siddhiContext.getThreadPoolExecutor());
                streamJunctionMap.put(streamDefinition.getStreamId(), streamJunction);
            }
            InputHandler inputHandler = new InputHandler(streamDefinition.getStreamId(), streamJunction, siddhiContext);
            inputHandlerMap.put(streamDefinition.getStreamId(), inputHandler);
            return inputHandler;
        } else {
            return inputHandlerMap.get(streamDefinition.getStreamId());
        }

    }


    public void defineStream(String streamDefinition) throws SiddhiParserException {
        defineStream(SiddhiCompiler.parseStreamDefinition(streamDefinition));
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
        AbstractDefinition definition = streamDefinitionMap.get(newStreamDefinition.getStreamId());
        if (definition != null) {
            if (definition instanceof TableDefinition) {
                throw new DifferentDefinitionAlreadyExistException("Table " + newStreamDefinition.getStreamId() + " is already defined as " + definition + ", hence cannot define " + newStreamDefinition);
            } else if (!definition.getAttributeList().equals(newStreamDefinition.getAttributeList())) {
                throw new DifferentDefinitionAlreadyExistException("Stream " + newStreamDefinition.getStreamId() + " is already defined as " + definition + ", hence cannot define " + newStreamDefinition);
            } else {
                return true;
            }
        }
        return false;
    }

    public String addQuery(String query) throws SiddhiParserException {
        return this.addQuery(SiddhiCompiler.parseQuery(query));
    }


    public String addQuery(Query query) {
        QueryRuntime queryRuntime = new QueryRuntime(query, streamDefinitionMap, streamJunctionMap, siddhiContext);
        OutputCallback outputCallback = queryRuntime.getOutputCallback();
        if (outputCallback != null && outputCallback instanceof InsertIntoStreamCallback) {
            defineStream(((InsertIntoStreamCallback) outputCallback).getOutputStreamDefinition());
        }

        queryProcessorMap.put(queryRuntime.getQueryId(), queryRuntime);
        return queryRuntime.getQueryId();


    }

    public void removeQuery(String queryId) {
        QueryRuntime queryRuntime = queryProcessorMap.remove(queryId);
        if (queryRuntime != null) {
            queryRuntime.removeQuery(streamJunctionMap, streamDefinitionMap);
        }
    }


    public Query getQuery(String queryReference) {
        return queryProcessorMap.get(queryReference).getQuery();
    }

    public InputHandler getInputHandler(String streamId) {
        return inputHandlerMap.get(streamId);
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

    public void addCallback(String queryReference, QueryCallback callback) {
        QueryRuntime queryRuntime = queryProcessorMap.get(queryReference);
        if (queryRuntime == null) {
            throw new QueryNotExistException("No query fund for " + queryReference);
        }
        callback.setStreamDefinition(queryRuntime.getOutputStreamDefinition());
        callback.setSiddhiContext(siddhiContext);
        queryRuntime.addCallback(callback);

    }


    public void shutdown() {
        siddhiContext.getThreadPoolExecutor().shutdown();
        siddhiContext.getScheduledExecutorService().shutdownNow();

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


    public byte[] snapshot() {
        return siddhiContext.getSnapshotService().snapshot();
    }

    public void restore(byte[] snapshot) {
        siddhiContext.getSnapshotService().restore(snapshot);
    }

    public SiddhiContext getSiddhiContext() {
        return siddhiContext;
    }

}
