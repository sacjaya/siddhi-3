package org.wso2.siddhi.core.event.pool;

import org.wso2.siddhi.core.event.ComplexEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventFactory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by suho on 8/8/14.
 */
public class EventPool {
    private SiddhiEventFactory siddhiEventFactory;
    private int size;
    private ComplexEvent complexEvent = null;
    private int position = -1;
    private Lock lock = new ReentrantLock();
//    private AtomicInteger position = new AtomicInteger(-1);

    public EventPool(SiddhiEventFactory siddhiEventFactory, int size) {
        this.siddhiEventFactory = siddhiEventFactory;
        this.size = size;
    }

    public ComplexEvent getEvent() {
        if (position < 0) {
            return siddhiEventFactory.newInstance();
        } else {
            if (lock.tryLock()) {
                try {
                    if (position < 0) {
                        return siddhiEventFactory.newInstance();

                    } else {
                        position--;
                        StreamEvent currentEvent = (StreamEvent) complexEvent;
                        complexEvent = ((StreamEvent) complexEvent).getNext();
                        currentEvent.setNext(null);
                        return currentEvent;
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                return siddhiEventFactory.newInstance();
            }
        }

    }

    public synchronized void returnEvent(ComplexEvent returnEvent) {

        if (position < size) {
            if (lock.tryLock()) {
                try {
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
                } finally {
                    lock.unlock();
                }
            }


        }
    }

}
