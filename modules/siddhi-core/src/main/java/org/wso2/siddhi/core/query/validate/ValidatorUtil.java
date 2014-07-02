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
package org.wso2.siddhi.core.query.validate;

import org.wso2.siddhi.query.api.condition.*;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.Multiply;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.expression.constant.Constant;

import java.util.Map;

public class ValidatorUtil {
    private StreamDefinition streamDefinition;
    private Map<String, StreamDefinition> streamDefinitionMap;
    private String streamId;

    public ValidatorUtil(Map<String, StreamDefinition> streamDefinitionMap) {
        this.streamDefinitionMap = streamDefinitionMap;
    }

    public Boolean validateCondition(Condition condition, String streamId) {
        this.streamId = streamId;
        return validateCondition(condition);
    }

    public Boolean validateCondition(Condition condition) {

        if (condition == null) {
            return false;
        } else {
            if (condition instanceof Compare) {
                return handleCompareCondition((Compare) condition);
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

    }

    private Boolean handleCompareCondition(Compare condition) {
        Boolean left = validateCompareExpression(condition.getLeftExpression());
        Boolean right = validateCompareExpression(condition.getRightExpression());
        return (left && right);
    }

    private Boolean validateCompareExpression(Expression expression) {
        if (expression instanceof Variable) {
            return handleVariable((Variable) expression);
        } else if (expression instanceof Multiply) {
            Multiply multiply = (Multiply) expression;
            Boolean left = validateCompareExpression(multiply.getLeftValue());
            Boolean right = validateCompareExpression(multiply.getRightValue());
            return (left && right);
        } else if (expression instanceof Constant) {
            return true;
        } else {
            return false;
        }
    }

    private Boolean handleVariable(Variable variable) {
        String attributeName = variable.getAttributeName();
        String streamId = variable.getStreamId();
        if (streamId == null) {
            streamId = this.streamId;
        }
        String[] attributeNameArray = streamDefinitionMap.get(streamId).getAttributeNameArray();
        for (int i = 0; i < attributeNameArray.length; i++) {           //iterate through attribute list
            if (attributeNameArray[i].equals(attributeName)) {
                return true;
            }
        }
        return false;
    }
}
