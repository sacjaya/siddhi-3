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
import org.wso2.siddhi.core.exception.OperationNotSupportedException;
import org.wso2.siddhi.core.executor.ExpressionExecutor;
import org.wso2.siddhi.query.api.definition.Attribute;

import java.util.Arrays;
import java.util.List;

/**
 * Created by seshika on 4/29/14.
 */
public class SinFunctionExecutor extends FunctionExecutor {

    @Override
    public void init(List<ExpressionExecutor> attributeExpressionExecutors, SiddhiContext siddhiContext) {
        if (attributeSize != 1) {
            throw new OperationNotSupportedException("Sin function has to have exactly 1 parameter, currently " +
                    attributeSize + " parameters provided");
        }
    }

    /**
     * The main executions method which will be called upon event arrival
     *
     * @param data the runtime values of the attributeExpressionExecutors
     * @return
     */
    @Override
    protected Object execute(Object[] data) {
        throw new IllegalStateException("sin cannot execute two data " + Arrays.deepToString(data));
    }

    @Override
    protected Object execute(Object data) {
        return Math.sin(Double.parseDouble(data.toString()));
    }

    @Override
    public Attribute.Type getReturnType() {
        return Attribute.Type.DOUBLE;
    }
}
