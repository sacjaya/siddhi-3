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
import org.wso2.siddhi.query.api.query.Query;

public class ExecutionPlan {
    private String name;

    //todo manage the variables
    private StreamDefinition streamDefinition;
    private TableDefinition tableDefinition;
    private Query query;

    public ExecutionPlan(String name) {
        this.name = name;
    }

    public ExecutionPlan() {
    }

    public static ExecutionPlan executionPlan(String name) {
        return new ExecutionPlan(name);
    }

    public static ExecutionPlan executionPlan() {
        return new ExecutionPlan();
    }

    public ExecutionPlan defineStream(StreamDefinition streamDefinition) {
        this.streamDefinition = streamDefinition;
        return this;
    }

    public ExecutionPlan defineTable(TableDefinition tableDefinition) {
        this.tableDefinition = tableDefinition;
        return this;
    }

    public ExecutionPlan addQuery(Query query) {
        this.query = query;
        return this;
    }
}
