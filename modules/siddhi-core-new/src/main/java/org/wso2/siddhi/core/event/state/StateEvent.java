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

package org.wso2.siddhi.core.event.state;

import org.wso2.siddhi.core.event.ComplexEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;

public class StateEvent implements ComplexEvent{
    private StreamEvent[] streamEvents;
    private StateEvent next;
    private int eventCount = 0;

    public StateEvent(int size){
        streamEvents = new StreamEvent[size];
    }

    public StateEvent(StreamEvent[] streamEvents){
        this.streamEvents = streamEvents;
        eventCount = streamEvents.length;
    }

    public StreamEvent getEvent(int position){
        return streamEvents[position];
    }

    public void addEvent(StreamEvent streamEvent){
        streamEvents[eventCount] = streamEvent;
        eventCount++;
    }

    public void setNext(StateEvent stateEvent){
        next = stateEvent;
    }

    public StateEvent getNext() {
        return next;
    }

    public Object[] getAttributes(int[] positions){
        Object[] attributes = new Object[streamEvents.length];
        for(int i=0; i<positions.length;i++){
            attributes[i] = streamEvents[i].getOutputData()[positions[i]];
        }
        return attributes;
    }
}
