package org.wso2.siddhi.core.event;

import org.junit.Assert;
import org.junit.Test;
import org.wso2.siddhi.core.event.factory.StreamEventFactory;
import org.wso2.siddhi.core.event.pool.StreamEventPool;

/**
 * Created by suho on 8/13/14.
 */
public class EventTest {

    @Test
    public void testEventCreation() {
        StreamEventFactory streamEventFactory = new StreamEventFactory(2);
        Assert.assertEquals(2, streamEventFactory.newInstance().getData().length);
    }

    @Test
    public void testEventPool() {
        StreamEventFactory streamEventFactory = new StreamEventFactory(2);
        StreamEventPool streamEventPool = new StreamEventPool(streamEventFactory, 4);

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
}
