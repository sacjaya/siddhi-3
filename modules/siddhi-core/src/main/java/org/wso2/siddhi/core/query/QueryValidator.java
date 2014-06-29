/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.query;

import org.wso2.siddhi.query.api.condition.ConditionValidator;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.exception.AttributeNotExistException;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.ExpressionValidator;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.WindowInputStream;
import org.wso2.siddhi.query.api.query.input.handler.Filter;
import org.wso2.siddhi.query.api.query.input.handler.StreamFunction;
import org.wso2.siddhi.query.api.query.input.handler.StreamHandler;
import org.wso2.siddhi.query.api.query.input.handler.Window;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by suho on 6/2/14.
 */
public class QueryValidator {
    public static void validate(Query query, ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap) {

        if (query.getInputStream() instanceof WindowInputStream) {

            WindowInputStream stream = (WindowInputStream) query.getInputStream();
            AbstractDefinition inputStreamDefinition = streamTableDefinitionMap.get(stream.getStreamId());
            for (StreamHandler streamHandler : stream.getStreamHandlers()) {
                if (streamHandler instanceof Filter) {
                    Filter filter = (Filter) streamHandler;
                    Map<String, Set<String>> dependencies = ConditionValidator.getDependency(filter.getFilterCondition());
                    checkAttribute(stream.getStreamId(), stream.getStreamId(), inputStreamDefinition, dependencies);
                    checkAttribute(stream.getStreamReferenceId(), stream.getStreamId(), inputStreamDefinition, dependencies);
                    checkAttribute(null, stream.getStreamId(), inputStreamDefinition, dependencies);

                } else if (streamHandler instanceof Window) {
                    Window window = (Window) streamHandler;
                    for (Expression expression : window.getParameters()) {
                        Map<String, Set<String>> dependencies = ExpressionValidator.getDependency(expression);
                        checkAttribute(stream.getStreamId(), stream.getStreamId(), inputStreamDefinition, dependencies);
                        checkAttribute(stream.getStreamReferenceId(), stream.getStreamId(), inputStreamDefinition, dependencies);
                        checkAttribute(null, stream.getStreamId(), inputStreamDefinition, dependencies);
                    }
                } else if (streamHandler instanceof StreamFunction) {
                    StreamFunction streamFunction = (StreamFunction) streamHandler;
                    for (Expression expression : streamFunction.getParameters()) {
                        Map<String, Set<String>> dependencies = ExpressionValidator.getDependency(expression);
                        checkAttribute(stream.getStreamId(), stream.getStreamId(), inputStreamDefinition, dependencies);
                        checkAttribute(stream.getStreamReferenceId(), stream.getStreamId(), inputStreamDefinition, dependencies);
                        checkAttribute(null, stream.getStreamId(), inputStreamDefinition, dependencies);
                    }
                }
            }
        }

    }

    private static void checkAttribute(String id, String streamId, AbstractDefinition inputStreamDefinition, Map<String, Set<String>> dependencies) {
        Set<String> attributes = dependencies.get(id);
        if (attributes != null) {
            for (String dependentAttribute : attributes) {
                boolean attributeExist = false;
                for (String attribute : inputStreamDefinition.getAttributeNameArray()) {
                    if (attribute.equals(dependentAttribute)) {
                        attributeExist = true;
                        break;
                    }
                }
                if (!attributeExist) {
                    throw new AttributeNotExistException(dependentAttribute + " does not exist in " + streamId);
                }
            }
        }
    }
}
