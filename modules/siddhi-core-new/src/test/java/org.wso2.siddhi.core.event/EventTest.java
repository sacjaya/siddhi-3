/*
*  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import org.junit.Assert;
import org.junit.Test;
import org.wso2.siddhi.core.event.inner.InnerStreamEvent;
import org.wso2.siddhi.core.event.inner.InnerStreamEventFactory;
import org.wso2.siddhi.core.event.stream.StreamEventFactory;
import org.wso2.siddhi.core.event.inner.InnerStreamEventPool;

public class EventTest {

    @Test
    public void testEventCreation() {
        StreamEventFactory streamEventFactory = new StreamEventFactory(2);
        Assert.assertEquals(2, streamEventFactory.newInstance().getData().length);
    }

    @Test
    public void testEventPool() {
        InnerStreamEventFactory eventFactory = new InnerStreamEventFactory(2,3,1);
        InnerStreamEventPool innerStreamEventPool = new InnerStreamEventPool(eventFactory, 4);

        InnerStreamEvent[] innerStreamEvents = new InnerStreamEvent[5];
        for (int i = 0; i < 5; i++) {
            innerStreamEvents[i] = innerStreamEventPool.borrowEvent();
        }
        Assert.assertEquals(0, innerStreamEventPool.getBufferedEventsSize());

        for (int i = 0; i < 5; i++) {
            innerStreamEventPool.returnEvent(innerStreamEvents[i]);
        }
        Assert.assertEquals(4, innerStreamEventPool.getBufferedEventsSize());

        innerStreamEventPool.borrowEvent();
        Assert.assertEquals(3, innerStreamEventPool.getBufferedEventsSize());

    }
}
