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

import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.query.creator.QueryCreator;
import org.wso2.siddhi.core.query.creator.QueryCreatorFactory;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.SimpleHandlerProcessor;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.util.parser.QueryOutputParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class QueryRuntime {
    static final Logger log = Logger.getLogger(QueryRuntime.class);
    private String queryId;
    private Query query;
    private List<HandlerProcessor> handlerProcessors = new ArrayList<HandlerProcessor>();
    private StreamDefinition outputStreamDefinition;
    private List<QueryCallback> queryCallbackList = new ArrayList<QueryCallback>();
    private OutputCallback outputCallback = null;
    private OutputRateManager outputRateManager;


    public QueryRuntime(Query query, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, StreamJunction> streamJunctionMap, SiddhiContext siddhiContext) {
        if (query.getOutputStream() != null) {
            this.queryId = query.getOutputStream().getStreamId() + "-" + UUID.randomUUID();
        } else {
            this.queryId = UUID.randomUUID().toString();
        }
        this.query = query;
        outputRateManager = QueryOutputParser.constructOutputRateManager(query.getOutputRate());
        QueryCreator queryCreator = QueryCreatorFactory.constructQueryCreator(queryId, query, streamDefinitionMap, streamJunctionMap, outputRateManager, siddhiContext);
        outputStreamDefinition = queryCreator.getOutputStreamDefinition();

        if (query.getOutputStream() != null) {
            outputCallback = QueryOutputParser.constructOutputCallback(query.getOutputStream(), streamJunctionMap, siddhiContext, queryCreator.getOutputStreamDefinition());
            outputRateManager.setOutputCallback(outputCallback);
        }


        //TODO: add the correct processor
        SimpleHandlerProcessor simpleHandlerProcessor = new SimpleHandlerProcessor();
        simpleHandlerProcessor.setNext(queryCreator.querySelector);

        streamJunctionMap.get(query.getInputStream().getStreamIds().get(0)).addEventFlow(simpleHandlerProcessor);
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

    public void removeQuery(ConcurrentMap<String, StreamJunction> streamJunctionMap, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap) {
        for (HandlerProcessor queryStreamProcessor : handlerProcessors) {
            StreamJunction junction = streamJunctionMap.get(queryStreamProcessor.getStreamId());
            if (junction != null) {
                junction.removeEventFlow(queryStreamProcessor);
            }
        }
        streamDefinitionMap.remove(query.getOutputStream().getStreamId());
    }

    public Query getQuery() {
        return query;
    }

    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }
}
