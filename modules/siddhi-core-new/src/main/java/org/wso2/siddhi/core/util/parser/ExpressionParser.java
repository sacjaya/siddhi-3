/*
 *
 *  * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org)
 *  * All Rights Reserved.
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
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
import org.wso2.siddhi.core.event.ComplexMetaEvent;
import org.wso2.siddhi.core.event.stream.MetaStreamEvent;
import org.wso2.siddhi.core.exception.OperationNotSupportedException;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.ConstantExpressionExecutor;
import org.wso2.siddhi.core.executor.ExpressionExecutor;
import org.wso2.siddhi.core.executor.VariableExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.AndConditionExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.ConditionExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.NotConditionExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.OrConditionExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.compare.contains.ContainsCompareConditionExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.compare.equal.*;
import org.wso2.siddhi.core.executor.condition.compare.greater_than.*;
import org.wso2.siddhi.core.executor.condition.compare.greater_than_equal.*;
import org.wso2.siddhi.core.executor.condition.compare.less_than.*;
import org.wso2.siddhi.core.executor.condition.compare.less_than_equal.*;
import org.wso2.siddhi.core.executor.condition.compare.not_equal.*;
import org.wso2.siddhi.core.executor.math.Subtract.SubtractExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.math.Subtract.SubtractExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.math.Subtract.SubtractExpressionExecutorInt;
import org.wso2.siddhi.core.executor.math.Subtract.SubtractExpressionExecutorLong;
import org.wso2.siddhi.core.executor.math.add.AddExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.math.add.AddExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.math.add.AddExpressionExecutorInt;
import org.wso2.siddhi.core.executor.math.add.AddExpressionExecutorLong;
import org.wso2.siddhi.core.executor.math.divide.DivideExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.math.divide.DivideExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.math.divide.DivideExpressionExecutorInt;
import org.wso2.siddhi.core.executor.math.divide.DivideExpressionExecutorLong;
import org.wso2.siddhi.core.executor.math.mod.ModExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.math.mod.ModExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.math.mod.ModExpressionExecutorInt;
import org.wso2.siddhi.core.executor.math.mod.ModExpressionExecutorLong;
import org.wso2.siddhi.core.executor.math.multiply.MultiplyExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.math.multiply.MultiplyExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.math.multiply.MultiplyExpressionExecutorInt;
import org.wso2.siddhi.core.executor.math.multiply.MultiplyExpressionExecutorLong;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.expression.condition.And;
import org.wso2.siddhi.query.api.expression.condition.Compare;
import org.wso2.siddhi.query.api.expression.condition.Not;
import org.wso2.siddhi.query.api.expression.condition.Or;
import org.wso2.siddhi.query.api.expression.constant.*;
import org.wso2.siddhi.query.api.expression.function.AttributeFunction;
import org.wso2.siddhi.query.api.expression.math.*;

import java.util.List;
import java.util.Map;

/**
 * Class to parse Expressions and create Expression executors.
 */
public class ExpressionParser {

