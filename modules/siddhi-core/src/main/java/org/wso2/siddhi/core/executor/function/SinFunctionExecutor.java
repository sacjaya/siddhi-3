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

package org.wso2.siddhi.core.executor.function;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.QueryCreationException;
import org.wso2.siddhi.query.api.definition.Attribute;

/**
 * Created by seshika on 4/29/14.
 */
public class SinFunctionExecutor extends FunctionExecutor {

    @Override
    public void init(Attribute.Type[] attributeTypes, SiddhiContext siddhiContext) {
        if (attributeSize != 1) {
            throw new QueryCreationException("Sin function has to have exactly 1 parameter, currently " + attributeSize + " parameters provided");
        }
    }

    @Override
    protected Object process(Object data) {
        return Math.sin(Double.parseDouble(data.toString()));
    }

    @Override
    public void destroy() {
    }

    @Override
    public Attribute.Type getReturnType() {
        return Attribute.Type.DOUBLE;
    }
}
