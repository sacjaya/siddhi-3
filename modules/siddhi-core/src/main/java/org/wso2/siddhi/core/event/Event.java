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
 * This is the event interface exposed to the user.
 */
public interface Event {
    /**
     * This should return the timestamp associated with the event.
     *
     * @return
     */
    long getTimeStamp();

    /**
     * This should return the object[] which holds attribute values of the event
     *
     * @return
     */
    Object[] getData();

    /**
     * This should return object in the ith position of attribute array.
     *
     * @param i array index
     * @return
     */
    Object getData(int i);

    /**
     * This should return whether the message is expired
     *
     * @return
     */
    Boolean isExpired();
}
