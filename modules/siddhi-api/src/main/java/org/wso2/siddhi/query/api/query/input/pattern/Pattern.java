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

import org.wso2.siddhi.query.api.query.input.StandardInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.element.CountElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.FollowedByElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.LogicalElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;

public class Pattern {


    public static PatternInputStream every(PatternElement patternElement) {
        return new PatternInputStream(patternElement,null);
    }

    public static PatternElement logical(StandardInputStream standardStream1, LogicalElement.Type type,
                                         StandardInputStream standardStream2) {
        return new LogicalElement(standardStream1, type, standardStream2);
    }

    public static PatternElement followedBy(PatternElement patternElement,
                                            PatternElement followedByPatternElement) {
        return new FollowedByElement(patternElement, followedByPatternElement);
    }

    public static PatternElement count(StandardInputStream standardStream, int min, int max) {
        return new CountElement(standardStream, min, max);
    }
}
