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
package org.wso2.siddhi.query.api.query.input.pattern;

import org.wso2.siddhi.query.api.expression.constant.TimeConstant;
import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.element.*;

public class Pattern {


    public static PatternInputStream every(PatternElement patternElement) {
        return new PatternInputStream(patternElement);
    }


    public static PatternInputStream every(PatternElement patternElement, TimeConstant time) {
        return new PatternInputStream(patternElement, time);
    }

    public static PatternElement logicalAnd(StreamElement streamElement1,
                                            StreamElement streamElement2) {
        return new LogicalElement(streamElement1, LogicalElement.Type.AND, streamElement2);
    }

    public static PatternElement logicalOr(StreamElement streamElement1,
                                           StreamElement streamElement2) {
        return new LogicalElement(streamElement1, LogicalElement.Type.OR, streamElement2);
    }

    public static PatternElement logicalAnd(StreamElement streamElement1,
                                            StreamElement streamElement2, TimeConstant time) {
        return new LogicalElement(streamElement1, LogicalElement.Type.AND, streamElement2, time);
    }

    public static PatternElement logicalOr(StreamElement streamElement1,
                                           StreamElement streamElement2, TimeConstant time) {
        return new LogicalElement(streamElement1, LogicalElement.Type.OR, streamElement2, time);
    }

    public static PatternElement logicalNot(StreamElement notStreamElement,
                                            TimeConstant time) {
        return new LogicalElement(null, LogicalElement.Type.NOT, notStreamElement, time);
    }

    public static PatternElement logicalNotAnd(StreamElement notStreamElement,
                                               StreamElement andStreamElement,
                                               TimeConstant time) {
        return new LogicalElement(andStreamElement, LogicalElement.Type.NOT, notStreamElement, time);
    }

    public static PatternElement logicalNotAnd(StreamElement notStreamElement,
                                               StreamElement andStreamElement) {
        return new LogicalElement(andStreamElement, LogicalElement.Type.NOT, notStreamElement);
    }

    public static PatternElement followedBy(PatternElement patternElement,
                                            PatternElement followedByPatternElement) {
        return new FollowedByElement(patternElement, followedByPatternElement);
    }

    public static PatternElement followedBy(PatternElement patternElement,
                                            PatternElement followedByPatternElement, TimeConstant time) {
        return new FollowedByElement(patternElement, followedByPatternElement, time);
    }

    public static PatternElement count(StreamElement streamElement, int min, int max) {
        return new CountElement(streamElement, min, max);
    }

    public static PatternElement countMoreThanEqual(StreamElement streamElement, int min) {
        return new CountElement(streamElement, min, CountElement.ANY);
    }

    public static PatternElement countLessThanEqual(StreamElement streamElement, int max) {
        return new CountElement(streamElement, CountElement.ANY, max);
    }

    public static PatternElement count(StreamElement streamElement, int min, int max, TimeConstant time) {
        return new CountElement(streamElement, min, max, time);
    }

    public static PatternElement countMoreThanEqual(StreamElement streamElement, int min, TimeConstant time) {
        return new CountElement(streamElement, min, CountElement.ANY, time);
    }

    public static PatternElement countLessThanEqual(StreamElement streamElement, int max, TimeConstant time) {
        return new CountElement(streamElement, CountElement.ANY, max, time);
    }

    public static StreamElement stream(BasicSingleInputStream basicSingleInputStream) {
        return new StreamElement(basicSingleInputStream);
    }

    public static StreamElement stream(BasicSingleInputStream basicSingleInputStream,TimeConstant time) {
        return new StreamElement(basicSingleInputStream, time);
    }
}
