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
package org.wso2.siddhi.core.query.creator;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.BasicSingleInputStream;
import org.wso2.siddhi.query.api.execution.query.input.SingleInputStream;

import java.util.concurrent.ConcurrentMap;

public class QueryCreatorFactory {

    public static QueryCreator constructQueryCreator(String queryId, Query query, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap,
                                                     OutputRateManager outputRateManager,
                                                     SiddhiContext siddhiContext) {
        if (query.getInputStream() instanceof BasicSingleInputStream || query.getInputStream() instanceof SingleInputStream) {
            return new BasicQueryCreator(queryId, query, streamDefinitionMap, localStreamDefinitionMap, outputRateManager, siddhiContext);
            //TODO: for other streams
        } else {
            throw new QueryCreationException("Unsupported input stream found, " + query.getInputStream().getClass().getName());
        }

    }
}
