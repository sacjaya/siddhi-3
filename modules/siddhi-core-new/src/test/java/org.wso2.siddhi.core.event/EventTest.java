package org.wso2.siddhi.core.event;

import org.junit.Assert;
import org.junit.Test;
import org.wso2.siddhi.core.event.inner.InnerStreamEvent;
import org.wso2.siddhi.core.event.inner.InnerStreamEventConverter;
import org.wso2.siddhi.core.event.inner.MetaInnerStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventFactory;
import org.wso2.siddhi.core.event.inner.InnerStreamEventPool;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

/**
 * Created by suho on 8/13/14.
 */
public class EventTest {

    @Test
    public void testEventCreation() {
        StreamEventFactory streamEventFactory = new StreamEventFactory(2);
        Assert.assertEquals(2, streamEventFactory.newInstance().getData().length);
    }

//    @Test
//    public void testEventPool() {
//        StreamEventFactory streamEventFactory = new StreamEventFactory(2);
//        InnerStreamEventPool innerStreamEventPool = new InnerStreamEventPool(streamEventFactory, 4);
//
//        StreamEvent[] streamEvents = new StreamEvent[5];
//        for (int i = 0; i < 5; i++) {
//            streamEvents[i] = innerStreamEventPool.borrowEvent();
//        }
//        Assert.assertEquals(0, innerStreamEventPool.getBufferedEventsSize());
//
//        for (int i = 0; i < 5; i++) {
//            innerStreamEventPool.returnEvent(streamEvents[i]);
//        }
//        Assert.assertEquals(4, innerStreamEventPool.getBufferedEventsSize());
//
//        innerStreamEventPool.borrowEvent();
//        Assert.assertEquals(3, innerStreamEventPool.getBufferedEventsSize());
//
//    }


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
