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
package org.wso2.siddhi.core.query.creator;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.parser.QueryOutputParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.SingleInputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class QueryCreator {

    protected final ConcurrentMap<String, AbstractDefinition> streamDefinitionMap;
    protected final ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap;
    protected OutputRateManager outputRateManager;
    protected final SiddhiContext siddhiContext;
    protected final String queryId;
    protected final Query query;
    protected StreamDefinition outputStreamDefinition;
    protected QuerySelector querySelector;
    protected Map<String, StreamDefinition> tempStreamDefinitionMap = new HashMap<String, StreamDefinition>();
    protected StreamDefinition defaultDefinition;
    protected MetaStreamEvent metaStreamEvent = new MetaStreamEvent();

    protected QueryCreator(String queryId, Query query, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap, OutputRateManager outputRateManager, SiddhiContext siddhiContext) {
        this.queryId = queryId;
        this.query = query;
        this.streamDefinitionMap = streamDefinitionMap;
        this.localStreamDefinitionMap = localStreamDefinitionMap;
        this.outputRateManager = outputRateManager;
        this.siddhiContext = siddhiContext;
        if(getInputStream() instanceof SingleInputStream){
            String streamId = ((SingleInputStream) getInputStream()).getStreamId();
            if(((SingleInputStream) getInputStream()).isInnerStream())    {
                this.defaultDefinition = (StreamDefinition) localStreamDefinitionMap.get(streamId);
            }  else {
                this.defaultDefinition = (StreamDefinition) streamDefinitionMap.get(streamId);
            }
        } //TODO other streams
    }

    protected QuerySelector constructQuerySelector(OutputRateManager outputRateManager, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutors) {

        return QueryOutputParser.constructQuerySelector(tempStreamDefinitionMap, query.getOutputStream(), query.getSelector(), outputRateManager, siddhiContext, metaStreamEvent, variableExpressionExecutors);
    }


    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }

    public Map<String, StreamDefinition> getTempStreamDefinitionMap() {
        return tempStreamDefinitionMap;
    }

    public InputStream getInputStream() {
        return query.getInputStream();
    }


    public abstract QueryPartComposite constructQuery(OutputRateManager outputRateManager) ;

    public abstract List<HandlerProcessor> cloneHandlers(OutputRateManager outputRateManager, QueryPartComposite queryPartComposite);


//    public abstract QueryPartComposite constructQuery();

    public QuerySelector getQuerySelector() {
        return querySelector;
    }

    public MetaStreamEvent getMetaStreamEvent() {
        return metaStreamEvent;
    }

    protected void constructTempStreamDefinitionMap(InputStream inputStream) {
        if (((SingleInputStream) inputStream).isInnerStream()) {
            tempStreamDefinitionMap.put(((SingleInputStream) getInputStream()).getStreamId(), (StreamDefinition) localStreamDefinitionMap.get(((SingleInputStream) getInputStream()).getStreamId()));
        } else {
            tempStreamDefinitionMap.put(((SingleInputStream) getInputStream()).getStreamId(), (StreamDefinition) streamDefinitionMap.get(((SingleInputStream) getInputStream()).getStreamId()));
        }

    }

}
