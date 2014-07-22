/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.siddhi.core.util.validate;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.input.*;
import org.wso2.siddhi.query.api.query.input.handler.Filter;
import org.wso2.siddhi.query.api.query.input.handler.StreamFunction;
import org.wso2.siddhi.query.api.query.input.handler.StreamHandler;
import org.wso2.siddhi.query.api.query.input.handler.Window;

import java.util.Map;

public class InStreamValidator {

    /**
     * Validate a given input stream. Complex streams should be handled at upper layer
     * @param inputStream
     * @param streamDefinitionMap  @throws ValidatorException
     * @param tempDefinitionMap
     */
    public static void validate(InputStream inputStream, Map<String, StreamDefinition> streamDefinitionMap, Map<String, StreamDefinition> tempDefinitionMap) throws ValidatorException {
        if (inputStream instanceof BasicSingleInputStream || inputStream instanceof SingleInputStream) {
            tempDefinitionMap.put(((SingleInputStream) inputStream).getStreamId(), streamDefinitionMap.get(((SingleInputStream) inputStream).getStreamId()));
            String defaultDefinition = ((SingleInputStream) inputStream).getStreamId();
            SiddhiContext mockSiddhiContext = new SiddhiContext("testID", SiddhiContext.ProcessingState.DISABLED);
            for (StreamHandler handler : ((SingleInputStream) inputStream).getStreamHandlers()) {
                if (handler instanceof Filter) {
                    Condition condition = ((Filter) handler).getFilterCondition();
                    //ValidatorUtil.validateCondition(condition, tempDefinitionMap, defaultDefinition);
                    ExecutorParser.parseCondition(condition, defaultDefinition, mockSiddhiContext, tempDefinitionMap);
                } else if (handler instanceof Window) {
                    for (Expression expression : ((Window) handler).getParameters()) {
                        //ValidatorUtil.validateCompareExpression(expression, tempDefinitionMap, defaultDefinition);
                        ExecutorParser.parseExpression(expression, defaultDefinition, mockSiddhiContext, tempDefinitionMap);
                    }
                } else if (handler instanceof StreamFunction) {
                    //TODO: handle. get output attr names and types and set them in temp map
                }
            }
            ((SingleInputStream) inputStream).setDefinition(streamDefinitionMap.get(((SingleInputStream) inputStream).getStreamId()));  //set the definition
            if (!(((SingleInputStream) inputStream).getStreamReferenceId().equals(((SingleInputStream) inputStream).getStreamId()))) { //if ref id is provided
                StreamDefinition temp = tempDefinitionMap.remove(((SingleInputStream) inputStream).getStreamId());                  //remove original definition from temp map
                tempDefinitionMap.put(((SingleInputStream) inputStream).getStreamReferenceId(), temp);
            }
        }
    }
}
