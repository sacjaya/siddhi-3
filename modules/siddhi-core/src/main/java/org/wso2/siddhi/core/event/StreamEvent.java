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
 * Basic processing event class implementation
 */
public class StreamEvent implements Event, ComplexEvent {

    private long timeStamp = -1;
    private Object[] data = new Object[1];
    private Boolean isExpired = false;

    public StreamEvent(long timeStamp, Object[] data) {
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public StreamEvent() {
    }

    public StreamEvent(int dataSize) {
        this.data = new Object[dataSize];
    }


    public long getTimeStamp() {
        return timeStamp;
    }

    public Object[] getData() {
        return data;
    }

    public Object getData(int i) {
        return data[i];
    }

    @Override
    public Boolean isExpired() {
        return null;
    }

    @Override
    public String toString() {
        return "Event{" +
                " timeStamp=" + timeStamp +
                ", data=" + (data == null ? null : Arrays.asList(data)) +
                '}';
    }

    public StreamEvent[] toArray() { //TODO: review and remove
        return new StreamEvent[]{this};
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

}
