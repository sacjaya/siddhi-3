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
package org.wso2.siddhi.core.query.processor.handler;

import com.lmax.disruptor.dsl.Disruptor;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.query.processor.PreSelectProcessingElement;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.selector.QuerySelector;

public class SimpleHandlerProcessor implements HandlerProcessor, PreSelectProcessingElement {

    private Disruptor[] disruptors;
    private QuerySelector next;
    private Processor processor;
    private String streamId;
    private EventConverter eventConverter;

    public SimpleHandlerProcessor(Processor processor, String streamId) {
        this.processor = processor;
        this.streamId = streamId;
    }

    public SimpleHandlerProcessor(String streamId) {
        this.streamId = streamId;
    }

    @Override
    public void receive(StreamEvent streamEvent) {
        if (eventConverter != null) {
            streamEvent = eventConverter.constructInnerStreamEvent(streamEvent.getData());
        }
        processHandler(streamEvent);
    }

    private void processHandler(String key, StreamEvent streamEvent) {
        streamEvent = processor.process(streamEvent);
        if (streamEvent != null) {
            next.process(streamEvent);
        }
    }

    @Override
    public void setDisruptors(Disruptor[] disruptors) {
        this.disruptors = disruptors;
    }

    @Override
    public String getStreamId() {
        return streamId;
    }

    protected void processHandler(StreamEvent streamEvent) {
        streamEvent = processor.process(streamEvent);
        if (streamEvent != null) {
            next.process(streamEvent);
        }
    }

    @Override
    public Disruptor[] getDisruptors() {
        return disruptors;
    }

    @Override
    public Processor getProcessor() {
        return processor;
    }

    @Override
    public void setEventConverter(EventConverter eventConverter) {
        this.eventConverter = eventConverter;
    }

    @Override
    public void setSelector(QuerySelector querySelector) {
        this.next = querySelector;
    }

    public void setNext(QuerySelector querySelector) {
        this.next = querySelector;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
