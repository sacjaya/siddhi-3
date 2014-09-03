/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
import org.wso2.siddhi.core.event.state.MetaStateEvent;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.executor.VariableExpressionExecutor;
import org.wso2.siddhi.core.partition.PartitionRuntime;
import org.wso2.siddhi.core.partition.PartitionStreamReceiver;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.query.output.rate_limit.OutputRateLimiter;
import org.wso2.siddhi.core.query.selector.QueryPartitioner;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.stream.QueryStreamReceiver;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.runtime.SingleStreamRuntime;
import org.wso2.siddhi.core.stream.runtime.StreamRuntime;
import org.wso2.siddhi.core.util.parser.InputStreamParser;
import org.wso2.siddhi.core.util.parser.OutputParser;
import org.wso2.siddhi.core.util.parser.QueryParser;
import org.wso2.siddhi.core.util.parser.SelectorParser;
import org.wso2.siddhi.core.util.parser.helper.QueryParserHelper;
import org.wso2.siddhi.query.api.annotation.Element;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.exception.DuplicateAnnotationException;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.stream.BasicSingleInputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.JoinInputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.SingleInputStream;
import org.wso2.siddhi.query.api.execution.query.output.stream.InsertIntoStream;
import org.wso2.siddhi.query.api.util.AnnotationHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

public class QueryRuntime {

    private StreamRuntime streamRuntime;
    private OutputRateLimiter outputRateLimiter;
    private String queryId;
    private Query query;
    private SiddhiContext siddhiContext;
    private OutputCallback outputCallback;
    private StreamDefinition outputStreamDefinition;
    private QueryPartitioner queryPartitioner;
    private boolean toLocalStream;
    private QuerySelector selector;
    private ConcurrentMap<String, AbstractDefinition> definitionMap;
    private MetaStateEvent metaStateEvent;

    public void setId() {
        try {
            Element element = AnnotationHelper.getAnnotationElement("info", "name", query.getAnnotations());
            if (element != null) {
                queryId = element.getValue();

            }
        } catch (DuplicateAnnotationException e) {
            throw new QueryCreationException(e.getMessage() + " for the same Query " + query.toString());
        }
        if (queryId == null) {
            queryId = UUID.randomUUID().toString();
        }

    }

    public OutputCallback getOutputCallback() {
        return outputCallback;
    }

    public String getQueryId() {
        return queryId;
    }

    public void setQueryId(String queryId) {
        this.queryId = queryId;
    }

    public void addCallback(QueryCallback callback) {
        outputRateLimiter.addQueryCallback(callback);
    }

    public OutputRateLimiter getOutputRateManager() {
        return outputRateLimiter;
    }

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

    public QueryRuntime clone(StreamDefinition streamDefinition, String key, ConcurrentMap<String, StreamJunction> localStreamJunctionMap) {

        StreamRuntime clonedStreamRuntime = this.streamRuntime.clone(key);
        QuerySelector clonedSelector = this.selector.clone(key);
        OutputRateLimiter clonedOutputRateLimiter = outputRateLimiter.clone(key);

        QueryRuntime queryRuntime = new QueryRuntime();
        queryRuntime.queryId = this.queryId + key;
        queryRuntime.setQuery(query);
        queryRuntime.setSiddhiContext(siddhiContext);
        queryRuntime.setStreamRuntime(clonedStreamRuntime);
        queryRuntime.setSelector(clonedSelector);
        queryRuntime.setOutputRateLimiter(clonedOutputRateLimiter);
        queryRuntime.setMetaStateEvent(this.metaStateEvent);
        queryRuntime.setToLocalStream(toLocalStream);
        queryRuntime.setDefinitionMap(definitionMap);
        queryRuntime.init();
        queryRuntime.outputStreamDefinition = this.outputStreamDefinition;

        if (!toLocalStream) {
            queryRuntime.outputRateLimiter.setOutputCallback(outputCallback);
            queryRuntime.outputCallback = this.outputCallback;
        } else {
            OutputCallback outputCallback = OutputParser.constructOutputCallback(query.getOutputStream(), key, localStreamJunctionMap, outputStreamDefinition, siddhiContext);
            queryRuntime.outputRateLimiter.setOutputCallback(outputCallback);
            queryRuntime.outputCallback = outputCallback;
        }
        return queryRuntime;

    }

    public void setStreamRuntime(StreamRuntime streamRuntime) {
        this.streamRuntime = streamRuntime;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public void setSiddhiContext(SiddhiContext siddhiContext) {
        this.siddhiContext = siddhiContext;
    }

    public void setOutputRateLimiter(OutputRateLimiter outputRateLimiter) {
        this.outputRateLimiter = outputRateLimiter;
        selector.setNext(outputRateLimiter);
    }

    public void setSelector(QuerySelector selector) {
        this.selector = selector;
    }

    public StreamRuntime getStreamRuntime() {
        return streamRuntime;
    }

    public void setDefinitionMap(ConcurrentMap<String, AbstractDefinition> definitionMap) {
        this.definitionMap = definitionMap;
    }

    public void setMetaStateEvent(MetaStateEvent metaStateEvent) {
        outputStreamDefinition = metaStateEvent.getOutputStreamDefinition();
        this.metaStateEvent = metaStateEvent;
    }

    public void setQueryPartitioner(QueryPartitioner queryPartitioner) {
        this.queryPartitioner = queryPartitioner;
    }

    public MetaStateEvent getMetaStateEvent() {
        return metaStateEvent;
    }

    public void setToLocalStream(boolean toLocalStream){
        this.toLocalStream = toLocalStream;
    }
    public Query getQuery() {
        return query;
    }

    public void setOutputCallback(OutputCallback outputCallback) {
        this.outputCallback = outputCallback;
    }

    public QueryPartitioner getQueryPartitioner() {
        return queryPartitioner;
    }

    public void init() {
        if (((SingleStreamRuntime) streamRuntime).getProcessorChain() == null) {
            ((SingleStreamRuntime) streamRuntime).getQueryStreamReceiver().setNext(selector);
        } else {
            ((SingleStreamRuntime) streamRuntime).getQueryStreamReceiver().getProcessorChain().setNext(selector);
        }

    }
}
