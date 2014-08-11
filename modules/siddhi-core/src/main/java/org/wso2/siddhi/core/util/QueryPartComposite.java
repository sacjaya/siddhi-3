/*
*  Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.siddhi.core.util;

import org.wso2.siddhi.core.query.processor.PreSelectProcessingElement;
import org.wso2.siddhi.core.query.processor.handler.BasicHandlerProcessor;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.selector.QuerySelector;

import java.util.ArrayList;
import java.util.List;

public class QueryPartComposite {
    private List<PreSelectProcessingElement> preSelectProcessingElementList = new ArrayList<PreSelectProcessingElement>();
    private List<BasicHandlerProcessor> handlerProcessorList = new ArrayList<BasicHandlerProcessor>();//TODO review and remove
    private BasicHandlerProcessor handlerProcessor;

    public List<PreSelectProcessingElement> getPreSelectProcessingElementList() {
        return preSelectProcessingElementList;
    }

    public List<BasicHandlerProcessor> getHandlerProcessorList() {
        return handlerProcessorList;
    }

    public void setHandlerProcessor(BasicHandlerProcessor handlerProcessor) {
        this.handlerProcessor = handlerProcessor;
    }

    public BasicHandlerProcessor getHandlerProcessor() {
        return handlerProcessor;
    }

}