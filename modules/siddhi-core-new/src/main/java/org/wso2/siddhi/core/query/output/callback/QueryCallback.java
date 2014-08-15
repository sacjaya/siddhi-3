/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org)
 * All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.query.output.callback;

import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.stream.StreamEvent;

import java.util.ArrayList;

public abstract class QueryCallback {

    private final String queryName;
    private final int outputDataSize;
    private ArrayList<Event> eventBuffer = new ArrayList<Event>();

    protected QueryCallback(String queryName, int outputDataSize) {
        this.queryName = queryName;
        this.outputDataSize = outputDataSize;
    }

    public String getQueryName() {
        return queryName;
    }

    public void receiveStreamEvent(long timeStamp, StreamEvent currentStreamEvent, StreamEvent expiredStreamEvent) {

        Event[] currentEvents = null;
        Event[] expiredEvents = null;

        StreamEvent processedEvent = currentStreamEvent;
        bufferEvents(processedEvent);

        if (currentStreamEvent != null) {
            currentEvents = eventBuffer.toArray(new Event[eventBuffer.size()]);
            eventBuffer.clear();
        }

        processedEvent = expiredStreamEvent;
        bufferEvents(processedEvent);

        if (expiredStreamEvent != null) {
            expiredEvents = eventBuffer.toArray(new Event[eventBuffer.size()]);
            eventBuffer.clear();
        }

        receive(timeStamp, currentEvents, expiredEvents);

    }

    private void bufferEvents(StreamEvent processedEvent) {
        while (processedEvent != null) {
            eventBuffer.add(new Event(outputDataSize).copyFrom(processedEvent));
            processedEvent = processedEvent.getNext();
        }
    }

    public abstract void receive(long timeStamp, Event[] inEvents, Event[] removeEvents);

}
