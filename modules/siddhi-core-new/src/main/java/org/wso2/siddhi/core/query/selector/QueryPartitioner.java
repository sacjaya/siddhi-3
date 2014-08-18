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
package org.wso2.siddhi.core.query.selector;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.partition.executor.ValuePartitionExecutor;
import org.wso2.siddhi.core.query.creator.QueryCreator;
import org.wso2.siddhi.core.query.output.rate_limit.OutputRateLimiter;
import org.wso2.siddhi.core.stream.runtime.StreamRuntime;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.partition.PartitionType;
import org.wso2.siddhi.query.api.execution.partition.ValuePartitionType;
import org.wso2.siddhi.query.api.execution.query.input.stream.BasicSingleInputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;
import sun.security.validator.ValidatorException;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//TODO: rename
public class QueryPartitioner {

    private final QueryCreator queryCreator;
    private List<List<PartitionExecutor>> partitionExecutors = new ArrayList<List<PartitionExecutor>>();
    private ConcurrentHashMap<String, StreamRuntime> partitionMap = new ConcurrentHashMap<String, StreamRuntime>();

    public QueryPartitioner(Partition partition, QueryCreator queryCreator,
                            SiddhiContext siddhiContext) {
        this.queryCreator = queryCreator;

        if (partition != null) {

            InputStream inputStream = queryCreator.getInputStream();

            if(inputStream instanceof BasicSingleInputStream){
                ArrayList<PartitionExecutor> executorList = new ArrayList<PartitionExecutor>();
                partitionExecutors.add(executorList);
                for (PartitionType partitionType : partition.getPartitionTypeMap().values()) {
                    if (partitionType instanceof ValuePartitionType) {
                       if (partitionType.getStreamId().equals(((BasicSingleInputStream) inputStream).getStreamId())) {
                            try {
                                executorList.add(new ValuePartitionExecutor(ExecutorParser.parseExpression(((ValuePartitionType) partitionType).getExpression(),
                                        ((BasicSingleInputStream) inputStream).getStreamId(), siddhiContext, queryCreator.getTempStreamDefinitionMap(), null,null)));//TODO: handle null arguments
                            } catch (ValidatorException e) {
                                //This will never happen
                            }
                        }
                    } else {
                          //TODO: range partitioning
                    }
                }
            }
            //TODO: else
        }
    }


    public StreamRuntime getQueryStreamRuntime(OutputRateLimiter outputRateLimiter) {
        //TODO
        return null;
    }


    public List<List<PartitionExecutor>> getPartitionExecutors() {
        return partitionExecutors;
    }

    public StreamRuntime cloneStreamRuntime(String partitionKey, OutputRateLimiter outputRateLimiter) {
        StreamRuntime streamRuntime = partitionMap.get(partitionKey);
        if (streamRuntime == null) {
//            streamRuntime = TODO:construct StreamRuntime;
            partitionMap.put(partitionKey, streamRuntime);
        }
        return streamRuntime;
    }

    public StreamRuntime cloneStreamRuntime(OutputRateLimiter outputRateLimiter) {
        return null;   //TODO:construct StreamRuntime;

    }

}
