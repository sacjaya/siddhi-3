/**
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.siddhi.core.config;

import org.wso2.siddhi.core.exception.CreateExecutionPlanException;
import org.wso2.siddhi.core.exception.DifferentDefinitionAlreadyExistException;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.StreamReceiver;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.core.util.validate.StreamValidator;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.partition.Partition;
import org.wso2.siddhi.query.api.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Container class to store and transfer query and
 * related stream definitions to siddhi manager.
 */
public class ExecutionPlan {
    private List<Query> queryList;
    private Map<String, StreamDefinition> streamDefinitionMap;
    private List<Partition> partitionList;
    private List<InputHandler> inputHandlerList;
    private List<StreamReceiver> streamRecieverList;
    private String name;
    private ExecutionPlanRuntime executionPlanRuntime;


    /**
     * Class to contain configuration related to a query plan
     *
     * @param name name of the execution plan
     */
    public ExecutionPlan(String name) {
        this.name = name;
//        executionPlanRuntime = new ExecutionPlanRuntime();
    }

    public void addQuery(Query query) throws ValidatorException {
        if (queryList == null) {
            queryList = new ArrayList<Query>();
        }
        QueryValidator.validate(query, streamDefinitionMap);
        queryList.add(query);
    }

    public Map<String, StreamDefinition> getStreamDefinitionMap() {
        return streamDefinitionMap;
    }

    public void setStreamDefinitionMap(Map<String, StreamDefinition> streamDefinitionMap) {
        this.streamDefinitionMap = streamDefinitionMap;
    }

    public void addStreamDefinition(StreamDefinition definition) throws CreateExecutionPlanException {
        if (definition == null) {
            throw new CreateExecutionPlanException("Stream definition should not be null");
        }
        if (streamDefinitionMap == null) {
            streamDefinitionMap = new HashMap<String, StreamDefinition>();
        }
        try {
            StreamValidator.validate(streamDefinitionMap, definition);
        } catch (ValidatorException e) {
            throw new CreateExecutionPlanException(e.getMessage());
        }

    }

    /**
     * Returns stream definition for a given stream ID
     *
     * @param streamId stream ID to fetch corresponding definition
     * @return Stream definition for the given streamId
     */
    public StreamDefinition getStreamDefinition(String streamId) {
        return streamDefinitionMap.get(streamId);
    }

    public void addInputHandler(InputHandler inputHandler) {
        inputHandlerList.add(inputHandler);
    }

    public List<InputHandler> getInputHandlerList() {
        return inputHandlerList;
    }

    public void addStreamReciever(StreamReceiver receiver) {
        streamRecieverList.add(receiver);
    }

    public List<StreamReceiver> getStreamRecieverList() {
        return streamRecieverList;
    }


    public List<Query> getQueryList() {
        return queryList;
    }

    public void addExecutionPlan(){
//        executionPlanRuntime.addStreamDefinitions(streamDefinitionMap);
//        executionPlanRuntime.addPartitions(partitionList);
//        executionPlanRuntime.addQueries(queryList);
    }
}
