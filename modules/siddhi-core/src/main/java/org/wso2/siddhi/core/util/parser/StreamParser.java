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
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.query.processor.filter.FilterProcessor;
import org.wso2.siddhi.core.query.processor.filter.PassThroughFilterProcessor;
import org.wso2.siddhi.core.query.processor.handler.SimpleHandlerProcessor;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.input.SingleInputStream;
import org.wso2.siddhi.query.api.query.input.handler.Filter;
import org.wso2.siddhi.query.api.query.input.handler.StreamHandler;

import java.util.List;
import java.util.Map;

public class StreamParser {


    public static QueryPartComposite parseSingleStream(InputStream inputStream, Map<String, StreamDefinition> tempStreamDefinitionMap, SiddhiContext siddhiContext) {
        QueryPartComposite queryPartComposite = new QueryPartComposite();

        SimpleHandlerProcessor simpleHandlerProcessor =
                new SimpleHandlerProcessor(generateFilerProcessor(inputStream, tempStreamDefinitionMap, siddhiContext), ((SingleInputStream) inputStream).getStreamId());

        if (inputStream instanceof BasicSingleInputStream) {
            queryPartComposite.getPreSelectProcessingElementList().add(simpleHandlerProcessor);
        } else {
            //TODO: else
        }

        queryPartComposite.getHandlerProcessorList().add(simpleHandlerProcessor);
        return queryPartComposite;
    }


    private static FilterProcessor generateFilerProcessor(InputStream inputStream, Map<String, StreamDefinition> tempStreamDefinitionMap, SiddhiContext siddhiContext) {
        //TODO :handle other input streams
        List<StreamHandler> streamHandlers = ((SingleInputStream) inputStream).getStreamHandlers();
        if (streamHandlers.size() == 0) {
            return new PassThroughFilterProcessor();
        }
        for (StreamHandler streamHandler : streamHandlers) {
            if (streamHandler instanceof Filter) {
                Filter filter = (Filter) streamHandler;
                Condition condition = filter.getFilterCondition();
                try {
                    return new FilterProcessor(ExecutorParser.parseCondition(condition, ((SingleInputStream) inputStream).getStreamId(), siddhiContext, tempStreamDefinitionMap));
                } catch (ValidatorException e) {
                    //This will never occur
                }
            }
        }
        return null;

    }

}
