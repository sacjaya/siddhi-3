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

package org.wso2.siddhi.core.config;

import java.util.List;
import java.util.UUID;

public class SiddhiConfiguration {

    /**
     * Number of max events bundled when event rates are high
     */
    private int eventBatchSize;

    /**
     * Identifier to current Siddhi instance
     */
    private String siddhiInstanceIdentifier;

    /**
     * Siddhi Extensions classes
     */
    private List<Class> siddhiExtensions;

    public SiddhiConfiguration() {

        eventBatchSize = 50;
        siddhiInstanceIdentifier = UUID.randomUUID().toString();

    }

    public int getEventBatchSize() {
        return eventBatchSize;
    }

    public SiddhiConfiguration setEventBatchSize(int eventBatchSize) {
        this.eventBatchSize = eventBatchSize;
        return this;
    }

    public SiddhiConfiguration setSiddhiInstanceIdentifier(String siddhiInstanceIdentifier) {
        this.siddhiInstanceIdentifier = siddhiInstanceIdentifier;
        return this;
    }

    public String getSiddhiInstanceIdentifier() {
        return siddhiInstanceIdentifier;
    }

    public List<Class> getSiddhiExtensions() {
        return siddhiExtensions;
    }

    public void setSiddhiExtensions(List<Class> siddhiExtensions) {
        this.siddhiExtensions = siddhiExtensions;
    }
}


