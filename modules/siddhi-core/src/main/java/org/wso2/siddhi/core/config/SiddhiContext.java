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

import org.wso2.siddhi.core.extension.EternalReferencedHolder;
import org.wso2.siddhi.core.snapshot.SnapshotService;
import org.wso2.siddhi.core.snapshot.ThreadBarrier;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class SiddhiContext {

    private int eventBatchSize;
    private SnapshotService snapshotService;
    private ExecutorService executorService;
    private ScheduledExecutorService scheduledExecutorService;
    private String siddhiInstanceIdentifier;
    private List<Class> siddhiExtensions;
    private ConcurrentHashMap<String, DataSource> siddhiDataSources;
    private ThreadBarrier threadBarrier;
    private List<EternalReferencedHolder> eternalReferencedHolders;


    public enum ProcessingState {ENABLE_INTERNAL, ENABLE_EXTERNAL, DISABLED}

    public SiddhiContext(String siddhiInstanceIdentifier, ProcessingState distributedProcessingState) {
        this.siddhiInstanceIdentifier = siddhiInstanceIdentifier;
        this.siddhiDataSources = new ConcurrentHashMap<String, DataSource>();
        this.eternalReferencedHolders = new ArrayList<EternalReferencedHolder>();
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

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    public String getSiddhiInstanceIdentifier() {
        return siddhiInstanceIdentifier;
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

    public void setThreadBarrier(ThreadBarrier threadBarrier) {
        this.threadBarrier = threadBarrier;
    }

    public ThreadBarrier getThreadBarrier() {
        return threadBarrier;
    }

    public void addEternalReferencedHolder(EternalReferencedHolder eternalReferencedHolder) {
        eternalReferencedHolders.add(eternalReferencedHolder);
    }

    public List<EternalReferencedHolder> getEternalReferencedHolders() {
        return eternalReferencedHolders;
    }

}




