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
package org.wso2.siddhi.query.api.query.input.sequence;

import org.wso2.siddhi.query.api.expression.constant.Constant;
import org.wso2.siddhi.query.api.query.input.InputStream;
import org.wso2.siddhi.query.api.query.input.StandardInputStream;
import org.wso2.siddhi.query.api.query.input.sequence.element.NextElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.OrElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.RegexElement;
import org.wso2.siddhi.query.api.query.input.sequence.element.SequenceElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SequenceInputStream implements InputStream, SequenceElement {
    private SequenceElement sequenceElement;
    private List<String> streamIdList;
    private Constant within;

    public SequenceInputStream(SequenceElement sequenceElement, Constant within) {
        this.sequenceElement = sequenceElement;
        this.streamIdList = new ArrayList<String>(collectStreamIds(sequenceElement, new HashSet<String>()));
        this.within = within;
    }

    public SequenceElement getSequenceElement() {
        return sequenceElement;
    }

    @Override
    public List<String> getStreamIds() {
        return streamIdList;
    }

//    @Override
//    public List<QueryEventSource> constructQueryEventSourceList(
//            ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap,
//            List<QueryEventSource> queryEventSources) {
//        return constructEventStreamList(getSequenceElement(), streamTableDefinitionMap, queryEventSources);
//    }

    private HashSet<String> collectStreamIds(SequenceElement sequenceElement,
                                             HashSet<String> streamIds) {
        if (sequenceElement instanceof SequenceInputStream) {
            streamIds.addAll(((SequenceInputStream) sequenceElement).getStreamIds());
        } else if (sequenceElement instanceof StandardInputStream) {
            streamIds.addAll(((StandardInputStream) sequenceElement).getStreamIds());
        } else if (sequenceElement instanceof OrElement) {
            collectStreamIds(((OrElement) sequenceElement).getStandardStream1(), streamIds);
            collectStreamIds(((OrElement) sequenceElement).getStandardStream2(), streamIds);
        } else if (sequenceElement instanceof RegexElement) {
            collectStreamIds(((RegexElement) sequenceElement).getStandardStream(), streamIds);
        } else if (sequenceElement instanceof NextElement) {
            collectStreamIds(((NextElement) sequenceElement).getSequenceElement(), streamIds);
            collectStreamIds(((NextElement) sequenceElement).getNextSequenceElement(), streamIds);
        }
        return streamIds;
    }
//
//    public List<QueryEventSource> constructEventStreamList(SequenceElement sequenceElement,
//                                                           ConcurrentMap<String, AbstractDefinition> streamTableDefinitionMap,
//                                                           List<QueryEventSource> queryEventSources) {
//
//
//        if (sequenceElement instanceof StandardInputStream) {
//            //todo fix
//            //   ((StandardInputStream) sequenceElement).constructQueryEventSourceList(streamTableDefinitionMap, queryEventSources);
//        } else if (sequenceElement instanceof OrElement) {
//            constructEventStreamList(((OrElement) sequenceElement).getStandardStream1(), streamTableDefinitionMap, queryEventSources);
//            constructEventStreamList(((OrElement) sequenceElement).getStandardStream2(), streamTableDefinitionMap, queryEventSources);
//        } else if (sequenceElement instanceof RegexElement) {
//            constructEventStreamList(((RegexElement) sequenceElement).getStandardStream(), streamTableDefinitionMap, queryEventSources);
//        } else if (sequenceElement instanceof NextElement) {
//            constructEventStreamList(((NextElement) sequenceElement).getSequenceElement(), streamTableDefinitionMap, queryEventSources);
//            constructEventStreamList(((NextElement) sequenceElement).getNextSequenceElement(), streamTableDefinitionMap, queryEventSources);
//        } else if (sequenceElement instanceof SequenceInputStream) {
//            ((SequenceInputStream) sequenceElement).constructQueryEventSourceList(streamTableDefinitionMap, queryEventSources);
//        }
//
//        return queryEventSources;
//    }

    public Constant getWithin() {
        return within;
    }
}
