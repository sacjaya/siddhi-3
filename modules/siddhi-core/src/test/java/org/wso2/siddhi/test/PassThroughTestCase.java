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

package org.wso2.siddhi.test;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.config.ExecutionPlanRuntime;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.output.StreamCallback;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.core.util.validate.StreamValidator;
import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.exception.CreateExecutionPlanException;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.Query;

import java.util.HashMap;
import java.util.Map;

public class PassThroughTestCase {
    static final Logger log = Logger.getLogger(PassThroughTestCase.class);
    private int count;
    private boolean eventArrived;
    Map<String, StreamDefinition> streamDefinitionMap = new HashMap<String, StreamDefinition>();

    @Before
    public void init() {
        count = 0;
        eventArrived = false;
    }


    @Test
    public void streamCallbackTest() throws InterruptedException, CreateExecutionPlanException {

        log.info("stream callback test");

        ExecutionPlan executionPlan = new ExecutionPlan("plan1");
        executionPlan.defineStream(StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT));

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("cseEventStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });


        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream") ;
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(100);
        Assert.assertTrue(eventArrived);
        Assert.assertEquals(2, count);


    }


    @Test
    public void testPassThroughQuery() throws InterruptedException, ValidatorException, CreateExecutionPlanException {
        log.info("Pass through query");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan =  new ExecutionPlan("plan1");

        StreamDefinition streamDefinition =  StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.from(Query.inputStream("cseEventStream"));
        query.property("name", "query1");
        query.select(
                query.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))
        ) ;
        query.insertInto("StockQuote");

        streamDefinitionMap.put("cseEventStream",streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query,streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime exRuntime = siddhiManager.addExecutionPlan(executionPlan);

        exRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
            }

        });


        exRuntime.addCallback("StockQuote", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;

            }
        });


        InputHandler inputHandler = exRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(1000);
        Assert.assertEquals(4, count);
        siddhiManager.shutdown();


    }


    @Test
    public void testPassThroughQuery2() throws InterruptedException, ValidatorException, CreateExecutionPlanException {
        log.info("Pass through query 2");

        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan =  new ExecutionPlan("plan1");

        StreamDefinition streamDefinition =  StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Query query = new Query();
        query.property("name","query1");
        query.from(Query.inputStream("cseEventStream"));
        query.select(
                query.outputSelector().
                        select("volume", Expression.variable("volume"))
        ) ;
        query.insertInto("StockQuote");


        streamDefinitionMap.put("cseEventStream",streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query,streamDefinitionMap);

        executionPlan.addQuery(query);

        ExecutionPlanRuntime executionPlanRuntime = siddhiManager.addExecutionPlan(executionPlan);

        executionPlanRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertEquals(100, inEvents[0].getData(0));
                count++;
            }

        });


        executionPlanRuntime.addCallback("StockQuote", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;

            }
        });


        InputHandler inputHandler = executionPlanRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        Thread.sleep(1000);
        Assert.assertEquals(4, count);
        siddhiManager.shutdown();



    }

}
