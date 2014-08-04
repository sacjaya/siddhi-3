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
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.selector.attribute.processor.AttributeProcessor;
import org.wso2.siddhi.core.query.selector.attribute.processor.NonGroupingAttributeProcessor;
import org.wso2.siddhi.core.query.selector.attribute.processor.PassThroughAttributeProcessor;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.definition.FunctionAttribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.AttributeFunction;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.query.selection.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.Selector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuerySelector {

    private StreamDefinition outputStreamDefinition;
    private Selector selector;
    private final OutputRateManager outputRateManager;
    private int outputSize;
    private ArrayList<AttributeProcessor> attributeProcessorList;
    private Map<String, StreamDefinition> tempStreamDefinitionMap;
    private boolean partitionedStream = false;
    public boolean currentOn = false;
    public boolean expiredOn = false;


    public QuerySelector(String outputStreamId, Selector selector,
                         OutputRateManager outputRateManager, SiddhiContext siddhiContext, boolean currentOn, boolean expiredOn, boolean isPartitioned, Map<String, StreamDefinition> tempStreamDefinitionMap, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutors) {
        this.currentOn = currentOn;
        this.expiredOn = expiredOn;
        this.selector = selector;
        this.outputSize = selector.getSelectionList().size();
        this.tempStreamDefinitionMap = tempStreamDefinitionMap;
        this.outputStreamDefinition = new StreamDefinition();
        this.outputStreamDefinition.setId(outputStreamId);
        this.outputRateManager = outputRateManager;
        this.partitionedStream = isPartitioned;
        attributeProcessorList = new ArrayList<AttributeProcessor>(outputSize);
        populateAttributeProcessorList(siddhiContext, metaStreamEvent, variableExpressionExecutors);


    }


    public void process(StreamEvent streamEvent) {
        Object[] data = new Object[outputSize];
        for (int i = 0; i < outputSize; i++) {
            AttributeProcessor attributeProcessor = attributeProcessorList.get(i);
            data[i] = processOutputAttributeGenerator(streamEvent, attributeProcessor);
        }

        StreamEvent event = new StreamEvent(streamEvent.getTimestamp(), data);
        outputRateManager.send(event.getTimestamp(), event, null);

    }


    private Object processOutputAttributeGenerator(StreamEvent streamEvent, AttributeProcessor attributeProcessor) {
        if (attributeProcessor instanceof NonGroupingAttributeProcessor) {
            return ((NonGroupingAttributeProcessor) attributeProcessor).process(streamEvent);
        } else {
            //TODO: else
            return null;
        }
    }


    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }

    public boolean isPartitioned() {
        return partitionedStream;
    }

    private void populateAttributeProcessorList(SiddhiContext siddhiContext, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutors) {
        for (OutputAttribute outputAttribute : selector.getSelectionList()) {
            try {
                if (!(outputAttribute.getExpression() instanceof Variable)) {
                    metaStreamEvent.addData(new FunctionAttribute(false));//insert dummy function attribute with isInitialized set to false
                    //TODO: implement function attribute processor
                    PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(ExecutorParser.parseExpression(outputAttribute.getExpression(), null, siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutors));//TODO: handle null args
                    attributeProcessorList.add(attributeGenerator);
                    outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
                    ((FunctionAttribute) metaStreamEvent.getOutData().get(metaStreamEvent.getOutData().size() - 1)).setIsInitialized(true);    //set isInitialed true after processing
                } else {
                    PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(ExecutorParser.parseExpression(outputAttribute.getExpression(), null, siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutors));//TODO: handle null args
                    attributeProcessorList.add(attributeGenerator);
                    outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
                }

            } catch (ValidatorException e) {
                //this will never happen as this is already validated
            }
            //TODO avg, sum
        }


    }


}

