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

import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.StreamEvent;
import org.wso2.siddhi.core.executor.condition.ConditionExecutor;
import org.wso2.siddhi.core.extension.EternalReferencedHolder;
import org.wso2.siddhi.core.query.processor.PreSelectProcessingElement;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.snapshot.SnapshotObject;
import org.wso2.siddhi.core.snapshot.Snapshotable;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.expression.Expression;

import java.util.Iterator;
import java.util.concurrent.locks.Lock;

/**
* The common interface for all windows, windows always holds RemoveEvents within them.
* This only processes InStreamEvents
*/
public abstract class WindowProcessor extends Processor implements Snapshotable, PreSelectProcessingElement, EternalReferencedHolder {
    protected static final Logger log = Logger.getLogger(WindowProcessor.class);

    protected String elementId;
    protected SiddhiContext siddhiContext;
    private Lock lock;
    protected QuerySelector nextProcessor;
    protected AbstractDefinition definition;
    protected boolean async;
    protected Expression[] parameters;

    public void setParameters(Expression[] parameters) {
        this.parameters = parameters;
    }

    public void setDefinition(AbstractDefinition definition) {
        this.definition = definition;
    }

    public void setAsync(boolean async) {
        this.async = async;
    }


    public void process(StreamEvent streamEvent) {

            processEvent(streamEvent);

    }

    protected abstract void processEvent(StreamEvent event);


//    public abstract Iterator<StreamEvent> iterator();
//
//    public abstract Iterator<StreamEvent> iterator(String predicate);
//
//    public Iterator<StreamEvent> iterator(StreamEvent streamEvent, ConditionExecutor conditionExecutor) {
//        return null;
//    }


    @Override
    public String getElementId() {
        return elementId;
    }

    @Override
    public final SnapshotObject snapshot() {
       return new SnapshotObject(currentState());
    }

    protected abstract Object[] currentState();

    @Override
    public final void restore(SnapshotObject snapshotObject) {
        restoreState(snapshotObject.getData());
    }

    protected abstract void restoreState(Object[] data);

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    protected void acquireLock() {
        if (lock != null) {
            if (log.isDebugEnabled()) {
                log.debug(lock + " trying to acquire window Lock");
            }
            lock.lock();
            if (log.isDebugEnabled()) {
                log.debug(lock + " window locked");
            }
        }
    }

    protected void releaseLock() {
        if (lock != null) {
            try {
                lock.unlock();
            } catch (IllegalMonitorStateException e) {
                log.warn(e.getMessage());
            }
            if (log.isDebugEnabled()) {
                log.debug(lock + " window unlocked");
            }
        }
    }



    @Override
    public void setNext(QuerySelector querySelector) {
        this.nextProcessor = querySelector;
    }

    public void setSiddhiContext(SiddhiContext siddhiContext) {
        this.siddhiContext = siddhiContext;
    }

    public final void initWindow() {
        init(parameters,  definition, elementId, async, siddhiContext);
    }

    protected abstract void init(Expression[] parameters, AbstractDefinition streamDefinition, String elementId, boolean async, SiddhiContext siddhiContext);


}
