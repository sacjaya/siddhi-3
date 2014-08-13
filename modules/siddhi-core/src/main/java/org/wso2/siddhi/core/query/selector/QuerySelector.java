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
import org.wso2.siddhi.core.event.InnerStreamEvent;
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.remove.RemoveStream;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.QueryProcessingElement;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.core.query.selector.attribute.factory.OutputAttributeAggregatorFactory;
import org.wso2.siddhi.core.query.selector.attribute.processor.*;
import org.wso2.siddhi.core.util.SiddhiClassLoader;
import org.wso2.siddhi.core.util.parser.ExecutorParser;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.selection.OutputAttribute;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.expression.constant.Constant;
import org.wso2.siddhi.query.api.expression.function.AttributeFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QuerySelector implements QueryProcessingElement {

    private StreamDefinition outputStreamDefinition;
    private Selector selector;
    private final OutputRateManager outputRateManager;
    private int outputSize;
    private ArrayList<AttributeProcessor> attributeProcessorList;
    private List<AttributeProcessor> aggregateAttributeProcessorList;
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
        aggregateAttributeProcessorList = new ArrayList<AttributeProcessor>(outputSize);
        populateAttributeProcessorList(siddhiContext, metaStreamEvent, variableExpressionExecutors);


    }


    public void process(StreamEvent streamEvent) {

        if ((!(streamEvent instanceof InnerStreamEvent) || !currentOn) && (!(streamEvent instanceof RemoveStream) || !expiredOn)) {
            for (AttributeProcessor attributeProcessor : aggregateAttributeProcessorList) {
                processOutputAttributeGenerator(streamEvent, attributeProcessor);
            }
            return;
        }


        Object[] data = new Object[streamEvent.getData().length];      //Returns outData array from meta stream event
        for (int i = 0; i < streamEvent.getData().length; i++) {
            data[i] = streamEvent.getData()[i];
        }

        for (int i = 0; i < outputSize; i++) {
            AttributeProcessor attributeProcessor = attributeProcessorList.get(i);
            if (attributeProcessor instanceof AggregationAttributeProcessor) {        //only processing complex attributes.
                data[i] = processOutputAttributeGenerator(streamEvent, attributeProcessor);
            }   //else data is already filled

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
                    if (outputAttribute.getExpression() instanceof Constant) {
                        PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(ExecutorParser.parseExpression(outputAttribute.getExpression(),
                                null, siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutors));//TODO: handle null args
                        attributeProcessorList.add(attributeGenerator);
                        outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
                        ((ComplexAttribute) metaStreamEvent.getOutData().get(metaStreamEvent.getOutData().size() - 1)).setIsInitialized(true);    //set isInitialed true after processing
                    } else if (outputAttribute.getExpression() instanceof AttributeFunction) {
                        metaStreamEvent.addData(new ComplexAttribute(false));

                        OutputAttributeAggregatorFactory outputAttributeAggregatorFactory;
                        outputAttributeAggregatorFactory = (OutputAttributeAggregatorFactory) SiddhiClassLoader.loadSiddhiImplementation(((AttributeFunction) outputAttribute.getExpression()).getFunction(), OutputAttributeAggregatorFactory.class);
                        Expression[] expressions = null;
                        expressions = ((AttributeFunction) outputAttribute.getExpression()).getParameters();
                        AttributeProcessor attributeProcessor = AttributeProcessorFactory.createAttributeProcessor(
                                expressions, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutors, outputAttributeAggregatorFactory, siddhiContext);

                        aggregateAttributeProcessorList.add(attributeProcessor);
                        attributeProcessorList.add(attributeProcessor);
                        outputStreamDefinition.attribute(outputAttribute.getRename(), attributeProcessor.getOutputType());
                    }
                } else {
                    PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(ExecutorParser.parseExpression(outputAttribute.getExpression(),
                            null, siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutors));//TODO: handle null args
                    attributeProcessorList.add(attributeGenerator);
                    outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
                }

            } catch (ValidatorException e) {
                //this will never happen as this is already validated
            }
        }


    }


}

