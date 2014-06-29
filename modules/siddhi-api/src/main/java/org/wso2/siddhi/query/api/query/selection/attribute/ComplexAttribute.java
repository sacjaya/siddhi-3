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
package org.wso2.siddhi.query.api.query.selection.attribute;

import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.ExpressionValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ComplexAttribute implements OutputAttribute {
    private String rename;
    private String attributeName;
    private Expression[] expressions;

    public ComplexAttribute(String rename, String attributeName, Expression... expressions) {
        this.rename = rename;
        this.attributeName = attributeName;
        this.expressions = expressions;
    }

    public String getRename() {
        return rename;
    }

//    @Override
//    public Attribute.Type getType() {
//        return null;
//    }

    public String getAttributeName() {
        return attributeName;
    }

    public Expression[] getExpressions() {
        return expressions;
    }

    @Override
    public Map<String, Set<String>> getDependency() {
        Map<String, Set<String>> dependencyMap = new HashMap<String, Set<String>>();
        for (Expression expression : expressions) {
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
