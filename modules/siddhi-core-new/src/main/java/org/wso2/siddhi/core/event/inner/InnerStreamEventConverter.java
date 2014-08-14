package org.wso2.siddhi.core.event.inner;

import org.wso2.siddhi.core.event.stream.StreamEvent;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.core.util.SiddhiConstants;
import org.wso2.siddhi.query.api.definition.Attribute;
import org.wso2.siddhi.query.api.definition.StreamDefinition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suho on 8/14/14.
 */
public class InnerStreamEventConverter {
    private ArrayList<ConverterElement> converterElements;       //List to hold information needed for conversion

    private int beforeWindowDataSize;
    private int onAfterWindowDataSize;
    private int outputDataSize;


    /**
     * Creation and initialization of EventConverter. This will create
     * relevant infrastructure for event conversion.
     *
     * @param metaInnerStreamEvent
     * @param defaultDefinition
     */
    public InnerStreamEventConverter(MetaInnerStreamEvent metaInnerStreamEvent, StreamDefinition defaultDefinition) {
        this.beforeWindowDataSize = metaInnerStreamEvent.getBeforeWindowData().size();
        this.onAfterWindowDataSize = metaInnerStreamEvent.getAfterWindowData().size();
        this.outputDataSize = metaInnerStreamEvent.getOutputData().size();

        int size = metaInnerStreamEvent.getBeforeWindowData().size() + metaInnerStreamEvent.getAfterWindowData().size() + metaInnerStreamEvent.getOutputData().size();
        converterElements = new ArrayList<ConverterElement>(size);

        for (int j = 0; j < 3; j++) {
            List<Attribute> currentDataList = null;
            if (j == 0) {
                currentDataList = metaInnerStreamEvent.getBeforeWindowData();
            } else if (j == 1) {
                currentDataList = metaInnerStreamEvent.getAfterWindowData();
            } else if (j == 2) {
                currentDataList = metaInnerStreamEvent.getOutputData();
            }
            if (currentDataList != null) {
                int i = 0;
                for (Attribute attribute : currentDataList) {           //Only variable slots will be filled.
                    if (!(attribute instanceof ComplexAttribute)) {
                        ConverterElement converterElement = new ConverterElement();
                        int[] position = new int[2];
                        converterElement.setFromPosition(defaultDefinition.getAttributePosition(attribute.getName()));
                        position[0] = j;
                        position[1] = i;
                        converterElement.setToPosition(position);
                        converterElements.add(converterElement);
                        i++;
                    }
                }
            }
        }
    }


    public InnerStreamEvent convertToInnerStreamEvent(Object[] data, boolean isExpected, long timestamp) {

        InnerStreamEvent innerStreamEvent = new InnerStreamEvent(beforeWindowDataSize,onAfterWindowDataSize,outputDataSize);  //todo get from pool

        for (ConverterElement converterElement : converterElements) {
            if (converterElement.getToPosition()[0] == SiddhiConstants.BEFORE_WINDOW_DATA_INDEX) {
                innerStreamEvent.getBeforeWindowData()[converterElement.getToPosition()[1]] = data[converterElement.getFromPosition()];
            } else if (converterElement.getToPosition()[0] == SiddhiConstants.AFTER_WINDOW_DATA_INDEX) {
                innerStreamEvent.getOnAfterWindowData()[converterElement.getToPosition()[1]] = data[converterElement.getFromPosition()];
            } else if (converterElement.getToPosition()[0] == SiddhiConstants.OUTPUT_DATA_INDEX) {
                innerStreamEvent.getOutputData()[converterElement.getToPosition()[1]] = data[converterElement.getFromPosition()];
            }
        }

        innerStreamEvent.setExpired(isExpected);
        innerStreamEvent.setTimestamp(timestamp);

        return innerStreamEvent;
    }

    /**
     * This will return the InnerStreamEvent.
     *
     * @param streamEvent event to be converted
     * @return
     */
    public InnerStreamEvent convertToInnerStreamEvent(StreamEvent streamEvent) {
        return convertToInnerStreamEvent(streamEvent.getData(), streamEvent.isExpired(), streamEvent.getTimestamp());
    }

    public InnerStreamEvent convertToInnerStreamEvent(InnerStreamEvent innerStreamEvent) {
        return convertToInnerStreamEvent(innerStreamEvent.getOutputData(), innerStreamEvent.isExpired(), innerStreamEvent.getTimestamp());
    }

    /**
     * Element to hold helper information to event
     * conversion process
     */
    public class ConverterElement {
        private int fromPosition;               //position of StreamEvent
        private int[] toPosition = new int[2];  //new position in InnerStreamEvent

        public int[] getToPosition() {
            return toPosition;
        }

        public void setToPosition(int[] toPosition) {
            this.toPosition = toPosition;
        }

        public int getFromPosition() {
            return fromPosition;
        }

        public void setFromPosition(int fromPosition) {
            this.fromPosition = fromPosition;
        }
    }
}
