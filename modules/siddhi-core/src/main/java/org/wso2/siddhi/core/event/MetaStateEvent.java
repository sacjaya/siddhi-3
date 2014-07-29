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

package org.wso2.siddhi.core.event;

import java.util.ArrayList;
import java.util.List;

/**
 * Container class to hold all MetaStreamEvents corresponding to
 * all StreamEvents in StateEvent.
 */
public class MetaStateEvent {

    private List<MetaStreamEvent> metaStreamEventList = new ArrayList<MetaStreamEvent>();

    public List<MetaStreamEvent> getMetaStreamEventList() {
        return metaStreamEventList;
    }

    public void addMetaStreamEvent(MetaStreamEvent metaStreamEvent) {
        metaStreamEventList.add(metaStreamEvent);
    }


}
