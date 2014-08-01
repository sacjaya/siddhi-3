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

import org.wso2.siddhi.core.event.converter.EventConverter;
import org.wso2.siddhi.core.query.processor.Processor;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.stream.StreamReceiver;

public interface HandlerProcessor extends StreamReceiver {

    /**
     * Get first Processor of Processor chain
     *
     * @return
     */
    Processor getProcessor();

    /**
     * Set eventConverter to Handler Processor which does
     * Stream event to InnerStreamEvent conversion
     *
     * @param eventConverter
     */
    void setEventConverter(EventConverter eventConverter);

    /**
     * Set the QuerySelector of the handler
     *
     * @param querySelector
     */
    void setSelector(QuerySelector querySelector);


}
