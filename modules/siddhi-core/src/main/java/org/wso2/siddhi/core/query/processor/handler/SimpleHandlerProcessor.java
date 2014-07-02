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

import org.apache.log4j.Logger;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.event.*;

import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.query.api.query.QueryEventSource;

import java.util.concurrent.ThreadPoolExecutor;

public class SimpleHandlerProcessor implements HandlerProcessor{

    static final Logger log = Logger.getLogger(SimpleHandlerProcessor.class);

    private QueryEventSource queryEventSource;
    private ThreadPoolExecutor threadPoolExecutor;
    private SiddhiContext context;

    private QuerySelector next;


    public SimpleHandlerProcessor(QuerySelector querySelector){
                      next = querySelector;
    }

    @Override
    public void receive(StreamEvent streamEvent) {


                processHandler(streamEvent);


    }



    protected void processHandler(StreamEvent streamEvent) {
       if (streamEvent != null) {

                next.process(streamEvent);

        }
    }

    public String getStreamId() {
        return queryEventSource.getSourceId();
    }


}
