package org.wso2.siddhi.test;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.ExecutionPlanRuntime;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.stream.output.StreamCallback;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.core.util.validate.StreamValidator;
import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.annotation.Annotation;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.execution.query.input.InputStream;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.condition.Compare;

import java.util.HashMap;
import java.util.Map;

public class PartitionTestCase {
    static final Logger log = Logger.getLogger(FilterTestCase.class);

    private int count;
    int stockStreamEventCount;
    private boolean eventArrived;
    Map<String, StreamDefinition> streamDefinitionMap = new HashMap<String, StreamDefinition>();

    @Before
    public void init() {
        count = 0;
        stockStreamEventCount = 0;
        eventArrived = false;
    }


    @Test
    public void testPartitionQuery() throws InterruptedException, ValidatorException {
        log.info("Partition test");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        StreamDefinition streamDefinition1 = StreamDefinition.id("cseEventStream1").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);
        executionPlan.defineStream(streamDefinition1);

        Partition partition = Partition.partition().
                with("cseEventStream1", Expression.variable("symbol"));

        Query query = Query.query().annotation(Annotation.annotation("info").element("name", "queryyy"));
        query.from(InputStream.stream("cseEventStream").
                filter(Expression.compare(Expression.value(700),
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
        query.insertInto("OutStockStream");


        streamDefinitionMap.put("cseEventStream", streamDefinition);
        streamDefinitionMap.put("cseEventStream1", streamDefinition1);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);


        partition.addQuery(query);


        executionPlan.addPartition(partition);

        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);


        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });

        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});
        Thread.sleep(5000);
        siddhiManager.shutdown();
        Assert.assertEquals(0, count);


    }


    @Test
    public void testPartitionQuery1() throws InterruptedException, ValidatorException {
        log.info("Partition test1");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);

        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol"));

        Query query = Query.query().annotation(Annotation.annotation("info").element("name", "queryyy"));
        query.from(InputStream.stream("cseEventStream").
                filter(Expression.compare(Expression.value(700),
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
        query.insertInto("OutStockStream");


        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);


        partition.addQuery(query);


        executionPlan.addPartition(partition);

        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);


        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });

        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});
        Thread.sleep(5000);
        siddhiManager.shutdown();
        Assert.assertEquals(4, count);


    }


    @Test
    public void testPartitionQuery2() throws InterruptedException, ValidatorException {
        log.info("Partition test2");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition);
        StreamDefinition streamDefinition2 = StreamDefinition.id("StockStream1").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        executionPlan.defineStream(streamDefinition2);

        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol")).
                with("StockStream1", Expression.variable("symbol"))
        ;

        Query query = Query.query();
        query.from(InputStream.stream("cseEventStream").
                filter(Expression.compare(Expression.value(700),
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
        query.insertInto("OutStockStream");



        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);


        partition.addQuery(query);


        executionPlan.addPartition(partition);

        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);


        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });
        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});
        Thread.sleep(1000);
        Assert.assertEquals(4, count);
        siddhiManager.shutdown();

    }



    @Test
    public void testPartitionQuery3() throws InterruptedException, ValidatorException {
        log.info("Partition test3");


        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);

        executionPlan.defineStream(streamDefinition);

        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol"));

        Query query = Query.query();
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query.insertIntoInner("StockStream");



        Query query1 = Query.query();
        query1.from(InputStream.innerStream("StockStream"));
        query1.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query1.insertInto("OutStockStream");



        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);
        QueryValidator.validate(query1, streamDefinitionMap);


        partition.addQuery(query);
        partition.addQuery(query1);

        executionPlan.addPartition(partition);


        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);



        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });
        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});
        Thread.sleep(8000);
        siddhiManager.shutdown();
        Assert.assertEquals(4, count);


    }

    @Test
    public void testPartitionQuery4() throws InterruptedException, ValidatorException {
        log.info("Partition test4");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        StreamDefinition streamDefinition1 = StreamDefinition.id("cseEventStream1").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);

        executionPlan.defineStream(streamDefinition);
        executionPlan.defineStream(streamDefinition1);


        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol"));

        Query query = Query.query();
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query.insertIntoInner("StockStream");



        Query query1 = Query.query();
        query1.from(InputStream.innerStream("StockStream"));
        query1.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query1.insertInto("OutStockStream");


       ////////////////////////////////////partition-2/////////////////


        Partition partition1 = Partition.partition().
                with("cseEventStream1", Expression.variable("symbol"));

        Query query2 = Query.query();
        query2.from(InputStream.stream("cseEventStream1"));
        query2.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query2.insertIntoInner("StockStream");



        Query query3 = Query.query();
        query3.from(InputStream.innerStream("StockStream"));
        query3.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query3.insertInto("OutStockStream");














        streamDefinitionMap.put("cseEventStream", streamDefinition);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);
        QueryValidator.validate(query1, streamDefinitionMap);


        partition.addQuery(query);
        partition.addQuery(query1);

        partition1.addQuery(query2);
        partition1.addQuery(query3);

        executionPlan.addPartition(partition);

        executionPlan.addPartition(partition1);

        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);



        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });


        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});

        InputHandler inputHandler2 = executionRuntime.getInputHandler("cseEventStream1");
        inputHandler2.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler2.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler2.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler2.send(new Object[]{"ORACLE", 75.6f, 100});

        Thread.sleep(50000);
        siddhiManager.shutdown();
        ////////;
        Assert.assertEquals(8, count);


    }

    @Test
    public void testPartitionQuery5() throws InterruptedException, ValidatorException {
        log.info("Partition test5");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        StreamDefinition streamDefinition1 = StreamDefinition.id("cseEventStream1").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        StreamDefinition streamDefinition2 = StreamDefinition.id("StockStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);


        executionPlan.defineStream(streamDefinition);
        executionPlan.defineStream(streamDefinition1);

        executionPlan.defineStream(streamDefinition2);


        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol"));

        Query query = Query.query();
        query.from(InputStream.stream("cseEventStream")).annotation(Annotation.annotation("info").element("name", "query"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query.insertIntoInner("StockStream");


//
        Query query1 = Query.query();
        query1.from(InputStream.innerStream("StockStream")).annotation(Annotation.annotation("info").element("name", "query1"));
        query1.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query1.insertInto("OutStockStream");

//
//        ////////////////////////////////////partition-2/////////////////


        Partition partition1 = Partition.partition().
                with("cseEventStream1", Expression.variable("symbol"));

        Query query2 = Query.query();
        query2.from(InputStream.stream("cseEventStream1")).annotation(Annotation.annotation("info").element("name",  "query2"));
        query2.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query2.insertIntoInner("StockStream");



        Query query3 = Query.query();
        query3.from(InputStream.innerStream("StockStream")).annotation(Annotation.annotation("info").element("name", "query3"));
        query3.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query3.insertInto("OutStockStream");




        Query query4 = Query.query();
        query4.from(InputStream.stream("StockStream")).annotation(Annotation.annotation("info").element("name", "query4"));
        query4.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query4.insertInto("OutStockStream");


        Query query5 = Query.query();
        query5.from(InputStream.innerStream("StockStream")).annotation(Annotation.annotation("info").element("name", "query5"));
        query5.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query5.insertInto("StockStream");







        streamDefinitionMap.put("cseEventStream", streamDefinition);
        streamDefinitionMap.put("cseEventStream1", streamDefinition1);
        streamDefinitionMap.put("StockStream", streamDefinition2);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);
        QueryValidator.validate(query1, streamDefinitionMap);
        QueryValidator.validate(query2, streamDefinitionMap);
        QueryValidator.validate(query3, streamDefinitionMap);
        QueryValidator.validate(query4, streamDefinitionMap);
        QueryValidator.validate(query5, streamDefinitionMap);



        partition.addQuery(query);
        partition.addQuery(query1);
        partition.addQuery(query5);

        partition1.addQuery(query2);
        partition1.addQuery(query3);

        executionPlan.addPartition(partition);

        executionPlan.addPartition(partition1);

        executionPlan.addQuery(query4);

        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);



        executionRuntime.addCallback("StockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                stockStreamEventCount++;

            }
        });



        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });


