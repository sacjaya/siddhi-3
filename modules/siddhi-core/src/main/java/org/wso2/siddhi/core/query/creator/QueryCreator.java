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
package org.wso2.siddhi.core.query.creator;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.util.QueryPartComposite;
import org.wso2.siddhi.core.util.parser.QueryOutputParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.input.SingleInputStream;
import org.wso2.siddhi.query.api.query.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class QueryCreator {

    protected final ConcurrentMap<String, AbstractDefinition> streamDefinitionMap;
    protected final ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap;
    protected OutputRateManager outputRateManager;
    protected final SiddhiContext siddhiContext;
    protected final String queryId;
    protected final Query query;
    protected StreamDefinition outputStreamDefinition;
    public QuerySelector querySelector;
    Map<String, StreamDefinition> tempStreamDefinitionMap = new HashMap<String, StreamDefinition>();

    protected QueryCreator(String queryId, Query query, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, ConcurrentMap<String, AbstractDefinition> localStreamDefinitionMap, OutputRateManager outputRateManager, SiddhiContext siddhiContext) {
        this.queryId = queryId;
        this.query = query;
        this.streamDefinitionMap = streamDefinitionMap;
        this.localStreamDefinitionMap = localStreamDefinitionMap;
        this.outputRateManager = outputRateManager;
        this.siddhiContext = siddhiContext;
    }

    protected void init() {
        InputStream inputStream = getInputStream();
        if (inputStream instanceof BasicSingleInputStream) {
           if(((BasicSingleInputStream) inputStream).isPartitioned()){
               tempStreamDefinitionMap.put(((SingleInputStream) inputStream).getStreamId(), (StreamDefinition) localStreamDefinitionMap.get(((SingleInputStream) inputStream).getStreamId()));
           }  else {
           tempStreamDefinitionMap.put(((SingleInputStream) inputStream).getStreamId(), (StreamDefinition) streamDefinitionMap.get(((SingleInputStream) inputStream).getStreamId()));
           }

        } else {
            //TODO: other inputstreamTypes

        }
        querySelector = constructQuerySelector(outputRateManager);
        outputStreamDefinition = querySelector.getOutputStreamDefinition();

    }



    protected QuerySelector constructQuerySelector(OutputRateManager outputRateManager) {
        return QueryOutputParser.constructQuerySelector(tempStreamDefinitionMap,query.getOutputStream(), query.getSelector(), outputRateManager,siddhiContext);
    }


    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }

    public  Map<String, StreamDefinition> getTempStreamDefinitionMap(){
        return tempStreamDefinitionMap;
    }

    public InputStream getInputStream() {
        return query.getInputStream();
    }

    public abstract QueryPartComposite constructQuery(OutputRateManager outputRateManager) ;

}