    /**
     * Parse the given expression and create the appropriate Executor by recursively traversing the expression
     *
     * @param expression             Expression to be parsed
     * @param currentStreamReference Stream id associated with current expression
     * @param siddhiContext          Associated Siddhi Context to be used when parsing Function Expressions
     * @param streamDefinitionMap    Map containing all relevant stream definitions for parsing the expression
     * @param metaEvent
     * @param executorList           List to hold VariableExpressionExecutors to update after query parsing  @return
     * @throws ValidatorException
     */
    public static ExpressionExecutor parseExpression(Expression expression, String currentStreamReference, SiddhiContext siddhiContext,
                                                     Map<String, StreamDefinition> streamDefinitionMap, ComplexMetaEvent metaEvent,
                                                     List<VariableExpressionExecutor> executorList) throws ValidatorException {
        if (expression instanceof And) {
            return new AndConditionExpressionExecutor(
                    parseExpression(((And) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                    parseExpression(((And) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
        } else if (expression instanceof Or) {
            return new OrConditionExpressionExecutor(
                    parseExpression(((Or) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                    parseExpression(((Or) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
        } else if (expression instanceof Not) {
            return new NotConditionExpressionExecutor(parseExpression(((Not) expression).getExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
        } else if (expression instanceof Compare) {
            if (((Compare) expression).getOperator() == Compare.Operator.EQUAL) {
                return parseEqualCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.NOT_EQUAL) {
                return parseNotEqualCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.GREATER_THAN) {
                return parseGreaterThanCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.GREATER_THAN_EQUAL) {
                return parseGreaterThanEqualCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.LESS_THAN) {
                return parseLessThanCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.LESS_THAN_EQUAL) {
                return parseLessThanEqualCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.CONTAINS) {
                return parseContainsCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            } else if (((Compare) expression).getOperator() == Compare.Operator.INSTANCE_OF) {
                return parseInstanceOfCompare(
                        parseExpression(((Compare) expression).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList),
                        parseExpression(((Compare) expression).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList));
            }

        } else if (expression instanceof Constant) {
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
            return parseVariable((Variable) expression, currentStreamReference, streamDefinitionMap, metaEvent, executorList);

        } else if (expression instanceof Multiply) {
            ExpressionExecutor left = parseExpression(((Multiply) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
            ExpressionExecutor right = parseExpression(((Multiply) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
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
            ExpressionExecutor left = parseExpression(((Add) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
            ExpressionExecutor right = parseExpression(((Add) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
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
        } else if (expression instanceof Subtract) {
            ExpressionExecutor left = parseExpression(((Subtract) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
            ExpressionExecutor right = parseExpression(((Subtract) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
            Attribute.Type type = parseArithmeticOperationResultType(left, right);
            switch (type) {
                case INT:
                    return new SubtractExpressionExecutorInt(left, right);
                case LONG:
                    return new SubtractExpressionExecutorLong(left, right);
                case FLOAT:
                    return new SubtractExpressionExecutorFloat(left, right);
                case DOUBLE:
                    return new SubtractExpressionExecutorDouble(left, right);
            }
        } else if (expression instanceof Mod) {
            ExpressionExecutor left = parseExpression(((Mod) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
            ExpressionExecutor right = parseExpression(((Mod) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
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
            ExpressionExecutor left = parseExpression(((Divide) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
            ExpressionExecutor right = parseExpression(((Divide) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaEvent, executorList);
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

        } else if (expression instanceof AttributeFunction) {
            //TODO Attribute Functions
        }

        //TODO else if parts
        throw new UnsupportedOperationException(expression.toString() + " not supported!");

    }

    /**
     * Create greater than Compare Condition Expression Executor which evaluates whether value of leftExpressionExecutor
     * is greater than value of rightExpressionExecutor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseGreaterThanCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                throw new OperationNotSupportedException("string cannot used in greater than comparisons");
            case INT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("int cannot be compared with string");
                    case INT:
                        return new GreaterThanCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanCompareConditionExpressionExecutorIntLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanCompareConditionExpressionExecutorIntFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanCompareConditionExpressionExecutorIntDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case LONG:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("long cannot be compared with string");
                    case INT:
                        return new GreaterThanCompareConditionExpressionExecutorLongInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanCompareConditionExpressionExecutorLongLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanCompareConditionExpressionExecutorLongFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanCompareConditionExpressionExecutorLongDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case FLOAT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new GreaterThanCompareConditionExpressionExecutorFloatInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanCompareConditionExpressionExecutorFloatLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanCompareConditionExpressionExecutorFloatFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanCompareConditionExpressionExecutorFloatDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case DOUBLE:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new GreaterThanCompareConditionExpressionExecutorDoubleInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanCompareConditionExpressionExecutorDoubleLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanCompareConditionExpressionExecutorDoubleFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanCompareConditionExpressionExecutorDoubleDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case BOOL:
                throw new OperationNotSupportedException("bool cannot used in greater than comparisons");
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used in greater than comparisons");
    }

    /**
     * Create greater than or equal Compare Condition Expression Executor which evaluates whether value of leftExpressionExecutor
     * is greater than or equal to value of rightExpressionExecutor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseGreaterThanEqualCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                throw new OperationNotSupportedException("string cannot used in greater than equal comparisons");
            case INT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("int cannot be compared with string");
                    case INT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanEqualCompareConditionExpressionExecutorIntLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorIntFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanEqualCompareConditionExpressionExecutorIntDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case LONG:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("long cannot be compared with string");
                    case INT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorLongInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanEqualCompareConditionExpressionExecutorLongLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorLongFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanEqualCompareConditionExpressionExecutorLongDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case FLOAT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorFloatInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanEqualCompareConditionExpressionExecutorFloatLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorFloatFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanEqualCompareConditionExpressionExecutorFloatDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case DOUBLE:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorDoubleInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new GreaterThanEqualCompareConditionExpressionExecutorDoubleLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new GreaterThanEqualCompareConditionExpressionExecutorDoubleFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new GreaterThanEqualCompareConditionExpressionExecutorDoubleDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case BOOL:
                throw new OperationNotSupportedException("bool cannot used in greater than equal comparisons");
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used in greater than equal comparisons");
    }

    /**
     * Create less than Compare Condition Expression Executor which evaluates whether value of leftExpressionExecutor
     * is less than value of rightExpressionExecutor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseLessThanCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                throw new OperationNotSupportedException("string cannot used in less than comparisons");
            case INT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("int cannot be compared with string");
                    case INT:
                        return new LessThanCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanCompareConditionExpressionExecutorIntLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanCompareConditionExpressionExecutorIntFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanCompareConditionExpressionExecutorIntDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case LONG:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("long cannot be compared with string");
                    case INT:
                        return new LessThanCompareConditionExpressionExecutorLongInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanCompareConditionExpressionExecutorLongLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanCompareConditionExpressionExecutorLongFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanCompareConditionExpressionExecutorLongDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case FLOAT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new LessThanCompareConditionExpressionExecutorFloatInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanCompareConditionExpressionExecutorFloatLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanCompareConditionExpressionExecutorFloatFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanCompareConditionExpressionExecutorFloatDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case DOUBLE:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new LessThanCompareConditionExpressionExecutorDoubleInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanCompareConditionExpressionExecutorDoubleLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanCompareConditionExpressionExecutorDoubleFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanCompareConditionExpressionExecutorDoubleDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case BOOL:
                throw new OperationNotSupportedException("bool cannot used in less than comparisons");
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used in less than comparisons");
    }

    /**
     * Create less than or equal Compare Condition Expression Executor which evaluates whether value of leftExpressionExecutor
     * is less than or equal to value of rightExpressionExecutor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseLessThanEqualCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                throw new OperationNotSupportedException("string cannot used in less than equal comparisons");
            case INT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("int cannot be compared with string");
                    case INT:
                        return new LessThanEqualCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanEqualCompareConditionExpressionExecutorIntLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanEqualCompareConditionExpressionExecutorIntFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanEqualCompareConditionExpressionExecutorIntDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case LONG:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("long cannot be compared with string");
                    case INT:
                        return new LessThanEqualCompareConditionExpressionExecutorLongInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanEqualCompareConditionExpressionExecutorLongLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanEqualCompareConditionExpressionExecutorLongFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanEqualCompareConditionExpressionExecutorLongDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case FLOAT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new LessThanEqualCompareConditionExpressionExecutorFloatInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanEqualCompareConditionExpressionExecutorFloatLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanEqualCompareConditionExpressionExecutorFloatFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanEqualCompareConditionExpressionExecutorFloatDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case DOUBLE:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new LessThanEqualCompareConditionExpressionExecutorDoubleInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new LessThanEqualCompareConditionExpressionExecutorDoubleLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new LessThanEqualCompareConditionExpressionExecutorDoubleFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new LessThanEqualCompareConditionExpressionExecutorDoubleDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case BOOL:
                throw new OperationNotSupportedException("bool cannot used in less than equal comparisons");
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used in less than equal comparisons");
    }

    /**
     * Create equal Compare Condition Expression Executor which evaluates whether value of leftExpressionExecutor
     * is equal to value of rightExpressionExecutor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseEqualCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        return new EqualCompareConditionExpressionExecutorStringString(leftExpressionExecutor, rightExpressionExecutor);
                    default:
                        throw new OperationNotSupportedException("sting cannot be compared with " + rightExpressionExecutor.getReturnType());
                }
            case INT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("int cannot be compared with string");
                    case INT:
                        return new EqualCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new EqualCompareConditionExpressionExecutorIntLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new EqualCompareConditionExecutorIntFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new EqualCompareConditionExpressionExecutorIntDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case LONG:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("long cannot be compared with string");
                    case INT:
                        return new EqualCompareConditionExpressionExecutorLongInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new EqualCompareConditionExpressionExecutorLongLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new EqualCompareConditionExpressionExecutorLongFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new EqualCompareConditionExpressionExecutorLongDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case FLOAT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new EqualCompareConditionExpressionExecutorFloatInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new EqualCompareConditionExpressionExecutorFloatLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new EqualCompareConditionExpressionExecutorFloatFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new EqualCompareConditionExpressionExecutorFloatDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case DOUBLE:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new EqualCompareConditionExpressionExecutorDoubleInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new EqualCompareConditionExpressionExecutorDoubleLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new EqualCompareConditionExecutorDoubleFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new EqualCompareConditionExpressionExecutorDoubleDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case BOOL:
                switch (rightExpressionExecutor.getReturnType()) {
                    case BOOL:
                        return new EqualCompareConditionExpressionExecutorBoolBool(leftExpressionExecutor, rightExpressionExecutor);
                    default:
                        throw new OperationNotSupportedException("bool cannot be compared with " + rightExpressionExecutor.getReturnType());
                }
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used  equal comparisons");
    }

    /**
     * Create not equal Compare Condition Expression Executor which evaluates whether value of leftExpressionExecutor
     * is not equal to value of rightExpressionExecutor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseNotEqualCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        return new NotEqualCompareConditionExpressionExecutorStringString(leftExpressionExecutor, rightExpressionExecutor);
                    default:
                        throw new OperationNotSupportedException("sting cannot be compared with " + rightExpressionExecutor.getReturnType());
                }
            case INT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("int cannot be compared with string");
                    case INT:
                        return new NotEqualCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new NotEqualCompareConditionExpressionExecutorIntLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new NotEqualCompareConditionExpressionExecutorIntFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new NotEqualCompareConditionExpressionExecutorIntDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case LONG:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("long cannot be compared with string");
                    case INT:
                        return new NotEqualCompareConditionExpressionExecutorLongInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new NotEqualCompareConditionExpressionExecutorLongLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new NotEqualCompareConditionExpressionExecutorLongFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new NotEqualCompareConditionExpressionExecutorLongDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case FLOAT:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new NotEqualCompareConditionExpressionExecutorFloatInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new NotEqualCompareConditionExpressionExecutorFloatLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new NotEqualCompareConditionExpressionExecutorFloatFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new NotEqualCompareConditionExpressionExecutorFloatDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case DOUBLE:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        throw new OperationNotSupportedException("float cannot be compared with string");
                    case INT:
                        return new NotEqualCompareConditionExpressionExecutorDoubleInt(leftExpressionExecutor, rightExpressionExecutor);
                    case LONG:
                        return new NotEqualCompareConditionExpressionExecutorDoubleLong(leftExpressionExecutor, rightExpressionExecutor);
                    case FLOAT:
                        return new NotEqualCompareConditionExpressionExecutorDoubleFloat(leftExpressionExecutor, rightExpressionExecutor);
                    case DOUBLE:
                        return new NotEqualCompareConditionExpressionExecutorDoubleDouble(leftExpressionExecutor, rightExpressionExecutor);
                    case BOOL:
                        throw new OperationNotSupportedException("int cannot be compared with bool");
                }
            case BOOL:
                switch (rightExpressionExecutor.getReturnType()) {
                    case BOOL:
                        return new NotEqualCompareConditionExpressionExecutorBoolBool(leftExpressionExecutor, rightExpressionExecutor);
                    default:
                        throw new OperationNotSupportedException("bool cannot be compared with " + rightExpressionExecutor.getReturnType());
                }
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used in not equal comparisons");
    }

    /**
     * Create contains Compare Condition Expression Executor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseContainsCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {
        switch (leftExpressionExecutor.getReturnType()) {
            case STRING:
                switch (rightExpressionExecutor.getReturnType()) {
                    case STRING:
                        return new ContainsCompareConditionExpressionExecutor(leftExpressionExecutor, rightExpressionExecutor);
                    default:
                        throw new OperationNotSupportedException(rightExpressionExecutor.getReturnType() + " cannot be used in contains comparisons");
                }
        }
        throw new OperationNotSupportedException(leftExpressionExecutor.getReturnType() + " cannot be used in contains comparisons");
    }


    /**
     * Create instance of Compare Condition Expression Executor.
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
    private static ConditionExpressionExecutor parseInstanceOfCompare(
            ExpressionExecutor leftExpressionExecutor, ExpressionExecutor rightExpressionExecutor) {

        switch (rightExpressionExecutor.getReturnType()) {
            //TODO remove?
//            case TYPE:
//                return new InstanceOfCompareConditionExecutor(leftExpressionExecutor, rightExpressionExecutor);
        }
        throw new OperationNotSupportedException(rightExpressionExecutor.getReturnType() + " cannot be used in right hand side of the instanceof comparisons");
    }

    /**
     * Parse and validate the given Siddhi variable and return a VariableExpressionExecutor
     *
     * @param variable               Variable to be parsed
     * @param currentStreamReference Stream id associated with current expression
     * @param streamDefinitionMap    Map containing all relevant stream definitions for parsing the expression
     * @param metaEvent              Meta event used to collect execution info of stream associated with query
     * @param executorList           List to hold VariableExpressionExecutors to update after query parsing
     * @return VariableExpressionExecutor representing given variable
     * @throws ValidatorException
     */
    private static ExpressionExecutor parseVariable(Variable variable, String currentStreamReference, Map<String, StreamDefinition> streamDefinitionMap,
                                                    ComplexMetaEvent metaEvent, List<VariableExpressionExecutor> executorList) throws ValidatorException {
        String attributeName = variable.getAttributeName();
        String streamId = variable.getStreamId();
        String[] attributeNameArray;
        if (metaEvent == null) {  //validation step
            if (streamDefinitionMap == null) {    //stream definition map should be present
                throw new ValidatorException("Provided stream definition map is null");
            }
            if (streamId == null) {
                if (currentStreamReference != null) {
                    if (streamDefinitionMap.containsKey(currentStreamReference)) {
                        attributeNameArray = streamDefinitionMap.get(currentStreamReference).getAttributeNameArray();
                        streamId = currentStreamReference;
                    } else {
                        throw new ValidatorException("Can not find a stream definition named " + currentStreamReference);
                    }
                } else { //if current stream reference is also null check for unique attribute
                    int count = 0;
                    for (Map.Entry<String, StreamDefinition> entry : streamDefinitionMap.entrySet()) {
                        attributeNameArray = entry.getValue().getAttributeNameArray();
                        for (String anAttributeNameArray : attributeNameArray) {           //iterate through attribute list
                            if (anAttributeNameArray.equals(attributeName)) {
                                count++;
                                streamId = entry.getKey();
                            }
                        }
                    }
                    if (count == 1) {
                        attributeNameArray = streamDefinitionMap.get(streamId).getAttributeNameArray();
                    } else if (count == 0) {
                        throw new ValidatorException("Could not find an attribute named " + attributeName);
                    } else {
                        throw new ValidatorException("Could not find an unique attribute named " + attributeName);
                    }
                }
            } else {
                attributeNameArray = streamDefinitionMap.get(streamId).getAttributeNameArray();
            }
            if (attributeNameArray != null) {
                for (String resultAttributeName : attributeNameArray) {           //iterate through attribute list
                    if (attributeName.equals(resultAttributeName)) {
                        return new VariableExpressionExecutor(attributeName, streamDefinitionMap.get(streamId));
                    }
                }
                throw new ValidatorException("Stream definition " + streamId + " does not contain an attribute named " + attributeName);
            } else {
                throw new ValidatorException("Stream definition " + streamId + " does not contain any attributes");
            }
        } else {
            if (metaEvent instanceof MetaStreamEvent) {
                MetaStreamEvent metaStreamEvent = (MetaStreamEvent) metaEvent;
                metaEvent.addData(new Attribute(attributeName, metaStreamEvent.getDefinition().getAttributeType(attributeName)));
                VariableExpressionExecutor variableExpressionExecutor = new VariableExpressionExecutor(attributeName, (StreamDefinition) (metaStreamEvent.getDefinition()));
                executorList.add(variableExpressionExecutor);
                return variableExpressionExecutor;
            } else {
                //TODO handle meta state events
                throw new OperationNotSupportedException("MetaStateEvents are not supported at the moment");
            }
        }
    }

    /**
     * Calculate the return type of arithmetic operation executors.(Ex: add, subtract, etc)
     *
     * @param leftExpressionExecutor
     * @param rightExpressionExecutor
     * @return
     */
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
            throw new ArithmeticException("Arithmetic operation between " + leftExpressionExecutor.getReturnType() + " and " + rightExpressionExecutor.getReturnType() + " cannot be executed");
        }
    }


}
