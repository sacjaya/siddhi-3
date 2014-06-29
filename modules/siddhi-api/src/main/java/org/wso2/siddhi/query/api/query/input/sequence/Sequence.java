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
package org.wso2.siddhi.query.api.query.input.sequence;

import org.wso2.siddhi.query.api.query.input.StandardInputStream;
import org.wso2.siddhi.query.api.query.input.sequence.element.NextElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.OrElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.RegexElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;
import org.wso2.siddhi.query.api.utils.SiddhiConstants;

public class Sequence {


    public static SequenceElement or(StandardInputStream standardStream1,
                                     StandardInputStream standardStream2) {
        return new OrElement(standardStream1, standardStream2);
    }

//    public static SequenceElement count(StandardInputStream singleStream, int min, int max) {
//        singleStream.setCounterStream(true);
//        return new RegexElement(singleStream, min, max);
//    }

    public static SequenceElement next(SequenceElement sequenceElement,
                                       SequenceElement nextSequenceElement) {
        return new NextElement(sequenceElement, nextSequenceElement);
    }

    public static SequenceElement zeroOrMany(StandardInputStream standardStream) {
        return new RegexElement(standardStream, 0, SiddhiConstants.UNLIMITED);
    }

    public static SequenceElement zeroOrOne(StandardInputStream standardStream) {
        return new RegexElement(standardStream, 0, 1);

    }

    public static SequenceElement oneOrMany(StandardInputStream standardStream) {
        return new RegexElement(standardStream, 1, SiddhiConstants.UNLIMITED);

    }
}
