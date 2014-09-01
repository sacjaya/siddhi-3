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
package org.wso2.siddhi.core.event.stream;

import org.wso2.siddhi.core.event.ComplexMetaEvent;
import org.wso2.siddhi.core.query.selector.attribute.ComplexAttribute;
import org.wso2.siddhi.query.api.definition.AbstractDefinition;
import org.wso2.siddhi.query.api.definition.Attribute;

import java.util.ArrayList;
import java.util.List;


/**
 * Class to hold mapping between Event
 * and StreamEvent. This will be eventually
 * used to update variable positions on Variable executors
 */
public class MetaStreamEvent implements ComplexMetaEvent{
    private List<Attribute> beforeWindowData = new ArrayList<Attribute>();
    private List<Attribute> afterWindowData = null;
    private List<Attribute> outputData = null;
    private AbstractDefinition definition;      //check Abstract/Stream Definition
    private String referenceId;

    public List<Attribute> getBeforeWindowData() {
        return beforeWindowData;
    }

    public List<Attribute> getAfterWindowData() {
        if (afterWindowData != null) {
            return afterWindowData;
        } else {
            return new ArrayList<Attribute>();  //return empty arraylist to avoid NPE
        }
    }

    public List<Attribute> getOutputData() {
        if (outputData != null) {
            return outputData;
        } else {
            return new ArrayList<Attribute>();  //return empty arraylist to avoid NPE
        }
    }

    public void intializeAfterWindowData() {
        if (afterWindowData == null) {
            afterWindowData = new ArrayList<Attribute>();
        }
    }

    public void intializeOutData() {
        if (afterWindowData == null) {
            afterWindowData = new ArrayList<Attribute>();
        }
        if (outputData == null) {
            outputData = new ArrayList<Attribute>();
        }
    }

    /**
     * Universal method to add data to MetaStream event.
     * Will make sure event will be added to corresponding array by
     * initializing them accordingly.
     *
     * @param attribute
     */
    @Override
    public void addData(Attribute attribute) {
        if (outputData != null) {
            if (outputData.size() > 0 && outputData.get(outputData.size() - 1) instanceof ComplexAttribute) {
                if (!((ComplexAttribute) outputData.get(outputData.size() - 1)).isInitialized()) {   //if last element is a not initialized function attribute,
                    afterWindowData.add(attribute);                                             //then reserve that spot for result of function and
                } else {                                                                        //allocate position for actual variable
                    outputData.add(attribute);
                }
            } else {
                outputData.add(attribute);
            }
        } else if (afterWindowData != null) {
            if (!afterWindowData.contains(attribute)) {
                afterWindowData.add(attribute);
            }
        } else {
            if (!beforeWindowData.contains(attribute)) {
                beforeWindowData.add(attribute);
            }
        }
    }

    public AbstractDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(AbstractDefinition definition) {
        this.definition = definition;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }


}
