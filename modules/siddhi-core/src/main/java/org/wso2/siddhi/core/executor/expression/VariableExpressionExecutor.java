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
package org.wso2.siddhi.core.executor.expression;

import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.event.InnerStreamEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.util.Constants;
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
    private int[] position = new int[]{-1, -1};


    public VariableExpressionExecutor(String streamIdOfVariable, String attributeName, StreamDefinition definition, boolean processInDefinition) {
        this.attributeName = attributeName;
        if (streamIdOfVariable != null) {
            streamReference = streamIdOfVariable;
        }

        if (definition != null) {
            type = definition.getAttributeType(attributeName);
            attributePosition = definition.getAttributePosition(attributeName);
            position[0] = Constants.OUT_DATA_INDEX;
            position[1] = attributePosition;
            attribute = new Attribute(attributeName, type);
        }
    }

    @Override
    public Object execute(StreamEvent event) {
        switch (position[0]) {
            case (Constants.BEFORE_WINDOW_DATA_INDEX):
                return ((InnerStreamEvent) event).getBeforeWindowData()[position[1]];
            case (Constants.AFTER_WINDOW_DATA_INDEX):
                return ((InnerStreamEvent) event).getOnAfterWindowData()[position[1]];
            case (Constants.OUT_DATA_INDEX):
                return (event).getData()[position[1]];
            case (-1):
                return null; //TODO: exception?
            default:
                return null; //TODO: exception?
        }

    }

    public Attribute.Type getReturnType() {
        return type;
    }


    public String constructFilterQuery(StreamEvent newEvent, int level) {
        Object obj = execute(newEvent);
        if (obj == null) {
            StringBuilder sb = new StringBuilder();
            if (streamPosition >= 0 && level == 0) {
                sb.append("event").append(streamPosition).append(".");
            }
            if (innerStreamPosition >= 0) {
                sb.append("event").append(innerStreamPosition).append(".");
            }
            if (attributePosition >= 0) {
                sb.append("data").append(attributePosition);
            }
            return sb.toString();
        } else if (obj instanceof String) {
            return "'" + obj.toString() + "'";
        } else {
            return obj.toString();
        }
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
