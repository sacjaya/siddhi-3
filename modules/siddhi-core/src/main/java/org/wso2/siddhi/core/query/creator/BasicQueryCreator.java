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
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.parser.StreamParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.SingleInputStream;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class BasicQueryCreator extends QueryCreator {

    //Map<String, StreamDefinition> tempStreamDefinitionMap = new HashMap<String, StreamDefinition>();

    public BasicQueryCreator(String queryId, Query query, ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap, ConcurrentMap<String, AbstractDefinition> localStreamTableDefinitionMap, OutputRateManager outputRateManager, SiddhiContext siddhiContext) {
        super(queryId, query, streamTableDefinitionMap, localStreamTableDefinitionMap, outputRateManager, siddhiContext);
        init();
        if (((SingleInputStream) getInputStream()).isPartitioned()) {
            tempStreamDefinitionMap.put(((SingleInputStream) getInputStream()).getStreamId(), (StreamDefinition) localStreamDefinitionMap.get(((SingleInputStream) getInputStream()).getStreamId()));
        } else {
            tempStreamDefinitionMap.put(((SingleInputStream) getInputStream()).getStreamId(), (StreamDefinition) streamDefinitionMap.get(((SingleInputStream) getInputStream()).getStreamId()));
        }
    }

    public QueryPartComposite constructQuery() {
        MetaStreamEvent metaStreamEvent = new MetaStreamEvent();
        List<VariableExpressionExecutor> variableExpressionExecutorList = new LinkedList<VariableExpressionExecutor>();
        tempStreamDefinitionMap.put(((SingleInputStream) getInputStream()).getStreamId(), (StreamDefinition) streamDefinitionMap.get(((SingleInputStream) getInputStream()).getStreamId()));
        QueryPartComposite queryPartComposite = StreamParser.parseSingleStream(getInputStream(), this.tempStreamDefinitionMap, siddhiContext, metaStreamEvent, variableExpressionExecutorList);
        metaStreamEvent.intializeAfterWindowData();
        metaStreamEvent.intializeOutData();
        this.querySelector = constructQuerySelector(outputRateManager, metaStreamEvent, variableExpressionExecutorList);
        this.outputStreamDefinition = querySelector.getOutputStreamDefinition();
        queryPartComposite.setQuerySelector(querySelector);
        queryPartComposite.getHandlerProcessor().setSelector(querySelector);
        updateVariablePosition(metaStreamEvent, variableExpressionExecutorList);
        queryPartComposite.getHandlerProcessor().setEventConverter(new EventConverter(metaStreamEvent, defaultDefinition));
        return queryPartComposite;
    }


}
