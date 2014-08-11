/*
*  Copyright (c) 2005-2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.siddhi.core.query;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.partition.executor.ValuePartitionExecutor;
import org.wso2.siddhi.core.query.creator.QueryCreator;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.processor.PreSelectProcessingElement;
import org.wso2.siddhi.core.query.processor.handler.BasicHandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.partition.PartitionType;
import org.wso2.siddhi.query.api.execution.partition.ValuePartitionType;
import org.wso2.siddhi.query.api.execution.query.input.stream.BasicSingleInputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QueryPartitioner {
    private final QueryCreator queryCreator;
    private List<List<PartitionExecutor>> partitionExecutors = new ArrayList<List<PartitionExecutor>>();
    private ConcurrentHashMap<String, List<BasicHandlerProcessor>> partitionMap = new ConcurrentHashMap<String, List<BasicHandlerProcessor>>();
    private QueryPartComposite queryPartComposite;

    public QueryPartitioner(Partition partition, QueryCreator queryCreator,
                            SiddhiContext siddhiContext) {
        this.queryCreator = queryCreator;

        if (partition != null) {

            InputStream inputStream = queryCreator.getInputStream();

            if(inputStream instanceof BasicSingleInputStream){
                ArrayList<PartitionExecutor> executorList = new ArrayList<PartitionExecutor>();
                partitionExecutors.add(executorList);
                for (PartitionType partitionType : partition.getPartitionTypeMap().values()) {
                    Map<String, Set<String>> dependencyMap =null;
                    if (partitionType instanceof ValuePartitionType) {
                        //todo fix get dependency
//                       dependencyMap = ExpressionValidator.getDependency(((ValuePartitionType) partitionType).getExpression());
                        if (/*dependencyMap.isEmpty() ||*/  partitionType.getStreamId().equals(((BasicSingleInputStream) inputStream).getStreamId())) {
                            try {
                                executorList.add(new ValuePartitionExecutor(ExecutorParser.parseExpression(((ValuePartitionType) partitionType).getExpression(), ((BasicSingleInputStream) inputStream).getStreamId(), siddhiContext, queryCreator.getTempStreamDefinitionMap(), null,null)));//TODO: handle null arguments
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


    public List<BasicHandlerProcessor> constructPartition(OutputRateManager outputRateManager) {
        queryPartComposite = queryCreator.constructQuery(outputRateManager);
        return Arrays.asList(queryPartComposite.getHandlerProcessor()); //TODO: discuss and fix handlerProcessorList/processor
    }


    public List<List<PartitionExecutor>> getPartitionExecutors() {
        return partitionExecutors;
    }

    public HandlerProcessor newPartition(int handlerId, String partitionKey, OutputRateManager outputRateManager) {
        List<BasicHandlerProcessor> handlerProcessorList = partitionMap.get(partitionKey);
        if (handlerProcessorList == null) {
            handlerProcessorList = cloneHandlerProcessors(outputRateManager);
            partitionMap.put(partitionKey, handlerProcessorList);
        }
        return handlerProcessorList.get(handlerId);
    }


    public List<BasicHandlerProcessor> cloneHandlerProcessors(OutputRateManager outputRateManager) {
       return queryCreator.cloneHandlers(outputRateManager,queryPartComposite);
    }
}
