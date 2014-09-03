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

package org.wso2.siddhi.core.query;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.ExecutionPlanRuntime;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.EventPrinter;
import org.wso2.siddhi.core.util.parser.ExecutionPlanParser;
import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.annotation.Annotation;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.condition.Compare;

public class FilterTestCase {
    static final Logger log = Logger.getLogger(FilterTestCase.class);
    private int count;
    private boolean eventArrived;

    @Before
    public void init() {
        count = 0;
        eventArrived = false;
    }



    @Test
    public void FilterTest() throws InterruptedException {
        log.info("filter test");
        SiddhiContext siddhiContext = new SiddhiContext();

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));

        Query query = new Query();
        query.from(InputStream.stream("streamA"). filter(Expression.compare(Expression.value(70),
                Compare.Operator.GREATER_THAN,
                Expression.variable("price"))
        ));
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price"))
        );
        query.insertInto("StockQuote");


        ExecutionPlan executionPlan = new ExecutionPlan("ep1");
        executionPlan.defineStream(streamA);
        executionPlan.addQuery(query);
        ExecutionPlanRuntime executionPlanRuntime = ExecutionPlanParser.parse(executionPlan);


        executionPlanRuntime.addCallback("query1", new QueryCallback(query, "query1", 2, siddhiContext) {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
                eventArrived = true;
            }

        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("streamA");
        inputHandler.send(new Object[]{"IBM", 700});
        inputHandler.send(new Object[]{"WSO2", 60});
        Assert.assertEquals(1, count);
        Assert.assertTrue(eventArrived);
    }


}
