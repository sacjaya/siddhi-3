/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.siddhi.core.query.processor.handler;

import com.lmax.disruptor.dsl.Disruptor;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.query.PartitionRuntime;
import org.wso2.siddhi.core.query.QueryPartitioner;

import org.wso2.siddhi.core.query.QueryRuntime;
import org.wso2.siddhi.core.stream.StreamJunction;

import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.selector.QuerySelector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PartitionHandlerProcessor implements HandlerProcessor {

    private final String streamId;
    private QueryPartitioner queryPartitioner;
    private int disruptorsSize = 3;
    private Disruptor[] disruptors;
    private SiddhiContext siddhiContext;
    private final int handlerId;
    private PartitionRuntime partitionRuntime;
    private List<PartitionExecutor> partitionExecutors;
    private ConcurrentHashMap<String,StreamJunction> cachedStreamJunctionMap = new ConcurrentHashMap<String, StreamJunction>();


    private ConcurrentHashMap<String, HandlerProcessor> partitionedHandlerMap = new ConcurrentHashMap<String, HandlerProcessor>();
    private EventConverter eventConverter;
    private QuerySelector next;     //TODO: review. added to implement HandlerProcessor.setQuerySelector()


    public PartitionHandlerProcessor(SiddhiContext siddhiContext, String streamId, QueryPartitioner queryPartitioner, int handlerId, List<PartitionExecutor> partitionExecutors, PartitionRuntime partitionRuntime) {
        this.streamId = streamId;
        this.queryPartitioner = queryPartitioner;
        this.handlerId = handlerId;
        this.partitionExecutors = partitionExecutors;
        this.partitionRuntime = partitionRuntime;
        this.siddhiContext = siddhiContext;
    }

    @Override
    public void receive(StreamEvent streamEvent) {
        if (partitionExecutors.isEmpty()) {
            send(streamEvent);
        } else {
            for (PartitionExecutor partitionExecutor : partitionExecutors) {
                String key = partitionExecutor.execute((streamEvent));
                send(key, streamEvent);
            }
        }
    }

    public void setDisruptors(Disruptor[] disruptors) {
        this.disruptors = disruptors;
    }

    private void send(String key, StreamEvent event) {
        if (key == null) {
            return;
        }

        partitionRuntime.clone(key);
        getStreamJunction(streamId+key).send(event);
    }




    private void send(StreamEvent event) {
        getStreamJunction(streamId).send(event);
//        StreamJunction streamJunction = partitionRuntime.getStreamJunction(streamId);
//        if (streamJunction == null) {
//            streamJunction = new StreamJunction(streamId, siddhiContext.getExecutorService());
//            partitionRuntime.addStreamJunction(streamId,streamJunction);
//        }
//        streamJunction.send(event);

    }

    private StreamJunction getStreamJunction(String streamJunctionName){
        StreamJunction streamJunction = cachedStreamJunctionMap.get(streamJunctionName);
        if (streamJunction == null) {
            streamJunction = new StreamJunction(streamJunctionName, siddhiContext.getExecutorService());
            partitionRuntime.addStreamJunction(streamJunctionName,streamJunction);
            cachedStreamJunctionMap.putIfAbsent(streamJunctionName, streamJunction);
        }
        return streamJunction;
    }


    public void addStreamJunction(String key, List<QueryRuntime> queryRuntimeList) {
        if (!partitionExecutors.isEmpty()) {
            StreamJunction streamJunction = cachedStreamJunctionMap.get(streamId + key);
            if (streamJunction == null) {
                for (QueryRuntime queryRuntime : queryRuntimeList) {
                    if (queryRuntime.getInputStreamId().get(0).equals(streamId)) {

                        HandlerProcessor handlerProcessor = queryPartitioner.newPartition(handlerId, key, queryRuntime.getOutputRateManager());
                        streamJunction = new StreamJunction(streamId + key, siddhiContext.getExecutorService());
                        streamJunction.addEventFlow(handlerProcessor);
                        partitionRuntime.addStreamJunction(streamId + key, streamJunction);
                        cachedStreamJunctionMap.put(streamId + key, streamJunction);


                    }
                }
            }
        }
    }

    public String getStreamId() {
        return streamId;
    }


    public Disruptor[] getDisruptors() {
        return disruptors;
    }

    @Override
    public Processor getProcessor() { //TODO: figure out what to do. Needed for setting event converter
        return null;
    }

    @Override
    public void setEventConverter(EventConverter eventConverter) {
        this.eventConverter = eventConverter;
    }

    @Override
    public void setSelector(QuerySelector querySelector) {
        this.next = querySelector;
    }

    public int getDisruptorsSize() {
        return disruptorsSize;
    }

    public void setDisruptorsSize(int disruptorsSize) {
        this.disruptorsSize = disruptorsSize;
    }

    public List<String> getPartitionKeys(StreamEvent streamEvent) {
        List<String> keys = new ArrayList<String>();
        for (PartitionExecutor partitionExecutor : partitionExecutors) {
            keys.add(partitionExecutor.execute((streamEvent)));

        }
        return keys;
    }


}
