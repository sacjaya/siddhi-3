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
import org.wso2.siddhi.core.event.state.MetaStateEvent;
import org.wso2.siddhi.core.event.stream.MetaStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventConverter;
import org.wso2.siddhi.core.executor.ConstantExpressionExecutor;
import org.wso2.siddhi.core.executor.ExpressionExecutor;
import org.wso2.siddhi.core.executor.VariableExpressionExecutor;
import org.wso2.siddhi.core.executor.condition.compare.greater_than.GreaterThanCompareConditionExpressionExecutorIntInt;
import org.wso2.siddhi.core.partition.PartitionRuntime;
import org.wso2.siddhi.core.partition.PartitionStreamReceiver;
import org.wso2.siddhi.core.partition.executor.PartitionExecutor;
import org.wso2.siddhi.core.partition.executor.ValuePartitionExecutor;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.query.output.rate_limit.OutputRateLimiter;
import org.wso2.siddhi.core.query.processor.filter.FilterProcessor;
import org.wso2.siddhi.core.query.selector.QueryPartitioner;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.stream.QueryStreamReceiver;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.runtime.SingleStreamRuntime;
import org.wso2.siddhi.core.stream.runtime.StreamRuntime;
import org.wso2.siddhi.core.util.parser.OutputParser;
import org.wso2.siddhi.core.util.parser.QueryParser;
import org.wso2.siddhi.core.util.parser.SelectorParser;
import org.wso2.siddhi.query.api.annotation.Annotation;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.condition.Compare;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QueryTestCase {
    static final Logger log = Logger.getLogger(QueryTestCase.class);
    private int count;
    private boolean eventArrived;

    @Before
    public void init() {
        count = 0;
        eventArrived = false;
    }


    @Test
    public void PassThroughTest() throws InterruptedException {
        log.info("pass through test");
        SiddhiContext siddhiContext = new SiddhiContext();

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));

        Query query = new Query();
        query.from(InputStream.stream("streamA"));
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price"))
        );
        query.insertInto("StockQuote");

        ExecutionPlanRuntime executionPlanRuntime = new ExecutionPlanRuntime(siddhiContext);
        executionPlanRuntime.defineStream(streamA);

        QueryRuntime queryRuntime = QueryParser.parse(query, siddhiContext, executionPlanRuntime.getStreamDefinitionMap());
        queryRuntime.setQueryId("query1");
        executionPlanRuntime.addQueryRuntime(queryRuntime);

        MetaStreamEvent metaStreamEvent = new MetaStreamEvent();
        metaStreamEvent.intializeOutputData();
        metaStreamEvent.addData(new Attribute("symbol", Attribute.Type.STRING));
        metaStreamEvent.addData(new Attribute("price", Attribute.Type.INT));
        metaStreamEvent.setDefinition(streamA);
        MetaStateEvent metaStateEvent = new MetaStateEvent(1);
        metaStateEvent.addEvent(metaStreamEvent);

        QueryStreamReceiver queryStreamReceiver = new QueryStreamReceiver(metaStreamEvent, streamA);
        queryStreamReceiver.setEventConverter(new StreamEventConverter(metaStreamEvent));
        List<VariableExpressionExecutor> variableExpressionExecutorList = new LinkedList<VariableExpressionExecutor>();

        Map<String, StreamDefinition> tempStreamDefinitionMap = new ConcurrentHashMap<String, StreamDefinition>();
        tempStreamDefinitionMap.put("streamA", streamA);
        QuerySelector querySelector = SelectorParser.parse(query.getSelector(), query.getOutputStream(), siddhiContext, metaStateEvent, variableExpressionExecutorList);
        OutputRateLimiter outputRateLimiter = queryRuntime.getOutputRateManager();
        querySelector.setNext(outputRateLimiter);
        StreamRuntime streamRuntime = new SingleStreamRuntime(queryStreamReceiver, querySelector);


        OutputCallback outputCallback = OutputParser.constructOutputCallback(query.getOutputStream(), executionPlanRuntime.getStreamJunctions(),
                new StreamDefinition("StockQuote").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT), siddhiContext);
        outputRateLimiter.setOutputCallback(outputCallback);

        executionPlanRuntime.getStreamJunctions().get(queryStreamReceiver.getStreamId()).subscribe(queryStreamReceiver);

        executionPlanRuntime.addCallback("query1", new QueryCallback(query, "query1", 2, siddhiContext) {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
                eventArrived = true;
            }

        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("streamA");
        inputHandler.send(new Object[]{"IBM", 100});
        inputHandler.send(new Object[]{"WSO2", 100});
        Assert.assertEquals(2, count);
        Assert.assertTrue(eventArrived);
    }

    @Test
    public void FilterTest() throws InterruptedException {
        log.info("filter test");
        SiddhiContext siddhiContext = new SiddhiContext();

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));

        Query query = new Query();
        query.from(InputStream.stream("streamA").
                filter(Expression.compare(Expression.value(70),
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

        ExecutionPlanRuntime executionPlanRuntime = new ExecutionPlanRuntime(siddhiContext);
        executionPlanRuntime.defineStream(streamA);

        QueryRuntime queryRuntime = QueryParser.parse(query, siddhiContext, executionPlanRuntime.getStreamDefinitionMap());
        queryRuntime.setQueryId("query1");

        executionPlanRuntime.addQueryRuntime(queryRuntime);

        MetaStreamEvent metaStreamEvent = new MetaStreamEvent();
        metaStreamEvent.intializeOutputData();
        metaStreamEvent.addData(new Attribute("symbol", Attribute.Type.STRING));
        metaStreamEvent.addData(new Attribute("price", Attribute.Type.INT));
        metaStreamEvent.setDefinition(streamA);
        MetaStateEvent metaStateEvent = new MetaStateEvent(1);
        metaStateEvent.addEvent(metaStreamEvent);

        Map<String, StreamDefinition> tempStreamDefinitionMap = new ConcurrentHashMap<String, StreamDefinition>();
        tempStreamDefinitionMap.put("streamA", streamA);

        ExpressionExecutor leftExpressionExecutor = new ConstantExpressionExecutor(70, Attribute.Type.INT);
        VariableExpressionExecutor rightExpressionExecutor = new VariableExpressionExecutor("price", streamA);

        rightExpressionExecutor.setPosition(new int[]{-1, -1, 2, 1});

        ExpressionExecutor conditionExecutor = new GreaterThanCompareConditionExpressionExecutorIntInt(leftExpressionExecutor, rightExpressionExecutor);
        FilterProcessor filterProcessor = new FilterProcessor(conditionExecutor);

        QueryStreamReceiver queryStreamReceiver = new QueryStreamReceiver(metaStreamEvent, streamA);
        queryStreamReceiver.setEventConverter(new StreamEventConverter(metaStreamEvent));
        List<VariableExpressionExecutor> variableExpressionExecutorList = new LinkedList<VariableExpressionExecutor>();
        QuerySelector querySelector = SelectorParser.parse(query.getSelector(), query.getOutputStream(), siddhiContext, metaStateEvent, variableExpressionExecutorList);

        OutputRateLimiter outputRateLimiter = queryRuntime.getOutputRateManager();

        filterProcessor.setNext(querySelector);
        querySelector.setNext(outputRateLimiter);

        StreamRuntime streamRuntime = new SingleStreamRuntime(queryStreamReceiver, filterProcessor);


        OutputCallback outputCallback = OutputParser.constructOutputCallback(query.getOutputStream(), executionPlanRuntime.getStreamJunctions(),
                new StreamDefinition("StockQuote").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT), siddhiContext);
        outputRateLimiter.setOutputCallback(outputCallback);

        executionPlanRuntime.getStreamJunctions().get(queryStreamReceiver.getStreamId()).subscribe(queryStreamReceiver);

        executionPlanRuntime.addCallback("query1", new QueryCallback(query, "query1", 2, siddhiContext) {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                Assert.assertTrue("IBM".equals(inEvents[0].getData(0)) || "WSO2".equals(inEvents[0].getData(0)));
                count++;
                eventArrived = true;
            }

        });
        InputHandler inputHandler = executionPlanRuntime.getInputHandler("streamA");
        inputHandler.send(new Object[]{"IBM", 10});
        inputHandler.send(new Object[]{"WSO2", 100});
        Assert.assertEquals(1, count);
        Assert.assertTrue(eventArrived);
    }

    @Test
    public void PartitionTest() throws InterruptedException {
        log.info("partition test");
        SiddhiContext siddhiContext = new SiddhiContext();

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));

        Partition partition = Partition.partition().
                with("streamA", Expression.variable("symbol"));


        Query query = new Query();
        query.from(InputStream.stream("streamA"));
        query.annotation(Annotation.annotation("info").element("name", "query1"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price"))
        );
        query.insertInto("StockQuote");

        ExecutionPlanRuntime executionPlanRuntime = new ExecutionPlanRuntime(siddhiContext);
        executionPlanRuntime.defineStream(streamA);


        PartitionRuntime partitionRuntime = new PartitionRuntime(executionPlanRuntime, partition, siddhiContext);

        QueryRuntime queryRuntime = QueryParser.parse(query, siddhiContext, executionPlanRuntime.getStreamDefinitionMap());
        queryRuntime.setQueryId("query1");

        executionPlanRuntime.addQueryRuntime(queryRuntime);

        MetaStreamEvent metaStreamEvent = new MetaStreamEvent();
        metaStreamEvent.intializeOutputData();
        metaStreamEvent.addData(new Attribute("symbol", Attribute.Type.STRING));
        metaStreamEvent.addData(new Attribute("price", Attribute.Type.INT));
        metaStreamEvent.setDefinition(streamA);


        QueryPartitioner queryPartitioner = new QueryPartitioner(query.getInputStream(), partition, metaStreamEvent, siddhiContext);
        List<PartitionExecutor> partitionExecutors = new ArrayList<PartitionExecutor>();

        VariableExpressionExecutor expressionExecutor = new VariableExpressionExecutor("symbol", streamA);
        expressionExecutor.setPosition(new int[]{-1, -1, 2, 0});

        partitionExecutors.add(new ValuePartitionExecutor(expressionExecutor));
        PartitionStreamReceiver partitionStreamReceiver = new PartitionStreamReceiver(siddhiContext, metaStreamEvent, streamA, partitionExecutors, partitionRuntime);
        partitionRuntime.addPartitionReceiver(partitionStreamReceiver);


        InputHandler inputHandler = executionPlanRuntime.getInputHandler("streamA");
        Assert.assertNull(partitionRuntime.getLocalStreamJunctionMap().get("streamAIBM"));
        inputHandler.send(new Object[]{"IBM", 100});
        StreamJunction streamJunctionIBM = partitionRuntime.getLocalStreamJunctionMap().get("streamAIBM");
        Assert.assertNotNull(streamJunctionIBM);
        inputHandler.send(new Object[]{"WSO2", 100});
        Assert.assertNotNull(partitionRuntime.getLocalStreamJunctionMap().get("streamAWSO2"));
        inputHandler.send(new Object[]{"IBM", 200});
        Assert.assertEquals(streamJunctionIBM, partitionRuntime.getLocalStreamJunctionMap().get("streamAIBM"));

    }

}
