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

package org.wso2.siddhi.core.event.disruptor.util;

import com.lmax.disruptor.EventTranslator;
import org.wso2.siddhi.core.event.Event;

public class SiddhiEventPublishTranslator implements EventTranslator<Event> {
    private String streamId;
    private long timeStamp;
    private Object[] data;


    public SiddhiEventPublishTranslator(Event event) {
        this.timeStamp = event.getTimeStamp();
        this.data = event.getData();
        this.streamId = event.getStreamId();
    }

    public void translateTo(Event event, long sequence) {
        event.setData(data);
        event.setTimeStamp(timeStamp);
        event.setStreamId(streamId);
    }
}