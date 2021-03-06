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
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.output.callback.InsertIntoStreamCallback;
import org.wso2.siddhi.core.query.output.callback.OutputCallback;
import org.wso2.siddhi.core.query.output.rateLimit.PassThroughOutputRateManager;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.stream.StreamJunction;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.query.output.ratelimit.OutputRate;
import org.wso2.siddhi.query.api.execution.query.output.stream.DeleteStream;
import org.wso2.siddhi.query.api.execution.query.output.stream.InsertIntoStream;
import org.wso2.siddhi.query.api.execution.query.output.stream.OutputStream;
import org.wso2.siddhi.query.api.execution.query.output.stream.UpdateStream;
import org.wso2.siddhi.query.api.execution.query.selection.Selector;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class QueryOutputParser {


    public static QuerySelector constructQuerySelector(Map<String, StreamDefinition> tempStreamDefinitionMap, OutputStream outStream, Selector selector, OutputRateManager outputRateManager
            , SiddhiContext siddhiContext, MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutors) {
        boolean currentOn = false;
        boolean expiredOn = false;
        String id = null;

        if (outStream != null) {
            if (outStream.getOutputEventType() == OutputStream.OutputEventType.CURRENT_EVENTS || outStream.getOutputEventType() == OutputStream.OutputEventType.ALL_EVENTS) {
                currentOn = true;
            }
            if (outStream.getOutputEventType() == OutputStream.OutputEventType.EXPIRED_EVENTS || outStream.getOutputEventType() == OutputStream.OutputEventType.ALL_EVENTS) {
                expiredOn = true;
            }

            id = outStream.getId();
        } else {
            currentOn = true;
            expiredOn = true;
        }
        return new QuerySelector(id, selector, outputRateManager, siddhiContext, currentOn, expiredOn, tempStreamDefinitionMap, metaStreamEvent, variableExpressionExecutors);


    }

    public static OutputCallback constructOutputCallback(OutputStream outStream,  ConcurrentMap<String, StreamJunction> streamJunctionMap, SiddhiContext siddhiContext,
                                                         StreamDefinition outputStreamDefinition) {
        String id = outStream.getId();
        //Construct CallBack
        if (outStream instanceof InsertIntoStream) {
            StreamJunction outputStreamJunction = streamJunctionMap.get(id);
            if (outputStreamJunction == null) {
                outputStreamJunction = new StreamJunction(id, siddhiContext.getExecutorService());
                streamJunctionMap.putIfAbsent(id, outputStreamJunction);
            }
            return new InsertIntoStreamCallback(outputStreamJunction, outputStreamDefinition);

        } else if (outStream instanceof DeleteStream) {
            //TODO: else
            return null;
        } else if (outStream instanceof UpdateStream) {
            //TODO: else
            return null;
        } else {
            throw new QueryCreationException(outStream.getClass().getName() + " not supported");
        }
    }

    public static OutputCallback constructOutputCallback(OutputStream outStream, String key, ConcurrentMap<String, StreamJunction> streamJunctionMap, SiddhiContext siddhiContext,
                                                         StreamDefinition outputStreamDefinition) {
        String id = outStream.getId();
        //Construct CallBack
        if (outStream instanceof InsertIntoStream) {
            StreamJunction outputStreamJunction = streamJunctionMap.get(id+key);
            if (outputStreamJunction == null) {
                outputStreamJunction = new StreamJunction(id+key, siddhiContext.getExecutorService());
                streamJunctionMap.putIfAbsent(id+key, outputStreamJunction);
            }
            return new InsertIntoStreamCallback(outputStreamJunction, outputStreamDefinition);

        } else if (outStream instanceof DeleteStream) {
            //TODO: else
            return null;
        } else if (outStream instanceof UpdateStream) {
            //TODO: else
            return null;
        } else {
            throw new QueryCreationException(outStream.getClass().getName() + " not supported");
        }
    }


    public static OutputCallback constructOutputCallback(StreamJunction streamJunction, SiddhiContext siddhiContext,
                                                         StreamDefinition outputStreamDefinition) {

            return new InsertIntoStreamCallback(streamJunction, outputStreamDefinition);


    }
    public static OutputRateManager constructOutputRateManager(OutputRate outputRate) {
        if (outputRate == null) {
            return new PassThroughOutputRateManager();
        }
        //TODO: else


        return null;
    }
}
