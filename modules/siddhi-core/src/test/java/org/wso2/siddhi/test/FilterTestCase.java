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
package org.wso2.siddhi.test;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.ExecutionPlanRuntime;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.core.util.validate.StreamValidator;
import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.annotation.Annotation;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.InputStream;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.condition.Compare;

import java.util.HashMap;
import java.util.Map;

public class FilterTestCase {
    static final Logger log = Logger.getLogger(FilterTestCase.class);

    private int count;
    private boolean eventArrived;
    Map<String, StreamDefinition> streamDefinitionMap = new HashMap<String, StreamDefinition>();

    @Before
    public void init() {
        count = 0;
        eventArrived = false;
    }

    @Test
    public void testFilterQuery1() throws InterruptedException, ValidatorException {

        log.info("Filter test1");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.from(InputStream.stream("cseEventStream"));
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))
        );
        query.insertInto("StockQuote");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime exRuntime = siddhiManager.addExecutionPlan(executionPlan);

        exRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
            }
        });

        InputHandler inputHandler = exRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();
    }

    @Test
    public void testFilterQuery2() throws InterruptedException, ValidatorException {
        log.info("Filter test2");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);
        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))
        );
        query.insertInto("StockQuote");


        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
            }

        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery3() throws InterruptedException, ValidatorException {
        log.info("Filter test3");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol"))
        );
        query.insertInto("StockQuote");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
            }

        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery4() throws InterruptedException, ValidatorException {
        log.info("Filter test4");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").
                        filter(Expression.compare(Expression.value(70),
                                        Compare.Operator.GREATER_THAN,
                                        Expression.variable("price"))
                        )
        );
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))
        );
        query.insertInto("StockQuote");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("WSO2".equals(inEvents[0].getData(0)));
                count++;
            }

        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 55.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 57.6f, 100});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery5() throws InterruptedException, ValidatorException {


        log.info("Filter test5");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume")).groupBy(Expression.variable("symbol"))
        );
        query.insertInto("StockQuote");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
                eventArrived = true;
            }
        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        Assert.assertEquals("Event arrived", true, eventArrived);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery6() throws InterruptedException, ValidatorException {
        log.info("Filter test6");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("increasedVolume", Expression.add(Expression.value(100), Expression.variable("volume"))).
                        select("decreasedVolume", Expression.subtract(Expression.variable("volume"), Expression.value(50))).
                        select("multipliedVolume", Expression.multiply(Expression.value(4), Expression.variable("volume"))).
                        select("dividedVolume", Expression.divide(Expression.variable("volume"), Expression.value(8)))
        );
        query.insertInto("OutputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("200".equals(inEvents[0].getData()[2].toString()));
                Assert.assertTrue("50".equals(inEvents[0].getData()[3].toString()));
                Assert.assertTrue("400".equals(inEvents[0].getData()[4].toString()));
                Assert.assertTrue("12.5".equals(inEvents[0].getData()[5].toString()));
            }

        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 55.6f, 100l});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100l});
        inputHandler.send(new Object[]{"WSO2", 57.6f, 100l});
        Thread.sleep(100);

        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery7() throws InterruptedException, ValidatorException {
        log.info("Filter test7");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.NOT_EQUAL, Expression.value(50))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 45f, 100});
        inputHandler.send(new Object[]{"IBM", 35f, 50});

        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery8() throws InterruptedException, ValidatorException {
        log.info("Filter test8");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.NOT_EQUAL, Expression.value(50))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 45f, 100});
        inputHandler.send(new Object[]{"IBM", 35f, 50});

        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery9() throws InterruptedException, ValidatorException {
        log.info("Filter test9");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.NOT_EQUAL, Expression.value(100L))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("volume", Expression.variable("volume")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 40f, 70});
        inputHandler.send(new Object[]{"WSO2", 60f, 50});
        inputHandler.send(new Object[]{"WSO2", 100f, 100});

        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();


    }

    @Test
    public void testFilterQuery10() throws InterruptedException, ValidatorException {
        log.info("Filter test10");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.NOT_EQUAL, Expression.value(50))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 40f, 50});
        inputHandler.send(new Object[]{"WSO2", 20f, 100});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();


    }

    @Test
    public void testFilterQuery11() throws InterruptedException, ValidatorException {
        log.info("Filter test11");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.NOT_EQUAL, Expression.value(50f))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 40f, 50});
        inputHandler.send(new Object[]{"WSO2", 20f, 100});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();
    }

    @Test
    public void testFilterQuery12() throws InterruptedException, ValidatorException {
        log.info("Filter test12");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("price"), Compare.Operator.NOT_EQUAL, Expression.value(50l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("volume", Expression.variable("volume")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);


        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 50});
        inputHandler.send(new Object[]{"IBM", 500f, 100});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();
    }

    @Test
    public void testFilterQuery13() throws InterruptedException, ValidatorException {
        log.info("Filter test13");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("validity", Attribute.Type.BOOL);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("validity"), Compare.Operator.EQUAL, Expression.value(true))));
        query.insertInto("outputStream");
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("volume", Expression.variable("volume")));

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50d, 50, true});
        inputHandler.send(new Object[]{"IBM", 55d, 100, false});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();
    }

    @Test
    public void testFilterQuery14() throws InterruptedException, ValidatorException {
        log.info("Filter test14");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.GREATER_THAN, Expression.value(50l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("volume", Expression.variable("volume")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60});
        inputHandler.send(new Object[]{"WSO2", 70f, 40});
        inputHandler.send(new Object[]{"WSO2", 44f, 200});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery15() throws InterruptedException, ValidatorException {
        log.info("Filter test15");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.GREATER_THAN, Expression.value(50l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("volume", Expression.variable("volume")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60});
        inputHandler.send(new Object[]{"WSO2", 70f, 40});
        inputHandler.send(new Object[]{"WSO2", 44f, 200});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery16() throws InterruptedException, ValidatorException {
        log.info("Filter test16");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.GREATER_THAN, Expression.value(50l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("volume", Expression.variable("volume")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60});
        inputHandler.send(new Object[]{"WSO2", 70f, 40});
        inputHandler.send(new Object[]{"WSO2", 44f, 200});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery17() throws InterruptedException, ValidatorException {
        log.info("Filter test17");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.GREATER_THAN, Expression.value(50l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60});
        inputHandler.send(new Object[]{"WSO2", 70f, 40});
        inputHandler.send(new Object[]{"WSO2", 44f, 200});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery18() throws InterruptedException, ValidatorException {
        log.info("Filter test18");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.EQUAL, Expression.value(60l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60});
        inputHandler.send(new Object[]{"WSO2", 70f, 60});
        inputHandler.send(new Object[]{"WSO2", 44f, 200});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery19() throws InterruptedException, ValidatorException {
        log.info("Filter test19");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.DOUBLE);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("price"), Compare.Operator.EQUAL, Expression.value(60l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60d});
        inputHandler.send(new Object[]{"WSO2", 70f, 60d});
        inputHandler.send(new Object[]{"WSO2", 60f, 200d});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery20() throws InterruptedException, ValidatorException {
        log.info("Filter test20");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.DOUBLE).attribute("quantity", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.EQUAL, Expression.value(5d))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60d, 5});
        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
        inputHandler.send(new Object[]{"WSO2", 60f, 200d, 4});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery21() throws InterruptedException, ValidatorException {
        log.info("Filter test21");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.DOUBLE).attribute("quantity", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.EQUAL, Expression.value(5f))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);
        for (StreamDefinition streamDef : streamDefinitionMap.values()) {

        }
        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60d, 5});
        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
        inputHandler.send(new Object[]{"WSO2", 60f, 200d, 4});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery22() throws InterruptedException, ValidatorException {
        log.info("Filter test22");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.DOUBLE).attribute("quantity", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.EQUAL, Expression.value(2))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60d, 5});
        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
        inputHandler.send(new Object[]{"WSO2", 60f, 200d, 4});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery23() throws InterruptedException, ValidatorException {
        log.info("Filter test23");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.DOUBLE).attribute("quantity", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.EQUAL, Expression.value(4l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);


        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60d, 5});
        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
        inputHandler.send(new Object[]{"WSO2", 60f, 200d, 4});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery24() throws InterruptedException, ValidatorException {
        log.info("Filter test24");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.EQUAL, Expression.value(200l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);


        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60, 5});
        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
        inputHandler.send(new Object[]{"WSO2", 60f, 200, 4});
        Thread.sleep(100);
        Assert.assertEquals(1, count);
        siddhiManager.shutdown();

    }

    @Test
    public void testFilterQuery25() throws InterruptedException, ValidatorException {
        log.info("Filter test25");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.LESS_THAN_EQUAL, Expression.value(200l))));
        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
        query.insertInto("outputStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);

        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);
        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                count++;
            }
        });

        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"WSO2", 50f, 60, 5});
        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
        inputHandler.send(new Object[]{"WSO2", 60f, 300, 4});
        Thread.sleep(100);
        Assert.assertEquals(2, count);
        siddhiManager.shutdown();

    }

