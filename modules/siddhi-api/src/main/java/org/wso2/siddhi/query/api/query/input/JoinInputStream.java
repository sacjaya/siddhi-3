/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.query.api.query.input;

import org.wso2.siddhi.query.api.condition.Condition;
import org.wso2.siddhi.query.api.expression.constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class JoinInputStream implements InputStream {

    private InputStream leftInputStream;
    private Type type;
    private InputStream rightInputStream;
    private Condition onCompare;
    private EventTrigger trigger;
    private Constant within;

    public enum Type {JOIN, INNER_JOIN, LEFT_OUTER_JOIN, RIGHT_OUTER_JOIN, FULL_OUTER_JOIN}

    public enum EventTrigger {
        LEFT,RIGHT,ALL
    }
    public JoinInputStream(InputStream leftInputStream, Type type,
                           InputStream rightInputStream, Condition onCompare, Constant within,
                           EventTrigger trigger) {
        this.leftInputStream = leftInputStream;
        this.type = type;
        this.rightInputStream = rightInputStream;
        this.onCompare = onCompare;
        this.within= within;
        this.trigger = trigger;
    }

    public InputStream getLeftInputStream() {
        return leftInputStream;
    }

    public Type getType() {
        return type;
    }

    public InputStream getRightInputStream() {
        return rightInputStream;
    }

    public Condition getOnCompare() {
        return onCompare;
    }

    public EventTrigger getTrigger() {
        return trigger;
    }

    public Constant getWithin() {
        return within;
    }

    @Override
    public List<String> getStreamIds() {
        List<String> list = new ArrayList<String>();
        for (String streamId : leftInputStream.getStreamIds()) {
            if (!list.contains(streamId)) {
                list.add(streamId);
            }
        }
        for (String streamId : rightInputStream.getStreamIds()) {
            if (!list.contains(streamId)) {
                list.add(streamId);
            }
        }
        return list;
    }

//    @Override
//    public List<QueryEventSource> constructQueryEventSourceList(
//            ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap,
//            List<QueryEventSource> queryEventSources) {
//        List<QueryEventSource> queryEventSourceList = leftInputStream.constructQueryEventSourceList(streamTableDefinitionMap, queryEventSources);
//        return rightInputStream.constructQueryEventSourceList(streamTableDefinitionMap, queryEventSourceList);
//    }


}
