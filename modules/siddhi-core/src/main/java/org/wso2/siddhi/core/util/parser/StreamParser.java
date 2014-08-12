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
package org.wso2.siddhi.core.util.parser;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.processor.filter.FilterProcessor;
import org.wso2.siddhi.core.query.processor.filter.PassThroughFilterProcessor;
import org.wso2.siddhi.core.query.processor.window.WindowProcessor;
import org.wso2.siddhi.core.query.processor.handler.SingleHandlerProcessor;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.SiddhiClassLoader;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.input.stream.InputStream;
import org.wso2.siddhi.query.api.execution.query.input.stream.SingleInputStream;
import org.wso2.siddhi.query.api.execution.query.input.handler.Filter;
import org.wso2.siddhi.query.api.execution.query.input.handler.StreamHandler;
import org.wso2.siddhi.query.api.execution.query.input.handler.Window;
import org.wso2.siddhi.query.api.expression.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamParser {


    public static QueryPartComposite parseSingleStream(InputStream inputStream, Map<String, StreamDefinition> tempStreamDefinitionMap, SiddhiContext siddhiContext, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutorList) {
        QueryPartComposite queryPartComposite = new QueryPartComposite();
        //TODO pass-through
        int i = 0;
        Processor processor = null;
        if (((SingleInputStream) inputStream).getStreamHandlers().size() > 0) {
            for (StreamHandler handler : ((SingleInputStream) inputStream).getStreamHandlers()) {
                if (i == 0) {
                    processor = generateProcessor(handler, tempStreamDefinitionMap, siddhiContext, metaStreamEvent, variableExpressionExecutorList);
                    i++;
                } else {
                    processor.addToLast(generateProcessor(handler, tempStreamDefinitionMap, siddhiContext, metaStreamEvent, variableExpressionExecutorList));
                }
            }
        } else {
            processor = new PassThroughFilterProcessor();

        }


        SingleHandlerProcessor singleHandlerProcessor = new SingleHandlerProcessor(inputStream.getStreamIds().get(0));
        singleHandlerProcessor.setProcessorChain(processor);
        //queryPartComposite.getPreSelectProcessingElementList().add(simpleHandlerProcessor);
        //queryPartComposite.setProcessorChain(processor);
        queryPartComposite.setHandlerProcessor(singleHandlerProcessor); //TODO remove QPC
        return queryPartComposite;
    }

    private static Processor generateProcessor(StreamHandler streamHandler, Map<String, StreamDefinition> tempStreamDefinitionMap, SiddhiContext siddhiContext, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutorList) {
        if (streamHandler instanceof Filter) {
            //Filter filter = (Filter) streamHandler;
            Expression condition = ((Filter) streamHandler).getFilterExpression();
            try {
                return new FilterProcessor(ExecutorParser.parseCondition(condition, null, siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutorList)); //id already set at validation
                //return new FilterProcessor(ExecutorParser.parseCondition(condition, ((BasicSingleInputStream) inputStream).getId(),  siddhiContext, tempStreamDefinitionMap,metaStreamEvent,variableExpressionExecutorList));
            } catch (ValidatorException e) {
                //This will never occur
            }
        } else if (streamHandler instanceof Window) {
            metaStreamEvent.intializeAfterWindowData();

            Window window = (Window) streamHandler;
            WindowProcessor windowProcessor = (WindowProcessor) SiddhiClassLoader.loadProcessor(window.getFunction(),WindowProcessor.class);
            windowProcessor.setSiddhiContext(siddhiContext);
            windowProcessor.setParameters(window.getParameters());
            windowProcessor.initWindow();


            return windowProcessor;

        } else {
            //TODO: else
        }
        return null;
    }


    private static List<FilterProcessor> generateFilerProcessor(InputStream inputStream, Map<String, StreamDefinition> tempStreamDefinitionMap, SiddhiContext siddhiContext, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutorList) {
        //TODO :handle other input streams
        List<FilterProcessor> filterProcessors = new ArrayList<FilterProcessor>();
        List<StreamHandler> streamHandlers = ((SingleInputStream) inputStream).getStreamHandlers();
        /*if (streamHandlers.size() == 0) {
            return(Arrays.asList(new PassThroughFilterProcessor()));
        }*/
        for (StreamHandler streamHandler : streamHandlers) {
            if (streamHandler instanceof Filter) {
                //Filter filter = (Filter) streamHandler;
                Expression condition = ((Filter) streamHandler).getFilterExpression();
                try {
                    FilterProcessor filterProcessor = new FilterProcessor(ExecutorParser.parseCondition(condition, ((SingleInputStream) inputStream).getStreamId(), siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutorList));
                    filterProcessors.add(filterProcessor);
                    //return new FilterProcessor(ExecutorParser.parseCondition(condition, ((BasicSingleInputStream) inputStream).getId(),  siddhiContext, tempStreamDefinitionMap,metaStreamEvent,variableExpressionExecutorList));

                } catch (ValidatorException e) {
                    //This will never occur
                }
            } else if (streamHandler instanceof Window) {
                metaStreamEvent.intializeAfterWindowData();
                for (Expression expression : ((Window) streamHandler).getParameters()) {
                    try {
                        ExecutorParser.parseExpression(expression, ((SingleInputStream) inputStream).getStreamId(), siddhiContext, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutorList);
                    } catch (ValidatorException e) {
                        //This will never occur
                    }
                }

            } else {
                //TODO: else
            }
        }
        return filterProcessors;

    }

}
