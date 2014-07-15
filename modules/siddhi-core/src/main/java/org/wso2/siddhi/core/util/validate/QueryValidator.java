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
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.Query;
import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.input.JoinInputStream;
import org.wso2.siddhi.query.api.query.input.SingleInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.PatternInputStream;
import org.wso2.siddhi.query.api.query.input.pattern.element.FollowedByElement;
import org.wso2.siddhi.query.api.query.input.pattern.element.PatternElement;
import org.wso2.siddhi.query.api.query.output.stream.OutputStream;
import org.wso2.siddhi.query.api.query.selection.Selector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to validate a single siddhi query.
 */
public class QueryValidator {

    private static Map<String, StreamDefinition> validateInStream(InputStream inputStream, Map<String, StreamDefinition> definitionMap) throws ValidatorException {//TODO:Handle renaming
        Map<String, StreamDefinition> tempDefinitionMap = new HashMap<String, StreamDefinition>();
        if (inputStream instanceof BasicSingleInputStream || inputStream instanceof SingleInputStream) {
            InStreamValidator.validate(inputStream, definitionMap, tempDefinitionMap);

        } else if (inputStream instanceof JoinInputStream) {
            InputStream leftStream = ((JoinInputStream) inputStream).getLeftInputStream();
            InputStream rightStream = ((JoinInputStream) inputStream).getRightInputStream();
            InStreamValidator.validate(leftStream, definitionMap, tempDefinitionMap);
            InStreamValidator.validate(rightStream, definitionMap, tempDefinitionMap);
            ValidatorUtil.validateCondition(((JoinInputStream) inputStream).getOnCompare(), tempDefinitionMap, null);

        } else if (inputStream instanceof PatternInputStream) {
            handlePatternElement(((PatternInputStream) inputStream).getPatternElement(), definitionMap, tempDefinitionMap);
        }
        return tempDefinitionMap;
    }

    private static void handlePatternElement(PatternElement patternElement, Map<String, StreamDefinition> definitionMap, Map<String, StreamDefinition> tempDefinitionMap) throws ValidatorException {
        if (patternElement instanceof FollowedByElement) {
            handlePatternElement(((FollowedByElement) patternElement).getPatternElement(), definitionMap, tempDefinitionMap);
            handlePatternElement(((FollowedByElement) patternElement).getFollowedByPatternElement(), definitionMap, tempDefinitionMap);
        } else if (patternElement instanceof BasicSingleInputStream) {
            InStreamValidator.validate((BasicSingleInputStream) patternElement, definitionMap, tempDefinitionMap);
        }
    }


    public static void validate(Query query, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        Map<String, StreamDefinition> tempDefinition = validateInStream(query.getInputStream(), streamDefinitionMap);
        validateSelector(query.getSelector(), tempDefinition);
        validateOutStream(query.getOutputStream(), tempDefinition, streamDefinitionMap);
    }

    private static void getRelevantDefinitionMap(Map<String, Object> relevantDefinitionMap, List<String> streamIds, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        for (String streamId : streamIds) {
            if (streamDefinitionMap.get(streamId) != null) {
                relevantDefinitionMap.put(streamId, streamDefinitionMap.get(streamId));
            } else {
                throw new ValidatorException("No stream definition found for stream ID " + streamId);
            }
        }
    }

    private static void validateOutStream(OutputStream outputStream, Map<String, StreamDefinition> relevantDefinitionMap, Map<String, StreamDefinition> definitionMap) throws ValidatorException {
        StreamDefinition definition = relevantDefinitionMap.get(null);
        definition.setId(outputStream.getStreamId());
        StreamValidator.validate(definitionMap, definition);
        definitionMap.put(definition.getStreamId(), definition);
    }

    private static void validateSelector(Selector selector, Map<String, StreamDefinition> streamDefinitionMap) throws ValidatorException {
        SelectorValidator.validate(selector, streamDefinitionMap);
    }

    private static List<StreamDefinition> getRelevantDefinitions(List<String> streamIds, Map<String, StreamDefinition> streamDefinitionMap, Map<String, String> renameHandlerMap) throws ValidatorException {
        ArrayList<StreamDefinition> result = new ArrayList<StreamDefinition>(streamIds.size());
        for (String streamId : streamIds) {
            if (renameHandlerMap.get(streamId) != null) {
                streamId = renameHandlerMap.get(streamId);                         //handling renaming
            }
            if (streamDefinitionMap.get(streamId) != null) {
                result.add(streamDefinitionMap.get(streamId));
            } else {
                throw new ValidatorException("No stream definition found for stream ID " + streamId);
            }
        }
        return result;
    }
}
