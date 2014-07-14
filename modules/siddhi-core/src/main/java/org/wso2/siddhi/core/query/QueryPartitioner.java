/*
*  Copyright (c) 2005-2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.siddhi.core.query;

import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.query.creator.QueryCreator;
import org.wso2.siddhi.core.query.processor.PreSelectProcessingElement;
import org.wso2.siddhi.core.query.processor.handler.HandlerProcessor;
import org.wso2.siddhi.core.query.selector.QuerySelector;
import org.wso2.siddhi.core.util.QueryPartComposite;

import java.util.*;

public class QueryPartitioner {
    private final QueryCreator queryCreator;
    private List<QuerySelector> querySelectorList;

    public QueryPartitioner(QueryCreator queryCreator, List<QuerySelector> querySelectorList,
                            SiddhiContext siddhiContext) {
        this.queryCreator = queryCreator;
        this.querySelectorList = querySelectorList;

    }

    public List<HandlerProcessor> constructPartition() {
        QueryPartComposite queryPartComposite = queryCreator.constructQuery();
        querySelectorList.add(queryPartComposite.getQuerySelector());
        for (PreSelectProcessingElement preSelectProcessingElement : queryPartComposite.getPreSelectProcessingElementList()) {
            preSelectProcessingElement.setNext(queryPartComposite.getQuerySelector());
        }
        return queryPartComposite.getHandlerProcessorList();
    }

}
