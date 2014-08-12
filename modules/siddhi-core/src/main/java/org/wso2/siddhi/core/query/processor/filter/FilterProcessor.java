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

import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.executor.condition.ConditionExecutor;
import org.wso2.siddhi.core.query.QueryProcessingElement;
import org.wso2.siddhi.core.query.processor.Processor;


public class FilterProcessor extends Processor {
    private ConditionExecutor conditionExecutor;
    QueryProcessingElement next = null;

    public FilterProcessor(ConditionExecutor conditionExecutor) {
        this.conditionExecutor = conditionExecutor;
    }

    public void process(StreamEvent streamEvent) {
        if (conditionExecutor.execute(streamEvent)) {
            if (this.next != null) {
               this.next.process(streamEvent);
            }

        }
//        this.next.process(streamEvent);
    }

    @Override
    public QueryProcessingElement getNext() {
        return next;
    }

    @Override
    public void addToNext(QueryProcessingElement processor) {
        if (next == null) {
            this.next = processor;
        } else {
            ((Processor)this.next).addToNext(processor);
        }
    }

}
