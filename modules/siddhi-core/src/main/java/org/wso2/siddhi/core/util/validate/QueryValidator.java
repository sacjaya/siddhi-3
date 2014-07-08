/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.siddhi.core.util.validate;

import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.expression.Variable;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.*;
import org.wso2.siddhi.query.api.query.input.pattern.PatternInputStream;
import org.wso2.siddhi.query.api.query.output.stream.OutputStream;
import org.wso2.siddhi.query.api.query.selection.Selector;
import org.wso2.siddhi.query.api.query.selection.attribute.OutputAttribute;
import org.wso2.siddhi.query.api.query.selection.attribute.SimpleAttribute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to validate a single siddhi query.
 */
public class QueryValidator {

    private Map<String, String> streamIdMap;
    private Query query;
    private List<StreamDefinition> definitionList;


    /*public void validate(Query query, List<StreamDefinition> definitionList) throws ValidatorException {
        this.query = query; //TODO: check if assignment is really necessary
        validateInStream(query.getInputStream(), definitionList, streamIdMap);//TODO:only forward relevant streams
    }*/

    /*private static void validateInStream(InputStream inputStream, List<StreamDefinition> definitionList) throws ValidatorException {//TODO:Handle renaming
        if (inputStream instanceof BasicSingleInputStream || inputStream instanceof SingleInputStream) {
            InStreamValidator.validate(inputStream, definitionList);   // left/right streams can't have multiple stream IDs
            if (!(((SingleInputStream) inputStream).getStreamReferenceId().equals(((SingleInputStream) inputStream).getStreamId()))) {
                this.streamIdMap.put(((SingleInputStream) inputStream).getStreamReferenceId(), ((SingleInputStream) inputStream).getStreamId());
            }
        } else if (inputStream instanceof JoinInputStream) {
            InputStream leftStream = ((JoinInputStream) inputStream).getLeftInputStream();
            InputStream rightStream = ((JoinInputStream) inputStream).getRightInputStream();
            InStreamValidator.validate(leftStream, getDefinitionFor(leftStream.getStreamIds().get(0)));
            InStreamValidator.validate(rightStream, getDefinitionFor(rightStream.getStreamIds().get(0)));
        } else if (inputStream instanceof PatternInputStream) {
            //TODO: iterate through pattern and call validateInStream recursively
        }
    }*/
    //Testing implementation
    private static void validateInStream(InputStream inputStream, Map<String, StreamDefinition> definitionMap, Map<String, String> renameHandlerMap) throws ValidatorException {//TODO:Handle renaming
        if (inputStream instanceof BasicSingleInputStream || inputStream instanceof SingleInputStream) {
            InStreamValidator.validate(inputStream, getRelevantDefinitions(inputStream.getStreamIds(), definitionMap));   // left/right streams can't have multiple stream IDs
            if (!(((SingleInputStream) inputStream).getStreamReferenceId().equals(((SingleInputStream) inputStream).getStreamId()))) {
                renameHandlerMap.remove(((SingleInputStream) inputStream).getStreamId());
                renameHandlerMap.put(((SingleInputStream) inputStream).getStreamReferenceId(), ((SingleInputStream) inputStream).getStreamId());
                //TODO: handle renaming
            }
        } else if (inputStream instanceof JoinInputStream) {
            InputStream leftStream = ((JoinInputStream) inputStream).getLeftInputStream();
            InputStream rightStream = ((JoinInputStream) inputStream).getRightInputStream();
            validateInStream(leftStream, definitionMap, renameHandlerMap);
            validateInStream(rightStream, definitionMap, renameHandlerMap);
        } else if (inputStream instanceof PatternInputStream) {
            //TODO: iterate through pattern and call validateInStream recursively
        }
    }

    /*private StreamDefinition getDefinitionFor(String id) throws ValidatorException {
        if (streamIdMap.containsKey(id)) {
            id = streamIdMap.get(id);
        }
        for (StreamDefinition definition : definitionList) {
            if (definition.getStreamId().equals(id)) {
                return definition;
            }
        }
        throw new ValidatorException("No stream definition found for stream ID: " + id);
    }*/


    public static void validate(Query query, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        Map<String, String> renameHandlerMap = new HashMap<String, String>();        //<StreamReferenceId,StreamId>
        for (String key : streamDefinitionMap.keySet()) {
            renameHandlerMap.put(key, key);
        }
        List<StreamDefinition> definitionList = getRelevantDefinitions(query.getInputStream().getStreamIds(), streamDefinitionMap); //To streamID being null in some cases
        validateInStream(query.getInputStream(), streamDefinitionMap, renameHandlerMap);
        validateSelector(query.getSelector(), definitionList, renameHandlerMap); //TODO: handle infer streams. check implementation level
        validateOutStream(query.getOutputStream(), query.getSelector(), streamDefinitionMap);
    }

    private static void validateOutStream(OutputStream outputStream, Selector selector, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        StreamDefinition definition = new StreamDefinition(outputStream.getStreamId());         //TODO:check whether we need to move implementation into out stream validator.
        for (OutputAttribute attribute : selector.getSelectionList()) {
            if (attribute instanceof SimpleAttribute) {                                          //TODO: handle complex attributes
                StreamDefinition sourceDefinition = streamDefinitionMap.get(((Variable) ((SimpleAttribute) attribute).getExpression()).getStreamId());
                String name = ((Variable) ((SimpleAttribute) attribute).getExpression()).getAttributeName();
                Attribute.Type type = null;
                for (Attribute attribute1 : sourceDefinition.getAttributeList()) {
                    if (attribute1.getName().equals(name)) {
                        type = attribute1.getType();
                    }
                }
                if (type != null) {
                    definition.attribute(attribute.getRename(), type);
                } else {
                    throw new ValidatorException("Attribute " + name + " was not found in stream definition " + sourceDefinition.getStreamId());
                }

            }
        }
        StreamValidator.validate(streamDefinitionMap, definition);
        streamDefinitionMap.put(definition.getStreamId(), definition);
    }

    private static void validateSelector(Selector selector, List<StreamDefinition> streamDefinitionList, Map<String, String> renameHandlerMap) throws ValidatorException {
        SelectorValidator.validate(selector, streamDefinitionList, renameHandlerMap);
    }

    private static List<StreamDefinition> getRelevantDefinitions(List<String> streamIds, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        ArrayList<StreamDefinition> result = new ArrayList<StreamDefinition>(streamIds.size());
        for (String streamId : streamIds) {
            if (streamDefinitionMap.get(streamId) != null) {
                result.add(streamDefinitionMap.get(streamId));
            } else {
                throw new ValidatorException("No stream definition found for stream ID " + streamId);
            }
        }
        return result;
    }
}
