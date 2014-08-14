/*
 * Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.event.inner.InnerStreamEvent;
import org.wso2.siddhi.core.event.inner.InnerStreamEventFactory;
import org.wso2.siddhi.core.event.inner.InnerStreamEventPool;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.core.stream.output.StreamCallback;
import org.wso2.siddhi.query.api.annotation.Annotation;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JunctionTestCase {
    static final Logger log = Logger.getLogger(JunctionTestCase.class);
    private int count;
    private boolean eventArrived;
    private ExecutorService executorService;

    @Before
    public void init() {
        count = 0;
        eventArrived = false;
        executorService = Executors.newCachedThreadPool();
    }


    @Test
    public void JunctionToReceiverTest() throws InterruptedException {
        log.info("junction to receiver");

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionA = new StreamJunction(streamA,executorService,1024);
        StreamJunction.Publisher streamPublisherA = streamJunctionA.constructPublisher();

        StreamCallback streamCallback = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                count++;
                eventArrived = true;

            }
        };

        streamJunctionA.subscribe(streamCallback);
        streamJunctionA.startProcessing();
        streamPublisherA.send(new InnerStreamEvent(2,2,2));
        streamPublisherA.send(new InnerStreamEvent(2,2,2));
        Thread.sleep(100);
        Assert.assertTrue(eventArrived);
        Assert.assertEquals(2,count);

    }

    @Test
    public void OneToOneTest() throws InterruptedException {
        log.info("one to one");

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionA = new StreamJunction(streamA,executorService,1024);
        StreamJunction.Publisher streamPublisherA = streamJunctionA.constructPublisher();

        StreamDefinition streamB = new StreamDefinition("streamB").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));;
        StreamJunction streamJunctionB = new StreamJunction(streamB,executorService,1024);
        final StreamJunction.Publisher streamPublisherB = streamJunctionB.constructPublisher();


        StreamCallback streamCallbackA = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                innerStreamEvent.setOutputData(streamEvents[0].getData());
                streamPublisherB.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackB = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
               count++;
               eventArrived = true;
               Assert.assertTrue(streamEvents[0].getData()[0].equals("IBM")||(streamEvents[0].getData()[0].equals("WSO2")));
            }
        };

        streamJunctionA.subscribe(streamCallbackA);
        streamJunctionA.startProcessing();

        streamJunctionB.subscribe(streamCallbackB);
        streamJunctionB.startProcessing();

        InnerStreamEvent innerStreamEvent1 = new InnerStreamEvent(2,2,2);
        innerStreamEvent1.setTimestamp(System.currentTimeMillis());
        innerStreamEvent1.setOutputData(new Object[]{"IBM", 12});

        InnerStreamEvent innerStreamEvent2 = new InnerStreamEvent(2,2,2);
        innerStreamEvent2.setTimestamp(System.currentTimeMillis());
        innerStreamEvent2.setOutputData(new Object[]{"WSO2", 112});

        streamPublisherA.send(innerStreamEvent1);
        streamPublisherA.send(innerStreamEvent2);
        Thread.sleep(100);
        Assert.assertTrue(eventArrived);
        Assert.assertEquals(2,count);

    }

    @Test
    public void MultiThreadedTest1() throws InterruptedException {
        log.info("multi threaded 1");

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionA = new StreamJunction(streamA,executorService,1024);
        StreamJunction.Publisher streamPublisherA = streamJunctionA.constructPublisher();

        StreamDefinition streamB = new StreamDefinition("streamB").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionB = new StreamJunction(streamB,executorService,1024);
        final StreamJunction.Publisher streamPublisherB_1 = streamJunctionB.constructPublisher();
        final StreamJunction.Publisher streamPublisherB_2 = streamJunctionB.constructPublisher();
        final StreamJunction.Publisher streamPublisherB_3 = streamJunctionB.constructPublisher();


        StreamCallback streamCallbackA_1 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                innerStreamEvent.setOutputData(streamEvents[0].getData());
                streamPublisherB_1.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackA_2 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                innerStreamEvent.setOutputData(streamEvents[0].getData());
                streamPublisherB_2.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackA_3 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                innerStreamEvent.setOutputData(streamEvents[0].getData());
                streamPublisherB_3.send(innerStreamEvent);
            }
        };


        StreamCallback streamCallbackB = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                count++;
                eventArrived = true;
                Assert.assertTrue(streamEvents[0].getData()[0].equals("IBM")||(streamEvents[0].getData()[0].equals("WSO2")));
            }
        };

        streamJunctionA.subscribe(streamCallbackA_1);
        streamJunctionA.subscribe(streamCallbackA_2);
        streamJunctionA.subscribe(streamCallbackA_3);
        streamJunctionA.startProcessing();

        streamJunctionB.subscribe(streamCallbackB);
        streamJunctionB.startProcessing();

        InnerStreamEvent innerStreamEvent1 = new InnerStreamEvent(2,2,2);
        innerStreamEvent1.setTimestamp(System.currentTimeMillis());
        innerStreamEvent1.setOutputData(new Object[]{"IBM", 12});

        InnerStreamEvent innerStreamEvent2 = new InnerStreamEvent(2,2,2);
        innerStreamEvent2.setTimestamp(System.currentTimeMillis());
        innerStreamEvent2.setOutputData(new Object[]{"WSO2", 112});

        streamPublisherA.send(innerStreamEvent1);
        streamPublisherA.send(innerStreamEvent2);
        Thread.sleep(100);
        Assert.assertTrue(eventArrived);
        Assert.assertEquals(6,count);

    }

    @Test
    public void MultiThreadedTest2() throws InterruptedException {
        log.info("multi threaded 2");

        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionA = new StreamJunction(streamA,executorService,1024);
        StreamJunction.Publisher streamPublisherA = streamJunctionA.constructPublisher();

        StreamDefinition streamB = new StreamDefinition("streamB").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionB = new StreamJunction(streamB,executorService,1024);
        final StreamJunction.Publisher streamPublisherB_1 = streamJunctionB.constructPublisher();
        final StreamJunction.Publisher streamPublisherB_2 = streamJunctionB.constructPublisher();
        final StreamJunction.Publisher streamPublisherB_3 = streamJunctionB.constructPublisher();

        StreamDefinition streamC = new StreamDefinition("streamC").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionC = new StreamJunction(streamC,executorService,1024);
        final StreamJunction.Publisher streamPublisherC_1 = streamJunctionC.constructPublisher();
        final StreamJunction.Publisher streamPublisherC_2 = streamJunctionC.constructPublisher();

        StreamCallback streamCallbackA_1 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
               Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("A1");
                innerStreamEvent.setOutputData(data);
                streamPublisherB_1.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackA_2 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
               Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("A2");
                innerStreamEvent.setOutputData(data);
                streamPublisherB_2.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackA_3 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
               Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("A3");
                innerStreamEvent.setOutputData(data);
                streamPublisherB_3.send(innerStreamEvent);
            }
        };


        StreamCallback streamCallbackB_1 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("B1");
                innerStreamEvent.setOutputData(data);
                streamPublisherC_1.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackB_2 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = new InnerStreamEvent(2,2,2);
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
               Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("B2");
                innerStreamEvent.setOutputData(data);
                streamPublisherC_2.send(innerStreamEvent);
            }
        };


        StreamCallback streamCallbackC = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                count++;
                eventArrived = true;
                Assert.assertTrue(((String)streamEvents[0].getData()[0]).matches("(WSO2|IBM)(A)(1|2|3)(B)(1|2)"));
            }
        };

        streamJunctionA.subscribe(streamCallbackA_1);
        streamJunctionA.subscribe(streamCallbackA_2);
        streamJunctionA.subscribe(streamCallbackA_3);
        streamJunctionA.startProcessing();

        streamJunctionB.subscribe(streamCallbackB_1);
        streamJunctionB.subscribe(streamCallbackB_2);
        streamJunctionB.startProcessing();

        streamJunctionC.subscribe(streamCallbackC);
        streamJunctionB.startProcessing();

        InnerStreamEvent innerStreamEvent1 = new InnerStreamEvent(2,2,2);
        innerStreamEvent1.setTimestamp(System.currentTimeMillis());
        innerStreamEvent1.setOutputData(new Object[]{"IBM", 12});

        InnerStreamEvent innerStreamEvent2 = new InnerStreamEvent(2,2,2);
        innerStreamEvent2.setTimestamp(System.currentTimeMillis());
        innerStreamEvent2.setOutputData(new Object[]{"WSO2", 112});

        streamPublisherA.send(innerStreamEvent1);
        streamPublisherA.send(innerStreamEvent2);
        Thread.sleep(100);
        Assert.assertTrue(eventArrived);
        Assert.assertEquals(12,count);

    }


    @Test
    public void MultiThreadedWithEventPoolTest() throws InterruptedException {
        log.info("multi threaded test using event pool");

        InnerStreamEventFactory eventFactory = new InnerStreamEventFactory(2, 2, 2);
        final InnerStreamEventPool innerStreamEventPool_A_1 = new InnerStreamEventPool(eventFactory, 4);
        final InnerStreamEventPool innerStreamEventPool_A_2 = new InnerStreamEventPool(eventFactory, 4);
        final InnerStreamEventPool innerStreamEventPool_A_3 = new InnerStreamEventPool(eventFactory, 4);
        final InnerStreamEventPool innerStreamEventPool_B_1 = new InnerStreamEventPool(eventFactory, 4);
        final InnerStreamEventPool innerStreamEventPool_B_2 = new InnerStreamEventPool(eventFactory, 4);


        StreamDefinition streamA = new StreamDefinition("streamA").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionA = new StreamJunction(streamA,executorService,1024);
        StreamJunction.Publisher streamPublisherA = streamJunctionA.constructPublisher();

        StreamDefinition streamB = new StreamDefinition("streamB").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionB = new StreamJunction(streamB,executorService,1024);
        final StreamJunction.Publisher streamPublisherB_1 = streamJunctionB.constructPublisher();
        final StreamJunction.Publisher streamPublisherB_2 = streamJunctionB.constructPublisher();
        final StreamJunction.Publisher streamPublisherB_3 = streamJunctionB.constructPublisher();

        StreamDefinition streamC = new StreamDefinition("streamC").attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.INT).
                annotation(Annotation.annotation("config").element("async", "true"));
        StreamJunction streamJunctionC = new StreamJunction(streamC,executorService,1024);
        final StreamJunction.Publisher streamPublisherC_1 = streamJunctionC.constructPublisher();
        final StreamJunction.Publisher streamPublisherC_2 = streamJunctionC.constructPublisher();

        StreamCallback streamCallbackA_1 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = innerStreamEventPool_A_1.borrowEvent();
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("A1");
                innerStreamEvent.setOutputData(data);
                streamPublisherB_1.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackA_2 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = innerStreamEventPool_A_2.borrowEvent();
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("A2");
                innerStreamEvent.setOutputData(data);
                streamPublisherB_2.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackA_3 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = innerStreamEventPool_A_3.borrowEvent();
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("A3");
                innerStreamEvent.setOutputData(data);
                streamPublisherB_3.send(innerStreamEvent);
            }
        };


        StreamCallback streamCallbackB_1 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = innerStreamEventPool_B_1.borrowEvent();
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("B1");
                innerStreamEvent.setOutputData(data);
                streamPublisherC_1.send(innerStreamEvent);
            }
        };

        StreamCallback streamCallbackB_2 = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                InnerStreamEvent innerStreamEvent = innerStreamEventPool_B_2.borrowEvent();
                innerStreamEvent.setTimestamp(streamEvents[0].getTimestamp());
                Object[] data = new Object[]{streamEvents[0].getData()[0],streamEvents[0].getData()[1]};
                data[0] = ((String)data[0]).concat("B2");
                innerStreamEvent.setOutputData(data);
                streamPublisherC_2.send(innerStreamEvent);
            }
        };


        StreamCallback streamCallbackC = new StreamCallback() {
            @Override
            public void receive(StreamEvent[] streamEvents) {
                count++;
                eventArrived = true;
                Assert.assertTrue(((String)streamEvents[0].getData()[0]).matches("(WSO2|IBM)(A)(1|2|3)(B)(1|2)"));
            }
        };

        streamJunctionA.subscribe(streamCallbackA_1);
        streamJunctionA.subscribe(streamCallbackA_2);
        streamJunctionA.subscribe(streamCallbackA_3);
        streamJunctionA.startProcessing();

        streamJunctionB.subscribe(streamCallbackB_1);
        streamJunctionB.subscribe(streamCallbackB_2);
        streamJunctionB.startProcessing();

        streamJunctionC.subscribe(streamCallbackC);
        streamJunctionB.startProcessing();

        InnerStreamEvent innerStreamEvent1 = new InnerStreamEvent(2,2,2);
        innerStreamEvent1.setTimestamp(System.currentTimeMillis());
        innerStreamEvent1.setOutputData(new Object[]{"IBM", 12});

        InnerStreamEvent innerStreamEvent2 = new InnerStreamEvent(2,2,2);
        innerStreamEvent2.setTimestamp(System.currentTimeMillis());
        innerStreamEvent2.setOutputData(new Object[]{"WSO2", 112});

        streamPublisherA.send(innerStreamEvent1);
        streamPublisherA.send(innerStreamEvent2);
        Thread.sleep(200);
        Assert.assertTrue(eventArrived);
        Assert.assertEquals(12,count);

    }
}