//    @Test
//    public void testFilterQuery26() throws InterruptedException, ValidatorException {
//        log.info("Filter test26");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("price"), Compare.Operator.LESS_THAN_EQUAL, Expression.value(200l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 60d, 5});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300d, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery27() throws InterruptedException, ValidatorException {
//        log.info("Filter test27");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.LESS_THAN_EQUAL, Expression.value(5d))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 60d, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300d, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery28() throws InterruptedException, ValidatorException {
//        log.info("Filter test28");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.LESS_THAN_EQUAL, Expression.value(5f))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 60d, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300d, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery29() throws InterruptedException, ValidatorException {
//        log.info("Filter test29");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.LESS_THAN_EQUAL, Expression.value(3l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 60d, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300d, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(1, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery30() throws InterruptedException, ValidatorException {
//        log.info("Filter test30");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.LESS_THAN_EQUAL, Expression.value(60l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 60, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//
//    //*************************************************************************************************************************
//    //Test cases for less-than operator
//
//
//    @Test
//    public void testFilterQuery31() throws InterruptedException, ValidatorException {
//        log.info("Filter test31");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.LESS_THAN, Expression.value(60l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(1, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery32() throws InterruptedException, ValidatorException {
//        log.info("Filter test32");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("price"), Compare.Operator.LESS_THAN, Expression.value(60l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50d, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
//        inputHandler.send(new Object[]{"WSO2", 50f, 300d, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(1, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery33() throws InterruptedException, ValidatorException {
//        log.info("Filter test33");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.LESS_THAN, Expression.value(4l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50d, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60d, 2});
//        inputHandler.send(new Object[]{"WSO2", 50f, 300d, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(1, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery34() throws InterruptedException, ValidatorException {
//        log.info("Filter test34");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.LESS_THAN, Expression.value(40l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 20, 2});
//        inputHandler.send(new Object[]{"WSO2", 50f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(1, count);
//        siddhiManager.shutdown();
//
//    }
//
//    //*********************************************************************************************************************
//    // Test cases for Greater_than_equal operator
//
//    @Test
//    public void testFilterQuery35() throws InterruptedException, ValidatorException {
//        log.info("Filter test35");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.GREATER_THAN_EQUAL, Expression.value(60l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
//        inputHandler.send(new Object[]{"WSO2", 60f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery36() throws InterruptedException, ValidatorException {
//        log.info("Filter test36");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("price"), Compare.Operator.GREATER_THAN_EQUAL, Expression.value(60l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
//        inputHandler.send(new Object[]{"WSO2", 50f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery37() throws InterruptedException, ValidatorException {
//        log.info("Filter test37");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("quantity"), Compare.Operator.GREATER_THAN_EQUAL, Expression.value(4l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 60, 2});
//        inputHandler.send(new Object[]{"WSO2", 50f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    @Test
//    public void testFilterQuery38() throws InterruptedException, ValidatorException {
//        log.info("Filter test38");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").filter(Expression.compare(Expression.variable("volume"), Compare.Operator.GREATER_THAN_EQUAL, Expression.value(40l))));
//        query.select(Selector.selector().select("symbol", Expression.variable("symbol")).select("price", Expression.variable("price")).select("quantity", Expression.variable("quantity")));
//        query.insertInto("outputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                count++;
//            }
//        });
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 500f, 50, 6});
//        inputHandler.send(new Object[]{"WSO2", 70f, 20, 2});
//        inputHandler.send(new Object[]{"WSO2", 50f, 300, 4});
//        Thread.sleep(100);
//        Assert.assertEquals(2, count);
//        siddhiManager.shutdown();
//
//    }
//
//    //***********************************************************************************************************************
//    //Expression-Add
//
//    @Test
//    public void testFilterQuery39() throws InterruptedException, ValidatorException {
//        log.info("Filter test39");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream"));
//        query.select(
//                Selector.selector().
//                        select("symbol", Expression.variable("symbol")).
//                        select("increasedPrice", Expression.add(Expression.value(100), Expression.variable("price"))).
//                        select("increasedVolume", Expression.add(Expression.value(50), Expression.variable("volume"))).
//                        select("increasedQuantity", Expression.add(Expression.value(4), Expression.variable("quantity")))
//
//        );
//        query.insertInto("OutputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                Assert.assertTrue("155.5".equals(inEvents[0].getData()[1].toString()));
//                Assert.assertTrue("150".equals(inEvents[0].getData()[2].toString()));
//                Assert.assertTrue("9".equals(inEvents[0].getData()[3].toString()));
//            }
//
//        });
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 55.5f, 100, 5});
//
//        Thread.sleep(100);
//
//        siddhiManager.shutdown();
//
//    }
//
//    //*******************************************************************************************************************
//    //Expression-Minus
//    @Test
//    public void testFilterQuery40() throws InterruptedException, ValidatorException {
//        log.info("Filter test40");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream"));
//        query.select(
//                Selector.selector().
//                        select("symbol", Expression.variable("symbol")).
//                        select("decreasedPrice", Expression.subtract(Expression.variable("price"), Expression.value(20))).
//                        select("decreasedVolume", Expression.subtract(Expression.variable("volume"), Expression.value(50))).
//                        select("decreasedQuantity", Expression.subtract(Expression.variable("quantity"), Expression.value(4)))
//
//        );
//        query.insertInto("OutputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                Assert.assertTrue("35.5".equals(inEvents[0].getData()[1].toString()));
//                Assert.assertTrue("50".equals(inEvents[0].getData()[2].toString()));
//                Assert.assertTrue("1".equals(inEvents[0].getData()[3].toString()));
//            }
//
//        });
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 55.5f, 100, 5});
//
//        Thread.sleep(100);
//
//        siddhiManager.shutdown();
//
//    }
//
//    //************************************************************************************************************************
//    //Expression Divide
//    @Test
//    public void testFilterQuery41() throws InterruptedException, ValidatorException {
//        log.info("Filter test41");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream"));
//        query.select(
//                Selector.selector().
//                        select("symbol", Expression.variable("symbol")).
//                        select("dividedPrice", Expression.divide(Expression.variable("price"), Expression.value(2))).
//                        select("dividedVolume", Expression.divide(Expression.variable("volume"), Expression.value(2)))
//
//        );
//        query.insertInto("OutputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                Assert.assertTrue("30.0".equals(inEvents[0].getData()[1].toString()));
//                Assert.assertTrue("50.0".equals(inEvents[0].getData()[2].toString()));
//
//            }
//
//        });
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 60f, 100d});
//
//        Thread.sleep(100);
//
//        siddhiManager.shutdown();
//    }
//
//    //*********************************************************************************************************************
//    //Expression Multiply
//    @Test
//    public void testFilterQuery42() throws InterruptedException, ValidatorException {
//        log.info("Filter test42");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream"));
//        query.select(
//                Selector.selector().
//                        select("symbol", Expression.variable("symbol")).
//                        select("multipliedQuantity", Expression.multiply(Expression.variable("quantity"), Expression.value(4)))
//
//        );
//        query.insertInto("OutputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                Assert.assertTrue("20".equals(inEvents[0].getData()[1].toString()));
//            }
//
//        });
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 55.5f, 100d, 5});
//
//        Thread.sleep(100);
//
//        siddhiManager.shutdown();
//
//    }
//
//    //******************************************************************************************************************
//    //Expression Mod
//
//    @Test
//    public void testFilterQuery43() throws InterruptedException, ValidatorException {
//        log.info("Filter test43");
//
//        SiddhiManager siddhiManager = new SiddhiManager();
//
//        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT).attribute("quantity", Attribute.Type.INT).attribute("awards", Attribute.Type.LONG);
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream"));
//        query.select(
//                Selector.selector().
//                        select("symbol", Expression.variable("symbol")).
//                        select("modPrice", Expression.mod(Expression.variable("price"), Expression.value(2))).
//                        select("modVolume", Expression.mod(Expression.variable("volume"), Expression.value(2))).
//                        select("modQuantity", Expression.mod(Expression.variable("quantity"), Expression.value(2))).
//                        select("modAwards", Expression.mod(Expression.variable("awards"), Expression.value(2)))
//
//        );
//        query.insertInto("OutputStream");
//
//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        for (StreamDefinition streamDef : streamDefinitionMap.values()) {
//            
//        }
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                Assert.assertTrue("1.5".equals(inEvents[0].getData()[1].toString()));
//                Assert.assertTrue("1".equals(inEvents[0].getData()[2].toString()));
//                Assert.assertTrue("1".equals(inEvents[0].getData()[3].toString()));
//                Assert.assertTrue("1".equals(inEvents[0].getData()[4].toString()));
//            }
//
//        });
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"WSO2", 55.5f, 101, 5, 7l});
//
//        Thread.sleep(100);
//
//        siddhiManager.shutdown();
//
//    }
//
//    //Contains onDeleteExpression
//
//    @Test
//    public void testFilterQuery44() throws InterruptedException, ValidatorException {
//        log.info("Filter test44");
//        SiddhiManager siddhiManager = new SiddhiManager();
//
//        StreamDefinition streamDefinition =  StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
//        siddhiManager.defineStream(streamDefinition);
//
//
//        Query query = new Query();         query.annotation(Annotation.annotation("info").element("name", "query1")); 
//        query.from(InputStream.stream("cseEventStream").
//                filter(Expression.compare(Expression.variable("symbol"),
//                        Compare.Operator.CONTAINS,
//                        Expression.value("IBM"))
//                )
//        );
//        query.select(
//                Selector.selector().
//                        select("volume", Expression.variable("volume"))
//        ) ;
//        query.insertInto("StockQuote");
//
//        streamDefinitionMap.put("cseEventStream",streamDefinition);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query,streamDefinitionMap);
//        for(StreamDefinition streamDef: streamDefinitionMap.values()){
//            
//
//        }
//
//        executionPlan.addQuery(query);          ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan); 
//
//        executionPlanRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timestamp, Event[] inEvents, Event[] removeEvents) {
//                Assert.assertEquals(60, inEvents[0].getData(0));
//                count++;
//            }
//
//        });
//
//
//        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
//        inputHandler.send(new Object[]{"IBM", 50.6f, 60});
//        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
//        Thread.sleep(1000);
//        Assert.assertEquals(1, count);
//        siddhiManager.shutdown();
//    }


}
