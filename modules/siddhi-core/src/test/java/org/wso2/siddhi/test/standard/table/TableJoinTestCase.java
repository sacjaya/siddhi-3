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
package org.wso2.siddhi.test.standard.table;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.EventPrinter;

public class TableJoinTestCase {
    static final Logger log = Logger.getLogger(org.wso2.siddhi.test.standard.table.TableJoinTestCase.class);
    private int eventCount;
    private boolean eventArrived;

    @Before
    public void init() {
        eventCount = 0;
        eventArrived = false;
    }

    @Test
    public void testTableJoinQuery1() throws InterruptedException {
        log.info("Table Join test1");

        SiddhiManager siddhiManager = new SiddhiManager();


        siddhiManager.defineStream("define stream cseEventStream (symbol string, price float, volume long) ");
        siddhiManager.defineStream("define stream cseEventCheckStream (symbol string) ");
        siddhiManager.defineTable("define table cseEventTable (symbol string, price float, volume long) ");

        siddhiManager.addQuery("from cseEventStream " +
                               "insert into cseEventTable;");

        String queryReference = siddhiManager.addQuery("from cseEventCheckStream#window.length(1) join cseEventTable " +
                                                       "select cseEventCheckStream.symbol as checkSymbol, cseEventTable.symbol as symbol, cseEventTable.volume as volume " +
                                                       "insert into joinOutputStream;");

        siddhiManager.addCallback(queryReference, new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                eventArrived = true;
                if(inEvents!=null){
                    eventCount+=inEvents.length;
                }
            }

        });
        InputHandler cseEventStreamHandler = siddhiManager.getInputHandler("cseEventStream");
        InputHandler twitterStreamHandler = siddhiManager.getInputHandler("cseEventCheckStream");
        cseEventStreamHandler.send(new Object[]{"WSO2", 55.6f, 100});
        cseEventStreamHandler.send(new Object[]{"IBM", 75.6f, 100});
        twitterStreamHandler.send(new Object[]{"WSO2"});
        Thread.sleep(500);

        Assert.assertEquals("Number of success events", 2, eventCount);
        Assert.assertEquals("Event arrived", true, eventArrived);
        siddhiManager.shutdown();
    }

    @Test
    public void testTableJoinQuery2() throws InterruptedException {
        log.info("Table Join test2");

        SiddhiManager siddhiManager = new SiddhiManager();


        siddhiManager.defineStream("define stream cseEventStream (symbol string, price float, volume long) ");
        siddhiManager.defineStream("define stream cseEventCheckStream (symbol string) ");
        siddhiManager.defineTable("define table cseEventTable (symbol string, price float, volume long) ");

        siddhiManager.addQuery("from cseEventStream " +
                               "insert into cseEventTable;");

        String queryReference = siddhiManager.addQuery("from cseEventCheckStream#window.length(1) join cseEventTable " +
                                                       "on cseEventTable.symbol==cseEventCheckStream.symbol " +
                                                       "select cseEventCheckStream.symbol as checkSymbol, cseEventTable.symbol as symbol, cseEventTable.volume as volume " +
                                                       "insert into joinOutputStream;");

        siddhiManager.addCallback(queryReference, new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                eventArrived = true;
                eventCount++;
            }

        });
        InputHandler cseEventStreamHandler = siddhiManager.getInputHandler("cseEventStream");
        InputHandler twitterStreamHandler = siddhiManager.getInputHandler("cseEventCheckStream");
        cseEventStreamHandler.send(new Object[]{"WSO2", 55.6f, 100});
        cseEventStreamHandler.send(new Object[]{"IBM", 75.6f, 100});
        twitterStreamHandler.send(new Object[]{"WSO2"});
        Thread.sleep(500);

        Assert.assertEquals("Number of success events", 1, eventCount);
        Assert.assertEquals("Event arrived", true, eventArrived);
        siddhiManager.shutdown();
    }

    @Test
    public void testTableJoinQuery3() throws InterruptedException {
        log.info("Table Join test3");

        SiddhiManager siddhiManager = new SiddhiManager();


        siddhiManager.defineStream("define stream cseEventStream (symbol string, price float, volume long) ");
        siddhiManager.defineStream("define stream cseEventCheckStream (symbol string) ");
        siddhiManager.defineTable("define table cseEventTable (symbol string, price float, volume long) ");

        siddhiManager.addQuery("from cseEventStream " +
                               "insert into cseEventTable;");

        String queryReference = siddhiManager.addQuery("from cseEventCheckStream#window.length(1) as checkStream join cseEventTable  " +
                                                       "on checkStream.symbol != cseEventTable.symbol " +
                                                       "select cseEventCheckStream.symbol as checkSymbol, cseEventTable.symbol as symbol, cseEventTable.volume as volume " +
                                                       "insert into joinOutputStream;");

        siddhiManager.addCallback(queryReference, new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                eventArrived = true;
                eventCount++;
            }

        });
        InputHandler cseEventStreamHandler = siddhiManager.getInputHandler("cseEventStream");
        InputHandler twitterStreamHandler = siddhiManager.getInputHandler("cseEventCheckStream");
        cseEventStreamHandler.send(new Object[]{"WSO2", 55.6f, 100});
        cseEventStreamHandler.send(new Object[]{"IBM", 75.6f, 100});
        twitterStreamHandler.send(new Object[]{"WSO2"});
        Thread.sleep(500);

        Assert.assertEquals("Number of success events", 1, eventCount);
        Assert.assertEquals("Event arrived", true, eventArrived);
        siddhiManager.shutdown();
    }

    @Test
    public void testTableJoinQuery4() throws InterruptedException {
        log.info("Table Join test4");

        SiddhiManager siddhiManager = new SiddhiManager();


        siddhiManager.defineStream("define stream cseEventStream (symbol string, price float, volume long) ");
        siddhiManager.defineStream("define stream cseEventCheckStream (symbol string) ");
        siddhiManager.defineTable("define table cseEventTable (symbol string, price float, volume long) ");

        siddhiManager.addQuery("from cseEventStream " +
                               "insert into cseEventTable;");

        String queryReference = siddhiManager.addQuery("from cseEventCheckStream#window.time(1000) as checkStream join cseEventTable  " +
                                                       "on checkStream.symbol != cseEventTable.symbol " +
                                                       "select cseEventCheckStream.symbol as checkSymbol, cseEventTable.symbol as symbol, cseEventTable.volume as volume " +
                                                       "insert into joinOutputStream for all-events;");

        siddhiManager.addCallback(queryReference, new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents, Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                eventArrived = true;
                eventCount++;
            }

        });
        InputHandler cseEventStreamHandler = siddhiManager.getInputHandler("cseEventStream");
        InputHandler twitterStreamHandler = siddhiManager.getInputHandler("cseEventCheckStream");
        cseEventStreamHandler.send(new Object[]{"WSO2", 55.6f, 100});
        cseEventStreamHandler.send(new Object[]{"IBM", 75.6f, 100});
        twitterStreamHandler.send(new Object[]{"WSO2"});
        Thread.sleep(3000);

        Assert.assertEquals("Number of success events", 2, eventCount);
        Assert.assertEquals("Event arrived", true, eventArrived);
        siddhiManager.shutdown();
    }

}
