/*
*  Copyright (c) 2005-2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.siddhi.core.query.selector.attribute.processor;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.core.query.selector.attribute.factory.OutputAttributeAggregatorFactory;
import org.wso2.siddhi.core.query.selector.attribute.handler.OutputAttributeAggregator;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;


import java.util.List;
import java.util.Map;

public class AggregationAttributeProcessor extends AbstractAggregationAttributeProcessor implements NonGroupingAttributeProcessor {

    private OutputAttributeAggregator outputAttributeAggregator;

    public AggregationAttributeProcessor(Expression[] expressions,  Map<String, StreamDefinition> tempStreamDefinitionMap,
                                         MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutors,
                                         OutputAttributeAggregatorFactory outputAttributeAggregatorFactory, SiddhiContext siddhiContext) {
       super(expressions, tempStreamDefinitionMap,outputAttributeAggregatorFactory,metaStreamEvent,variableExpressionExecutors,siddhiContext) ;
        this.outputAttributeAggregator = sampleOutputAttributeAggregator;
    }

    public synchronized Object process(StreamEvent event) {
        return process(event, outputAttributeAggregator);
    }


    @Override
    protected Object[] currentState() {
        return new Object[]{outputAttributeAggregator};
    }

    @Override
    protected void restoreState(Object[] data) {
        outputAttributeAggregator = (OutputAttributeAggregator) data[0];

    }


}
