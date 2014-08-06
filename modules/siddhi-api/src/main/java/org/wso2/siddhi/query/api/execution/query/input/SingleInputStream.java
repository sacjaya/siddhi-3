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
package org.wso2.siddhi.query.api.execution.query.input;

import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.execution.query.input.handler.*;
import org.wso2.siddhi.query.api.utils.StreamUsage;

import java.util.ArrayList;
import java.util.List;

public class SingleInputStream extends InputStream{

    protected boolean isInnerStream =false;
    protected String streamId;
    protected AbstractDefinition definition;
    protected String streamReferenceId;
    protected List<StreamHandler> streamHandlers = new ArrayList<StreamHandler>();
    protected int windowPosition = -1;

    protected SingleInputStream(String streamId) {
        this(streamId,false);
    }
    protected SingleInputStream(String streamId, boolean isInnerStream) {
        this(null, streamId, isInnerStream);
    }

    public SingleInputStream(String streamReferenceId, String streamId) {
        this(streamReferenceId, streamId,false);
    }

    public SingleInputStream(String streamReferenceId, String streamId, boolean isInnerStream) {
        this.streamId = streamId;
        this.streamReferenceId = streamReferenceId;
        this.isInnerStream = isInnerStream;
    }

    public SingleInputStream(BasicSingleInputStream basicSingleInputStream, Window window) {
        streamId = basicSingleInputStream.getStreamId();
        isInnerStream=basicSingleInputStream.isInnerStream();
        definition = basicSingleInputStream.getDefinition();
        streamReferenceId = basicSingleInputStream.getStreamReferenceId();
        streamHandlers = basicSingleInputStream.getStreamHandlers();
        windowPosition = basicSingleInputStream.getStreamHandlers().size();
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


    public SingleInputStream as(String streamReferenceId) {
        this.streamReferenceId = streamReferenceId;
        return this;
    }

    public List<StreamHandler> getStreamHandlers() {
        return streamHandlers;
    }

    public void addStreamHandlers(List<StreamHandler> streamHandlers) {
        this.streamHandlers.addAll(streamHandlers);
    }

    public SingleInputStream filter(Expression filterExpression) {
        streamHandlers.add(new Filter(filterExpression));
        return this;
    }

    public SingleInputStream filter(Filter filter) {
        streamHandlers.add(filter);
        return this;
    }

    public SingleInputStream function(String name, Expression... parameters) {
        streamHandlers.add(new StreamFunction(name, parameters));
        return this;
    }

    public SingleInputStream function(String extensionName, String functionName,
                                 Expression... parameters) {
        streamHandlers.add(new StreamFunctionExtension(extensionName, functionName, parameters));
        return this;
    }

    public SingleInputStream function(StreamFunction streamFunction) {
        streamHandlers.add(streamFunction);
        return this;
    }

    public boolean isInnerStream() {
        return isInnerStream;
    }

    @Override
    public String toString() {
        return "SingleInputStream{" +
                "isInnerStream=" + isInnerStream +
                ", streamId='" + streamId + '\'' +
                ", definition=" + definition +
                ", streamReferenceId='" + streamReferenceId + '\'' +
                ", streamHandlers=" + streamHandlers +
                ", windowPosition=" + windowPosition +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleInputStream)) return false;

        SingleInputStream that = (SingleInputStream) o;

        if (isInnerStream != that.isInnerStream) return false;
        if (windowPosition != that.windowPosition) return false;
        if (definition != null ? !definition.equals(that.definition) : that.definition != null) return false;
        if (streamHandlers != null ? !streamHandlers.equals(that.streamHandlers) : that.streamHandlers != null)
            return false;
        if (streamId != null ? !streamId.equals(that.streamId) : that.streamId != null) return false;
        if (streamReferenceId != null ? !streamReferenceId.equals(that.streamReferenceId) : that.streamReferenceId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (isInnerStream ? 1 : 0);
        result = 31 * result + (streamId != null ? streamId.hashCode() : 0);
        result = 31 * result + (definition != null ? definition.hashCode() : 0);
        result = 31 * result + (streamReferenceId != null ? streamReferenceId.hashCode() : 0);
        result = 31 * result + (streamHandlers != null ? streamHandlers.hashCode() : 0);
        result = 31 * result + windowPosition;
        return result;
    }
}
