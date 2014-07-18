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
package org.wso2.siddhi.query.api.query;

import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.expression.constant.Constant;
import org.wso2.siddhi.query.api.expression.constant.TimeConstant;
import org.wso2.siddhi.query.api.query.input.*;
import org.wso2.siddhi.query.api.query.input.pattern.PatternInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;
import org.wso2.siddhi.query.api.query.input.sequence.SequenceInputStream;
import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;
import org.wso2.siddhi.query.api.query.output.OutputRate;
import org.wso2.siddhi.query.api.query.output.stream.*;
import org.wso2.siddhi.query.api.query.selection.Selector;

import java.util.HashMap;
import java.util.Map;

public class Query {

    private InputStream inputStream;
    private Selector selector = new Selector();
    private OutputStream outputStream;
    private OutputRate outputRate;
    private Map<String,String> properties = new HashMap();

    public static Query query() {
        return new Query();
    }

    public  Query property(String key, String value) {
       //todo handel
       properties.put(key,value);
       return this;
    }

    public  String getPropertyValue(String key) {
        //todo handel
        return properties.get(key);
    }

    public Query from(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }

    public Query select(Selector selector) {
        this.selector = selector;
        return this;
    }

    public Query outStream(OutputStream outputStream) {
        this.outputStream = outputStream;
        return this;
    }

    public Query insertInto(String outputStreamId, OutputStream.OutputEventsFor outputEventsFor) {
        this.outputStream = new InsertIntoStream(outputStreamId, outputEventsFor);
        return this;
    }

    public Query insertInto(String outputStreamId) {
        this.outputStream = new InsertIntoStream(outputStreamId);
        return this;
    }

    public Query insertIntoPartitioned(String outputStreamId, OutputStream.OutputEventsFor outputEventsFor) {
        this.outputStream = new InsertIntoPartitionedStream(outputStreamId, outputEventsFor);
        return this;
    }

    public Query insertIntoPartitioned(String outputStreamId) {
        this.outputStream = new InsertIntoPartitionedStream(outputStreamId);
        return this;
    }

    public SingleInputStream returnStream() {
        return new AnonymousInputStream(this);
    }

    public void deleteBy(String outputTableId, Condition deletingCondition) {
        this.outputStream = new DeleteStream(outputTableId, deletingCondition);
    }

    public void deleteBy(String outputTableId, OutputStream.OutputEventsFor outputEventsFor, Condition deletingCondition) {
        this.outputStream = new DeleteStream(outputTableId, outputEventsFor, deletingCondition);
    }

    public void updateBy(String outputTableId, Condition deletingCondition) {
        this.outputStream = new UpdateStream(outputTableId, deletingCondition);
    }

    public void updateBy(String outputTableId, OutputStream.OutputEventsFor outputEventsFor, Condition updatingCondition) {
        this.outputStream = new UpdateStream(outputTableId, outputEventsFor, updatingCondition);
    }

    public void output(OutputRate outputRate) {
        this.outputRate = outputRate;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public Selector getSelector() {
        return selector;
    }

    public OutputRate getOutputRate() {
        return outputRate;
    }

    public static BasicSingleInputStream inputStream(String streamId) {
        return new BasicSingleInputStream(streamId, streamId);
    }

    public static BasicSingleInputStream inputStream(String streamReferenceId, String streamId) {
        return new BasicSingleInputStream(streamReferenceId, streamId);
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
                                              SingleInputStream rightStream,
                                              Constant within,
                                              JoinInputStream.EventTrigger trigger) {
        return new JoinInputStream(leftStream, type, rightStream, null, within, trigger);
    }

    public static InputStream joinInputStream(SingleInputStream leftStream, JoinInputStream.Type type,
                                              SingleInputStream rightStream,
                                              Condition onCompare,
                                              JoinInputStream.EventTrigger trigger) {
        return new JoinInputStream(leftStream, type, rightStream, onCompare, null, trigger);
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

    public static PatternInputStream patternInputStream(PatternElement patternElement, TimeConstant within) {
        return new PatternInputStream(patternElement, within);
    }

    public static SequenceInputStream sequenceInputStream(SequenceElement sequenceElement) {
        return new SequenceInputStream(sequenceElement, null);
    }

    public static SequenceInputStream sequenceInputStream(SequenceElement sequenceElement, Constant within) {
        return new SequenceInputStream(sequenceElement, within);
    }
}
