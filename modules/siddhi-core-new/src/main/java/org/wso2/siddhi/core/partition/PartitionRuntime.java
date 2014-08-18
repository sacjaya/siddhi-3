/*
 * Copyright (c) 2005 - 2014, WSO2 Inc. (http://www.wso2.org)
 * All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package org.wso2.siddhi.core.partition;

import org.wso2.siddhi.core.query.QueryRuntime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class PartitionRuntime {

    private ConcurrentMap<String,PartitionInstanceRuntime> partitionInstanceRuntimeMap = new ConcurrentHashMap<String, PartitionInstanceRuntime>();



    public PartitionInstanceRuntime getPartitionInstanceRuntime(String key){
        return partitionInstanceRuntimeMap.get(key);
    }

    /**
     * clone all the queries of the partition for a given partition key
     * @param key
     * @return
     */
    public void clone(String key){
        PartitionInstanceRuntime partitionInstance = this.getPartitionInstanceRuntime(key);
        if (partitionInstance == null) {
            clonePartition(key);
        }
    }

    private synchronized void clonePartition(String key){
        PartitionInstanceRuntime partitionInstance = this.getPartitionInstanceRuntime(key);
        //TODO

    }
}
