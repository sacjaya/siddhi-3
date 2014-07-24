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
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.query.QueryPartitioner;

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

    public PartitionedStreamHandlerProcessor(String streamId, QueryPartitioner queryPartitioner, int handlerId) {
        this.streamId = streamId;
        this.queryPartitioner = queryPartitioner;
        this.handlerId = handlerId;
    }

    @Override
    public void receive(StreamEvent streamEvent) {
//        for (PartitionExecutor partitionExecutor : partitionExecutors) {
//                String key = partitionExecutor.execute((streamEvent));
//                send(key, streamEvent);
//        }
    }

    @Override
    public void receive(String key, StreamEvent streamEvent) {
           send(key, streamEvent);

    }


    public void setDisruptors(Disruptor[] disruptors) {
        this.disruptors = disruptors;
    }

    private void send(String key, StreamEvent event) {
        if (key == null) {
            return;
        }
        HandlerProcessor handlerProcessor = partitionedHandlerMap.get(key);
        if (handlerProcessor == null) {
            handlerProcessor = queryPartitioner.newPartition(handlerId, key);
            partitionedHandlerMap.put(key, handlerProcessor);
        }
        handlerProcessor.receive(key,event);

    }

    public String getStreamId() {
        return streamId;
    }


    public Disruptor[] getDisruptors() {
        return disruptors;
    }

    public int getDisruptorsSize(){
        return disruptorsSize;
    }

    public void setDisruptorsSize(int disruptorsSize){
        this.disruptorsSize =  disruptorsSize;
    }



}
