/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.core.query.selector;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.*;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.selector.attribute.processor.AttributeProcessor;
import org.wso2.siddhi.core.query.selector.attribute.processor.NonGroupingAttributeProcessor;
import org.wso2.siddhi.core.query.selector.attribute.processor.PassThroughAttributeProcessor;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.selection.Selector;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;

import java.util.ArrayList;

public class QuerySelector {

    private String outputStreamId;
    private StreamDefinition outputStreamDefinition;
    private Selector selector;
    private final OutputRateManager outputRateManager;
    private int outputSize;
    private ArrayList<AttributeProcessor> attributeProcessorList;
    private InputStream inputStream;
    public boolean currentOn = false;
    public boolean expiredOn = false;


    public QuerySelector(String outputStreamId, AbstractDefinition outputStreamDefinition, Selector selector,
                         OutputRateManager outputRateManager, SiddhiContext siddhiContext, boolean currentOn, boolean expiredOn,InputStream inputStream) {
        this.outputStreamId = outputStreamId;
        this.currentOn = currentOn;
        this.expiredOn = expiredOn;
        this.selector = selector;

        outputSize = selector.getSelectionList().size();
        this.inputStream = inputStream;
        attributeProcessorList = new ArrayList<AttributeProcessor>(outputSize);
        this.outputStreamDefinition = (StreamDefinition) outputStreamDefinition;

        populateOutputAttributes(siddhiContext);

        this.outputRateManager = outputRateManager;

    }



    public void process(StreamEvent streamEvent) {
        Object[] data = new Object[outputSize];
        for (int i = 0; i < outputSize; i++) {
            AttributeProcessor attributeProcessor = attributeProcessorList.get(i);
            data[i] = processOutputAttributeGenerator(streamEvent, attributeProcessor);
        }

        StreamEvent event;
        event = new Event(streamEvent.getTimeStamp(), data);
        outputRateManager.send(event.getTimeStamp(), event, null);

    }

    private Object processOutputAttributeGenerator(StreamEvent streamEvent,AttributeProcessor attributeProcessor) {
        if (attributeProcessor instanceof NonGroupingAttributeProcessor) {
            return ((NonGroupingAttributeProcessor) attributeProcessor).process(streamEvent);
        } else {
            //TODO: else
            return null;
        }
    }


      public StreamDefinition getOutputStreamDefinition(){
          return outputStreamDefinition;
      }

    private void populateOutputAttributes(SiddhiContext siddhiContext) {
        for (OutputAttribute outputAttribute : selector.getSelectionList()) {
            if (outputAttribute instanceof SimpleAttribute) {
                PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(ExecutorParser.parseExpression(((SimpleAttribute) outputAttribute).getExpression(),  null, false, siddhiContext,inputStream));
                attributeProcessorList.add(attributeGenerator);
                if(outputStreamDefinition.getAttributeList().isEmpty()){
                outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
                }
            } else {
                //TODO: else
            }
        }


    }



}

