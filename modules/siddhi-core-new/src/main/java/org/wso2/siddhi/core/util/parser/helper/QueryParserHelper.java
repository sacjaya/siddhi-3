/*
 *
 *  * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org)
 *  * All Rights Reserved.
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.util.parser.helper;

import org.wso2.siddhi.core.event.state.MetaStateEvent;
import org.wso2.siddhi.core.event.stream.MetaStreamEvent;
import org.wso2.siddhi.core.event.stream.StreamEventConverter;
import org.wso2.siddhi.core.executor.VariableExpressionExecutor;
import org.wso2.siddhi.core.stream.runtime.SingleStreamRuntime;
import org.wso2.siddhi.core.stream.runtime.StreamRuntime;
import org.wso2.siddhi.core.util.SiddhiConstants;
import org.wso2.siddhi.core.util.converter.EventConverter;
import org.wso2.siddhi.query.api.definition.Attribute;

import java.util.List;

/**
 * Utility class for queryParser to help with QueryRuntime
 * generation.
 */
public class QueryParserHelper {

    /**
     * Method to clean/refactor MetaStreamEvent and update
     * VariableExpressionExecutors accordingly.
     *
     * @param metaStreamEvent
     * @param variableExpressionExecutorList
     * @param position
     */
    private static void updateVariablePosition(MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutorList, int[] position) {
        //Position[array ID, index] : Array ID -> outData = 2; afterWindowData = 1; beforeWindowData = 0;
        refactorMetaStreamEvent(metaStreamEvent);       //can remove this and call separately so that we can stop calling repeatedly in partition creation. But then we can't enforce refactoring.
        for (VariableExpressionExecutor variableExpressionExecutor : variableExpressionExecutorList) {
            if (metaStreamEvent.getOutputData().contains(variableExpressionExecutor.getAttribute())) {
                variableExpressionExecutor.setPosition(new int[]{SiddhiConstants.OUTPUT_DATA_INDEX, metaStreamEvent.getOutputData()
                        .indexOf(variableExpressionExecutor.getAttribute())});
            } else if (metaStreamEvent.getAfterWindowData().contains(variableExpressionExecutor.getAttribute())) {
                variableExpressionExecutor.setPosition(new int[]{SiddhiConstants.AFTER_WINDOW_DATA_INDEX, metaStreamEvent
                        .getAfterWindowData().indexOf(variableExpressionExecutor.getAttribute())});
            } else if (metaStreamEvent.getBeforeWindowData().contains(variableExpressionExecutor.getAttribute())) {
                variableExpressionExecutor.setPosition(new int[]{SiddhiConstants.BEFORE_WINDOW_DATA_INDEX, metaStreamEvent
                        .getBeforeWindowData().indexOf(variableExpressionExecutor.getAttribute())});
            }
        }

    }

    /**
     * Helper method to clean/refactor MetaStreamEvent
     *
     * @param metaStreamEvent
     */
    private synchronized static void refactorMetaStreamEvent(MetaStreamEvent metaStreamEvent) {
        for (Attribute attribute : metaStreamEvent.getOutputData()) {
            if (metaStreamEvent.getBeforeWindowData().contains(attribute)) {
                metaStreamEvent.getBeforeWindowData().remove(attribute);
            }
            if (metaStreamEvent.getAfterWindowData().contains(attribute)) {
                metaStreamEvent.getAfterWindowData().remove(attribute);
            }
        }
        for (Attribute attribute : metaStreamEvent.getAfterWindowData()) {
            if (metaStreamEvent.getBeforeWindowData().contains(attribute)) {
                metaStreamEvent.getBeforeWindowData().remove(attribute);
            }
        }
    }

    /**
     * Method to clean/refactor MetaStateEvent and update
     * VariableExpressionExecutors accordingly.
     * @param metaStateEvent
     * @param executors
     */
    public static void updateVariablePosition(MetaStateEvent metaStateEvent, List<VariableExpressionExecutor> executors) {
        if (metaStateEvent.getEventCount() == 1) {
            updateVariablePosition(metaStateEvent.getMetaEvent(0), executors, new int[]{-1, -1});  //position??
        } else {

            //TODO implement
        }
    }

    public static void addEventConverters(StreamRuntime runtime, MetaStateEvent metaStateEvent) {
        int index = 0;
        if (runtime instanceof SingleStreamRuntime) {

            StreamEventConverter converter = new StreamEventConverter(metaStateEvent,null);
            ((SingleStreamRuntime) runtime).getQueryStreamReceiver().setEventConverter(converter);
        } else {
            //TODO JoinStreamRuntime/PatternStreamRuntime
        }
    }
}
