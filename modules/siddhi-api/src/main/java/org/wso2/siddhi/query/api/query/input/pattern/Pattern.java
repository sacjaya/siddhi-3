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
import org.wso2.siddhi.query.api.query.input.pattern.element.CountElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.FollowedByElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.LogicalElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;

public class Pattern {


    public static PatternInputStream every(PatternElement patternElement) {
        return new PatternInputStream(patternElement);
    }


    public static PatternInputStream every(PatternElement patternElement, TimeConstant time) {
        return new PatternInputStream(patternElement, time);
    }

    public static PatternElement logicalAnd(BasicSingleInputStream standardStream1,
                                            BasicSingleInputStream standardStream2) {
        return new LogicalElement(standardStream1, LogicalElement.Type.AND, standardStream2);
    }

    public static PatternElement logicalOr(BasicSingleInputStream standardStream1,
                                           BasicSingleInputStream standardStream2) {
        return new LogicalElement(standardStream1, LogicalElement.Type.OR, standardStream2);
    }

    public static PatternElement logicalAnd(BasicSingleInputStream standardStream1,
                                            BasicSingleInputStream standardStream2, TimeConstant time) {
        return new LogicalElement(standardStream1, LogicalElement.Type.AND, standardStream2, time);
    }

    public static PatternElement logicalOr(BasicSingleInputStream standardStream1,
                                           BasicSingleInputStream standardStream2, TimeConstant time) {
        return new LogicalElement(standardStream1, LogicalElement.Type.OR, standardStream2, time);
    }

    public static PatternElement logicalNot(BasicSingleInputStream notStandardStream,
                                            TimeConstant time) {
        return new LogicalElement(null, LogicalElement.Type.NOT, notStandardStream, time);
    }

    public static PatternElement logicalNotAnd(BasicSingleInputStream notStandardStream,
                                               BasicSingleInputStream andStandardStream,
                                               TimeConstant time) {
        return new LogicalElement(andStandardStream, LogicalElement.Type.NOT, notStandardStream, time);
    }

    public static PatternElement logicalNotAnd(BasicSingleInputStream notStandardStream,
                                               BasicSingleInputStream andStandardStream) {
        return new LogicalElement(andStandardStream, LogicalElement.Type.NOT, notStandardStream);
    }

    public static PatternElement followedBy(PatternElement patternElement,
                                            PatternElement followedByPatternElement) {
        return new FollowedByElement(patternElement, followedByPatternElement);
    }

    public static PatternElement followedBy(PatternElement patternElement,
                                            PatternElement followedByPatternElement, TimeConstant time) {
        return new FollowedByElement(patternElement, followedByPatternElement, time);
    }

    public static PatternElement count(BasicSingleInputStream standardStream, int min, int max) {
        return new CountElement(standardStream, min, max);
    }

    public static PatternElement countMoreThanEqual(BasicSingleInputStream standardStream, int min) {
        return new CountElement(standardStream, min, CountElement.ANY);
    }

    public static PatternElement countLessThanEqual(BasicSingleInputStream standardStream, int max) {
        return new CountElement(standardStream, CountElement.ANY, max);
    }

    public static PatternElement count(BasicSingleInputStream standardStream, int min, int max, TimeConstant time) {
        return new CountElement(standardStream, min, max, time);
    }

    public static PatternElement countMoreThanEqual(BasicSingleInputStream standardStream, int min, TimeConstant time) {
        return new CountElement(standardStream, min, CountElement.ANY, time);
    }

    public static PatternElement countLessThanEqual(BasicSingleInputStream standardStream, int max, TimeConstant time) {
        return new CountElement(standardStream, CountElement.ANY, max, time);
    }
}
