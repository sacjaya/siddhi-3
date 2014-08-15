/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.siddhi.core.stream;

import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.stream.MetaStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventConverter;
import org.wso2.siddhi.core.stream.runtime.SingleStreamRuntime;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

import java.util.ArrayList;

public class QueryStreamReceiver implements StreamJunction.Receiver{

    private StreamEventConverter eventConverter;
    private String streamId;
    private ArrayList<StreamEvent> eventBuffer = new ArrayList<StreamEvent>();
    private SingleStreamRuntime singleStreamRuntime;

    public QueryStreamReceiver(MetaStreamEvent metaStreamEvent,StreamDefinition streamDefinition){
        this.streamId = streamDefinition.getId();
        eventConverter = new StreamEventConverter(metaStreamEvent,streamDefinition);
    }

    @Override
    public String getStreamId() {
        return streamId;
    }

    @Override
    public void receive(StreamEvent streamEvent) {
        streamEvent = eventConverter.convertToStreamEvent(streamEvent);
        if(singleStreamRuntime != null){
            singleStreamRuntime.receive(streamEvent);
        }
    }

    @Override
    public void receive(Event event, boolean endOfBatch) {
        StreamEvent streamEvent = eventConverter.convertToStreamEvent(event);

//        synchronized (this){
            if(eventBuffer.size()>0){
                eventBuffer.get(eventBuffer.size()-1).setNext(streamEvent);
            }
            eventBuffer.add(streamEvent);
//        }

        if (endOfBatch) {
            if (singleStreamRuntime != null) {
                singleStreamRuntime.receive(eventBuffer.get(0));
            }
            eventBuffer.clear();
        }

    }

    public void setSingleStreamRuntime(SingleStreamRuntime singleStreamRuntime){
        this.singleStreamRuntime = singleStreamRuntime;
    }



}
