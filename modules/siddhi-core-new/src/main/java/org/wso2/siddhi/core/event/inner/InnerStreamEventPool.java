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
package org.wso2.siddhi.core.event.inner;

public class InnerStreamEventPool {

    private InnerStreamEventFactory eventFactory;
    private int size;
    private int index = 0;
    private InnerStreamEvent innerStreamEventList;

    public InnerStreamEventPool(InnerStreamEventFactory eventFactory, int size) {
        this.eventFactory = eventFactory;
        this.size = size;
    }

    public InnerStreamEvent borrowEvent() {
        if (index > 0) {
            InnerStreamEvent event = innerStreamEventList;
            innerStreamEventList = innerStreamEventList.getNext();
            event.setNext(null);
            index--;
            return event;
        } else {
            return eventFactory.newInstance();
        }
    }

    public void returnEvent(InnerStreamEvent innerStreamEvent) {
        if (index < size) {
            innerStreamEvent.setNext(innerStreamEventList);
            innerStreamEventList = innerStreamEvent;
            index++;
        }
    }

    public int getBufferedEventsSize(){
        return index;
    }
}