//        executionRuntime.addCallback("query5", new QueryCallback() {
//            @Override
//            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
//                System.out.println("5"+inEvents[0].getData()[0]);
//
//            }
//        });

//        executionRuntime.addCallback("query", new QueryCallback() {
//            @Override
//            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
//                System.out.println("query"+inEvents[0].getData()[0]);
//            }
//        });
//
//        executionRuntime.addCallback("query1", new QueryCallback() {
//            @Override
//            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
//                System.out.println("1"+inEvents[0].getData()[0]);
//            }
//        });
//
//        executionRuntime.addCallback("query2", new QueryCallback() {
//            @Override
//            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
//                System.out.println("2"+inEvents[0].getData()[0]);
//            }
//        });
//
//        executionRuntime.addCallback("query3", new QueryCallback() {
//            @Override
//            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
//                System.out.println("3"+inEvents[0].getData()[0]);
//            }
//        });

//        executionRuntime.addCallback("query4", new QueryCallback() {
//            @Override
//            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
//                System.out.println("4"+inEvents[0].getData()[0]);
//            }
//        });

        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});

        InputHandler inputHandler2 = executionRuntime.getInputHandler("cseEventStream1");
        inputHandler2.send(new Object[]{"IBM1", 75.6f, 100});
        inputHandler2.send(new Object[]{"WSO21", 75.6f, 100});
        inputHandler2.send(new Object[]{"IBM1", 75.6f, 100});
        inputHandler2.send(new Object[]{"ORACLE1", 75.6f, 100});


        InputHandler inputHandler3 = executionRuntime.getInputHandler("StockStream");
        inputHandler3.send(new Object[]{"ABC", 75.6f, 100});
        inputHandler3.send(new Object[]{"DEF", 75.6f, 100});
        inputHandler3.send(new Object[]{"KLM", 75.6f, 100});
        inputHandler3.send(new Object[]{"ABC", 75.6f, 100});

        Thread.sleep(20000);
        siddhiManager.shutdown();
        Assert.assertEquals(16, count);
        Assert.assertEquals(8, stockStreamEventCount);

    }



    @Test
    public void testPartitionQuery6() throws InterruptedException, ValidatorException {
        log.info("Partition test6");
        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        StreamDefinition streamDefinition1 = StreamDefinition.id("cseEventStream1").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);


        executionPlan.defineStream(streamDefinition);
        executionPlan.defineStream(streamDefinition1);



        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol")).with("cseEventStream1", Expression.variable("symbol"));

        Query query = Query.query();
        query.from(InputStream.stream("cseEventStream")).annotation(Annotation.annotation("info").element("name", "query"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query.insertIntoInner("StockStream");

        Query query1 = Query.query();
        query1.from(InputStream.innerStream("StockStream")).annotation(Annotation.annotation("info").element("name", "query1"));
        query1.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query1.insertInto("OutStockStream");

        Query query2 = Query.query();
        query2.from(InputStream.stream("cseEventStream1")).annotation(Annotation.annotation("info").element("name",  "query2"));
        query2.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query2.insertIntoInner("StockStream1");



        Query query3 = Query.query();
        query3.from(InputStream.innerStream("StockStream1")).annotation(Annotation.annotation("info").element("name", "query3"));
        query3.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query3.insertInto("OutStockStream");

        streamDefinitionMap.put("cseEventStream", streamDefinition);
        streamDefinitionMap.put("cseEventStream1", streamDefinition1);
        StreamValidator.validate(streamDefinitionMap, streamDefinition);
        QueryValidator.validate(query, streamDefinitionMap);
        QueryValidator.validate(query1, streamDefinitionMap);
        QueryValidator.validate(query2, streamDefinitionMap);
        QueryValidator.validate(query3, streamDefinitionMap);



        partition.addQuery(query);
        partition.addQuery(query1);
        partition.addQuery(query2);
        partition.addQuery(query3);

        executionPlan.addPartition(partition);


        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);




        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });


        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});

        InputHandler inputHandler2 = executionRuntime.getInputHandler("cseEventStream1");
        inputHandler2.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler2.send(new Object[]{"WSO21", 75.6f, 100});
        inputHandler2.send(new Object[]{"IBM1", 75.6f, 100});
        inputHandler2.send(new Object[]{"ORACLE1", 75.6f, 100});


        Thread.sleep(20000);
        siddhiManager.shutdown();
        Assert.assertEquals(8, count);

    }

    @Test
    public void testPartitionQuery7() throws InterruptedException, ValidatorException {
        log.info("Partition test3");


        SiddhiManager siddhiManager = new SiddhiManager();
        ExecutionPlan executionPlan = new ExecutionPlan("plan1");

        StreamDefinition streamDefinition = StreamDefinition.id("cseEventStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);
        StreamDefinition streamDefinition1 = StreamDefinition.id("StockStream").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.STRING).attribute("volume", Attribute.Type.INT);

        executionPlan.defineStream(streamDefinition);
        executionPlan.defineStream(streamDefinition1);

        Partition partition = Partition.partition().
                with("cseEventStream", Expression.variable("symbol")).with("StockStream", Expression.variable("symbol"));

        Query query = Query.query();
        query.from(InputStream.stream("cseEventStream"));
        query.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query.insertIntoInner("StockStream");



        Query query1 = Query.query();
        query1.from(InputStream.innerStream("StockStream"));
        query1.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        select("volume", Expression.variable("volume"))

        );
        query1.insertInto("OutStockStream");

        Query query2 = Query.query();
        query2.from(InputStream.stream("StockStream"));
        query2.select(
                Selector.selector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", Expression.value(12.5f)).
                        select("volume", Expression.variable("volume"))

        );
        query2.insertInto("OutStockStream");


