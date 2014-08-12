/*
*  Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.siddhi.core.query.creator;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.BasicHandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.SingleHandlerProcessor;
import org.wso2.siddhi.core.util.MetaStreamEventHelper;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.parser.StreamParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.execution.query.Query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class BasicQueryCreator extends QueryCreator {
    private EventConverter eventConverter;


    public BasicQueryCreator(String queryId, Query query, ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap, ConcurrentMap<String, AbstractDefinition> localStreamTableDefinitionMap, OutputRateManager outputRateManager, SiddhiContext siddhiContext) {
        super(queryId, query, streamTableDefinitionMap, localStreamTableDefinitionMap, outputRateManager, siddhiContext);
        constructTempStreamDefinitionMap(query.getInputStream());
    }



    public QueryPartComposite constructQuery(OutputRateManager outputRateManager) {
        List<VariableExpressionExecutor> variableExpressionExecutorList = new LinkedList<VariableExpressionExecutor>();
        QueryPartComposite queryPartComposite = StreamParser.parseSingleStream(getInputStream(),
                this.tempStreamDefinitionMap, siddhiContext, metaStreamEvent, variableExpressionExecutorList);
        metaStreamEvent.intializeOutData();
        this.querySelector = constructQuerySelector(outputRateManager, metaStreamEvent, variableExpressionExecutorList);
        this.outputStreamDefinition = querySelector.getOutputStreamDefinition();




        //queryPartComposite.setQuerySelector(querySelector); //TODO:check usage. SInce we are already setting Selector to Handler processor
        queryPartComposite.getHandlerProcessor().setSelector(querySelector);
        MetaStreamEventHelper.updateVariablePosition(metaStreamEvent, variableExpressionExecutorList);
        updateQueryPartComposite(queryPartComposite);
        return queryPartComposite;
    }

    private void updateQueryPartComposite(QueryPartComposite queryPartComposite){
        queryPartComposite.getHandlerProcessor().setEventConverter(getEventConverter());
        Processor processor =  ((SingleHandlerProcessor)queryPartComposite.getHandlerProcessor()).getProcessorChain();
        Processor lastProcessor = null;
        while (processor!=null){
            lastProcessor = processor;
            processor = (Processor) processor.getNext();
        }
        lastProcessor.addToLast(this.querySelector);
    }


    public List<BasicHandlerProcessor> cloneHandlers(OutputRateManager outputRateManager) {
        List<VariableExpressionExecutor> variableExpressionExecutorList = new LinkedList<VariableExpressionExecutor>();
        QueryPartComposite queryPartComposite = StreamParser.parseSingleStream(getInputStream(), this.tempStreamDefinitionMap, siddhiContext, metaStreamEvent, variableExpressionExecutorList);
        this.querySelector = constructQuerySelector(outputRateManager, metaStreamEvent, variableExpressionExecutorList);
        this.outputStreamDefinition = querySelector.getOutputStreamDefinition();

        updateQueryPartCompositer(queryPartComposite);

        return Arrays.asList(queryPartComposite.getHandlerProcessor());
    }

    private void updateQueryPartCompositer(QueryPartComposite queryPartComposite){
        queryPartComposite.getHandlerProcessor().setSelector(querySelector);
        queryPartComposite.getHandlerProcessor().setEventConverter(getEventConverter());

        Processor processor =  ((SingleHandlerProcessor)queryPartComposite.getHandlerProcessor()).getProcessorChain();
        Processor lastProcessor = null;
        while (processor!=null){
            lastProcessor = processor;
            processor = (Processor) processor.getNext();
        }
        lastProcessor.addToLast(this.querySelector);
    }

    private synchronized EventConverter getEventConverter() {
        if (eventConverter == null) {
            eventConverter = new EventConverter(metaStreamEvent, defaultDefinition);
        }
        return eventConverter;
    }


}
