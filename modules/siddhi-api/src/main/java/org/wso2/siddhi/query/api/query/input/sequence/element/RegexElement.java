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
package org.wso2.siddhi.query.api.query.input.sequence.element;

import org.wso2.siddhi.query.api.query.input.StandardInputStream;

public class RegexElement implements SequenceElement {

    private StandardInputStream standardStream;
    private int minCount = -1;
    private int maxCount = -1;

    public RegexElement(StandardInputStream standardStream, int minCount, int maxCount) {
        this.standardStream = standardStream;
//        standardStream.setCounterStream(true);
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    public int getMinCount() {
        return minCount;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public StandardInputStream getStandardStream() {
        return standardStream;
    }
}
