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
import org.wso2.siddhi.query.api.query.input.sequence.Sequence;

public class SequenceQueryTestCase {

//    from e1=Stream1[price >= 20] , e2=Stream2[ price >= e1.price]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream
//    group by e1.symbol
//    having avgPrice>50;

    @Test
    public void testCreatingFilterPatternQuery() {
        Query query = Query.query();
        query.from(
                Query.sequenceInputStream(
                        Sequence.next(Query.inputStream("e1", "Stream1"),
                                Query.inputStream("e2", "Stream1")),
                        Expression.value(2000)
                ));
        query.insertInto("OutputStream");
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2",0, "price"))).
                        groupBy("e1", "symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                                 Condition.Operator.GREATER_THAN,
                                                 Expression.value(50)))


        );

    }
}