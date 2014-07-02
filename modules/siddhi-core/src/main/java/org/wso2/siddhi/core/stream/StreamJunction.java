/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.core.stream;

import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventFactory;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventPublishTranslator;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class StreamJunction {
    private List<Disruptor> disruptorList = new CopyOnWriteArrayList<Disruptor>();
    private ThreadPoolExecutor threadPoolExecutor;
    private SiddhiEventFactory factory = new SiddhiEventFactory();
    private int bufferSize = 1024;

    private String streamId;

    public StreamJunction(String streamId, ThreadPoolExecutor threadPoolExecutor) {
        this.streamId = streamId;
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public void send(StreamEvent allEvents) {
        Event event = (Event) allEvents;
       for (Disruptor disruptor : disruptorList) {
           disruptor.publishEvent(new SiddhiEventPublishTranslator(event));
       }
    }

    public synchronized void addEventFlow(StreamReceiver streamReceiver) {
        Disruptor disruptor = new Disruptor<Event>(factory, bufferSize, threadPoolExecutor, ProducerType.SINGLE,new SleepingWaitStrategy());
        disruptor.handleEventsWith(new StreamHandler(streamReceiver));
        disruptor.start();
        disruptorList.add(disruptor);
    }

    public synchronized void removeEventFlow(HandlerProcessor queryStreamProcessor) {
//        disruptorReceiversMap.remove(queryStreamProcessor).shutdown();
    }

    public String getStreamId() {
        return streamId;
    }
}
