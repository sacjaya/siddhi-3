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
package org.wso2.siddhi.core.stream.output;

import com.lmax.disruptor.dsl.Disruptor;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.stream.StreamReceiver;

public abstract class StreamCallback implements StreamReceiver {

    private String streamId;
    private Disruptor disruptor;


    public void receive(StreamEvent streamEvent) {
        send(streamEvent);
    }


    private void send(StreamEvent event) {
        receive(event.toArray());
    }

    public abstract void receive(Event[] events);

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setDisruptor(Disruptor disruptor) {
        this.disruptor = disruptor;
    }

    public Disruptor getDisruptor() {
        return disruptor;
    }

}
