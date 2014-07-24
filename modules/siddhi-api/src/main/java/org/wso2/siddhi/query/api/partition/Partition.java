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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@linkplain Partition} class is used to represent the definition of
 * a partition for a Siddhi instance. The partition definition consists of a
 * partition ID and a list of partition types that belong to a given definition
 * instance.
 */
public class Partition {

    private Map<String,String> properties = new HashMap<String,String>();
    private List<PartitionType> partitionTypeList = new ArrayList<PartitionType>();
    private List<Query> queryList = new ArrayList<Query>();

//    public Partition partitionBy(Variable variable) {
//        this.partitionTypeList.add(new ValuePartitionType(variable));
//        return this;
//    }
//
//    public Partition partitionBy(Condition condition, String label) {
//        this.partitionTypeList.add(new RangePartitionType(condition, label));
//        return this;
//    }

//    public void addPartitionType(PartitionType partitionType) {
//        this.partitionTypeList.add(partitionType);
//    }

    public static Partition partition() {
        return new Partition();
    }

    public List<PartitionType> getPartitionTypeList() {
        return partitionTypeList;
    }

    public Partition with(String streamId, Expression expression) {
        ValuePartitionType valuePartitionType = new ValuePartitionType(streamId, expression);
        partitionTypeList.add(valuePartitionType);
        //todo handle with
        return this;
    }

    public Partition with(String streamId, RangePartitionType.RangePartitionProperty... rangePartitionProperties) {
        RangePartitionType rangePartitionType = new RangePartitionType(streamId, rangePartitionProperties);
        partitionTypeList.add(rangePartitionType);
        //todo handle with
        return this;
    }

    public Partition addQuery(Query query) {
        //todo handle with
        queryList.add(query);
        return this;
    }

    public List<Query> getQueryList(){
        return queryList;
    }

    public static RangePartitionType.RangePartitionProperty range(String partitionKey, Condition condition) {
        return new RangePartitionType.RangePartitionProperty(partitionKey, condition);
    }

    public Partition property(String key, String value) {
        //todo handel
        properties.put(key,value);
        return this;
    }

    public  String getPropertyValue(String key) {
        //todo handel
        return properties.get(key);
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

}
