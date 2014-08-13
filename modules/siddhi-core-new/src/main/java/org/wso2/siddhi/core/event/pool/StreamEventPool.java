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
package org.wso2.siddhi.core.event.pool;

import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.factory.StreamEventFactory;

public class StreamEventPool {

    private StreamEventFactory eventFactory;
    private int size;
    private int index = 0;
    private StreamEvent streamEventList;

    public StreamEventPool(StreamEventFactory eventFactory, int size) {
        this.eventFactory = eventFactory;
        this.size = size;
    }

    public StreamEvent borrowEvent() {
        if (index > 0) {
            StreamEvent event = streamEventList;
            streamEventList = streamEventList.getNext();
            event.setNext(null);
            index--;
            return event;
        } else {
            return eventFactory.newInstance();
        }
    }

    public void returnEvent(StreamEvent streamEvent) {
        if (index < size) {
            streamEvent.setNext(streamEventList);
            streamEventList = streamEvent;
            index++;
        }
    }

    public int getBufferedEventsSize(){
        return index;
    }
}
