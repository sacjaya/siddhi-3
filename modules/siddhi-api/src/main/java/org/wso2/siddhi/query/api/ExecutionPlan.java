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
package org.wso2.siddhi.query.api;

import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.definition.TableDefinition;
import org.wso2.siddhi.query.api.exception.CreateExecutionPlanException;
import org.wso2.siddhi.query.api.execution.element.ExecutionElement;
import org.wso2.siddhi.query.api.partition.Partition;
import org.wso2.siddhi.query.api.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutionPlan {

    private String name;
    private List<ExecutionElement> executionElementList = new ArrayList<ExecutionElement>();
    private Map<String, StreamDefinition> streamDefinitionMap = new HashMap<String, StreamDefinition>();
    private Map<String, TableDefinition> tableDefinitionMap = new HashMap<String, TableDefinition>();

    public ExecutionPlan(String name) {
        this.name = name;
    }

    public static ExecutionPlan executionPlan(String name) {
        return new ExecutionPlan(name);
    }

    public ExecutionPlan defineStream(StreamDefinition streamDefinition) throws CreateExecutionPlanException {
        if (streamDefinition == null) {
            throw new CreateExecutionPlanException("Stream definition should not be null");
        }
        this.streamDefinitionMap.put(streamDefinition.getId(), streamDefinition);
        return this;
    }

    public ExecutionPlan defineTable(TableDefinition tableDefinition) {
        if (tableDefinition == null) {
            throw new CreateExecutionPlanException("Stream definition should not be null");
        }
        this.tableDefinitionMap.put(tableDefinition.getId(), tableDefinition);
        return this;
    }

    public ExecutionPlan addQuery(Query query) throws CreateExecutionPlanException {
        if (query == null) {
            throw new CreateExecutionPlanException("Query should not be null");
        }
        this.executionElementList.add(query);
        return this;
    }

    public ExecutionPlan addPartition(Partition partition) throws CreateExecutionPlanException {
        if (partition == null) {
            throw new CreateExecutionPlanException("Partition should not be null");
        }
        this.executionElementList.add(partition);
        return this;
    }

    public String getName() {
        return name;
    }

    public List<ExecutionElement> getExecutionElementList() {
        return executionElementList;
    }

    public Map<String, StreamDefinition> getStreamDefinitionMap() {
        return streamDefinitionMap;
    }

    public Map<String, TableDefinition> getTableDefinitionMap() {
        return tableDefinitionMap;
    }
}
