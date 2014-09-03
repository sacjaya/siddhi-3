/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org)
 * All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.query.selector;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.query.output.rate_limit.OutputRateLimiter;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.selector.attribute.processor.AttributeProcessor;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;

import java.util.ArrayList;

public class QuerySelector implements Processor {


    private Selector selector;
    private StreamDefinition outputStreamDefinition;
    private int outputSize;
    private SiddhiContext siddhiContext;
    private boolean currentOn = false;
    private boolean expiredOn = false;
    private OutputRateLimiter outputRateLimiter;
    private ArrayList<AttributeProcessor> attributeProcessorList;
    private String id;
    static final Logger log = Logger.getLogger(QuerySelector.class);



    //TODO:aggregateAttributeProcessorList and the methods -processOutputAttributeGenerator

    public QuerySelector(String id, Selector selector, boolean currentOn, boolean expiredOn, SiddhiContext siddhiContext) {
        this.id = id;
        this.currentOn = currentOn;
        this.expiredOn = expiredOn;
        this.selector = selector;
        this.siddhiContext = siddhiContext;
        this.outputSize = selector.getSelectionList().size();
    }

    @Override
    public void process(StreamEvent streamEvent) {
        //TODO:  for RemoveStreamEvents
        if(log.isTraceEnabled()){
            log.trace("event is processed by selector "+ id+ this);
        }
        Object[] data = new Object[streamEvent.getOutputData().length];      //Returns outData array from meta stream event
        for (int i = 0; i < streamEvent.getOutputData().length; i++) {
            data[i] = streamEvent.getOutputData()[i];
        }

        //TODO: populate data for complex attributes

        StreamEvent event = new StreamEvent(streamEvent.getBeforeWindowData().length, streamEvent.getOnAfterWindowData().length, streamEvent.getOutputData().length);
        event.setOutputData(data);
        event.setTimestamp(streamEvent.getTimestamp());
        outputRateLimiter.send(event.getTimestamp(), event, null);

    }

    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }

    @Override
    public Processor getNext() {
        return outputRateLimiter;
    }

    @Override
    public void setNext(Processor processor) {
        if (!(processor instanceof OutputRateLimiter)) {
            throw new QueryCreationException("processor is not an instance of OutputRateLimiter");
        }
        if (outputRateLimiter == null) {
            this.outputRateLimiter = (OutputRateLimiter) processor;
        } else {
            throw new QueryCreationException("outputRateLimiter is already assigned");
        }
    }

    @Override
    public void setToLast(Processor processor) {
        setNext(processor);
    }

    @Override
    public Processor clone() {
        return clone("");
    }


    public ArrayList<AttributeProcessor> getAttributeProcessorList() {
        return attributeProcessorList;
    }

    public void setAttributeProcessorList(ArrayList<AttributeProcessor> attributeProcessorList) {
        this.attributeProcessorList = attributeProcessorList;
    }

    public QuerySelector clone(String key){
        QuerySelector clonedQuerySelector = new QuerySelector(id+key,selector,currentOn,expiredOn,siddhiContext);
        clonedQuerySelector.attributeProcessorList =attributeProcessorList;
        return clonedQuerySelector;
    }


}
