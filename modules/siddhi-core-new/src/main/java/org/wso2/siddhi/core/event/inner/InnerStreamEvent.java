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
package org.wso2.siddhi.core.event.inner;

/**
 * Standard processing event inside Siddhi. InnerStreamEvent will be created
 * from StreamEvent before sending to Stream Handlers.
 */
public class InnerStreamEvent {

    protected long timestamp = -1;
    private Object[] beforeWindowData;          //Attributes before window execution
    private Object[] onAfterWindowData;         //Attributes on and after window execution
    protected Object[] outputData;                 //Attributes to send out
    protected boolean isExpired = false;
    private InnerStreamEvent next;

    public InnerStreamEvent(int beforeWindowDataSize, int onAfterWindowDataSize, int outputDataSize) {
        beforeWindowData = new Object[beforeWindowDataSize];
        onAfterWindowData = new Object[onAfterWindowDataSize];
        outputData = new Object[outputDataSize];
    }

    public Object[] getBeforeWindowData() {
        return beforeWindowData;
    }

    public void setBeforeWindowData(Object[] beforeWindowData) {
        this.beforeWindowData = beforeWindowData;
    }

    public Object[] getOnAfterWindowData() {
        return onAfterWindowData;
    }

    public void setOnAfterWindowData(Object[] onAfterWindowData) {
        this.onAfterWindowData = onAfterWindowData;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Object[] getOutputData() {
        return outputData;
    }

    public void setOutputData(Object[] outputData) {
        this.outputData = outputData;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean isExpired) {
        this.isExpired = isExpired;
    }

    public InnerStreamEvent getNext() {
        return next;
    }

    public void setNext(InnerStreamEvent next) {
        this.next = next;
    }
}
