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

import org.wso2.siddhi.query.api.condition.Condition;
//import org.wso2.siddhi.query.api.definition.partition.PartitionDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.definition.TableDefinition;
import org.wso2.siddhi.query.api.expression.constant.Constant;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.*;
import org.wso2.siddhi.query.api.query.input.StandardInputStream;
import org.wso2.siddhi.query.api.query.input.SingleInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.PatternInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;
import org.wso2.siddhi.query.api.query.input.sequence.SequenceInputStream;
import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;
import org.wso2.siddhi.query.api.query.selection.Selector;

public abstract class QueryFactory {

    public static Query query() {
        return new Query();
    }

    public static StreamDefinition streamDefinition() {
        return new StreamDefinition();
    }

    public static StandardInputStream inputStream(String streamId) {
        return new StandardInputStream(streamId, streamId);
    }

    public static StandardInputStream inputStream(String streamReferenceId, String streamId) {
        return new StandardInputStream(streamReferenceId, streamId);
    }

    public static Selector outputSelector() {
        return new Selector();
    }

    public static InputStream joinInputStream(SingleInputStream leftStream, JoinInputStream.Type type,
                                         SingleInputStream rightStream,
                                         Condition onCompare,
                                         Constant within) {
        return new JoinInputStream(leftStream, type, rightStream, onCompare, within, JoinInputStream.EventTrigger.ALL);
    }

    public static InputStream joinInputStream(SingleInputStream leftStream, JoinInputStream.Type type,
                                         SingleInputStream rightStream,
                                         Condition onCompare, Constant within,
                                         JoinInputStream.EventTrigger trigger) {
        return new JoinInputStream(leftStream, type, rightStream, onCompare, within, trigger);
    }

    public static InputStream joinInputStream(SingleInputStream leftStream, JoinInputStream.Type type,
                                         SingleInputStream rightStream, Constant within) {
        return new JoinInputStream(leftStream, type, rightStream, null, within, JoinInputStream.EventTrigger.ALL);
    }

    public static InputStream joinInputStream(SingleInputStream leftStream, JoinInputStream.Type type,
                                         SingleInputStream rightStream, Condition onCompare) {
        return new JoinInputStream(leftStream, type, rightStream, onCompare, null, JoinInputStream.EventTrigger.ALL);
    }

    public static InputStream joinInputStream(SingleInputStream leftStream, JoinInputStream.Type type,
                                         SingleInputStream rightStream) {
        return new JoinInputStream(leftStream, type, rightStream, null, null, JoinInputStream.EventTrigger.ALL);
    }

    public static PatternInputStream patternInputStream(PatternElement patternElement) {
        return new PatternInputStream(patternElement, null);
    }

    public static PatternInputStream patternInputStream(PatternElement patternElement, Constant within) {
        return new PatternInputStream(patternElement, within);
    }

    public static SequenceInputStream patternInputStream(SequenceElement sequenceElement) {
        return new SequenceInputStream(sequenceElement, null);
    }

    public static SequenceInputStream sequenceInputStream(SequenceElement sequenceElement, Constant within) {
        return new SequenceInputStream(sequenceElement, within);
    }

    public static TableDefinition tableDefinition() {
        return new TableDefinition();
    }

//    public static PartitionDefinition partition() {
//        return new PartitionDefinition();
//    }
}
