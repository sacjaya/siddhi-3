/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org)
 * All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.query.output.callback;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.util.SiddhiConstants;
import org.wso2.siddhi.query.api.annotation.Element;
import org.wso2.siddhi.query.api.exception.DuplicateAnnotationException;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.util.AnnotationHelper;

import java.util.ArrayList;

public abstract class QueryCallback {

    private final String queryName;
    private final int outputDataSize;
    private SiddhiContext siddhiContext;
    private Query query;
    private ArrayList<Event> currentEventBuffer = new ArrayList<Event>();
    private ArrayList<Event> expiredEventBuffer = new ArrayList<Event>();

    private Disruptor<EventHolder> disruptor;
    private RingBuffer<EventHolder> ringBuffer;
    private AsyncEventHandler asyncEventHandler;

    protected QueryCallback(Query query, String queryName, int outputDataSize, SiddhiContext siddhiContext) {
        this.query = query;
        this.queryName = queryName;
        this.outputDataSize = outputDataSize;
        this.siddhiContext = siddhiContext;
    }

    public String getQueryName() {
        return queryName;
    }

    public void receiveStreamEvent(long timeStamp, StreamEvent currentStreamEvent, StreamEvent expiredStreamEvent) {

        if (disruptor == null) {
            send(timeStamp, currentStreamEvent, expiredStreamEvent);
        } else {
            sendAsync(timeStamp, currentStreamEvent, expiredStreamEvent);
        }

    }

    private void sendAsync(long timeStamp, StreamEvent currentStreamEvent, StreamEvent expiredStreamEvent) {

        long sequenceNo = ringBuffer.next();
        try {
            EventHolder holder = ringBuffer.get(sequenceNo);
            holder.timeStamp = timeStamp;
            holder.currentStreamEvent = currentStreamEvent;
            holder.expiredStreamEvent = expiredStreamEvent;
        } finally {
            ringBuffer.publish(sequenceNo);
        }
    }

    private void send(long timeStamp, StreamEvent currentStreamEvent, StreamEvent expiredStreamEvent, boolean endOfBatch) {

        if (endOfBatch) {
            send(timeStamp, currentStreamEvent, expiredStreamEvent);
        } else {
            StreamEvent processedEvent = currentStreamEvent;
            bufferEvents(processedEvent, currentEventBuffer);

            processedEvent = expiredStreamEvent;
            bufferEvents(processedEvent, expiredEventBuffer);
        }
    }

    private void send(long timeStamp, StreamEvent currentStreamEvent, StreamEvent expiredStreamEvent) {

        Event[] currentEvents = null;
        Event[] expiredEvents = null;

        bufferEvents(currentStreamEvent, currentEventBuffer);

        if (currentEventBuffer.size() > 0) {
            currentEvents = currentEventBuffer.toArray(new Event[currentEventBuffer.size()]);
            currentEventBuffer.clear();
        }

        bufferEvents(expiredStreamEvent, expiredEventBuffer);

        if (expiredEventBuffer.size() > 0) {
            expiredEvents = expiredEventBuffer.toArray(new Event[expiredEventBuffer.size()]);
            expiredEventBuffer.clear();
        }

        receive(timeStamp, currentEvents, expiredEvents);
    }

    private void bufferEvents(StreamEvent streamEventList, ArrayList<Event> eventBuffer) {

        StreamEvent processedEvent = streamEventList;
        while (processedEvent != null) {
            eventBuffer.add(new Event(outputDataSize).copyFrom(processedEvent));
            processedEvent = processedEvent.getNext();
        }
    }

    public synchronized void startProcessing() {

        Boolean asyncEnabled = null;
        try {
            Element element = AnnotationHelper.getAnnotationElement(SiddhiConstants.ANNOTATION_CONFIG,
                    SiddhiConstants.ANNOTATION_ELEMENT_CALLBACK_ASYNC,
                    query.getAnnotations());

            if (element != null) {
                asyncEnabled = SiddhiConstants.TRUE.equalsIgnoreCase(element.getValue());
            }

        } catch (DuplicateAnnotationException e) {
            throw new QueryCreationException(e.getMessage() + " for the same Query " +
                    query.toString());
        }

        if (asyncEnabled != null && asyncEnabled || asyncEnabled == null) {

            ProducerType producerType = ProducerType.SINGLE;

            disruptor = new Disruptor<EventHolder>(new EventHolderFactory(), siddhiContext.getDefaultEventBufferSize(),
                    siddhiContext.getExecutorService(), ProducerType.SINGLE, new SleepingWaitStrategy());

            asyncEventHandler = new AsyncEventHandler(this);
            disruptor.handleEventsWith(asyncEventHandler);
            ringBuffer = disruptor.start();
        }
    }

    public synchronized void stopProcessing() {
        if (disruptor != null) {
            asyncEventHandler.queryCallback = null;
            disruptor.shutdown();
        }
    }


    public abstract void receive(long timeStamp, Event[] inEvents, Event[] removeEvents);


    public class AsyncEventHandler implements EventHandler<EventHolder> {

        private QueryCallback queryCallback;

        public AsyncEventHandler(QueryCallback queryCallback) {
            this.queryCallback = queryCallback;
        }

        /**
         * Called when a publisher has published an event to the {@link com.lmax.disruptor.RingBuffer}
         *
         * @param eventHolder published to the {@link com.lmax.disruptor.RingBuffer}
         * @param sequence    of the event being processed
         * @param endOfBatch  flag to indicate if this is the last event in a batch from the {@link com.lmax.disruptor.RingBuffer}
         * @throws Exception if the EventHandler would like the exception handled further up the chain.
         */
        @Override
        public void onEvent(EventHolder eventHolder, long sequence, boolean endOfBatch) throws Exception {
            if (queryCallback != null) {
                queryCallback.send(eventHolder.timeStamp, eventHolder.currentStreamEvent, eventHolder.expiredStreamEvent, endOfBatch);
            }
        }
    }

    public class EventHolder {

        private long timeStamp;
        private StreamEvent currentStreamEvent;
        private StreamEvent expiredStreamEvent;

    }

    public class EventHolderFactory implements com.lmax.disruptor.EventFactory<EventHolder> {

        public EventHolder newInstance() {
            return new EventHolder();
        }
    }
}
