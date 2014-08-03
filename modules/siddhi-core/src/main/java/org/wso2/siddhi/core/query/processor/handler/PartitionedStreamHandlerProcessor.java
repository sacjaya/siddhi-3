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
import org.wso2.siddhi.core.event.PartitionStreamEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.query.QueryPartitioner;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.selector.QuerySelector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PartitionedStreamHandlerProcessor implements HandlerProcessor {

    private final String streamId;
    private QueryPartitioner queryPartitioner;
    private int disruptorsSize = 5;
    private Disruptor[] disruptors;
    private final int handlerId;
    private ConcurrentHashMap<String, HandlerProcessor> partitionedHandlerMap = new ConcurrentHashMap<String, HandlerProcessor>();
    private EventConverter eventConverter;
    private QuerySelector next;     //TODO: review. added to implement HandlerProcessor.setQuerySelector()

    public PartitionedStreamHandlerProcessor(String streamId, QueryPartitioner queryPartitioner, int handlerId) {
        this.streamId = streamId;
        this.queryPartitioner = queryPartitioner;
        this.handlerId = handlerId;
    }



    @Override
    public void receive(StreamEvent streamEvent) {
           send(streamEvent);

    }


    public void setDisruptors(Disruptor[] disruptors) {
        this.disruptors = disruptors;
    }

    private void send(StreamEvent event) {
        if (!(event instanceof PartitionStreamEvent)) {
            return;
        }
        String key = ((PartitionStreamEvent) event).getPartitionKey();
        HandlerProcessor handlerProcessor = partitionedHandlerMap.get(key);
        if (handlerProcessor == null) {
            handlerProcessor = queryPartitioner.newPartition(handlerId, key);
            partitionedHandlerMap.put(key, handlerProcessor);
        }
        handlerProcessor.receive(event);

    }

    public String getStreamId() {
        return streamId;
    }


    public Disruptor[] getDisruptors() {
        return disruptors;
    }

    @Override
    public Processor getProcessor() { //TODO: figure out what to do
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

    public int getDisruptorsSize(){
        return disruptorsSize;
    }

    public void setDisruptorsSize(int disruptorsSize){
        this.disruptorsSize =  disruptorsSize;
    }



}
