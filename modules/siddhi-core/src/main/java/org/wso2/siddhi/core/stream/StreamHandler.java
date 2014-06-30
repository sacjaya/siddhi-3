package org.wso2.siddhi.core.stream;

import com.lmax.disruptor.EventHandler;
import org.wso2.siddhi.core.event.Event;

/**
 * Created with IntelliJ IDEA.
 * User: sachini
 * Date: 6/30/14
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class StreamHandler implements EventHandler<Event> {

    private StreamReceiver streamReceiver;
    public StreamHandler(StreamReceiver streamReceiver){
        this.streamReceiver =streamReceiver;
    }

    public void onEvent(Event event, long sequence, boolean endOfBatch)


    {
        streamReceiver.receive(event);


    }
}