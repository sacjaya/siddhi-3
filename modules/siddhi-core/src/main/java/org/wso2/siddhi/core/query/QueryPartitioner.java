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
import org.wso2.siddhi.core.query.processor.PreSelectProcessingElement;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.expression.ExpressionValidator;
import org.wso2.siddhi.query.api.partition.Partition;
import org.wso2.siddhi.query.api.partition.PartitionType;
import org.wso2.siddhi.query.api.partition.ValuePartitionType;
import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;
import org.wso2.siddhi.query.api.query.input.InputStream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class QueryPartitioner {
    private final QueryCreator queryCreator;
    private List<List<PartitionExecutor>> partitionExecutors = new ArrayList<List<PartitionExecutor>>();
    private ConcurrentHashMap<String, List<HandlerProcessor>> partitionMap = new ConcurrentHashMap<String, List<HandlerProcessor>>();
    private List<QuerySelector> querySelectorList;

    public QueryPartitioner(Partition partition, QueryCreator queryCreator, List<QuerySelector> querySelectorList,
                            SiddhiContext siddhiContext) {
        this.queryCreator = queryCreator;
        this.querySelectorList = querySelectorList;

        if (partition != null) {

            InputStream inputStream = queryCreator.getInputStream();

            if(inputStream instanceof BasicSingleInputStream){

                ArrayList<PartitionExecutor> executorList = new ArrayList<PartitionExecutor>();
                partitionExecutors.add(executorList);
                for (PartitionType partitionType : partition.getPartitionTypeList()) {
                    Map<String, Set<String>> dependencyMap;
                    if (partitionType instanceof ValuePartitionType) {
                        dependencyMap = ExpressionValidator.getDependency(((ValuePartitionType) partitionType).getExpression());
                        if (dependencyMap.isEmpty() ||  ((ValuePartitionType) partitionType).getStreamId().equals(((BasicSingleInputStream) inputStream).getStreamId())) {
                            try {
                                executorList.add(new ValuePartitionExecutor(ExecutorParser.parseExpression(((ValuePartitionType) partitionType).getExpression(), ((BasicSingleInputStream) inputStream).getStreamId(),  siddhiContext, queryCreator.getTempStreamDefinitionMap())));
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

    public List<HandlerProcessor> constructPartition() {
        QueryPartComposite queryPartComposite = queryCreator.constructQuery();
        querySelectorList.add(queryPartComposite.getQuerySelector());
        for (PreSelectProcessingElement preSelectProcessingElement : queryPartComposite.getPreSelectProcessingElementList()) {
            preSelectProcessingElement.setNext(queryPartComposite.getQuerySelector());
        }
        return queryPartComposite.getHandlerProcessorList();
    }


    public List<List<PartitionExecutor>> getPartitionExecutors() {
        return partitionExecutors;
    }

    public HandlerProcessor newPartition(int handlerId, String partitionKey) {
        List<HandlerProcessor> handlerProcessorList = partitionMap.get(partitionKey);
        if (handlerProcessorList == null) {
            handlerProcessorList = constructPartition();
            partitionMap.put(partitionKey, handlerProcessorList);
        }
        return handlerProcessorList.get(handlerId);

    }
}
