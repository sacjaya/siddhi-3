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
import org.wso2.siddhi.query.api.expression.Time;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.pattern.Pattern;

public class PatternQueryTestCase {


//    from e1=Stream1[price >= 30] -> e2=Stream1[ price >= 20] -> e3=Stream2[ price >= e1.price]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    group by e1.symbol
//    having avgPrice>50;
//    insert into OutputStream


    @Test
    public void testPatternQuery1() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                        Condition.Operator.GREATER_THAN_EQUAL,
                                        Expression.value(30)))),
                                Pattern.followedBy(
                                        Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(20)))),
                                        Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("e1", "price"))))
                                )
                        )
                )

        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price"))).
                        groupBy("e1", "symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN,
                                Expression.value(50)))


        );
        query.insertInto("OutputStream");

    }


//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ price >= 20] -> e3=Stream2[ price >= e1.price]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    group by e1.symbol
//    having avgPrice>50;
//    insert into OutputStream

    @Test
    public void testPatternQuery2() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(20)))),
                                        Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("e1", "price"))))
                                )
                        )
                )

        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price"))).
                        groupBy("e1", "symbol").
                        having(Condition.compare(Expression.variable("avgPrice"),
                                Condition.Operator.GREATER_THAN,
                                Expression.value(50)))


        );
        query.insertInto("OutputStream");
    }

//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ price >= 20] -> every (e3=Stream2[ price >= e1.price]) -> e4=Stream3[price>74] -> e5= Stream4[symbol=='IBM']
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery3() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(20)))),
                                        Pattern.followedBy(
                                                Pattern.every(
                                                        Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                                Expression.variable("e1", "price"))))),
                                                Pattern.followedBy(
                                                        Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                                Condition.Operator.GREATER_THAN,
                                                                Expression.value(74)))),
                                                        Pattern.stream(Query.inputStream("e5", "Stream4").filter(Condition.compare(Expression.variable("symbol"),
                                                                Condition.Operator.EQUAL,
                                                                Expression.value("IBM"))))

                                                )
                                        )
                                )
                        )
                )

        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");


    }


//    from every (e1=Stream1[price >= 30] -> e2=Stream1[ price >= 20]) -> e3=Stream2[ price >= e1.price] -> e4=Stream3[price>74]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery4() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.followedBy(
                                                Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(30)))),
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))))),
                                Pattern.followedBy(
                                        Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.variable("e1", "price")))),

                                        Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.value(74)))))

                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");


    }


//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ price >= 20] and e3=Stream2[ price >= e1.price] -> e4=Stream3[price>74]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery5() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.logicalAnd(
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))),
                                                Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.variable("e1", "price")))))
                                        ,
                                        Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.value(74)))))

                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");


    }


//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ price >= 20] or e3=Stream2[ price >= e1.price] within 3 min -> e4=Stream3[price>74] within 2 min
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery6() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.logicalOr(
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))),
                                                Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.variable("e1", "price")))),
                                                Time.minute(3))
                                        ,
                                        Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.value(74)))))

                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");


    }


//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ prev.price >= 20]<3:5> -> e3=Stream2[ price >= e1.price] -> e4=Stream3[price>74]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery7() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.count(
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("prev", "price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))),
                                                3, 5),
                                        Pattern.followedBy(
                                                Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.variable("e1", "price")))),
                                                Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN,
                                                        Expression.value(74)))))
                                )
                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");

    }

//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ prev.price >= 20]<:5> -> e3=Stream2[ price >= e1.price] -> e4=Stream3[price>74]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery8() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.countLessThanEqual(
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("prev", "price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))),
                                                5),
                                        Pattern.followedBy(
                                                Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.variable("e1", "price")))),
                                                Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN,
                                                        Expression.value(74)))))
                                )
                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");

    }


//    from every (e1=Stream1[price >= 30]) -> e2=Stream1[ prev.price >= 20]<5:> within 3 min -> e3=Stream2[ price >= e1.price] -> e4=Stream3[price>74]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery9() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.countMoreThanEqual(
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("prev", "price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))),
                                                5, Time.minute(3)),
                                        Pattern.followedBy(
                                                Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.variable("e1", "price")))),
                                                Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN,
                                                        Expression.value(74)))))
                                )
                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");

    }


//    from every (e1=Stream1[price >= 30]) -> (e2=Stream1[ prev.price >= 20] -> e3=Stream2[ price >= e1.price]) within 4 min -> e4=Stream3[price>74]
//    select e1.symbol, avg(e2.price ) as avgPrice
//    insert into OutputStream

    @Test
    public void testPatternQuery10() {
        Query query = Query.query();
        query.from(
                Query.patternInputStream(
                        Pattern.followedBy(
                                Pattern.every(
                                        Pattern.stream(Query.inputStream("e1", "Stream1").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN_EQUAL,
                                                Expression.value(30))))),
                                Pattern.followedBy(
                                        Pattern.followedBy(
                                                Pattern.stream(Query.inputStream("e2", "Stream1").filter(Condition.compare(Expression.variable("prev", "price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.value(20)))),
                                                Pattern.stream(Query.inputStream("e3", "Stream2").filter(Condition.compare(Expression.variable("price"),
                                                        Condition.Operator.GREATER_THAN_EQUAL,
                                                        Expression.variable("e1", "price")))),
                                                Time.minute(4)),
                                        Pattern.stream(Query.inputStream("e4", "Stream3").filter(Condition.compare(Expression.variable("price"),
                                                Condition.Operator.GREATER_THAN,
                                                Expression.value(74))))
                                )
                        )
                )
        );
        query.select(
                Query.outputSelector().
                        select("symbol", Expression.variable("e1", "symbol")).
                        select("avgPrice", Expression.function("avg", Expression.variable("e2", "price")))

        );
        query.insertInto("OutputStream");

    }


}
