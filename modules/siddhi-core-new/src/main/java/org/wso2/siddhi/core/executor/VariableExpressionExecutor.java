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
package org.wso2.siddhi.core.executor;

import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.util.SiddhiConstants;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

public class VariableExpressionExecutor implements ExpressionExecutor {
    Attribute attribute;
    Attribute.Type type;
    int streamPosition = -1;
    int attributePosition = -1;
    int innerStreamPosition = -1;  //Simple Event (Default)
    String attributeName;
    String streamReference;
    private int[] position = new int[]{-1, -1,-1,-1};


    public VariableExpressionExecutor(String streamIdOfVariable, String attributeName, StreamDefinition definition) {
        this.attributeName = attributeName;
        if (streamIdOfVariable != null) {
            streamReference = streamIdOfVariable;
        }

        if (definition != null) {
            type = definition.getAttributeType(attributeName);
            attributePosition = definition.getAttributePosition(attributeName);
            position[0] = SiddhiConstants.OUTPUT_DATA_INDEX;
            position[1] = attributePosition;
            attribute = new Attribute(attributeName, type);
        }
    }

    @Override
    public Object execute(StreamEvent event) {
        return event.getAttribute(position);
    }


    public Attribute.Type getReturnType() {
        return type;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }


}
