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
import org.wso2.siddhi.core.util.validate.InStreamValidator;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.core.util.validate.SelectorValidator;
import org.wso2.siddhi.core.util.validate.StreamValidator;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.JoinInputStream;
import org.wso2.siddhi.query.api.query.output.stream.OutputStream;
import org.wso2.siddhi.query.api.query.selection.Selector;

import java.util.*;

public class SimpleQueryValidatorTestCase {
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
        testDefinition2 = StreamDefinition.id("OutStockStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT);
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

        query.
                property("name", "Query1").property("summary", "Test Query").
                from(
                        Query.joinInputStream(
                                Query.inputStream("StockStream").
                                        window("lengthBatch", Expression.value(50)),
                                JoinInputStream.Type.JOIN,
                                Query.inputStream("TwitterStream").
                                        filter(
                                                Condition.compare(
                                                        Expression.value(50),
                                                        Condition.Operator.GREATER_THAN,
                                                        Expression.variable("TwitterStream", "wordCount")
                                                )


                                        ).window("lengthBatch", Expression.value(50)),
                                Condition.compare(
                                        Expression.variable("StockStream", "symbol"),
                                        Condition.Operator.EQUAL,
                                        Expression.variable("TwitterStream", "symbol"))
                        )
                ).
                select(
                        Query.outputSelector().
                                select("symbol", Expression.variable("StockStream", "symbol")).
                                select("price", Expression.variable(null, "price")).
                                groupBy("StockStream", "symbol").
                                having(
                                        Condition.compare(
                                                Expression.value(50),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable(null, "price"))
                                )
                ).
                insertInto("OutStockStream", OutputStream.OutputEventsFor.EXPIRED_EVENTS);


        /*executionPlan = new ExecutionPlan("testExecutionPlan");
        executionPlan.setStreamDefinitionMap(definitionMap);
        executionPlan.addQuery(query);*/

    }

    @Test
    public void streamDefinitionValidatorWithValidStreamTest() throws ValidatorException {
        StreamDefinition testDefinition = StreamDefinition.id("OutStockStream1").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT);
        StreamValidator.validate(definitionMap, testDefinition);
    }

    @Test(expected = ValidatorException.class)
    public void streamDefinitionValidatorWithInvalidStreamTest() throws ValidatorException {
        StreamDefinition testDefinition = StreamDefinition.id("OutStockStream").attribute("symbol", Attribute.Type.STRING).attribute("price1", Attribute.Type.FLOAT);
        StreamValidator.validate(definitionMap, testDefinition);
    }

    @Test
    public void streamDefinitionValidatorWithSameStreamTest() throws ValidatorException {
        StreamDefinition testDefinition = StreamDefinition.id("OutStockStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT);
        StreamValidator.validate(definitionMap, testDefinition);
    }

    @Test
    public void inStreamValidatorTest() throws ValidatorException {
        Map<String, StreamDefinition> sampleRenameMap = new HashMap<String, StreamDefinition>();
        InStreamValidator.validate(query.getInputStream(), definitionMap, sampleRenameMap);
    }

    @Test
    public void SelectorValidatorTest() throws ValidatorException {
        Map<String, StreamDefinition> sampleRenameMap = new HashMap<String, StreamDefinition>();
        sampleRenameMap.put(testDefinition1.getId(), testDefinition1);
        sampleRenameMap.put(testDefinition3.getId(), testDefinition3);
        SelectorValidator.validate(query.getSelector(), sampleRenameMap);
        query.getSelector();
    }

    @Test(expected = ValidatorException.class)
    public void SelectorValidatorInvalidTest() throws ValidatorException {
        Selector selector = Query.outputSelector().
                select("symbol", Expression.variable("symbol1")).
                select("price", Expression.variable("price"));
        Map<String, StreamDefinition> sampleRenameMap = new HashMap<String, StreamDefinition>();
        sampleRenameMap.put("testDef", testDefinition1);
        SelectorValidator.validate(selector, sampleRenameMap);
    }

    @Test
    public void QueryValidatorTestCase() throws ValidatorException {
        QueryValidator.validate(query, definitionMap);
    }
}
