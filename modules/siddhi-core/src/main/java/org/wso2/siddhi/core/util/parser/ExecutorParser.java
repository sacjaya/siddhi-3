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
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.exception.OperationNotSupportedException;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.condition.AndConditionExecutor;
import org.wso2.siddhi.core.executor.condition.ConditionExecutor;
import org.wso2.siddhi.core.executor.condition.NotConditionExecutor;
import org.wso2.siddhi.core.executor.condition.OrConditionExecutor;
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
import org.wso2.siddhi.core.executor.expression.Subtract.SubtractExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.Subtract.SubtractExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.Subtract.SubtractExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.Subtract.SubtractExpressionExecutorLong;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.mod.ModExpressionExecutorLong;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorDouble;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorFloat;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorInt;
import org.wso2.siddhi.core.executor.expression.multiply.MultiplyExpressionExecutorLong;
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

public class ExecutorParser {


    public static ConditionExecutor parseCondition(Expression condition,
                                                   String currentStreamReference,
                                                   SiddhiContext siddhiContext, Map<String, StreamDefinition> streamDefinitionMap, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> executorList) throws ValidatorException {
        if (condition instanceof And) {
            return new AndConditionExecutor(parseCondition(((And) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                    parseCondition(((And) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
        } else if (condition instanceof Or) {
            return new OrConditionExecutor(parseCondition(((Or) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                    parseCondition(((Or) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
        } else if (condition instanceof Not) {
            return new NotConditionExecutor(parseCondition(((Not) condition).getExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
//        } else if (condition instanceof BooleanCondition) {
//            return new BooleanConditionExecutor(parseExpression(((BooleanCondition) condition).getExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
        } else if (condition instanceof Compare) {
            if (((Compare) condition).getOperator() == Compare.Operator.EQUAL) {
                return ComparatorParser.parseEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            } else if (((Compare) condition).getOperator() == Compare.Operator.NOT_EQUAL) {
                return ComparatorParser.parseNotEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            } else if (((Compare) condition).getOperator() == Compare.Operator.GREATER_THAN) {
                return ComparatorParser.parseGreaterThanCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            } else if (((Compare) condition).getOperator() == Compare.Operator.GREATER_THAN_EQUAL) {
                return ComparatorParser.parseGreaterThanEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            } else if (((Compare) condition).getOperator() == Compare.Operator.LESS_THAN) {
                return ComparatorParser.parseLessThanCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            } else if (((Compare) condition).getOperator() == Compare.Operator.LESS_THAN_EQUAL) {
                return ComparatorParser.parseLessThanEqualCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));

            } else if (((Compare) condition).getOperator() == Compare.Operator.CONTAINS) {
                return ComparatorParser.parseContainsCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            } else if (((Compare) condition).getOperator() == Compare.Operator.INSTANCE_OF) {
                return ComparatorParser.parseInstanceOfCompare(parseExpression(((Compare) condition).getLeftExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList),
                        parseExpression(((Compare) condition).getRightExpression(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList));
            }
        } /*else if (condition instanceof FunctionCondition) {
            List<ExpressionExecutor> expressionExecutors = new LinkedList<ExpressionExecutor>();
            for (Expression expression : ((FunctionCondition) condition).getParameters()) {
                expressionExecutors.add(parseExpression(expression, currentStreamReference, siddhiContext, streamDefinitionMap));
            }
            FunctionExecutor expressionExecutor = (FunctionExecutor) SiddhiClassLoader.loadSiddhiImplementation(((AttributeFunction) Expression.function(((FunctionCondition) condition).getFunction(), ((FunctionCondition) condition).getParameters())).getFunction(), FunctionExecutor.class);
//            siddhiContext.addEternalReferencedHolder(expressionExecutor);
            expressionExecutor.setSiddhiContext(siddhiContext);
            expressionExecutor.setAttributeExpressionExecutors(expressionExecutors);
            expressionExecutor.init();
            if (expressionExecutor.getReturnType() != Attribute.Type.BOOL) {
                throw new OperationNotSupportedException(((FunctionCondition) condition).getFunction() + " of class " + expressionExecutor.getClass().getName() + " does not return bool hence it cannot be used as a onDeleteExpression");
            }
            return new BooleanConditionExecutor(expressionExecutor);
        }*/ else {
            //TODO: else
        }
        throw new OperationNotSupportedException(condition + " not supported !");
    }

    public static ExpressionExecutor parseExpression(Expression expression,
                                                     String currentStreamReference,
                                                     SiddhiContext siddhiContext, Map<String, StreamDefinition> streamDefinitionMap, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> executorList) throws ValidatorException {
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
            return parseVariable((Variable) expression, currentStreamReference, streamDefinitionMap, metaStreamEvent, executorList);
            //return new VariableExpressionExecutor(((Variable) expression).getId(), ((Variable) expression).getAttributeName(), currentStreamReference, streamDefinitionMap);
        } else if (expression instanceof Multiply) {
            ExpressionExecutor left = parseExpression(((Multiply) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
            ExpressionExecutor right = parseExpression(((Multiply) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
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
            ExpressionExecutor left = parseExpression(((Add) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
            ExpressionExecutor right = parseExpression(((Add) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
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
            ExpressionExecutor left = parseExpression(((Subtract) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
            ExpressionExecutor right = parseExpression(((Subtract) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
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
            ExpressionExecutor left = parseExpression(((Mod) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
            ExpressionExecutor right = parseExpression(((Mod) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
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
            ExpressionExecutor left = parseExpression(((Divide) expression).getLeftValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
            ExpressionExecutor right = parseExpression(((Divide) expression).getRightValue(), currentStreamReference, siddhiContext, streamDefinitionMap, metaStreamEvent, executorList);
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

    private static ExpressionExecutor parseVariable(Variable variable, String currentStreamReference, Map<String, StreamDefinition> streamDefinitionMap, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> executorList) throws ValidatorException {
        String attributeName = variable.getAttributeName();
        String streamId = variable.getStreamId();
        String[] attributeNameArray;
        if (streamId == null) {
            if (currentStreamReference != null) {
                attributeNameArray = streamDefinitionMap.get(currentStreamReference).getAttributeNameArray();
                streamId = currentStreamReference;
            } else {
                //Check for duplicates and existence of attribute
                int count = 0;
                String id = null;
                for (Map.Entry<String, StreamDefinition> entry : streamDefinitionMap.entrySet()) {
                    attributeNameArray = entry.getValue().getAttributeNameArray();
                    for (String anAttributeNameArray : attributeNameArray) {           //iterate through attribute list
                        if (anAttributeNameArray.equals(attributeName)) {
                            count++;
                            id = entry.getKey();
                        }
                    }
                }
                if (count == 1) {
                    if (metaStreamEvent != null && executorList != null) {
                        metaStreamEvent.addData(new Attribute(attributeName, streamDefinitionMap.get(id).getAttributeType(attributeName)));
                        VariableExpressionExecutor variableExpressionExecutor = new VariableExpressionExecutor(id, attributeName, streamDefinitionMap.get(id), true);//TODO: check process in definition
                        executorList.add(variableExpressionExecutor);
                        return variableExpressionExecutor;
                    } else {
                        return new VariableExpressionExecutor(id, attributeName, streamDefinitionMap.get(id), true);//TODO: check process in definition
                    }

                } else {
                    throw new ValidatorException("Could not find an attribute named " + attributeName);
                }
            }
        } else {
            attributeNameArray = streamDefinitionMap.get(streamId).getAttributeNameArray();
        }
        if (attributeNameArray != null) {
            for (String resultAttributeName : attributeNameArray) {           //iterate through attribute list
                if (attributeName.equals(resultAttributeName)) {
                    if (metaStreamEvent != null && executorList != null) {
                        metaStreamEvent.addData(new Attribute(attributeName, streamDefinitionMap.get(streamId).getAttributeType(attributeName)));
                        VariableExpressionExecutor variableExpressionExecutor = new VariableExpressionExecutor(streamId, attributeName, streamDefinitionMap.get(streamId), true);//TODO: check process in definition
                        executorList.add(variableExpressionExecutor);
                        return variableExpressionExecutor;
                    } else {
                        return new VariableExpressionExecutor(streamId, attributeName, streamDefinitionMap.get(streamId), true);//TODO: check process in definition
                    }
                }
            }
            throw new ValidatorException("Stream definition " + streamId + " does not contain an attribute named " + attributeName);
        } else {
            throw new ValidatorException("Stream definition " + streamId + " does not contain an attribute named " + attributeName);
        }
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
