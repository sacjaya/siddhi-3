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

import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.*;

import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.core.query.output.OutputManager;

import org.wso2.siddhi.core.query.selector.processor.AttributeProcessor;

import org.wso2.siddhi.core.query.selector.processor.PassThroughAttributeProcessor;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.ExpressionExtension;
import org.wso2.siddhi.query.api.extension.Extension;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.handler.Filter;
import org.wso2.siddhi.query.api.query.selection.Selector;
import org.wso2.siddhi.query.api.query.selection.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttributeExtension;
import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class QuerySelector {

    static final Logger log = Logger.getLogger(QuerySelector.class);


    private String outputStreamId;
    private AbstractDefinition inputStreamDefinition;
    private StreamDefinition outputStreamDefinition;
    private Selector selector;
    private List<AttributeProcessor> attributeProcessorList;
    private final OutputManager outputManager;

    public QuerySelector(String outputStreamId, Selector selector, AbstractDefinition inStreamDefinition,
                         OutputManager outputManager) {
        this.outputStreamId = outputStreamId;
        outputStreamDefinition = new StreamDefinition();
        outputStreamDefinition.id(outputStreamId);
        this.selector = selector;
        this.inputStreamDefinition = inStreamDefinition;
        this.outputManager = outputManager;
//        outputStreamDefinition.attribute("symbol", Attribute.Type.STRING).attribute("price", Attribute.Type.FLOAT).attribute("volume", Attribute.Type.INT);


    }

    public void process(StreamEvent streamEvent) {
        outputManager.send(streamEvent.getTimeStamp(), streamEvent, null);

    }

    private void populateOutputAttributes() {
        for (OutputAttribute outputAttribute : selector.getSelectionList()) {
            if (outputAttribute instanceof SimpleAttribute) {
                PassThroughAttributeProcessor attributeGenerator = new PassThroughAttributeProcessor(((SimpleAttribute) outputAttribute).getExpression(),inputStreamDefinition);
                outputStreamDefinition.attribute(outputAttribute.getRename(), attributeGenerator.getOutputType());
            } else {
                //TODO : for complex attributes
            }
        }

    }

      public StreamDefinition getOutputStreamDefinition(){
          return outputStreamDefinition;
      }


}

