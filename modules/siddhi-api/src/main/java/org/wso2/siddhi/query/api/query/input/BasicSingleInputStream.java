/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.query.api.query.input;

import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.input.handler.Filter;
import org.wso2.siddhi.query.api.query.input.handler.StreamFunction;
import org.wso2.siddhi.query.api.query.input.handler.StreamHandler;
import org.wso2.siddhi.query.api.query.input.handler.Window;
import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;

import java.util.List;

public class BasicSingleInputStream extends SingleInputStream implements SequenceElement {

//    protected boolean isCounterStream = false;

    protected BasicSingleInputStream(String streamId) {
        this(streamId, false);
    }

    protected BasicSingleInputStream(String streamId, boolean isPartitioned) {
        this(streamId, streamId, isPartitioned);
    }

    public BasicSingleInputStream(String streamId, String streamReferenceId) {
        this(streamId, streamReferenceId, false);

    }

    public BasicSingleInputStream(String streamId, String streamReferenceId, boolean isPartitioned) {
        super(streamId, streamReferenceId, isPartitioned);
    }

    public AbstractDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(AbstractDefinition definition) {
        this.definition = definition;
    }

    public String getStreamId() {
        return streamId;
    }

    public String getStreamReferenceId() {
        return streamReferenceId;
    }

    public SingleInputStream as(String streamReferenceId) {
        this.streamReferenceId = streamReferenceId;
        return this;
    }

//    @Override
//    public List<String> getStreamIds() {
//        List<String> list = new ArrayList<String>();
//        list.add(streamId);
//        return list;
//    }

//    @Override
//    public List<QueryEventSource> constructQueryEventSourceList(
//            ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap,
//            List<QueryEventSource> queryEventSources) {
//        definition = streamTableDefinitionMap.get(streamId);
//        if (definition == null) {
//            throw new SourceNotExistException("Definition not exist! No stream/table defined with stream ID: " + streamId);
//        }
//        if (definition instanceof tableDefinition) {
//            if (filter != null || transformer != null) {
//                throw new SourceNotExistException(streamId + " is not a InputStream but a Table, and it cant have filter or transformer");
//            }
//
//        }
//        queryEventSource = new QueryEventSource(streamId, streamReferenceId,
//                definition,
//                filter, transformer, null);
//        queryEventSource.setCounterStream(isCounterStream);
//        queryEventSources.add(queryEventSource);
//        return queryEventSources;
//    }


    public List<StreamHandler> getStreamHandlers() {
        return streamHandlers;
    }

    public void setStreamHandlers(List<StreamHandler> streamHandlers) {
        this.streamHandlers = streamHandlers;
    }

//    @Override
//    public QueryEventSource getQueryEventSource() {
//        return queryEventSource;
//    }

    public BasicSingleInputStream filter(Condition filterCondition) {
        streamHandlers.add(new Filter(filterCondition));
        return this;
    }

    public BasicSingleInputStream filter(Filter filter) {
        streamHandlers.add(filter);
        return this;
    }

    public SingleInputStream window(String name, Expression... parameters) {
        return new SingleInputStream(this, new Window(name, parameters));
    }

    public SingleInputStream window(String namespace, String function, Expression... parameters) {
        return new SingleInputStream(this, new Window(namespace, function, parameters));
    }

    public SingleInputStream window(Window window) {
        return new SingleInputStream(this, window);
    }

    public BasicSingleInputStream function(String name, Expression... parameters) {
        streamHandlers.add(new StreamFunction(name, parameters));
        return this;
    }

    public BasicSingleInputStream function(String extensionName, String functionName,
                                           Expression... parameters) {
        streamHandlers.add(new StreamFunction(extensionName, functionName, parameters));
        return this;
    }

    public BasicSingleInputStream function(StreamFunction streamFunction) {
        streamHandlers.add(streamFunction);
        return this;
    }

//    public void setCounterStream(boolean counterStream) {
//        isCounterStream = counterStream;
//    }

//    public boolean isCounterStream() {
//        return isCounterStream;
//    }
}