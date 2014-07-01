/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.siddhi.query.api.query.input;

import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.query.input.handler.Filter;

/**
 * Simplest format of input stream. Can be extended to create window/join streams.
 * Striped down version of current BasicStream class in siddhi.
 * Removed Transformer, isCounterStream and QueryEventSource attributes.
 * Removed functionality to get window/filtered stream.
 */
public class BasicStream{

    protected String streamId;
    protected AbstractDefinition definition;
    protected String streamReferenceId;
    protected Filter filter = null;


    protected BasicStream(String streamId, String streamReferenceId,
                          Filter filter) {
        this.streamId = streamId;
        this.streamReferenceId = streamReferenceId;
        this.filter = filter;
    }

    protected BasicStream(String streamId) {
        this(streamId, streamId);
    }

    public BasicStream(String streamReferenceId, String streamId) {
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

    public BasicStream setStreamReferenceId(String streamReferenceId) {
        this.streamReferenceId = streamReferenceId;
        return this;
    }

    public Filter getFilter() {
        return filter;
    }


    public void filter(Condition filterCondition) {
        filter = new Filter(filterCondition);
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

}