/*
*  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.siddhi.core.event.inner;

import com.lmax.disruptor.EventFactory;

/**
 * Event Factory to create new InnerStreamEvents
 */
public class InnerStreamEventFactory implements EventFactory<InnerStreamEvent> {

    private int beforeWindowDataSize;
    private int onAfterWindowDataSize;
    private int outputDataSize;

    /**
     * Initialization of the factory with event data sizes
     *
     * @param beforeWindowDataSize
     * @param onAfterWindowDataSize
     * @param outputDataSize
     */
    public InnerStreamEventFactory(int beforeWindowDataSize, int onAfterWindowDataSize, int outputDataSize) {
        this.beforeWindowDataSize = beforeWindowDataSize;
        this.onAfterWindowDataSize = onAfterWindowDataSize;
        this.outputDataSize = outputDataSize;
    }

    /**
     * Constructs new Events
     *
     * @return InnerStreamEvent
     */
    public InnerStreamEvent newInstance() {
        return new InnerStreamEvent(beforeWindowDataSize, onAfterWindowDataSize, outputDataSize);
    }

}