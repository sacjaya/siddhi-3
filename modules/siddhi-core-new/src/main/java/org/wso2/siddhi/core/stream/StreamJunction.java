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

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.util.SiddhiEventFactory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class StreamJunction {

    private List<StreamReceiver> streamReceivers = new CopyOnWriteArrayList<StreamReceiver>();
    private ExecutorService executorService;
    private SiddhiEventFactory factory = new SiddhiEventFactory();
    int bufferSize = 1024;
    private Disruptor<StreamEvent> disruptor;
    private boolean disruptorEnabled = false;
    private String streamId;
    RingBuffer<StreamEvent> ringBuffer;


    //TODO     disruptor.start();

    public StreamJunction(String streamId, ExecutorService executorService,ProducerType producerType) {
        this.streamId = streamId;
        this.executorService = executorService;
        disruptor = new Disruptor<StreamEvent>(factory, bufferSize, executorService, producerType, new SleepingWaitStrategy());
    }

    public void send(StreamEvent event) {
        ringBuffer = disruptor.start();

        if (disruptorEnabled) {
            long sequenceNo = ringBuffer.next();
            StreamEvent streamEvent = ringBuffer.get(sequenceNo);
            streamEvent.setData(event.getData());
            streamEvent.setTimestamp(event.getTimestamp());
            streamEvent.setIsExpired(event.isExpired());

            ringBuffer.publish(sequenceNo);
        } else {
            for (StreamReceiver streamReceiver : streamReceivers) {
                streamReceiver.receive(event);
            }
        }

    }

    public synchronized void addEventFlow(StreamReceiver streamReceiver) {
        if (disruptorEnabled) {
            disruptor.handleEventsWith(new StreamHandler(streamReceiver));
        }
        streamReceivers.add(0, streamReceiver);
    }


    public String getStreamId() {
        return streamId;
    }

    public void setDisruptorEnabled(boolean enabled) {
        disruptorEnabled = enabled;
    }

}
