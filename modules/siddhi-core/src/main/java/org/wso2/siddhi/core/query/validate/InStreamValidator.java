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
package org.wso2.siddhi.core.query.validate;

import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.query.input.BasicStream;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.input.handler.Filter;

import java.util.Map;

public class InStreamValidator {
    private Map<String, StreamDefinition> streamDefinitionMap;
    private Map<String, String> renameHandlerMap;       //to handle stream renaming

    public InStreamValidator(Map<String, StreamDefinition> streamDefinitionMap, Map<String, String> renameHandlerMap) {
        this.streamDefinitionMap = streamDefinitionMap;
        this.renameHandlerMap = renameHandlerMap;
    }

    public Boolean validate(InputStream inputStream){
        if(inputStream instanceof BasicStream){
            return validateBasicStream((BasicStream)inputStream);
        }
        return false;
    }

    private Boolean validateBasicStream(BasicStream inputStream) {
        String id = inputStream.getStreamId();
        String refId = inputStream.getStreamReferenceId();
        if(refId != null) {                                 //Populate renameMap
            if (!id.equals(refId)) {
                renameHandlerMap.remove(id);
                renameHandlerMap.put(refId, id);
            }
        }
        if(!streamDefinitionMap.containsKey(id)){
            return false;
        }
        Filter filter = inputStream.getFilter();
        ValidatorUtil validatorUtil = new ValidatorUtil(streamDefinitionMap);
        return validatorUtil.validateCondition(filter.getFilterCondition(),id);
    }
}
