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
import org.wso2.siddhi.query.api.expression.Expression;
import org.wso2.siddhi.query.api.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * {@linkplain Partition} class is used to represent the definition of
 * a partition for a Siddhi instance. The partition definition consists of a
 * partition ID and a list of partition types that belong to a given definition
 * instance.
 */
public class Partition {

    private List<PartitionType> partitionTypeList = new ArrayList<PartitionType>();
    private Query query;

//    public Partition partitionBy(Variable variable) {
//        this.partitionTypeList.add(new VariablePartitionType(variable));
//        return this;
//    }
//
//    public Partition partitionBy(Condition condition, String label) {
//        this.partitionTypeList.add(new RangePartitionType(condition, label));
//        return this;
//    }

    public void addPartitionType(PartitionType partitionType) {
        this.partitionTypeList.add(partitionType);
    }

    public List<PartitionType> getPartitionTypeList() {
        return partitionTypeList;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "partitionTypeList=" + partitionTypeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Partition that = (Partition) o;

        if (partitionTypeList != null ? !partitionTypeList.equals(that.partitionTypeList) : that.partitionTypeList != null) {
            return false;
        }

        return true;
    }

    public static Partition partition() {
        return new Partition();
    }

    public Partition with(String streamId, Expression expression) {
        new VariablePartitionType(streamId,expression);
        //todo handle with
        return this;
    }

    public Partition with(String streamId, Condition ...conditions) {
         new RangePartitionType(streamId,conditions);
        //todo handle with
        return this;
    }

    public Partition addQuery(Query query) {
        //todo handle with
        this.query = query;
        return this;
    }


}
