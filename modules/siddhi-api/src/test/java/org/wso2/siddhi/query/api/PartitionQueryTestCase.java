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
import org.wso2.siddhi.query.api.partition.Partition;
import org.wso2.siddhi.query.api.query.Query;

public class PartitionQueryTestCase {

//    from StockStream[ 7+9.5>price AND 100>=volume]
//    insert into OutStockStream symbol, avg(price) as avgPrice
//    group by symbol
//    having avgPrice>50

    @Test
    public void testCreatingFilterQuery() {

        Partition partition = Partition.partition().
                with("StockStream", Expression.variable("symbol")).
                with("StockStream1", Expression.variable("symbol")).
                with("StockStream2",
                        Partition.range("LessValue",
                                Condition.compare(
                                        Expression.value(7),
                                        Condition.Operator.GREATER_THAN,
                                        Expression.variable("price"))
                        ),
                        Partition.range("HighValue",
                                Condition.compare(
                                        Expression.value(9.5),
                                        Condition.Operator.LESS_THAN,
                                        Expression.variable("price1"))
                        )
                );

        Query query = Query.query();
        query.from(
                Query.partitionedInputStream("StockStream").
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
                Query.outputSelector().
                        select("symbol", Expression.variable("symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("symbol"))).
                        groupBy("symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN_EQUAL,
                                Expression.value(50)
                        ))
        );
        query.insertInto("OutStockStream");

        partition.addQuery(query);

    }
}
