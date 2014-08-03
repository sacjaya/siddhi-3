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
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventFactory;
import org.wso2.siddhi.core.event.disruptor.util.SiddhiEventPublishTranslator;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.PartitionHandlerProcessor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class StreamJunction {
    private List<StreamReceiver> streamReceivers = new CopyOnWriteArrayList<StreamReceiver>();
    private ThreadPoolExecutor threadPoolExecutor;
    private ExecutorService tst = Executors.newCachedThreadPool();
    private SiddhiEventFactory factory = new SiddhiEventFactory();
    private boolean disruptorEnabled = false;
    private String streamId;

    public StreamJunction(String streamId, ThreadPoolExecutor threadPoolExecutor) {
        this.streamId = streamId;
        this.threadPoolExecutor = threadPoolExecutor;
    }


    public void send(StreamEvent event) {

        for (StreamReceiver streamReceiver : streamReceivers) {

            if (disruptorEnabled) {
                if (streamReceiver instanceof PartitionHandlerProcessor ) {
                    for (String key : ((PartitionHandlerProcessor) streamReceiver).getPartitionKeys(event)) {
                        //hash function to get the disruptor to which the event should be sent
                        int disruptorNo = Math.abs(key.hashCode()) % ((PartitionHandlerProcessor) streamReceiver).getDisruptorsSize();
                        streamReceiver.getDisruptors()[disruptorNo].publishEvent(new SiddhiEventPublishTranslator(event));
                    }
                }else {
                    streamReceiver.getDisruptors()[0].publishEvent(new SiddhiEventPublishTranslator(event));
                }
            } else {
                streamReceiver.receive(event);
            }

        }
    }

    public synchronized void addEventFlow(StreamReceiver streamReceiver) {
        if (disruptorEnabled) {

            int bufferSize = 1024;
            if (streamReceiver instanceof PartitionHandlerProcessor) {
                int disruptorsSize = ((HandlerProcessor)streamReceiver).getDisruptorsSize();
                Disruptor[] disruptors = new Disruptor[disruptorsSize];
                for (int i = 0; i < disruptorsSize; i++) {
                    Disruptor<StreamEvent> disruptor = new Disruptor<StreamEvent>(factory, bufferSize, tst, ProducerType.SINGLE, new SleepingWaitStrategy());
                    disruptors[i] = disruptor;
                    disruptor.handleEventsWith(new StreamHandler(streamReceiver));
                    disruptor.start();
                }
                streamReceiver.setDisruptors(disruptors);

            }else {
                Disruptor[] disruptors = new Disruptor[1];
                Disruptor<StreamEvent> disruptor = new Disruptor<StreamEvent>(factory, bufferSize, tst, ProducerType.SINGLE, new SleepingWaitStrategy());
                disruptors[0] = disruptor;
                streamReceiver.setDisruptors(disruptors);
                disruptor.handleEventsWith(new StreamHandler(streamReceiver));
                disruptor.start();
            }

        }
        //in reverse order to execute the later states first to overcome to dependencies of count states
        streamReceivers.add(0, streamReceiver);

    }

    public void removeEventFlow(HandlerProcessor queryStreamProcessor) {
        streamReceivers.remove(queryStreamProcessor);
        if (disruptorEnabled) {
            for (Disruptor disruptor : queryStreamProcessor.getDisruptors()) {
                disruptor.shutdown();
            }
        }
    }

    public String getStreamId() {
        return streamId;
    }

    public void setDisruptorEnabled(boolean enabled) {
        disruptorEnabled = enabled;
    }

}
