package org.wso2.siddhi.core.event;

import com.lmax.disruptor.EventTranslator;

/**
 * Created with IntelliJ IDEA.
 * User: sachini
 * Date: 6/27/14
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class SiddhiEventPublishTranslator implements EventTranslator<Event> {
    private String streamId;
    private long timeStamp;
    private Object[] data;


    public SiddhiEventPublishTranslator(Event event) {
        this.timeStamp = event.getTimeStamp();
        this.data = event.getData();
        this.streamId = event.getStreamId();
    }

    public void translateTo(Event event, long sequence) {
        event.setData(data);
        event.setTimeStamp(timeStamp);
        event.setStreamId(streamId);
    }
}