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

import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.query.input.AnonymousInputStream;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.input.SingleInputStream;
import org.wso2.siddhi.query.api.query.output.OutputRate;
import org.wso2.siddhi.query.api.query.output.stream.DeleteStream;
import org.wso2.siddhi.query.api.query.output.stream.InsertIntoStream;
import org.wso2.siddhi.query.api.query.output.stream.OutputStream;
import org.wso2.siddhi.query.api.query.output.stream.UpdateStream;
import org.wso2.siddhi.query.api.query.selection.Selector;

public class Query implements ExecutionPlan {

    private String name;
    private String summery;
    private InputStream inputStream;
    private Selector selector = new Selector();
    private OutputStream outputStream;
    private String partitionId;
    private OutputRate outputRate;

    public Query name(String name) {
        this.name = name;
        return this;
    }

    public Query summery(String summery) {
        this.summery = summery;
        return this;
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

    public void partitionBy(String partitionId) {
        this.partitionId = partitionId;
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

    public String getPartitionId() {
        return partitionId;
    }

    public OutputRate getOutputRate() {
        return outputRate;
    }

    public String getName() {
        return name;
    }

    public String getSummery() {
        return summery;
    }

}