//        streamDefinitionMap.put("cseEventStream", streamDefinition);
//        streamDefinitionMap.put("StockStream", streamDefinition1);
//        StreamValidator.validate(streamDefinitionMap, streamDefinition);
//        QueryValidator.validate(query, streamDefinitionMap);
//        QueryValidator.validate(query1, streamDefinitionMap);


        partition.addQuery(query);
        partition.addQuery(query1);
        partition.addQuery(query2);
        executionPlan.addPartition(partition);


        ExecutionPlanRuntime executionRuntime = siddhiManager.addExecutionPlan(executionPlan);



        executionRuntime.addCallback("OutStockStream", new StreamCallback() {
            @Override
            public void receive(Event[] events) {
                count++;
                eventArrived = true;
            }
        });
        InputHandler inputHandler = executionRuntime.getInputHandler("cseEventStream");
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"WSO2", 75.6f, 100});
        inputHandler.send(new Object[]{"IBM", 75.6f, 100});
        inputHandler.send(new Object[]{"ORACLE", 75.6f, 100});

        InputHandler inputHandler1 = executionRuntime.getInputHandler("StockStream");
        inputHandler1.send(new Object[]{"IBM", "75.6f", 100});
        inputHandler1.send(new Object[]{"WSO2", "75.6f", 100});
        inputHandler1.send(new Object[]{"IBM", "75.6f", 100});
        inputHandler1.send(new Object[]{"ORACLE", "75.6f", 100});

        Thread.sleep(8000);
        siddhiManager.shutdown();
        Assert.assertEquals(8, count);


    }




}
