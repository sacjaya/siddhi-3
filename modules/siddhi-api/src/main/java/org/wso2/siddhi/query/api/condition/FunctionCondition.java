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
package org.wso2.siddhi.query.api.condition;

import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.ExpressionValidator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunctionCondition extends Condition {

    protected String functionName;
    protected Expression[] parameters;

    public FunctionCondition(String functionName, Expression[] parameters) {
        this.functionName = functionName;
        this.parameters = parameters;
    }


    public String getFunction() {
        return functionName;
    }

    public Expression[] getParameters() {
        return parameters;
    }

    public void setParameters(Expression[] parameters) {
        this.parameters = parameters;
    }

//    @Override
//    protected void validate(List<QueryEventSource> queryEventSourceList, ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap, String streamReferenceId,
//                            boolean processInStreamDefinition) {
//        for (Expression expression : parameters) {
//            ExpressionValidator.validate(expression, queryEventSourceList, streamReferenceId, processInStreamDefinition);
//        }
//    }

    @Override
    public String toString() {
        return "ConditionFunction{" +
               "functionName='" + functionName + '\'' +
               ", parameters=" + (parameters == null ? null : Arrays.asList(parameters)) +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FunctionCondition that = (FunctionCondition) o;

        if (!functionName.equals(that.functionName)) {
            return false;
        }
        if (!Arrays.equals(parameters, that.parameters)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = functionName.hashCode();
        result = 31 * result + (parameters != null ? Arrays.hashCode(parameters) : 0);
        return result;
    }

    @Override
    protected Map<String, Set<String>> getDependency() {
        Map<String, Set<String>> dependencyMap = new HashMap<String, Set<String>>();
        for (Expression expression : parameters) {
            for (Map.Entry<String,Set<String>> dependency : ExpressionValidator.getDependency(expression).entrySet()) {
                Set<String> attributeSet = dependencyMap.get(dependency.getKey());
                if (attributeSet != null) {
                    attributeSet.addAll(dependency.getValue());
                } else {
                    dependencyMap.put(dependency.getKey(), dependency.getValue());
                }

            }
        }
        return dependencyMap;
    }
}