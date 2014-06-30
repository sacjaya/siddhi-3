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

import org.wso2.siddhi.query.api.definition.StreamDefinition;
import java.util.Map;


/**
 * Container class to store and transfer query and
 * related stream definitions to siddhi manager.
 */
public class ExecutionPlan {
    private String query;
    private Map<String, StreamDefinition> streamDefinitionMap;

    /**
     * Create new execution plan providing necessary params
     *
     * @param query               String representation of siddhi query
     * @param streamDefinitionMap Map containing all the necessary stream definitions for above query
     */
    public ExecutionPlan(String query, Map<String, StreamDefinition> streamDefinitionMap) {
        this.query = query;
        this.streamDefinitionMap = streamDefinitionMap;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String, StreamDefinition> getStreamDefinitionMap() {
        return streamDefinitionMap;
    }

    public void setStreamDefinitionMap(Map<String, StreamDefinition> streamDefinitionMap) {
        this.streamDefinitionMap = streamDefinitionMap;
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

}
