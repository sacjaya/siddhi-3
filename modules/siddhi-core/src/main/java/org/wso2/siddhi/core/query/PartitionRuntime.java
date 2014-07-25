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

package org.wso2.siddhi.core.query;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.partition.Partition;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;

public class PartitionRuntime {
    private String partitionId;
    private List<String> queryIds = new ArrayList<String>();


    public PartitionRuntime(ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, StreamJunction> streamJunctionMap,  ConcurrentMap<String,ExecutionRuntime> queryProcessorMap, Partition partition, SiddhiContext siddhiContext) {
        if (partition.getPropertyValue("name") == null) {
           partition.property("name", UUID.randomUUID().toString());
        }
        this.partitionId = partition.getPropertyValue("name");

    }


   public void addQueryId(String queryId){
       queryIds.add(queryId);
   }

    public String getPartitionId() {
        return partitionId;
    }
}
