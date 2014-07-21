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
package org.wso2.siddhi.query.api.query.output.stream;

public class InsertIntoStream extends OutputStream {


    private boolean isPartitioned;

    public InsertIntoStream(String streamId) {
        this(streamId, false, OutputEventsFor.CURRENT_EVENTS);
    }

    public InsertIntoStream(String streamId, OutputEventsFor outputEventsFor) {
        this(streamId, false, outputEventsFor);
    }

    public InsertIntoStream(String streamId, boolean isPartitioned) {
        this(streamId, isPartitioned, OutputEventsFor.CURRENT_EVENTS);
    }

    public InsertIntoStream(String streamId, boolean isPartitioned, OutputEventsFor outputEventsFor) {
        this.isPartitioned = isPartitioned;
        this.streamId = streamId;
        this.outputEventsFor = outputEventsFor;
    }


    public boolean isPartitioned() {
        return isPartitioned;
    }
}
