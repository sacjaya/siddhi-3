/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.query.api;


import org.junit.Test;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.Query;

public class PassThroughQueryTestCase {

//    from StockStream
//    insert into OutStockStream symbol, avg(price) as avgPrice
//    group by symbol
//    having avgPrice>50

    @Test
    public void testQuery1() {
        Query query = QueryFactory.query();
        query.from(QueryFactory.inputStream("StockStream"));
        query.insertInto("OutStockStream");

    }

    @Test
    public void testQueryWithName() {
        Query query = QueryFactory.query();
        query.name("TestQuery").summery("Query for Test");
        query.from(QueryFactory.inputStream("StockStream"));
        query.insertInto("OutStockStream");
    }


    @Test
    public void testQuery2() {
        Query query = QueryFactory.query();
        query.from(QueryFactory.inputStream("StockStream"));
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "avg", Expression.variable("symbol"))
        );
        query.insertInto("OutStockStream");

    } 
    
    @Test
    public void testQuery3() {
        Query query = QueryFactory.query();
        query.from(QueryFactory.inputStream("StockStream"));
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "avg", Expression.variable("symbol")).
                        groupBy("symbol")
        );
        query.insertInto("OutStockStream");

    } 
    
    @Test
    public void testQuery4() {
        Query query = QueryFactory.query();
        query.from(QueryFactory.inputStream("StockStream"));
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "avg", Expression.variable("symbol")).
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN_EQUAL,
                                Expression.value(50)
                        ))
        );
        query.insertInto("OutStockStream");

    }
    
    @Test
    public void testQuery5() {
        Query query = QueryFactory.query();
        query.from(QueryFactory.inputStream("StockStream"));
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "avg", Expression.variable("symbol")).
                        groupBy("symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN_EQUAL,
                                Expression.value(50)
                        ))
        );
        query.insertInto("OutStockStream");
    }


}
