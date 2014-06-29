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
import org.wso2.siddhi.query.api.exception.AttributeAlreadyExistException;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.Query;

public class SimpleQueryTestCase {

//    from StockStream[ 7+9.5>price AND 100>=volume]
//    insert into OutStockStream symbol, avg(price) as avgPrice
//    group by symbol
//    having avgPrice>50

    @Test
    public void testCreatingFilterQuery() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(
                                Condition.and(
                                        Condition.compare(
                                                Expression.add(Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.compare(
                                                Expression.value(100),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("volume")
                                        )
                                )
                        )
        );
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

    @Test
    public void testQuery1() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(
                                Condition.and(
                                        Condition.compare(
                                                Expression.add(Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.compare(
                                                Expression.value(100),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("volume")
                                        )
                                )
                        ).window("length", Expression.value(50))
        );
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

    @Test
    public void testQuery2() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(Condition.and(
                                Condition.compare(
                                        Expression.add(Expression.value(7), Expression.value(9.5)),
                                        Condition.Operator.GREATER_THAN,
                                        Expression.variable("price")),
                                Condition.compare(
                                        Expression.value(100),
                                        Condition.Operator.GREATER_THAN_EQUAL,
                                        Expression.variable("volume")
                                )
                        )).
                        window("length", Expression.value(50)).
                        filter(
                                Condition.compare(
                                        Expression.variable("symbol"),
                                        Condition.Operator.EQUAL,
                                        Expression.value("WSO2")
                                )
                        )
        );
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

    @Test
    public void testQuery3() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(
                                Condition.and(
                                        Condition.compare(
                                                Expression.add(Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.compare(
                                                Expression.value(100),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("volume")
                                        )
                                )
                        ).
                        function("bar", Expression.value("price")).
                        window("length", Expression.value(50)).
                        function("foo", Expression.value(67), Expression.value(89)).
                        filter(
                                Condition.compare(
                                        Expression.value(10),
                                        Condition.Operator.LESS_THAN_EQUAL,
                                        Expression.variable("price")
                                )
                        )
        );
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

    @Test(expected = AttributeAlreadyExistException.class)
    public void testCreatingFilterQueryWithDuplicateOutputAttribute() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(Condition.and(Condition.compare(Expression.add(Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.compare(Expression.value(100),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("volume")
                                        )
                                )
                        ).window("lengthBatch", Expression.value(50))
        );
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("price", "avg", Expression.variable("symbol")).
                        select("price", Expression.variable("price")).
                        groupBy("symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN_EQUAL,
                                Expression.value(50)
                        ))
        );
        query.insertInto("OutStockStream");

    }

//    from (from StockStream[win.length(50)][ price >= 20]
//            return symbol, avg(price) as avgPrice
//    group by symbol) [symbol=="IBM"]
//    insert into IBMOutStockStream symbol, avgPrice

    @Test
    public void testCreatingNestedFilterQuery() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.query().
                        from(QueryFactory.inputStream("StockStream").
                                filter(
                                        Condition.compare(
                                                Expression.variable("StockStream", "price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(20))
                                )).
                        select(
                                QueryFactory.outputSelector().
                                        select("symbol", Expression.variable("symbol")).
                                        select("avgPrice", "avg", Expression.variable("symbol"))
                        ).
                        returnStream()
        );
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", Expression.variable("avgPrice"))
        );
        query.insertInto("IBMOutStockStream");

    }

//    from StockStream[win.lengthBatch(50)][price >= 20]
//    return symbol, avg(price) as avgPrice

    @Test
    public void testCreatingReturnFilterQuery() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(Condition.and(Condition.compare(Expression.add(Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.compare(Expression.value(100),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("volume")
                                        )
                                )
                        ).window("lengthBatch", Expression.value(50))
        );
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "avg", Expression.variable("symbol"))
        );
        query.returnStream();

    }


    @Test
    public void testCreatingReturnFilterQueryWithExtension() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(Condition.and(Condition.compare(Expression.extension("ext", "FooBarCond", Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.extension("ext", "BarCond", Expression.value(100),
                                                Expression.variable("volume")
                                        )
                                )
                        ).function("ext", "Foo", Expression.value(67), Expression.value(89)).window("ext", "lengthFirst10", Expression.value(50))
        );
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "ext", "avg", Expression.variable("symbol"))
        );
        query.returnStream();

    }

    @Test
    public void testCreatingReturnFilterQueryWithFunction() {
        Query query = QueryFactory.query();
        query.from(
                QueryFactory.inputStream("StockStream").
                        filter(Condition.and(Condition.compare(Expression.function("FooBarCond", Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable("price")),
                                        Condition.function("BarCond", Expression.value(100),
                                                Expression.variable("volume")
                                        )
                                )
                        ).function("ext", "Foo", Expression.value(67), Expression.value(89)).window("ext", "lengthFirst10", Expression.value(50))
        );
        query.select(
                QueryFactory.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", "ext", "avg", Expression.variable("symbol"))
        );
        query.returnStream();

    }


}
