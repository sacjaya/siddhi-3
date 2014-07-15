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
import org.wso2.siddhi.core.util.Constants;
import org.wso2.siddhi.query.api.condition.*;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.*;
import org.wso2.siddhi.query.api.expression.constant.Constant;

import java.util.Map;

public class ValidatorUtil {

    /**
     * Method to validate compare expression
     *
     * @param expression
     * @param streamDefinitionMap
     * @param defaultDefinition
     * @throws ValidatorException
     */
    public static void validateCompareExpression(Expression expression, Map<String, StreamDefinition> streamDefinitionMap, String defaultDefinition) throws ValidatorException {
        if (expression instanceof Variable) {
            handleVariable((Variable) expression, streamDefinitionMap, defaultDefinition);
        } else if (expression instanceof Constant) {
            //Do nothing
        } else if (expression instanceof Add) { //TODO: query feasibility of adding supper class to below classes
            validateCompareExpression(((Add) expression).getLeftValue(), streamDefinitionMap, defaultDefinition);
            validateCompareExpression(((Add) expression).getRightValue(), streamDefinitionMap, defaultDefinition);
        } else if (expression instanceof Divide) {
            validateCompareExpression(((Divide) expression).getLeftValue(), streamDefinitionMap, defaultDefinition);
            validateCompareExpression(((Divide) expression).getRightValue(), streamDefinitionMap, defaultDefinition);
        } else if (expression instanceof Minus) {
            validateCompareExpression(((Minus) expression).getLeftValue(), streamDefinitionMap, defaultDefinition);
            validateCompareExpression(((Minus) expression).getRightValue(), streamDefinitionMap, defaultDefinition);
        } else if (expression instanceof Mod) {
            validateCompareExpression(((Mod) expression).getLeftValue(), streamDefinitionMap, defaultDefinition);
            validateCompareExpression(((Mod) expression).getRightValue(), streamDefinitionMap, defaultDefinition);
        } else if (expression instanceof Multiply) {
            validateCompareExpression(((Multiply) expression).getLeftValue(), streamDefinitionMap, defaultDefinition);
            validateCompareExpression(((Multiply) expression).getRightValue(), streamDefinitionMap, defaultDefinition);
        } else {
            //TODO: time and other. Please discuss
        }
    }

    /**
     * Method to validate single variables
     *
     * @param variable
     * @param streamDefinitionMap
     * @throws ValidatorException
     */
    public static void handleVariable(Variable variable, Map<String, StreamDefinition> streamDefinitionMap, String defaultDefinition) throws ValidatorException {
        String attributeName = variable.getAttributeName();
        String streamId = variable.getStreamId();
        String[] attributeNameArray = null;
        if (streamId == null) {
            if (defaultDefinition != null) {
                attributeNameArray = streamDefinitionMap.get(defaultDefinition).getAttributeNameArray();
            } else {
                //Check for duplicates and existence of attribute
                int count = 0;
                String id = null;
                for (Map.Entry<String, StreamDefinition> entry : streamDefinitionMap.entrySet()) {
                    attributeNameArray = entry.getValue().getAttributeNameArray();
                    for (int i = 0; i < attributeNameArray.length; i++) {           //iterate through attribute list
                        if (attributeNameArray[i].equals(attributeName)) {
                            count++;
                            id = entry.getKey();
                        }
                    }
                }
                if (count == 1) {
                    variable.setStreamId(id);
                    return;
                } else {
                    throw new ValidatorException("Could not find an attribute named " + attributeName);
                }
            }
        } else {
            attributeNameArray = streamDefinitionMap.get(streamId).getAttributeNameArray();
        }
        if (attributeNameArray != null) {
            for (int i = 0; i < attributeNameArray.length; i++) {           //iterate through attribute list
                if (attributeNameArray[i].equals(attributeName)) {
                    return;
                }
            }
            throw new ValidatorException("Stream definition " + streamId + " does not contain an attribute named " + attributeName);
        }
    }


    /**
     * Method to validate siddhi conditions
     *
     * @param condition
     * @param streamDefinitionMap
     * @param defaultDefinition
     * @throws ValidatorException
     */
    public static void validateCondition(Condition condition, Map<String, StreamDefinition> streamDefinitionMap, String defaultDefinition) throws ValidatorException {

        if (condition instanceof Compare) {
            validateCompareExpression(((Compare) condition).getLeftExpression(), streamDefinitionMap, defaultDefinition);
            validateCompareExpression(((Compare) condition).getRightExpression(), streamDefinitionMap, defaultDefinition);
        } else if (condition instanceof AndCondition) {
            validateCondition(((AndCondition) condition).getLeftCondition(), streamDefinitionMap, defaultDefinition);
            validateCondition(((AndCondition) condition).getRightCondition(), streamDefinitionMap, defaultDefinition);
        } else if (condition instanceof BooleanCondition) {
            //TODO: validate BooleanCondition
        } else if (condition instanceof InCondition) {
            //TODO: validate InCondition
        } else if (condition instanceof NotCondition) {
            //TODO: validate NotCondition
        } else if (condition instanceof OrCondition) {
            validateCondition(((OrCondition) condition).getLeftCondition(), streamDefinitionMap, defaultDefinition);
            validateCondition(((OrCondition) condition).getRightCondition(), streamDefinitionMap, defaultDefinition);
        }

    }

    /**
     * Method to get return type of a given attribute. Used in generation output stream from selector
     *
     * @param attributeName
     * @param type
     * @return Type of aggregate function
     * @throws OperationNotSupportedException
     */
    public static Attribute.Type getAggregatorReturnType(String attributeName, Attribute.Type type) throws OperationNotSupportedException {
        if (attributeName.equals(Constants.AVG)) {
            if (type.equals(Attribute.Type.DOUBLE) || type.equals(Attribute.Type.LONG) || type.equals(Attribute.Type.INT)) {
                return Attribute.Type.DOUBLE;
            } else if (type.equals(Attribute.Type.LONG)) {
                return Attribute.Type.LONG;
            }
        } else if (attributeName.equals(Constants.SUM)) {
            if (type.equals(Attribute.Type.DOUBLE) || type.equals(Attribute.Type.FLOAT)) {
                return Attribute.Type.DOUBLE;
            } else if (type.equals(Attribute.Type.LONG) || type.equals(Attribute.Type.INT)) {
                return Attribute.Type.LONG;
            }
        } else if (attributeName.equals(Constants.MAX) || attributeName.equals(Constants.MIN)) {
            return type;
        } else if (attributeName.equals(Constants.COUNT)) {
            return Attribute.Type.LONG;
        } else {
            throw new OperationNotSupportedException("Aggregate function " + attributeName + " is not recognized");
        }
        return null;
    }

    /**
     * Method to get attribute type of a given simple attribute
     *
     * @param attributeName
     * @param definition
     * @return
     * @throws ValidatorException
     */
    public static Attribute.Type getAttributeType(String attributeName, StreamDefinition definition) throws ValidatorException {
        Attribute.Type type = null;
        for (Attribute attribute1 : definition.getAttributeList()) {
            if (attribute1.getName().equals(attributeName)) {
                type = attribute1.getType();
            }
        }
        if (type == null) {
            throw new ValidatorException("Attribute " + attributeName + " was not found in stream definition " + definition.getStreamId());
        }
        return type;
    }
}
