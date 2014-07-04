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

import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.*;

import org.wso2.siddhi.core.query.QueryEventSource;
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
import java.util.List;
import java.util.Map;


public class QuerySelector {

    static final Logger log = Logger.getLogger(QuerySelector.class);


    private String outputStreamId;
    private StreamDefinition outputStreamDefinition;
    private Selector selector;
    private final OutputRateManager outputRateManager;
    private int outputSize;
    private ArrayList<AttributeProcessor> attributeProcessorList;

    public QuerySelector(String outputStreamId, Selector selector,
                         OutputRateManager outputRateManager, Map<InputStream,QueryEventSource> queryEventSourceList, SiddhiContext siddhiContext, boolean currentOn, boolean expiredOn) {
        this.outputStreamId = outputStreamId;
        attributeProcessorList = new ArrayList<AttributeProcessor>(outputSize);

        outputStreamDefinition = new StreamDefinition();
        outputStreamDefinition.id(outputStreamId);
        this.selector = selector;
        outputSize = selector.getSelectionList().size();
        this.outputRateManager = outputRateManager;
//        populateOutputAttributes(queryEventSourceList); //TODO

    }


    //TODO: for selectors
    public void process(StreamEvent streamEvent) {
        outputRateManager.send(streamEvent.getTimeStamp(), streamEvent, null);
    }

    private Object processOutputAttributeGenerator(StreamEvent streamEvent,AttributeProcessor attributeProcessor) {
        if (attributeProcessor instanceof NonGroupingAttributeProcessor) {
            return ((NonGroupingAttributeProcessor) attributeProcessor).process(streamEvent);
        } else {
            //TODO
            return null;
        }
    }

    private void populateOutputAttributes(Map<InputStream,QueryEventSource> queryEventSourceList) {
        for (OutputAttribute outputAttribute : selector.getSelectionList()) {
            if (outputAttribute instanceof SimpleAttribute) {

            PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(ExecutorParser.parseExpression(((SimpleAttribute) outputAttribute).getExpression(), queryEventSourceList, null, false));


                outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
            } else {
                //TODO : for complex attributes
            }
        }

    }

      public StreamDefinition getOutputStreamDefinition(){
          return outputStreamDefinition;
      }


}

