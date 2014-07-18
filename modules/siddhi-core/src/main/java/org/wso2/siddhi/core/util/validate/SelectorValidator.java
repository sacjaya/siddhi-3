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

import org.wso2.siddhi.core.exception.OperationNotSupportedException;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.expression.ExpressionExecutor;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.query.selection.Selector;
import org.wso2.siddhi.query.api.query.selection.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.query.selection.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;

import java.util.HashMap;
import java.util.Map;

public class SelectorValidator {

    /**
     * Method to validate selector for given set of stream definitions     *
     *
     * @param selector            :       Selector to validate
     * @param streamDefinitionMap :      Map to handle renaming
     * @throws ValidatorException Thrown if not validated
     */
    public static void validate(Selector selector, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        StreamDefinition temp = new StreamDefinition();        //inferred stream
        if (selector.getSelectionList().size() > 0) {
            for (OutputAttribute attribute : selector.getSelectionList()) {
                if (attribute instanceof SimpleAttribute) {
                    /*ValidatorUtil.validateCompareExpression(((SimpleAttribute) attribute).getExpression(), streamDefinitionMap, null);
                    Attribute.Type returnType = ValidatorUtil.getExpressionReturnType(((SimpleAttribute) attribute).getExpression(), streamDefinitionMap);*/
                    ExpressionExecutor executor = ExecutorParser.parseExpression(((SimpleAttribute) attribute).getExpression(), null, null, streamDefinitionMap);//current stream reference and siddhi context is null
                    temp.attribute(attribute.getRename(), executor.getReturnType());
                } else if (attribute instanceof ComplexAttribute) {          //TODO:check if we need to validate attribute names
                    for (Expression expression : ((ComplexAttribute) attribute).getExpressions()) {
                        ValidatorUtil.validateCompareExpression(expression, streamDefinitionMap, null);
                        Attribute.Type type = ValidatorUtil.getExpressionReturnType(expression, streamDefinitionMap);
                        Attribute.Type result;
                        try {
                            result = ValidatorUtil.getAggregatorReturnType(((ComplexAttribute) attribute).getAttributeName(), type);
                        } catch (OperationNotSupportedException e) {
                            throw new ValidatorException(e.getMessage());
                        }
                        temp.attribute(attribute.getRename(), result);
                    }
                }
            }
            if (selector.getGroupByList() != null) {                        //Handle group by
                for (Variable var : selector.getGroupByList()) {
                    ValidatorUtil.handleVariable(var, streamDefinitionMap, null);
                }
            }
            if (selector.getHavingCondition() != null) {                    //Handle having condition. send only the inferred stream
                Map<String, StreamDefinition> tempMap = new HashMap<String, StreamDefinition>(1);
                tempMap.put(null, temp);                                     //putting with null id to avoid conflicts
                //ValidatorUtil.validateCondition(selector.getHavingCondition(), tempMap, null);
                ExecutorParser.parseCondition(selector.getHavingCondition(), null, null, tempMap);
            }
        } else {
            for (StreamDefinition definition : streamDefinitionMap.values()) {
                for (Attribute attribute : definition.getAttributeList()) {
                    temp.attribute(attribute.getName(), attribute.getType());
                    selector.select(attribute.getName(), new Variable(definition.getId(), attribute.getName())); //TODO:discuss for join
                }
            }
        }
        streamDefinitionMap.put(null, temp);
    }

}
