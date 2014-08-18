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

package org.wso2.siddhi.core.partition;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventConverter;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.query.QueryRuntime;
import org.wso2.siddhi.core.stream.StreamJunction;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PartitionStreamReceiver implements StreamJunction.Receiver{

    private String streamId;
    private SiddhiContext siddhiContext;
    private PartitionRuntime partitionRuntime;
    private List<PartitionExecutor> partitionExecutors;
    private StreamEventConverter eventConverter;
    private ConcurrentHashMap<String,StreamJunction> cachedStreamJunctionMap = new ConcurrentHashMap<String, StreamJunction>();

    public PartitionStreamReceiver(SiddhiContext siddhiContext, String streamId, int handlerId, List<PartitionExecutor> partitionExecutors, PartitionRuntime partitionRuntime) {
        this.streamId = streamId;
        this.partitionRuntime = partitionRuntime;
        this.partitionExecutors = partitionExecutors;
        this.siddhiContext = siddhiContext;
    }

    @Override
    public String getStreamId() {
        return streamId;
    }

    @Override
    public void receive(StreamEvent streamEvent) {
        streamEvent = eventConverter.convertToStreamEvent(streamEvent);
        for (PartitionExecutor partitionExecutor : partitionExecutors) {
            String key = partitionExecutor.execute((streamEvent));
            send(key, streamEvent);
        }
    }

    @Override
    public void receive(Event event, boolean endOfBatch) {
          //TODO
//        StreamEvent streamEvent = eventConverter.convertToStreamEvent(event);
//        for (PartitionExecutor partitionExecutor : partitionExecutors) {
//            String key = partitionExecutor.execute((streamEvent));
//            send(key, streamEvent);
//        }
    }

    private void send(String key, StreamEvent event) {
        if (key == null) {
            return;
        }
        partitionRuntime.clone(key);
        getStreamJunction(streamId+key).sendEvent(event);
    }

    private StreamJunction getStreamJunction(String streamJunctionName){
        //TODO
        return null;
    }


    public void addStreamJunction(String key, List<QueryRuntime> queryRuntimeList) {
        //TODO
    }
}
