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

package org.wso2.siddhi.core.util;

import org.wso2.siddhi.core.event.MetaStreamEvent;
import org.wso2.siddhi.core.executor.expression.VariableExpressionExecutor;
import org.wso2.siddhi.query.api.definition.Attribute;

import java.util.List;

public class MetaStreamEventHelper {

    public static void updateVariablePosition(MetaStreamEvent metaStreamEvent, List<VariableExpressionExecutor> variableExpressionExecutorList) {
        //Position[array ID, index] : Array ID -> outData = 2; afterWindowData = 1; beforeWindowData = 0;
        refactorMetaStreamEvent(metaStreamEvent);       //can remove this and call separately so that we can stop calling repeatedly in partition creation. But then we can't enforce refactoring.
        for (VariableExpressionExecutor variableExpressionExecutor : variableExpressionExecutorList) {
            if (metaStreamEvent.getOutData().contains(variableExpressionExecutor.getAttribute())) {
                variableExpressionExecutor.setPosition(new int[]{Constants.OUT_DATA_INDEX, metaStreamEvent.getOutData()
                        .indexOf(variableExpressionExecutor.getAttribute())});
            } else if (metaStreamEvent.getAfterWindowData().contains(variableExpressionExecutor.getAttribute())) {
                variableExpressionExecutor.setPosition(new int[]{Constants.AFTER_WINDOW_DATA_INDEX, metaStreamEvent
                        .getAfterWindowData().indexOf(variableExpressionExecutor.getAttribute())});
            } else if (metaStreamEvent.getBeforeWindowData().contains(variableExpressionExecutor.getAttribute())) {
                variableExpressionExecutor.setPosition(new int[]{Constants.BEFORE_WINDOW_DATA_INDEX, metaStreamEvent
                        .getBeforeWindowData().indexOf(variableExpressionExecutor.getAttribute())});
            }
        }

    }

    public synchronized static void refactorMetaStreamEvent(MetaStreamEvent metaStreamEvent) {
        for (Attribute attribute : metaStreamEvent.getOutData()) {
            if (metaStreamEvent.getBeforeWindowData().contains(attribute)) {
                metaStreamEvent.getBeforeWindowData().remove(attribute);
            } else if (metaStreamEvent.getAfterWindowData().contains(attribute)) {
                metaStreamEvent.getAfterWindowData().remove(attribute);
            }
        }
        for (Attribute attribute : metaStreamEvent.getAfterWindowData()) {
            if (metaStreamEvent.getBeforeWindowData().contains(attribute)) {
                metaStreamEvent.getBeforeWindowData().remove(attribute);
            }
        }
    }
}
