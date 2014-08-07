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
package org.wso2.siddhi.query.api.expression;

public class Variable extends Expression {

    public static final int LAST = -1;

    private String streamId;
    private boolean isInnerStream;
    private Integer streamIndex = null;

    private String functionId;
    private Integer functionIndex;

    private String attributeName;

    public Variable(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getStreamId() {
        return streamId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public boolean isInnerStream() {
        return isInnerStream;
    }

    public Integer getStreamIndex() {
        return streamIndex;
    }

    public String getFunctionId() {
        return functionId;
    }

    public Integer getFunctionIndex() {
        return functionIndex;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public void setInnerStream(boolean isInnerStream) {
        this.isInnerStream = isInnerStream;
    }

    public void setStreamIndex(Integer streamIndex) {
        this.streamIndex = streamIndex;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public void setFunctionIndex(Integer functionIndex) {
        this.functionIndex = functionIndex;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Variable ofStream(String streamId) {
        this.streamId = streamId;
        this.isInnerStream=false;
        return this;
    }

    public Variable ofInnerStream(String streamId) {
        this.streamId = streamId;
        this.isInnerStream=false;
        return this;
    }

    public Variable ofStream(String streamId, int streamIndex) {
        this.streamId = streamId;
        this.streamIndex = streamIndex;
        this.isInnerStream=false;
        return this;
    }

    public Variable ofInnerStream(String streamId, int streamIndex) {
        this.streamId = streamId;
        this.streamIndex = streamIndex;
        this.isInnerStream=true;
        return this;
    }

    public Variable ofFunction(String functionId) {
        this.functionId = functionId;
        return this;
    }

    public Variable ofFunction(String functionId,int functionIndex) {
        this.functionId = functionId;
        this.functionIndex = functionIndex;
        return this;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id='" + streamId + '\'' +
                ", isInnerStream=" + isInnerStream +
                ", streamIndex=" + streamIndex +
                ", functionId='" + functionId + '\'' +
                ", functionIndex=" + functionIndex +
                ", attributeName='" + attributeName + '\'' +
                "} ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Variable)) return false;

        Variable variable = (Variable) o;

        if (isInnerStream != variable.isInnerStream) return false;
        if (attributeName != null ? !attributeName.equals(variable.attributeName) : variable.attributeName != null)
            return false;
        if (functionId != null ? !functionId.equals(variable.functionId) : variable.functionId != null) return false;
        if (functionIndex != null ? !functionIndex.equals(variable.functionIndex) : variable.functionIndex != null)
            return false;
        if (streamId != null ? !streamId.equals(variable.streamId) : variable.streamId != null) return false;
        if (streamIndex != null ? !streamIndex.equals(variable.streamIndex) : variable.streamIndex != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = streamId != null ? streamId.hashCode() : 0;
        result = 31 * result + (isInnerStream ? 1 : 0);
        result = 31 * result + (streamIndex != null ? streamIndex.hashCode() : 0);
        result = 31 * result + (functionId != null ? functionId.hashCode() : 0);
        result = 31 * result + (functionIndex != null ? functionIndex.hashCode() : 0);
        result = 31 * result + (attributeName != null ? attributeName.hashCode() : 0);
        return result;
    }
}
