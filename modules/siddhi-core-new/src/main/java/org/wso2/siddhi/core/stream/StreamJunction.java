/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.wso2.siddhi.core.event.inner.InnerStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventFactory;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class StreamJunction {

    private List<Receiver> receivers = new CopyOnWriteArrayList<Receiver>();
    private List<Publisher> publishers = new CopyOnWriteArrayList<Publisher>();

    private StreamDefinition streamDefinition;
    private ExecutorService executorService;
    private int bufferSize;

    private Disruptor<StreamEvent> disruptor;

    private RingBuffer<StreamEvent> ringBuffer;

    public StreamJunction(StreamDefinition streamDefinition, ExecutorService executorService, int defaultBufferSize) {
        this.streamDefinition = streamDefinition;
        bufferSize = defaultBufferSize;
        this.executorService = executorService;
    }

    public void sendEvent(InnerStreamEvent innerStreamEvent) {

        InnerStreamEvent innerStreamEventList = innerStreamEvent;
        if (disruptor != null) {

            while (innerStreamEventList != null) {
                long sequenceNo = ringBuffer.next();
                try {
                    StreamEvent existingStreamEvent = ringBuffer.get(sequenceNo);
                    existingStreamEvent.copyFrom(innerStreamEventList);
                } finally {
                    ringBuffer.publish(sequenceNo);
                }
                innerStreamEventList = innerStreamEventList.getNext();
            }

        } else {
            for (Receiver receiver : receivers) {
                receiver.receive(innerStreamEvent);
            }
        }

    }

    public synchronized void startProcessing() {
        //todo check from annotation config(async=true)

        if (publishers.size() > 1 || receivers.size() > 1) {
            disruptor = new Disruptor<StreamEvent>(new StreamEventFactory(streamDefinition.getAttributeList().size()),
                    bufferSize, executorService, ProducerType.MULTI, new SleepingWaitStrategy());

            for (Receiver receiver : receivers) {
                disruptor.handleEventsWith(new StreamHandler(receiver));
            }

            ringBuffer = disruptor.getRingBuffer();

            disruptor.start();
        }

    }

    public synchronized void stopProcessing() {
        for (Publisher publisher : publishers) {
            publisher.setStreamJunction(null);
        }
        disruptor.shutdown();
    }

    private synchronized Publisher constructPublisher() {
        Publisher publisher = new Publisher();
        publisher.setStreamJunction(this);
        publishers.add(publisher);
        return publisher;
    }

    private synchronized void subscribe(Receiver receiver) {
        //to have reverse order at the sequence/pattern processors
        receivers.add(0, receiver);
    }

    public String getStreamId() {
        return streamDefinition.getId();
    }

    public class StreamHandler implements EventHandler<StreamEvent> {

        private Receiver receiver;

        public StreamHandler(Receiver receiver) {
            this.receiver = receiver;
        }

        public void onEvent(StreamEvent event, long sequence, boolean endOfBatch) {
            receiver.receive(event, endOfBatch);
        }

    }

    public interface Receiver {

        public String getStreamId();

        public void receive(InnerStreamEvent innerStreamEvent);

        public void receive(StreamEvent event, boolean endOfBatch);
    }

    public class Publisher {
        private StreamJunction streamJunction;

        public void setStreamJunction(StreamJunction streamJunction) {
            this.streamJunction = streamJunction;
        }

        public void send(InnerStreamEvent innerStreamEvent) {
            if (streamJunction != null) {
                streamJunction.sendEvent(innerStreamEvent);
            }
        }

        public String getStreamId() {
            return streamJunction.getStreamId();
        }
    }
}
