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
import org.wso2.siddhi.core.event.stream.MetaStreamEvent;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.VariableExpressionExecutor;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.partition.executor.ValuePartitionExecutor;
import org.wso2.siddhi.core.util.parser.ExpressionParser;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.partition.PartitionType;
import org.wso2.siddhi.query.api.execution.partition.ValuePartitionType;
import org.wso2.siddhi.query.api.execution.query.input.stream.BasicSingleInputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;

import java.util.ArrayList;
import java.util.List;

public class QueryPartitioner {

    private List<List<PartitionExecutor>> partitionExecutors = new ArrayList<List<PartitionExecutor>>();

    public QueryPartitioner(InputStream inputStream, Partition partition, MetaStreamEvent metaStreamEvent, SiddhiContext siddhiContext) {
        if (partition != null) {
           if (inputStream instanceof BasicSingleInputStream) {
                List<PartitionExecutor> executorList = new ArrayList<PartitionExecutor>();
                partitionExecutors.add(executorList);
                for (PartitionType partitionType : partition.getPartitionTypeMap().values()) {
                    if (partitionType instanceof ValuePartitionType) {
                        if (partitionType.getStreamId().equals(((BasicSingleInputStream) inputStream).getStreamId())) {
                            try {
                                executorList.add(new ValuePartitionExecutor(ExpressionParser.parseExpression(((ValuePartitionType) partitionType).getExpression(), ((BasicSingleInputStream) inputStream).getStreamId(), siddhiContext, null, metaStreamEvent, new ArrayList<VariableExpressionExecutor>())));//TODO: add correct streamDefinition map as 4th parameter
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

    public List<List<PartitionExecutor>> getPartitionExecutors() {
        return partitionExecutors;
    }



}
