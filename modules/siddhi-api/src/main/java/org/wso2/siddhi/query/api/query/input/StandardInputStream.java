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
import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;

import java.util.List;

public class StandardInputStream extends WindowInputStream implements PatternElement,SequenceElement {

//    protected boolean isCounterStream = false;

    protected StandardInputStream(String streamId) {
        this(streamId, streamId);
    }

    public StandardInputStream(String streamId, String streamReferenceId) {
        super(streamId, streamReferenceId);
        this.streamId = streamId;
        this.streamReferenceId = streamReferenceId;
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

    public WindowInputStream as(String streamReferenceId) {
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

    public StandardInputStream filter(Condition filterCondition) {
        streamHandlers.add(new Filter(filterCondition));
        return this;
    }

    public StandardInputStream filter(Filter filter) {
        streamHandlers.add(filter);
        return this;
    }

    public WindowInputStream window(String name, Expression... parameters) {
        return new WindowInputStream(this, new Window(name, parameters));
    }

    public WindowInputStream window(String namespace, String function, Expression... parameters) {
        return new WindowInputStream(this, new Window(namespace, function, parameters));
    }

    public WindowInputStream window(Window window) {
        return new WindowInputStream(this, window);
    }

    public StandardInputStream function(String name, Expression... parameters) {
        streamHandlers.add(new StreamFunction(name, parameters));
        return this;
    }

    public StandardInputStream function(String extensionName, String functionName,
                                 Expression... parameters) {
        streamHandlers.add(new StreamFunction(extensionName, functionName, parameters));
        return this;
    }

    public StandardInputStream function(StreamFunction streamFunction) {
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