package org.wso2.siddhi.core.event;

import com.lmax.disruptor.EventFactory;
/**
 * Created with IntelliJ IDEA.
 * User: sachini
 * Date: 6/27/14
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class SiddhiEventFactory implements EventFactory<Event>
{
    public Event newInstance()
    {
        return new Event("", 0,null);
    }
}