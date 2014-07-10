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
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.query.selection.Selector;
import org.wso2.siddhi.query.api.query.selection.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SelectorValidator {

    /**
     * Method to validate selector for given set of stream definitions     *
     *
     * @param selector:       Selector to validate
     * @param definitionList: Definitions to validate against
     * @param renameMap:      Map to handle renaming
     * @throws ValidatorException Thrown if not validated
     */
    public static void validate(Selector selector, List<StreamDefinition> definitionList, Map<String, String> renameMap) throws ValidatorException {
        StreamDefinition temp = new StreamDefinition(Constants.SELECTOR_STREAM);        //inferred stream
        for (OutputAttribute attribute : selector.getSelectionList()) {
            if (attribute instanceof SimpleAttribute) {
                if (((SimpleAttribute) attribute).getExpression() instanceof Variable) {
                    ValidatorUtil.handleVariable((Variable) ((SimpleAttribute) attribute).getExpression(), definitionList, renameMap);
                    StreamDefinition source = getDefinitionFor(((Variable) ((SimpleAttribute) attribute).getExpression()).getStreamId(), definitionList);
                    String name = ((Variable) ((SimpleAttribute) attribute).getExpression()).getAttributeName();
                    temp.attribute(attribute.getRename(), ValidatorUtil.getAttributeType(name, source));
                }//TODO: handle else
            } else if (attribute instanceof ComplexAttribute) {          //TODO:check if we need to validate attribute names
                for (Expression expression : ((ComplexAttribute) attribute).getExpressions()) {
                    ValidatorUtil.validateCompareExpression(expression, definitionList, renameMap);
                    //Assuming aggregator complex attributes will not get a expression list
                    Attribute.Type type = ValidatorUtil.getAttributeType(((Variable) expression).getAttributeName(), getDefinitionFor(((Variable) expression).getStreamId(), definitionList));
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
                ValidatorUtil.handleVariable(var, definitionList, renameMap);
            }
        }
        if (selector.getHavingCondition() != null) {                    //Handle having condition. send only the inferred stream
            ValidatorUtil.validateCondition(selector.getHavingCondition(), Arrays.asList(temp), renameMap);
        }
        definitionList.add(temp);
    }

    private static StreamDefinition getDefinitionFor(String streamId, List<StreamDefinition> definitionList) {
        for (StreamDefinition definition : definitionList) {
            if (definition.getStreamId().equals(streamId)) {
                return definition;
            }
        }
        return null;
    }
}
