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
package org.wso2.siddhi.core.query.processor.window;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.InnerStreamEvent;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.event.remove.RemoveEvent;
import org.wso2.siddhi.core.query.QueryProcessingElement;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.expression.constant.IntConstant;

import java.util.ArrayList;

public class LengthWindowProcessor extends WindowProcessor {

    private int lengthToKeep;
    private ArrayList<StreamEvent> window;
    QueryProcessingElement next = null;


    @Override
    protected void processEvent(StreamEvent event) {
        acquireLock();
        try {
            RemoveEvent removeEvent = new RemoveEvent(event,System.currentTimeMillis());
            removeEvent.setOnAfterWindowData(((InnerStreamEvent)event).getOnAfterWindowData());
            window.add(removeEvent);
            if (window.size() > lengthToKeep) {
                next.process(window.remove(0));
            }
            next.process(event);
        } finally {
            releaseLock();
        }

    }



    @Override
    protected Object[] currentState() {
        return null;
    }

    @Override
    protected void restoreState(Object[] data) {

    }


    @Override
    protected void init(Expression[] parameters, AbstractDefinition streamDefinition, String elementId, boolean async, SiddhiContext siddhiContext) {
        lengthToKeep = ((IntConstant) parameters[0]).getValue();
        window = new ArrayList<StreamEvent>();
    }

    @Override
    public void destroy(){

    }

//    @Override
//    public void addToNext(QueryProcessingElement processor) {
//        if (next == null) {
//            this.next = processor;
//        } else {
//            ((Processor)this.next).addToNext(processor);
//        }
//    }

    @Override
    public void addToLast(QueryProcessingElement processor) {
        if (next == null) {
            this.next = processor;
        } else {
            ((Processor)this.next).addToLast(processor);
        }
    }

    @Override
    public QueryProcessingElement getNext() {
        return next;
    }
}
