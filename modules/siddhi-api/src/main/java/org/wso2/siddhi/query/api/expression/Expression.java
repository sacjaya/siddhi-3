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
package org.wso2.siddhi.query.api.expression;


import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.expression.constant.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Expression {
    public static StringConstant value(String value) {
        return new StringConstant(value);
    }

    public static IntConstant value(int value) {
        return new IntConstant(value);
    }

    public static LongConstant value(long value) {
        return new LongConstant(value);
    }

    public static DoubleConstant value(double value) {
        return new DoubleConstant(value);
    }

    public static FloatConstant value(float value) {
        return new FloatConstant(value);
    }

    public static BoolConstant value(boolean value) {
        return new BoolConstant(value);
    }

    public static Variable variable(String streamId, String attributeName) {
        return new Variable(streamId, attributeName);
    }

    public static Add add(Expression leftValue, Expression rightValue) {
        return new Add(leftValue, rightValue);
    }

    public static Minus minus(Expression leftValue, Expression rightValue) {
        return new Minus(leftValue, rightValue);
    }

    public static Multiply multiply(Expression leftValue, Expression rightValue) {
        return new Multiply(leftValue, rightValue);
    }

    public static Divide divide(Expression leftValue, Expression rightValue) {
        return new Divide(leftValue, rightValue);
    }

    public static Mod mod(Expression leftValue, Expression rightValue) {
        return new Mod(leftValue, rightValue);
    }

    public static Variable variable(String attributeName) {
        return new Variable(null, attributeName);
    }

    //   public abstract Attribute.Type getType();

    //  public abstract void inferType(Map<String, StreamDefinition> streamTableDefinitionMap);

    public static Variable variable(String streamId, int position, String attributeName) {
        return new Variable(streamId, position, attributeName);
    }

    public static Expression extension(String extensionNamespace, String extensionFunctionName,
                                       Expression... expressions) {
        return new ExpressionExtension(extensionNamespace, extensionFunctionName, expressions);
    }

    public static Expression function(String extensionFunctionName,
                                      Expression... expressions) {
        return new FunctionExpression(extensionFunctionName, expressions);
    }

    public static Type type(Attribute.Type type) {
        return new Type(type);
    }

//    protected abstract void validate(List<QueryEventSource> queryEventSources,
//                                     String streamReferenceId, boolean processInStreamDefinition);

    protected Map<String,Set<String>> getDependency() {
        return new HashMap<String, Set<String>>();
    }
}
