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
package org.wso2.siddhi.core.util.parser;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.OperationNotSupportedException;
import org.wso2.siddhi.core.executor.condition.*;
import org.wso2.siddhi.core.executor.expression.ConstantExpressionExecutor;
import org.wso2.siddhi.core.executor.expression.ExpressionExecutor;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.executor.expression.add.AddExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.add.AddExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.add.AddExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.add.AddExpressionExecutorLong;
import org.wso2.siddhi.core.executor.expression.divide.DivideExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.divide.DivideExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.divide.DivideExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.divide.DivideExpressionExecutorLong;
import org.wso2.siddhi.core.executor.expression.minus.MinusExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.minus.MinusExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.minus.MinusExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.minus.MinusExpressionExecutorLong;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorLong;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorLong;
import org.wso2.siddhi.query.api.condition.*;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.expression.*;
import org.wso2.siddhi.query.api.expression.constant.*;
import org.wso2.siddhi.query.api.query.input.InputStream;

public class ExecutorParser {



    public static ConditionExecutor parseCondition(Condition condition,
                                                   String currentStreamReference,
                                                   boolean processInDefinition,
                                                   SiddhiContext siddhiContext,InputStream inputStream) {
        if (condition instanceof AndCondition) {
            return new AndConditionExecutor(parseCondition(((AndCondition) condition).getLeftCondition(), currentStreamReference,  processInDefinition, siddhiContext, inputStream),
                    parseCondition(((AndCondition) condition).getRightCondition(),  currentStreamReference,  processInDefinition, siddhiContext, inputStream));
        } else if (condition instanceof OrCondition) {
            return new OrConditionExecutor(parseCondition(((OrCondition) condition).getLeftCondition(),  currentStreamReference,  processInDefinition, siddhiContext, inputStream),
                    parseCondition(((OrCondition) condition).getRightCondition(),  currentStreamReference,  processInDefinition, siddhiContext, inputStream));
        }  else if (condition instanceof NotCondition) {
            return new NotConditionExecutor(parseCondition(((NotCondition) condition).getCondition(),  currentStreamReference,  processInDefinition, siddhiContext, inputStream));
        } else if (condition instanceof BooleanCondition) {
            return new BooleanConditionExecutor(parseExpression(((BooleanCondition) condition).getExpression(), currentStreamReference, processInDefinition, siddhiContext, inputStream));
        } else if (condition instanceof Compare) {
            if (((Compare) condition).getOperator() == Condition.Operator.EQUAL) {
                return ComparatorParser.parseEqualCompare(parseExpression(((Compare) condition).getLeftExpression(),  currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(),  currentStreamReference, processInDefinition, siddhiContext,inputStream));
            } else if (((Compare) condition).getOperator() == Condition.Operator.NOT_EQUAL) {
                return ComparatorParser.parseNotEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(),  currentStreamReference, processInDefinition, siddhiContext,inputStream));
            } else if (((Compare) condition).getOperator() == Condition.Operator.GREATER_THAN) {
                return ComparatorParser.parseGreaterThanCompare(parseExpression(((Compare) condition).getLeftExpression(),currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(),currentStreamReference, processInDefinition, siddhiContext,inputStream));
            } else if (((Compare) condition).getOperator() == Condition.Operator.GREATER_THAN_EQUAL) {
                return ComparatorParser.parseGreaterThanEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream));
            } else if (((Compare) condition).getOperator() == Condition.Operator.LESS_THAN) {
                return ComparatorParser.parseLessThanCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(),  currentStreamReference, processInDefinition, siddhiContext,inputStream));
            } else if (((Compare) condition).getOperator() == Condition.Operator.LESS_THAN_EQUAL) {
                return ComparatorParser.parseLessThanEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream));

            } else if (((Compare) condition).getOperator() == Condition.Operator.CONTAINS) {
                return ComparatorParser.parseContainsCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream));
            } else if (((Compare) condition).getOperator() == Condition.Operator.INSTANCE_OF) {
                return ComparatorParser.parseInstanceOfCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, processInDefinition, siddhiContext,inputStream));
            }
        } else {
           //TODO: else
        }
        throw new OperationNotSupportedException(condition + " not supported !");
    }
    public static ExpressionExecutor parseExpression(Expression expression,
                                                     String currentStreamReference,
                                                     boolean processInStreamDefinition,
                                                     SiddhiContext siddhiContext, InputStream inputStream) {
        if (expression instanceof Constant) {
            if (expression instanceof BoolConstant) {
                return new ConstantExpressionExecutor(((BoolConstant) expression).getValue(), Attribute.Type.BOOL);
            } else if (expression instanceof StringConstant) {
                return new ConstantExpressionExecutor(((StringConstant) expression).getValue(), Attribute.Type.STRING);
            } else if (expression instanceof IntConstant) {
                return new ConstantExpressionExecutor(((IntConstant) expression).getValue(), Attribute.Type.INT);
            } else if (expression instanceof LongConstant) {
                return new ConstantExpressionExecutor(((LongConstant) expression).getValue(), Attribute.Type.LONG);
            } else if (expression instanceof FloatConstant) {
                return new ConstantExpressionExecutor(((FloatConstant) expression).getValue(), Attribute.Type.FLOAT);
            } else if (expression instanceof DoubleConstant) {
                return new ConstantExpressionExecutor(((DoubleConstant) expression).getValue(), Attribute.Type.DOUBLE);
            }
        } else if (expression instanceof Variable) {
            return new VariableExpressionExecutor(((Variable) expression).getStreamId(), ((Variable) expression).getAttributeName(), ((Variable) expression).getPosition(),  currentStreamReference, processInStreamDefinition,inputStream);
        }  else if (expression instanceof Multiply) {
            ExpressionExecutor left = parseExpression(((Multiply) expression).getLeftValue(),  currentStreamReference, processInStreamDefinition, siddhiContext,inputStream);
            ExpressionExecutor right = parseExpression(((Multiply) expression).getRightValue(),  currentStreamReference, processInStreamDefinition, siddhiContext,inputStream);
            Attribute.Type type = parseArithmeticOperationResultType(left, right);
            switch (type) {
                case INT:
                    return new MultiplyExpressionExecutorInt(left, right);
                case LONG:
                    return new MultiplyExpressionExecutorLong(left, right);
                case FLOAT:
                    return new MultiplyExpressionExecutorFloat(left, right);
                case DOUBLE:
                    return new MultiplyExpressionExecutorDouble(left, right);
            }
        } else if (expression instanceof Add) {
            ExpressionExecutor left = parseExpression(((Add) expression).getLeftValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            ExpressionExecutor right = parseExpression(((Add) expression).getRightValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            Attribute.Type type = parseArithmeticOperationResultType(left, right);
            switch (type) {
                case INT:
                    return new AddExpressionExecutorInt(left, right);
                case LONG:
                    return new AddExpressionExecutorLong(left, right);
                case FLOAT:
                    return new AddExpressionExecutorFloat(left, right);
                case DOUBLE:
                    return new AddExpressionExecutorDouble(left, right);
            }
        } else if (expression instanceof Minus) {
            ExpressionExecutor left = parseExpression(((Minus) expression).getLeftValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            ExpressionExecutor right = parseExpression(((Minus) expression).getRightValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            Attribute.Type type = parseArithmeticOperationResultType(left, right);
            switch (type) {
                case INT:
                    return new MinusExpressionExecutorInt(left, right);
                case LONG:
                    return new MinusExpressionExecutorLong(left, right);
                case FLOAT:
                    return new MinusExpressionExecutorFloat(left, right);
                case DOUBLE:
                    return new MinusExpressionExecutorDouble(left, right);
            }
        } else if (expression instanceof Mod) {
            ExpressionExecutor left = parseExpression(((Mod) expression).getLeftValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            ExpressionExecutor right = parseExpression(((Mod) expression).getRightValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            Attribute.Type type = parseArithmeticOperationResultType(left, right);
            switch (type) {
                case INT:
                    return new ModExpressionExecutorInt(left, right);
                case LONG:
                    return new ModExpressionExecutorLong(left, right);
                case FLOAT:
                    return new ModExpressionExecutorFloat(left, right);
                case DOUBLE:
                    return new ModExpressionExecutorDouble(left, right);
            }
        } else if (expression instanceof Divide) {
            ExpressionExecutor left = parseExpression(((Divide) expression).getLeftValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            ExpressionExecutor right = parseExpression(((Divide) expression).getRightValue(), currentStreamReference, processInStreamDefinition, siddhiContext, inputStream);
            Attribute.Type type = parseArithmeticOperationResultType(left, right);
            switch (type) {
                case INT:
                    return new DivideExpressionExecutorInt(left, right);
                case LONG:
                    return new DivideExpressionExecutorLong(left, right);
                case FLOAT:
                    return new DivideExpressionExecutorFloat(left, right);
                case DOUBLE:
                    return new DivideExpressionExecutorDouble(left, right);
            }
        } //TODO else if parts
        throw new UnsupportedOperationException(expression.toString() + " not supported!");

    }


    private static Attribute.Type parseArithmeticOperationResultType(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        if (leftExpressionExecutor.getReturnType() == Attribute.Type.DOUBLE || rightExpressionExecutor.getReturnType() == Attribute.Type.DOUBLE) {
            return Attribute.Type.DOUBLE;
        } else if (leftExpressionExecutor.getReturnType() == Attribute.Type.FLOAT || rightExpressionExecutor.getReturnType() == Attribute.Type.FLOAT) {
            return Attribute.Type.FLOAT;
        } else if (leftExpressionExecutor.getReturnType() == Attribute.Type.LONG || rightExpressionExecutor.getReturnType() == Attribute.Type.LONG) {
            return Attribute.Type.LONG;
        } else if (leftExpressionExecutor.getReturnType() == Attribute.Type.INT || rightExpressionExecutor.getReturnType() == Attribute.Type.INT) {
            return Attribute.Type.INT;
        } else {
            throw new ArithmeticException(leftExpressionExecutor.getReturnType() + " or " + rightExpressionExecutor.getReturnType() + " cannot be multiplied");
        }
    }



}
