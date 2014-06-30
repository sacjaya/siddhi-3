/*
 * Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.siddhi.core.config;

import org.wso2.siddhi.core.snapshot.SnapshotService;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class SiddhiContext {

    private int eventBatchSize;
    private SnapshotService snapshotService;
    private ThreadPoolExecutor threadPoolExecutor;
    private ScheduledExecutorService scheduledExecutorService;
    private String executionPlanIdentifier;
    private List<Class> siddhiExtensions;
    private ConcurrentHashMap<String, DataSource> siddhiDataSources;


    public enum ProcessingState {ENABLE_INTERNAL,ENABLE_EXTERNAL,DISABLED}

    public SiddhiContext(String executionPlanIdentifier, ProcessingState distributedProcessingState) {
        this.executionPlanIdentifier = executionPlanIdentifier;
        this.siddhiDataSources = new ConcurrentHashMap<String, DataSource>();
    }

    public int getEventBatchSize() {
        return eventBatchSize;
    }

    public void setEventBatchSize(int eventBatchSize) {
        this.eventBatchSize = eventBatchSize;
    }

    public void setSnapshotService(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    public SnapshotService getSnapshotService() {
        return snapshotService;
    }

     public void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

     public String getExecutionPlanIdentifier() {
        return executionPlanIdentifier;
    }

    public void setSiddhiExtensions(List<Class> siddhiExtensions) {
        this.siddhiExtensions = siddhiExtensions;
    }

    public List<Class> getSiddhiExtensions() {
        return siddhiExtensions;
    }

    public DataSource getDataSource(String name) {
        return siddhiDataSources.get(name);
    }

    public void addDataSource(String name, DataSource dataSource) {
        siddhiDataSources.put(name, dataSource);
    }

 }




