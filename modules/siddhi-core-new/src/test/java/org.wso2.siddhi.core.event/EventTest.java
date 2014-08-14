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
import org.wso2.siddhi.core.event.inner.*;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventFactory;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

public class EventTest {

    @Test
    public void testEventCreation() {
        StreamEventFactory streamEventFactory = new StreamEventFactory(2);
        Assert.assertEquals(2, streamEventFactory.newInstance().getData().length);

        InnerStreamEventFactory innerStreamEventFactory = new InnerStreamEventFactory(2, 3, 4);
        InnerStreamEvent innerStreamEvent = innerStreamEventFactory.newInstance();
        Assert.assertEquals(2, innerStreamEvent.getBeforeWindowData().length);
        Assert.assertEquals(3, innerStreamEvent.getOnAfterWindowData().length);
        Assert.assertEquals(4, innerStreamEvent.getOutputData().length);
    }

    @Test
    public void testEventPool() {
        InnerStreamEventFactory eventFactory = new InnerStreamEventFactory(2, 3, 1);
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

    @Test
    public void testEventConverter() {
        Attribute price = new Attribute("price", Attribute.Type.DOUBLE);
        Attribute volume = new Attribute("volume", Attribute.Type.INT);
        Attribute symbol = new Attribute("symbol", Attribute.Type.STRING);
        ComplexAttribute avgPrice = new ComplexAttribute();

        MetaInnerStreamEvent metaInnerStreamEvent = new MetaInnerStreamEvent();
        metaInnerStreamEvent.addData(volume);
        metaInnerStreamEvent.intializeAfterWindowData();
        metaInnerStreamEvent.addData(price);
        metaInnerStreamEvent.intializeOutData();
        metaInnerStreamEvent.addData(symbol);
        metaInnerStreamEvent.addData(avgPrice);

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.DOUBLE).attribute("volume", Attribute.Type.INT);
        StreamEvent event = new StreamEvent(System.currentTimeMillis(), new Object[]{"WSO2", 200, 50});

        InnerStreamEventConverter converter = new InnerStreamEventConverter(metaInnerStreamEvent, streamDefinition);
        InnerStreamEvent innerStreamEvent = converter.convertToInnerStreamEvent(event);

        Assert.assertEquals(1, innerStreamEvent.getBeforeWindowData().length);      //volume
        Assert.assertEquals(1, innerStreamEvent.getOnAfterWindowData().length);     //price
        Assert.assertEquals(2, innerStreamEvent.getOutputData().length);            //symbol and avgPrice

        Assert.assertEquals(50, innerStreamEvent.getBeforeWindowData()[0]);
        Assert.assertEquals(200, innerStreamEvent.getOnAfterWindowData()[0]);
        Assert.assertEquals("WSO2", innerStreamEvent.getOutputData()[0]);
    }
}
