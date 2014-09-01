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

package org.wso2.siddhi.core.util.converter;

import org.wso2.siddhi.core.event.stream.MetaStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.core.util.SiddhiConstants;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * EventConverter class to convert StreamEvents to InnerStreamEvents.
 * EventConverter will be initialized at the time of query creation and
 * set into relevant Processor.
 */
public class EventConverter {
    private ArrayList<ConverterMetaElement> converterHelper;       //List to hold information needed for conversion
    private int beforeWindowDataSize;
    private int afterWindowDataSize;
    private int outDataSize;


    /**
     * Creation and initialization of EventConverter. This will create
     * relevant infrastructure for event conversion.
     *
     * @param metaStreamEvent
     */
    public EventConverter(MetaStreamEvent metaStreamEvent) {
        StreamDefinition defaultDefinition = (StreamDefinition) metaStreamEvent.getDefinition();
        this.beforeWindowDataSize = metaStreamEvent.getBeforeWindowData().size();
        this.afterWindowDataSize = metaStreamEvent.getAfterWindowData().size();
        this.outDataSize = metaStreamEvent.getOutputData().size();

        int size = metaStreamEvent.getBeforeWindowData().size() + metaStreamEvent.getAfterWindowData().size() + metaStreamEvent.getOutputData().size();
        converterHelper = new ArrayList<ConverterMetaElement>(size);

        for (int j = 0; j < 3; j++) {
            List<Attribute> currentDataList = null;
            if (j == 0) {
                currentDataList = metaStreamEvent.getBeforeWindowData();
            } else if (j == 1) {
                currentDataList = metaStreamEvent.getAfterWindowData();
            } else if (j == 2) {
                currentDataList = metaStreamEvent.getOutputData();
            }
            if (currentDataList != null) {
                int i = 0;
                for (Attribute attribute : currentDataList) {           //Only variable slots will be filled.
                    if (!(attribute instanceof ComplexAttribute)) {
                        ConverterMetaElement converterMetaElement = new ConverterMetaElement();
                        int[] position = new int[2];
                        converterMetaElement.setFromPosition(defaultDefinition.getAttributePosition(attribute.getName()));
                        position[0] = j;
                        position[1] = i;
                        converterMetaElement.setToPosition(position);
                        converterHelper.add(converterMetaElement);
                        i++;
                    }
                }
            }
        }
    }

    /**
     * This will return the InnerStreamEvent.
     *
     * @param data event data to be converted
     * @return
     */
    public StreamEvent constructStreamEvent(Object[] data) {

        StreamEvent streamEvent = new StreamEvent();
        Object[] beforeWindowData = new Object[beforeWindowDataSize];
        Object[] afterWindowData = new Object[afterWindowDataSize];
        Object[] outData = new Object[outDataSize];

        for (ConverterMetaElement converterMetaElement : converterHelper) {
            if (converterMetaElement.getToPosition()[0] == SiddhiConstants.BEFORE_WINDOW_DATA_INDEX) {
                beforeWindowData[converterMetaElement.getToPosition()[1]] = data[converterMetaElement.getFromPosition()];
            } else if (converterMetaElement.getToPosition()[0] == SiddhiConstants.AFTER_WINDOW_DATA_INDEX) {
                afterWindowData[converterMetaElement.getToPosition()[1]] = data[converterMetaElement.getFromPosition()];
            } else if (converterMetaElement.getToPosition()[0] == SiddhiConstants.OUTPUT_DATA_INDEX) {
                outData[converterMetaElement.getToPosition()[1]] = data[converterMetaElement.getFromPosition()];
            }
        }

        streamEvent.setBeforeWindowData(beforeWindowData);
        streamEvent.setOnAfterWindowData(afterWindowData);
        streamEvent.setOutputData(outData);

        return streamEvent;
    }
}
