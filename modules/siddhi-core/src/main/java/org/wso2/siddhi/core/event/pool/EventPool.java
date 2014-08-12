package org.wso2.siddhi.core.event.pool;

import org.wso2.siddhi.core.event.ComplexEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by suho on 8/8/14.
 */
public class EventPool {
    private SiddhiEventFactory siddhiEventFactory;
    private int size;
    private ComplexEvent complexEvent = null;
    private int position = -1;
//    private Lock lock = new ReentrantLock();
    private AtomicInteger lock = new AtomicInteger(1);
//    private AtomicBoolean lock = new AtomicBoolean(false);
//    private AtomicInteger position = new AtomicInteger(-1);

    public EventPool(SiddhiEventFactory siddhiEventFactory, int size) {
        this.siddhiEventFactory = siddhiEventFactory;
        this.size = size;
    }

    public ComplexEvent getEvent() {
        if (position < 0) {
            return siddhiEventFactory.newInstance();
        } else {
//            if (lock.decrementAndGet()==0) {
//            if (lock.tryLock()) {
//                try {
                    if (position < 0) {
                        return siddhiEventFactory.newInstance();

                    } else {
                        position--;
                        StreamEvent currentEvent = (StreamEvent) complexEvent;
                        complexEvent = ((StreamEvent) complexEvent).getNext();
                        currentEvent.setNext(null);
                        return currentEvent;
                    }
//                } finally {
//                    lock.unlock();
//                    lock.set(1);
//                }
//            } else {
//                return siddhiEventFactory.newInstance();
//            }
        }

    }

    public synchronized void returnEvent(ComplexEvent returnEvent) {

        if (position < size) {
//            if (lock.tryLock()) {
//            if (lock.decrementAndGet()==0) {
//                try {
                    StreamEvent currentEvent = ((StreamEvent) returnEvent);
                    while (true) {
                        if (position < size) {
                            position++;
                            StreamEvent nextEvent = currentEvent.getNext();
                            currentEvent.setNext(((StreamEvent) complexEvent));
                            complexEvent = currentEvent;
                            if (nextEvent != null) {
                                currentEvent = nextEvent;
                            } else {
                                break;
                            }
                        }
                    }
//                } finally {
//                    lock.unlock();
                    lock.set(1);
//                }
//            }


        }
    }

}
