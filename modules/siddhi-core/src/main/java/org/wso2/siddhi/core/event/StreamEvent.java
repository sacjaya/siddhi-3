/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.siddhi.core.event;

import java.util.Arrays;

/**
 * Basic processing event class implementation.
 * Disruptors will have StreamEvents and after acquired
 * by a handler will converted into InnerStreamEvent
 */
public class StreamEvent implements Event, ComplexEvent {

    protected long timestamp = -1;
    protected Object[] data = new Object[1];
    protected boolean isExpired = false;
    protected StreamEvent next = null;

    public StreamEvent(long timestamp, Object[] data) {
        this.timestamp = timestamp;
        this.data = data;
    }

    public StreamEvent() {
    }

    public StreamEvent(int dataSize) {
        this.data = new Object[dataSize];
    }


    public long getTimestamp() {
        return timestamp;
    }

    public Object[] getData() {
        return data;
    }

    public Object getData(int i) {
        return data[i];
    }

    @Override
    public boolean isExpired() {
        return isExpired;
    }

    @Override
    public String toString() {
        return "StreamEvent{" +
                "timestamp=" + timestamp +
                ", data=" + Arrays.toString(data) +
                ", isExpired=" + isExpired +
                '}';
    }

    public StreamEvent[] toArray() { //TODO: review and remove
        return new StreamEvent[]{this};
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public StreamEvent getNext() {
        return next;
    }

    public void setNext(StreamEvent next) {
        this.next = next;
    }


}
