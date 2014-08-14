package org.wso2.siddhi.core.event;

import org.junit.Assert;
import org.junit.Test;
import org.wso2.siddhi.core.event.inner.InnerStreamEvent;
import org.wso2.siddhi.core.event.inner.InnerStreamEventFactory;
import org.wso2.siddhi.core.event.stream.StreamEventFactory;
import org.wso2.siddhi.core.event.inner.InnerStreamEventPool;

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
