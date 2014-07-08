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

import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.query.api.condition.*;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.expression.constant.Constant;

import java.util.List;
import java.util.Map;

public class ValidatorUtil {
    /*private StreamDefinition streamDefinition;
    private Map<String, StreamDefinition> streamDefinitionMap;
    private String streamId;*/

    /*public ValidatorUtil(Map<String, StreamDefinition> streamDefinitionMap) {
        this.streamDefinitionMap = streamDefinitionMap;
    }*/

    /*public Boolean validateCondition(Condition condition, String streamId) {
        this.streamId = streamId;
        return validateCondition(condition);
    }*/

    /*public Boolean validateCondition(Condition condition) {

        if (condition == null) {
            return false;
        } else {
            if (condition instanceof Compare) {
                return handleCompareCondition((Compare) condition, definitionList);
            } else if (condition instanceof AndCondition) {
                Boolean left = validateCondition(((AndCondition) condition).getLeftCondition());
                Boolean right = validateCondition(((AndCondition) condition).getRightCondition());
                return (left && right);
            } else if (condition instanceof BooleanCondition) {
                //TODO: validate BooleanCondition
            } else if (condition instanceof InCondition) {
                //TODO: validate InCondition
            } else if (condition instanceof NotCondition) {
                //TODO: validate NotCondition
            } else if (condition instanceof OrCondition) {
                Boolean left = validateCondition(((OrCondition) condition).getLeftCondition());
                Boolean right = validateCondition(((OrCondition) condition).getRightCondition());
                return (left && right);
            }
            return false;
        }

    }*/

    /**
     * Method to validate compare expression
     *
     * @param expression
     * @param definitionList
     * @param renameMap
     * @throws ValidatorException
     */
    private static void validateCompareExpression(Expression expression, List<StreamDefinition> definitionList, Map<String, String> renameMap) throws ValidatorException {
        if (expression instanceof Variable) {
            handleVariable((Variable) expression, definitionList, renameMap);
        } else if (expression instanceof Constant) {
            //Do nothing
        } else {
            //TODO: Handle general expressions including add,sum
        }
    }

    /**
     * Method to validate single variables
     *
     * @param variable
     * @param definitionList
     * @param renameMap
     * @throws ValidatorException
     */
    public static void handleVariable(Variable variable, List<StreamDefinition> definitionList, Map<String, String> renameMap) throws ValidatorException {
        String attributeName = variable.getAttributeName();
        String streamId = variable.getStreamId();
        String[] attributeNameArray = null;
        if (streamId == null) {
            if (definitionList.size() > 0) {
                streamId = definitionList.get(0).getStreamId();
                attributeNameArray = definitionList.get(0).getAttributeNameArray();
                variable.setStreamId(streamId);
            } else {        //Check for duplicates and existence of attribute
                int count = 0;
                for (StreamDefinition definition : definitionList) {
                    attributeNameArray = definition.getAttributeNameArray();
                    for (int i = 0; i < attributeNameArray.length; i++) {           //iterate through attribute list
                        if (attributeNameArray[i].equals(attributeName)) {
                            count++;
                        }
                    }
                }
                if (count == 1) {
                    return;
                } else {
                    throw new ValidatorException("Could not find an attribute named " + attributeName);
                }


            }
            //streamId = definitionList.get(0).getStreamId();
            //attributeNameArray = definitionList.get(0).getAttributeNameArray();
        } else {
            for (StreamDefinition definition : definitionList) {
                if (renameMap != null) {
                    streamId = renameMap.get(streamId);                         //handling renaming
                }
                if (definition.getStreamId().equals(streamId)) {
                    attributeNameArray = definition.getAttributeNameArray();    //TODO: check whether stream definition existance is checked in down stream
                }
            }
        }
        for (int i = 0; i < attributeNameArray.length; i++) {           //iterate through attribute list
            if (attributeNameArray[i].equals(attributeName)) {
                return;
            }
        }
        throw new ValidatorException("Stream definition " + streamId + " does not contain an attribute named " + attributeName);
    }


    /**
     * Method to validate siddhi conditions
     *
     * @param condition
     * @param definitionList
     * @param renameMap
     * @throws ValidatorException
     */
    public static void validateCondition(Condition condition, List<StreamDefinition> definitionList, Map<String, String> renameMap) throws ValidatorException {

        if (condition instanceof Compare) {
            validateCompareExpression(((Compare) condition).getLeftExpression(), definitionList, renameMap);
            validateCompareExpression(((Compare) condition).getRightExpression(), definitionList, renameMap);
        } else if (condition instanceof AndCondition) {
            validateCondition(((AndCondition) condition).getLeftCondition(), definitionList, renameMap);
            validateCondition(((AndCondition) condition).getRightCondition(), definitionList, renameMap);
        } else if (condition instanceof BooleanCondition) {
            //TODO: validate BooleanCondition
        } else if (condition instanceof InCondition) {
            //TODO: validate InCondition
        } else if (condition instanceof NotCondition) {
            //TODO: validate NotCondition
        } else if (condition instanceof OrCondition) {
            validateCondition(((OrCondition) condition).getLeftCondition(), definitionList, renameMap);
            validateCondition(((OrCondition) condition).getRightCondition(), definitionList, renameMap);
        }

    }
}
