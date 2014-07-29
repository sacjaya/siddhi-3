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

import org.wso2.siddhi.query.api.definition.Attribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to hold mapping between StreamEvent
 * and InnerStreamEvent. This will be eventually
 * used to update variable positions on Variable executors
 */
public class MetaStreamEvent {
    private List<Attribute> beforeWindowData = new ArrayList<Attribute>();
    private List<Attribute> afterWindowData = null;
    private List<Attribute> outData = null;

    public List<Attribute> getBeforeWindowData() {
        return beforeWindowData;
    }

    public List<Attribute> getAfterWindowData() {
        return afterWindowData;
    }

    public List<Attribute> getOutData() {
        return outData;
    }

    public void intializeAfterWindowData() {
        if (afterWindowData == null) {
            afterWindowData = new ArrayList<Attribute>();
        }
    }

    public void intializeOutData() {
        if (outData == null) {
            outData = new ArrayList<Attribute>();
        }
    }

    /**
     * Universal method to add data to MetaStream event.
     * Will make sure event will be added to corresponding array by
     * initializing them accordingly.
     *
     * @param attribute
     */
    public void addData(Attribute attribute) { //TODO Handle complex selector attr
        if (outData != null) {
            outData.add(attribute);
        }
        if (afterWindowData != null) {
            afterWindowData.add(attribute);
        }
        beforeWindowData.add(attribute);
    }

}
