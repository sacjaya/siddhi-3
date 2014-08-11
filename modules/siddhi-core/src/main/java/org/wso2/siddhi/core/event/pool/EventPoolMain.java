package org.wso2.siddhi.core.event.pool;

import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventFactory;

/**
 * Created by suho on 8/8/14.
 */
public class EventPoolMain {
    public static void main(String[] args) {
        long events = 1000000000;
        long cont = 0;
        SiddhiEventFactory eventFactory = new SiddhiEventFactory();
        EventPool eventPool = new EventPool(new SiddhiEventFactory(), 10);
        long time = System.nanoTime();
        while (true) {
//            StreamEvent complexEvent = eventFactory.newInstance();
//            complexEvent.setData(new Object[]{"hjhk",798,234l,324.5,"yuiyui"});
            StreamEvent complexEvent = (StreamEvent) eventPool.getEvent();
//            complexEvent.setData(new Object[]{"hjhk", 798, 234l, 324.5, "yuiyui"});
            eventPool.returnEvent(complexEvent);
            cont++;
//            System.out.println(complexEvent);
            if (cont % events == 0) {
                long newTime = System.nanoTime();
                System.out.println((newTime - time));
                time = newTime;
            }
        }
//        System.out.println((System.nanoTime() - time));
    }
}
