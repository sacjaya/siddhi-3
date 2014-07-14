/*
 * Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.query.api.partition;

import org.wso2.siddhi.query.api.condition.Condition;

public class RangePartitionType implements PartitionType {

    private final String streamId;
    private final RangePartitionProperty[] rangePartitionProperties;

    public RangePartitionType(String streamId, RangePartitionProperty[] rangePartitionProperties) {

        this.streamId = streamId;
        this.rangePartitionProperties = rangePartitionProperties;
    }

    public String getStreamId() {
        return streamId;
    }

    public RangePartitionProperty[] getRangePartitionProperties() {
        return rangePartitionProperties;
    }


    public static class RangePartitionProperty  {
        private final String partitionKey;
        private final Condition condition;

        public RangePartitionProperty(String partitionKey, Condition condition) {

            this.partitionKey = partitionKey;
            this.condition = condition;
        }

        public String getPartitionKey() {
            return partitionKey;
        }

        public Condition getCondition() {
            return condition;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RangePartitionProperty that = (RangePartitionProperty) o;

            if (!condition.equals(that.condition)) return false;
            if (!partitionKey.equals(that.partitionKey)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = partitionKey.hashCode();
            result = 31 * result + condition.hashCode();
            return result;
        }
    }
}
