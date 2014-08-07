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
package org.wso2.siddhi.test.validator;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.condition.Compare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionValidatorTestCase {
    static final Logger log = Logger.getLogger(FunctionValidatorTestCase.class);
    private Map<String, StreamDefinition> definitionMap;
    private Map<String, String> renameMap;
    private List<StreamDefinition> streamDefinitionList;

    private ExecutionPlan executionPlan;
    private Query query;

    private StreamDefinition testDefinition1;
    private StreamDefinition testDefinition2;

    @Before
    public void init() {
        testDefinition1 = StreamDefinition.id("StockStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).attribute("volume", Attribute.Type.FLOAT);

        definitionMap = new HashMap<String, StreamDefinition>(2);
        definitionMap.put(testDefinition1.getId(), testDefinition1);

        renameMap = new HashMap<String, String>(2);
        renameMap.put(testDefinition1.getId(), testDefinition1.getId());

        query = new Query();

        query.from(
                InputStream.stream("StockStream").
                        filter(Expression.and(Expression.compare(Expression.value(9.5),
                                                Compare.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Expression.function("isMatch", Expression.value("[^0-9]+"),
                                                Expression.variable("volume")
                                        )
                                )
                        )
        );
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price"))
        );
        query.insertInto("OutStockStream");
        query.toString();

    }

    @Test
    public void FunctionValidatorTestCase() throws ValidatorException {
        List<String> test = query.getInputStream().getStreamIds();
        QueryValidator.validate(query, definitionMap);
    }
}
