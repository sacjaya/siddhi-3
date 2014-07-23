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

/**
 * Standard processing event inside Siddhi. InnerStreamEvent will be created
 * from StreamEvent before sending to Stream Handlers.
 */
public class InnerStreamEvent extends StreamEvent {
    private Object[] beforeWindow;          //Attributes before window execution
    private Object[] onAfterWindow;         //Attributes on and after window execution
    private Object[] out;                   //Resulting attributes

    public Object[] getBeforeWindow() {
        return beforeWindow;
    }

    public void setBeforeWindow(Object[] beforeWindow) {
        this.beforeWindow = beforeWindow;
    }

    public Object[] getOnAfterWindow() {
        return onAfterWindow;
    }

    public void setOnAfterWindow(Object[] onAfterWindow) {
        this.onAfterWindow = onAfterWindow;
    }

    public Object[] getOut() {
        return out;
    }

    public void setOut(Object[] out) {
        this.out = out;
    }


}
