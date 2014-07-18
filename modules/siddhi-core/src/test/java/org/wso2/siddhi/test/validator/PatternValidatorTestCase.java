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
import org.wso2.siddhi.core.config.ExecutionPlan;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.pattern.Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternValidatorTestCase {
    static final Logger log = Logger.getLogger(SimpleQueryValidatorTestCase.class);
    private Map<String, StreamDefinition> definitionMap;
    private Map<String, String> renameMap;
    private List<StreamDefinition> streamDefinitionList;

    private ExecutionPlan executionPlan;
    private Query query;

    private StreamDefinition testDefinition1;
    private StreamDefinition testDefinition2;
    private StreamDefinition testDefinition3;

    @Before
    public void init() {
        testDefinition1 = StreamDefinition.id("StockStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).attribute("volume", Attribute.Type.FLOAT);
        testDefinition2 = StreamDefinition.id("OutStockStream").attribute("symbol", Attribute.Type.STRING).attribute("avgPrice", Attribute.Type.DOUBLE);
        testDefinition3 = StreamDefinition.id("TwitterStream").attribute("symbol", Attribute.Type.STRING).attribute("wordCount", Attribute.Type.INT);

        definitionMap = new HashMap<String, StreamDefinition>(2);
        definitionMap.put(testDefinition1.getId(), testDefinition1);
        definitionMap.put(testDefinition2.getId(), testDefinition2);
        definitionMap.put(testDefinition3.getId(), testDefinition3);

        streamDefinitionList = new ArrayList<StreamDefinition>();
        streamDefinitionList.add(testDefinition1);
        streamDefinitionList.add(testDefinition2);
        renameMap = new HashMap<String, String>(2);
        renameMap.put(testDefinition1.getId(), testDefinition1.getId());
        renameMap.put(testDefinition2.getId(), testDefinition2.getId());
        renameMap.put(testDefinition3.getId(), testDefinition3.getId());

        query = new Query();

        /*query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Query.inputStream("StockStream", "e1").filter(Condition.compare(Expression.variable("price"),
                                        Condition.Operator.GREATER_THAN_EQUAL,
                                        Expression.value(30))),
                                Pattern.followedBy(Query.inputStream("StockStream", "e2").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(20))),
                                        Query.inputStream("TwitterStream", "e3").filter(Condition.compare(Expression.variable("wordCount"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("e1", "price")))
                                )
                        )
                        , Expression.value(3000)
                )

        );
        query.insertInto("OutStockStream");
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", "avg", Expression.variable("e2", "price")).
                        select("count", Expression.variable("wordCount")).
                        groupBy("e1", "symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN,
                                Expression.value(50)))


        );*/


        /*executionPlan = new ExecutionPlan("testExecutionPlan");
        executionPlan.setStreamDefinitionMap(definitionMap);
        executionPlan.addQuery(query);*/

    }

    @Test
    public void QueryValidatorTestCase() throws ValidatorException {
        List<String> test = query.getInputStream().getStreamIds();
        QueryValidator.validate(query, definitionMap);
    }
}
