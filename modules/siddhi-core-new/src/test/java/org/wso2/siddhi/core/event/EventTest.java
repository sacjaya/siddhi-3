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
import org.wso2.siddhi.core.stream.Event;
import org.wso2.siddhi.core.stream.EventFactory;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

public class EventTest {

    @Test
    public void testEventCreation() {
        EventFactory eventFactory = new EventFactory(2);
        Assert.assertEquals(2, eventFactory.newInstance().getData().length);

        StreamEventFactory streamEventFactory = new StreamEventFactory(2, 3, 4);
        StreamEvent streamEvent = streamEventFactory.newInstance();
        Assert.assertEquals(2, streamEvent.getBeforeWindowData().length);
        Assert.assertEquals(3, streamEvent.getOnAfterWindowData().length);
        Assert.assertEquals(4, streamEvent.getOutputData().length);
    }

    @Test
    public void testEventPool() {
        StreamEventFactory eventFactory = new StreamEventFactory(2, 3, 1);
        StreamEventPool streamEventPool = new StreamEventPool(eventFactory, 4);

        StreamEvent[] streamEvents = new StreamEvent[5];
        for (int i = 0; i < 5; i++) {
            streamEvents[i] = streamEventPool.borrowEvent();
        }
        Assert.assertEquals(0, streamEventPool.getBufferedEventsSize());

        for (int i = 0; i < 5; i++) {
            streamEventPool.returnEvent(streamEvents[i]);
        }
        Assert.assertEquals(4, streamEventPool.getBufferedEventsSize());

        streamEventPool.borrowEvent();
        Assert.assertEquals(3, streamEventPool.getBufferedEventsSize());

    }

    @Test
    public void testEventConverter() {
        Attribute price = new Attribute("price", Attribute.Type.DOUBLE);
        Attribute volume = new Attribute("volume", Attribute.Type.INT);
        Attribute symbol = new Attribute("symbol", Attribute.Type.STRING);
        ComplexAttribute avgPrice = new ComplexAttribute();

        MetaStreamEvent metaStreamEvent = new MetaStreamEvent();
        metaStreamEvent.addData(volume);
        metaStreamEvent.intializeAfterWindowData();
        metaStreamEvent.addData(price);
        metaStreamEvent.intializeOutData();
        metaStreamEvent.addData(symbol);
        metaStreamEvent.addData(avgPrice);

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.DOUBLE).attribute("volume", Attribute.Type.INT);
        Event event = new Event(System.currentTimeMillis(), new Object[]{"WSO2", 200, 50});

        StreamEventConverter converter = new StreamEventConverter(metaStreamEvent, streamDefinition);
        StreamEvent streamEvent = converter.convertToStreamEvent(event);

        Assert.assertEquals(1, streamEvent.getBeforeWindowData().length);      //volume
        Assert.assertEquals(1, streamEvent.getOnAfterWindowData().length);     //price
        Assert.assertEquals(2, streamEvent.getOutputData().length);            //symbol and avgPrice

        Assert.assertEquals(50, streamEvent.getBeforeWindowData()[0]);
        Assert.assertEquals(200, streamEvent.getOnAfterWindowData()[0]);
        Assert.assertEquals("WSO2", streamEvent.getOutputData()[0]);
    }
}
