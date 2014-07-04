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

import org.wso2.siddhi.core.config.ExecutionPlan;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

import java.util.Map;

public class Validator {
    private Map<String,String> renameHandlerMap;    //To handle stream renaming
    private Map<String, StreamDefinition> streamDefinitionMap;//TODO:validation context
    private ExecutionPlan executionPlan;
    //TODO: validate stream definition 1.attri name, duplicate SD

    /*private void populateRenameHandlerMap() {
        for(String key:streamDefinitionMap.keySet()){
            renameHandlerMap.put(key,key);
        }
    }*/

    public static void validate(ExecutionPlan executionPlan) {//TODO:void,execution plan validation context,make stream validator then query validator.
        ValidationContext validationContext = new ValidationContext();
        validationContext.setExecutionPlan(executionPlan);
        validationContext.addStreamDefinitionMap(executionPlan.getStreamDefinitionMap());

        //StreamValidator.validate(validationContext.getStreamDefinitionMap(), definition);

        /*for(Query query: executionPlan.getQueryList()) {
            InStreamValidator inValidator = new InStreamValidator(streamDefinitionMap,renameHandlerMap);
            Boolean inStream = inValidator.validate(query.getInputStream());
        }*/
    }
}
