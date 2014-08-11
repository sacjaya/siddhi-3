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

package org.wso2.siddhi.core.query.processor.handler;

import org.wso2.siddhi.core.query.selector.QuerySelector;

/**
 * Super class for Single/Join/Pattern Handler Processors.
 */
public abstract class BasicHandlerProcessor implements HandlerProcessor {

    protected QuerySelector selector;

    /**
     * Set the QuerySelector of the handler processor
     *
     * @param querySelector
     */
    public void setSelector(QuerySelector querySelector) {
        this.selector = querySelector;
    }

    /**
     * Get querySelector of this Handler Processor
     *
     * @return
     */
    public QuerySelector getSelector() {
        return selector;
    }


}
