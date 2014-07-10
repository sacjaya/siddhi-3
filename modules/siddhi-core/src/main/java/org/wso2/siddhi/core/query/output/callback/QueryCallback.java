/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

public abstract class QueryCallback {

    private StreamDefinition streamDefinition;


    public StreamDefinition getStreamDefinition() {
        return streamDefinition;
    }

    public void receiveStreamEvent(long timeStamp, StreamEvent currentEvent, StreamEvent expiredEvent) {
         send(timeStamp, currentEvent, expiredEvent);

    }

    private void send(long timeStamp, StreamEvent currentEvent, StreamEvent expiredEvent) {
        if (currentEvent != null) {
            receive(timeStamp, currentEvent.toArray(), null);
        } else if (expiredEvent != null) {
            receive(timeStamp, null, expiredEvent.toArray());
        } else {
            receive(timeStamp, null, null);
        }
    }

    public abstract void receive(long timeStamp, Event[] inEvents,
                                 Event[] removeEvents);

    public void setStreamDefinition(StreamDefinition streamDefinition) {
        this.streamDefinition = streamDefinition;
    }


}
