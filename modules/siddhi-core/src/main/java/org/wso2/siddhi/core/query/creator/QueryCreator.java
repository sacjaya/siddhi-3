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
import org.wso2.siddhi.core.exception.EventStreamNotExistException;
import org.wso2.siddhi.core.query.QueryEventSource;
import org.wso2.siddhi.core.query.output.rateLimit.OutputRateManager;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.util.parser.QueryOutputParser;
import org.wso2.siddhi.core.util.parser.StreamParser;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.ExpressionValidator;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.*;
import org.wso2.siddhi.query.api.query.selection.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttributeExtension;
import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class QueryCreator {

    protected final ConcurrentMap<String, AbstractDefinition> streamDefinitionMap;
    protected OutputRateManager outputRateManager;
    protected final SiddhiContext siddhiContext;
    protected final String queryId;
    protected final Query query;
    protected StreamDefinition outputStreamDefinition;
    protected Map<InputStream , QueryEventSource> queryEventSourceList;
    public QuerySelector querySelector;

    protected QueryCreator(String queryId, Query query, ConcurrentMap<String, AbstractDefinition> streamDefinitionMap, OutputRateManager outputRateManager, SiddhiContext siddhiContext) {
        this.queryId = queryId;
        this.query = query;
        this.streamDefinitionMap = streamDefinitionMap;
        this.outputRateManager = outputRateManager;
        this.siddhiContext = siddhiContext;
    }

    protected void init() {
        InputStream inputStream = query.getInputStream();
        queryEventSourceList = constructQueryEventSourceList(inputStream, streamDefinitionMap, new HashMap<InputStream, QueryEventSource>());
        // TODO
//          updateQueryEventSourceList(queryEventSourceList);
//        validateOutput(queryEventSourceList, query);
//        populateSelection(query);
        if (inputStream instanceof StandardInputStream) {
            querySelector = constructQuerySelector(outputRateManager);

        } else {
            //TODO: other inputstreamTypes

        }
        outputStreamDefinition = querySelector.getOutputStreamDefinition();

    }

    protected void updateQueryEventSourceList(Map<InputStream,QueryEventSource> queryEventSourceList) {

        StreamParser.updateQueryEventSourceOutDefinition(queryEventSourceList.get(query.getInputStream()), siddhiContext);
    }

//    protected void validateOutput(List<QueryEventSource> queryEventSourceList, Query query) {
//
//        List<OutputAttribute> outputAttributeList = query.getSelector().getSelectionList();
//        for (OutputAttribute outputAttribute : outputAttributeList) {
//            if (outputAttribute instanceof SimpleAttribute) {
//                ExpressionValidator.validate(((SimpleAttribute) outputAttribute).getExpression(), queryEventSourceList, null, false);
//            } else if (outputAttribute instanceof ComplexAttribute) {
//                for (Expression expression : ((ComplexAttribute) outputAttribute).getExpressions()) {
//                    ExpressionValidator.validate(expression, queryEventSourceList, null, false);
//                }
//            } else {//Extension
//                for (Expression expression : ((OutputAttributeExtension) outputAttribute).getExpressions()) {
//                    ExpressionValidator.validate(expression, queryEventSourceList, null, false);
//                }
//            }
//        }
//    }

    protected QuerySelector constructQuerySelector(OutputRateManager outputRateManager) {
        return QueryOutputParser.constructQuerySelector(query.getOutputStream(), query.getSelector(), outputRateManager,
                 queryEventSourceList,siddhiContext);
    }


    protected void populateSelection(Query query) {
        //populate selection for * case
        List<OutputAttribute> attributeList = query.getSelector().getSelectionList();
        InputStream queryInputStream = query.getInputStream();
        if (attributeList.size() == 0) {
            if (queryInputStream instanceof StandardInputStream) {
                StandardInputStream standardInputStream = ((StandardInputStream) queryInputStream);
                standardInputStream.setDefinition(streamDefinitionMap.get(standardInputStream.getStreamId()));
                for (Attribute attribute : ((StandardInputStream) queryInputStream).getDefinition().getAttributeList()) {
                    attributeList.add(new SimpleAttribute(attribute.getName(), Expression.variable(((StandardInputStream) queryInputStream).getStreamReferenceId(), attribute.getName())));
                }
            } else {
                //TODO
            }
        }
    }

    public StreamDefinition getOutputStreamDefinition() {
        return outputStreamDefinition;
    }


    public Map<InputStream,QueryEventSource> constructQueryEventSourceList(InputStream inputStream,
                                                                ConcurrentMap<String, AbstractDefinition> streamDefinitionMap,
                                                                Map<InputStream,QueryEventSource> queryEventSources) {

        AbstractDefinition definition;
        QueryEventSource queryEventSource;

        if (inputStream instanceof BasicStream) {

            BasicStream basicStream = (BasicStream) inputStream;
            definition = streamDefinitionMap.get(basicStream.getStreamId());
            if (definition == null) {
                throw new EventStreamNotExistException("Definition not exist! No stream/table defined with stream ID: " + basicStream.getStreamId());
            }
            queryEventSource = new QueryEventSource(basicStream.getStreamId(), basicStream.getStreamReferenceId(),
                    definition,
                    basicStream.getFilter(), null);
            queryEventSources.put(inputStream,queryEventSource);

        } else if (inputStream instanceof JoinInputStream) {

            JoinInputStream joinInputStream = (JoinInputStream) inputStream;
            queryEventSources = constructQueryEventSourceList(joinInputStream.getLeftInputStream(), streamDefinitionMap, queryEventSources);
            return constructQueryEventSourceList(joinInputStream.getRightInputStream(), streamDefinitionMap, queryEventSources);

        } else if (inputStream instanceof WindowInputStream) {

            WindowInputStream windowStream = (WindowInputStream) inputStream;
            definition = streamDefinitionMap.get(windowStream.getStreamId());
            if (definition == null) {
                throw new EventStreamNotExistException("Stream definition not exist! No steam defined with stream ID: " + windowStream.getStreamId());
            }
            StreamDefinition streamDefinition = (StreamDefinition) definition;
            queryEventSource = new QueryEventSource(windowStream.getStreamId(), windowStream.getStreamId(),
                    streamDefinition, null, null);
            queryEventSources.put(inputStream, queryEventSource);

        } else if (inputStream instanceof StandardInputStream) {

            StandardInputStream standardInputStream = (StandardInputStream) inputStream;
            definition = streamDefinitionMap.get(standardInputStream.getStreamId());
            if (definition == null) {
                throw new EventStreamNotExistException("Definition not exist! No stream/table defined with stream ID: " + standardInputStream.getStreamId());
            }

            queryEventSource = new QueryEventSource(standardInputStream.getStreamId(), standardInputStream.getStreamReferenceId(),
                    definition, null, null);
            queryEventSources.put(inputStream, queryEventSource);

        }
        return queryEventSources;

    }

}
