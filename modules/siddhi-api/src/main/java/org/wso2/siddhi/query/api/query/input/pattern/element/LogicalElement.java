/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org) All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.siddhi.query.api.query.input.pattern.element;

import org.wso2.siddhi.query.api.query.input.BasicSingleInputStream;

public class LogicalElement implements PatternElement {
    BasicSingleInputStream standardStream1;
    Type type;
    BasicSingleInputStream standardStream2;

    public LogicalElement(BasicSingleInputStream standardStream1, Type type,
                          BasicSingleInputStream standardStream2) {
        this.standardStream1 = standardStream1;
        this.type = type;
        this.standardStream2 = standardStream2;
    }

    public BasicSingleInputStream getStandardStream1() {
        return standardStream1;
    }

    public BasicSingleInputStream getStandardStream2() {
        return standardStream2;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        AND, OR
    }
}
