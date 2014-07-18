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
import org.wso2.siddhi.query.api.query.input.JoinInputStream;
import org.wso2.siddhi.query.api.query.output.stream.OutputStream;

public class JoinQueryTestCase {

    @Test
    public void testCreatingJoinQuery() {
        Query.query().
                property("name", "Query1").property("summery", "Test Query").
                from(
                        Query.joinInputStream(
                                Query.inputStream("s1", "cseEventStream").
                                        window("lengthBatch", Expression.value(50)),
                                JoinInputStream.Type.JOIN,
                                Query.inputStream("s2", "cseEventStream").
                                        filter(Condition.and(
                                                        Condition.compare(
                                                                Expression.add(Expression.value(7), Expression.value(9.5)),
                                                                Condition.Operator.GREATER_THAN,
                                                                Expression.variable("cseEventStream", "price")),
                                                        Condition.compare(Expression.value(100),
                                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                                Expression.variable("cseEventStream", "volume")
                                                        )
                                                )
                                        ).window("lengthBatch", Expression.value(50)),
                                Condition.compare(
                                        Expression.variable("s1", "price"),
                                        Condition.Operator.EQUAL,
                                        Expression.variable("s2", "price"))
                        )
                ).
                select(
                        Query.outputSelector().
                                select("symbol", Expression.variable("cseEventStream", "symbol")).
                                select(null, Expression.variable("cseEventStream", "symbol")).
                                groupBy("cseEventStream", "symbol").
                                having(
                                        Condition.compare(
                                                Expression.add(Expression.value(7), Expression.value(9.5)),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.variable(null, "price"))
                                )
                ).
                insertInto("StockQuote", OutputStream.OutputEventsFor.EXPIRED_EVENTS);

    }

    @Test
    public void testCreatingUnidirectionalJoinQuery() {
        Query.query().
                from(
                        Query.joinInputStream(
                                Query.inputStream("t", "TickEvent"),
                                JoinInputStream.Type.JOIN,
                                Query.inputStream("n", "NewsEvent").
                                        window("unique", Expression.variable("symbol")),
                                Condition.compare(
                                        Expression.variable("t", "symbol"),
                                        Condition.Operator.EQUAL,
                                        Expression.variable("n", "symbol")),
                                null,
                                JoinInputStream.EventTrigger.LEFT
                        )
                ).
                insertInto("JoinInputStream");
    }
}
