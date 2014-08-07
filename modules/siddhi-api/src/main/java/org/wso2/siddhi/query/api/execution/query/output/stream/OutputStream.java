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
package org.wso2.siddhi.query.api.execution.query.output.stream;

public abstract class OutputStream {

    public enum OutputEventType {
        EXPIRED_EVENTS, CURRENT_EVENTS, ALL_EVENTS, ALL_RAW_EVENTS, EXPIRED_RAW_EVENTS
    }

    protected String streamId;
    protected OutputEventType outputEventType;

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public OutputEventType getOutputEventType() {
        return outputEventType;
    }

    public void setOutputEventType(OutputEventType outputEventType) {
        this.outputEventType = outputEventType;
    }

    @Override
    public String toString() {
        return "OutputStream{" +
                "outputEventType=" + outputEventType +
                ", streamId='" + streamId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutputStream)) return false;

        OutputStream that = (OutputStream) o;

        if (outputEventType != that.outputEventType) return false;
        if (streamId != null ? !streamId.equals(that.streamId) : that.streamId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = outputEventType != null ? outputEventType.hashCode() : 0;
        result = 31 * result + (streamId != null ? streamId.hashCode() : 0);
        return result;
    }
}
