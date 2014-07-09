/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.siddhi.core.executor.condition;

import org.wso2.siddhi.core.event.StreamEvent;

public class OrConditionExecutor implements ConditionExecutor {

    public ConditionExecutor leftConditionExecutor;
    public ConditionExecutor rightConditionExecutor;

    public OrConditionExecutor(ConditionExecutor leftConditionExecutor,
                               ConditionExecutor rightConditionExecutor) {
        this.leftConditionExecutor = leftConditionExecutor;
        this.rightConditionExecutor = rightConditionExecutor;
    }

    public boolean execute(StreamEvent event) {
        return leftConditionExecutor.execute(event) || rightConditionExecutor.execute(event);
    }

    @Override
    public String constructFilterQuery(StreamEvent newEvent, int level) {
        return constructQuery(newEvent, level);
    }

    public String constructQuery(StreamEvent newEvent, int level) {
        String left, right;
        left = leftConditionExecutor.constructFilterQuery(newEvent, 1);
        right = rightConditionExecutor.constructFilterQuery(newEvent, 1);

        if (left.equals("*") && right.equals("*")) {
            return "*";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(left).append(") or (").append(right).append(")");
            return sb.toString();
        }
    }

}
