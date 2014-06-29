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
import org.wso2.siddhi.query.api.utils.StreamUsage;

import java.util.ArrayList;
import java.util.List;

public class WindowInputStream implements SingleInputStream {

    protected String streamId;
    protected AbstractDefinition definition;
    protected String streamReferenceId;

    protected List<StreamHandler> streamHandlers = new ArrayList<StreamHandler>();

    protected int windowPosition = -1;

    protected WindowInputStream(String streamId) {
        this(streamId, streamId);
    }

    public WindowInputStream(String streamId, String streamReferenceId) {
        this.streamId = streamId;
        this.streamReferenceId = streamReferenceId;
    }

    public WindowInputStream(StandardInputStream standardStream, Window window) {
        streamId = standardStream.getStreamId();
        definition = standardStream.getDefinition();
        streamReferenceId = standardStream.getStreamReferenceId();
        streamHandlers = standardStream.getStreamHandlers();
        windowPosition = standardStream.getStreamHandlers().size();
        streamHandlers.add(window);
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

    @Override
    public List<String> getStreamIds() {
        List<String> streamIds = new ArrayList<String>();
        streamIds.add(streamId);
        return streamIds;
    }

    public List<StreamUsage> getStreamUsages() {
        List<StreamUsage> streamUsages = new ArrayList<StreamUsage>();
        streamUsages.add(new StreamUsage(streamId));
        return streamUsages;
    }


    public WindowInputStream as(String streamReferenceId) {
        this.streamReferenceId = streamReferenceId;
        return this;
    }

    public List<StreamHandler> getStreamHandlers() {
        return streamHandlers;
    }

    public void setStreamHandlers(List<StreamHandler> streamHandlers) {
        this.streamHandlers = streamHandlers;
    }

    public WindowInputStream filter(Condition filterCondition) {
        streamHandlers.add(new Filter(filterCondition));
        return this;
    }

    public WindowInputStream filter(Filter filter) {
        streamHandlers.add(filter);
        return this;
    }

    public WindowInputStream function(String name, Expression... parameters) {
        streamHandlers.add(new StreamFunction(name, parameters));
        return this;
    }

    public WindowInputStream function(String extensionName, String functionName,
                                 Expression... parameters) {
        streamHandlers.add(new StreamFunction(extensionName, functionName, parameters));
        return this;
    }

    public WindowInputStream function(StreamFunction streamFunction) {
        streamHandlers.add(streamFunction);
        return this;
    }
}
