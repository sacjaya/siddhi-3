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

import org.wso2.siddhi.core.event.inner.InnerStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.stream.StreamJunction;

public abstract class StreamCallback implements StreamJunction.Receiver {


    private String streamId;

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    @Override
    public String getStreamId() {
        return streamId;
    }

    @Override
    public void receive(InnerStreamEvent innerStreamEvent) {
        receive(new StreamEvent[]{new StreamEvent(innerStreamEvent.getOutputData().length).copyFrom(innerStreamEvent)});    //Todo fix as array and Event
    }

    @Override
    public void receive(StreamEvent streamEvent, boolean endOfBatch) {
        receive(new StreamEvent[]{streamEvent});    //Todo fix as array and Event
    }

    public abstract void receive(StreamEvent[] streamEvents);

}
