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

package org.wso2.siddhi.query.api.execution.partition;

import org.wso2.siddhi.query.api.annotation.Annotation;
import org.wso2.siddhi.query.api.execution.ExecutionElement;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.api.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * {@linkplain Partition} class is used to represent the definition of
 * a partition for a Siddhi instance.
 */
public class Partition implements ExecutionElement {

    private List<PartitionType> partitionTypeList = new ArrayList<PartitionType>();
    private List<Query> queryList = new ArrayList<Query>();
    private List<Annotation> annotations = new ArrayList<Annotation>();

    public static Partition partition() {
        return new Partition();
    }

    public List<PartitionType> getPartitionTypeList() {
        return partitionTypeList;
    }

    public Partition with(String streamId, Expression expression) {
        ValuePartitionType valuePartitionType = new ValuePartitionType(streamId, expression);
        partitionTypeList.add(valuePartitionType);
        //todo handle duplicate
        return this;
    }

    public Partition with(String streamId, RangePartitionType.RangePartitionProperty... rangePartitionProperties) {
        PartitionType rangePartitionType = new RangePartitionType(streamId, rangePartitionProperties);
        partitionTypeList.add(rangePartitionType);
        //todo handle duplicate
        return this;
    }

    public Partition with(PartitionType partitionType) {
        partitionTypeList.add(partitionType);
        //todo handle duplicate
        return this;
    }

    public Partition addQuery(Query query) {
        //todo validate
        queryList.add(query);
        return this;
    }

    public List<Query> getQueryList(){
        return queryList;
    }

    public static RangePartitionType.RangePartitionProperty range(String partitionKey, Expression condition) {
        return new RangePartitionType.RangePartitionProperty(partitionKey, condition);
    }

    public Partition annotation(Annotation annotation) {
        annotations.add(annotation);
        return this;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public List<Annotation> getAnnotations(String name) {
        List<Annotation> annotationList=new ArrayList<Annotation>();
        for(Annotation annotation: annotations){
            if(name.equals(annotation.getName())){
                annotationList.add( annotation);
            }
        }
        return annotationList;
    }

    @Override
    public String toString() {
        return "Partition{" +
                "partitionTypeList=" + partitionTypeList +
                ", queryList=" + queryList +
                ", annotations=" + annotations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partition)) return false;

        Partition partition = (Partition) o;

        if (annotations != null ? !annotations.equals(partition.annotations) : partition.annotations != null)
            return false;
        if (partitionTypeList != null ? !partitionTypeList.equals(partition.partitionTypeList) : partition.partitionTypeList != null)
            return false;
        if (queryList != null ? !queryList.equals(partition.queryList) : partition.queryList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = partitionTypeList != null ? partitionTypeList.hashCode() : 0;
        result = 31 * result + (queryList != null ? queryList.hashCode() : 0);
        result = 31 * result + (annotations != null ? annotations.hashCode() : 0);
        return result;
    }
}
