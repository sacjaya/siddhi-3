/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.siddhi.core.query.processor.filter;

import org.wso2.siddhi.core.event.*;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.executor.condition.ConditionExecutor;
import org.wso2.siddhi.core.query.processor.Processor;


public class FilterProcessor implements Processor {
    private ConditionExecutor conditionExecutor;
    private Processor next;
    private EventConverter eventConverter = null;

    public FilterProcessor(ConditionExecutor conditionExecutor) {
        this.conditionExecutor = conditionExecutor;
    }

    public StreamEvent process(StreamEvent streamEvent) {
        if (conditionExecutor.execute(streamEvent)) {
            return streamEvent;
        }
        return null;
    }

    @Override
    public void addToNext(Processor processor) {
        if (next == null) {
            this.next = processor;
        } else {
            this.next.addToNext(processor);
        }
    }

    @Override
    public void setEventConverter(EventConverter eventConverter) {
        this.eventConverter = eventConverter;
    }

}
