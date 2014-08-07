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

package org.wso2.siddhi.core;

import org.wso2.siddhi.core.config.SiddhiConfiguration;
import org.wso2.siddhi.core.config.SiddhiContext;
import org.wso2.siddhi.core.exception.ValidatorException;
import org.wso2.siddhi.core.snapshot.SnapshotService;
import org.wso2.siddhi.core.snapshot.ThreadBarrier;
import org.wso2.siddhi.core.util.SiddhiThreadFactory;
import org.wso2.siddhi.core.util.validate.QueryValidator;
import org.wso2.siddhi.core.util.validate.StreamValidator;
import org.wso2.siddhi.query.api.ExecutionPlan;
import org.wso2.siddhi.query.api.definition.StreamDefinition;
import org.wso2.siddhi.query.api.execution.ExecutionElement;
import org.wso2.siddhi.query.api.execution.partition.Partition;
import org.wso2.siddhi.query.api.execution.query.Query;
import org.wso2.siddhi.query.compiler.exception.SiddhiParserException;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;


public class SiddhiManager {
    private SiddhiContext siddhiContext;
    private ConcurrentMap<String, ExecutionPlanRuntime> executionPlanRuntimeMap = new ConcurrentHashMap<String, ExecutionPlanRuntime>();


    public SiddhiManager() {
        this(new SiddhiConfiguration());
    }

    public SiddhiManager(SiddhiConfiguration siddhiConfiguration) {


        this.siddhiContext = new SiddhiContext(siddhiConfiguration.getSiddhiInstanceIdentifier(), SiddhiContext.ProcessingState.DISABLED);
        this.siddhiContext.setEventBatchSize(siddhiConfiguration.getEventBatchSize());
        this.siddhiContext.setSiddhiExtensions(siddhiConfiguration.getSiddhiExtensions());
        this.siddhiContext.setThreadBarrier(new ThreadBarrier());
        this.siddhiContext.setThreadPoolExecutor(new ThreadPoolExecutor(siddhiConfiguration.getThreadExecutorCorePoolSize(),
                siddhiConfiguration.getThreadExecutorMaxPoolSize(),
                50,
                TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new SiddhiThreadFactory("Executor")));
        this.siddhiContext.setScheduledExecutorService(Executors.newScheduledThreadPool(siddhiConfiguration.getThreadSchedulerCorePoolSize(), new SiddhiThreadFactory("Scheduler")));
        this.siddhiContext.setSnapshotService(new SnapshotService(siddhiContext));
    }


    public void validateExecutionPlan(ExecutionPlan executionPlan) throws ValidatorException {
        Map<String, StreamDefinition> tempMap = new HashMap<String, StreamDefinition>();
        for (StreamDefinition definition : executionPlan.getStreamDefinitionMap().values()) {
            StreamValidator.validate(tempMap, definition);
        }
        for (ExecutionElement executionElement : executionPlan.getExecutionElementList()) {
            if (executionElement instanceof Query) {
                QueryValidator.validate((Query) executionElement, tempMap);

            } else if (executionElement instanceof Partition) {
                //todo  ParttionValidator.validate((Partition)executionElement, tempMap);

            }
        }
    }

//    public void validateExecutionPlan(ExecutionPlan executionPlan) throws ValidatorException {
//        Map<String, StreamDefinition> tempMap = new HashMap<String, StreamDefinition>();
//        if (executionPlan.getStreamDefinitionMap() != null) {
//            for (StreamDefinition definition : executionPlan.getStreamDefinitionMap().values()) {
//                StreamValidator.validate(tempMap, definition);
//            }
//            if (executionPlan.getQueryList() != null) {
//                for (Query query : executionPlan.getQueryList()) {
//                    QueryValidator.validate(query, tempMap);
//                }
//            }
//        }
//    }

    /**
     * add stream definitions, partitions and queries of an execution plan
     *
     * @param executionPlan
     * @return
     * @throws SiddhiParserException
     */
    public ExecutionPlanRuntime addExecutionPlan(ExecutionPlan executionPlan) throws SiddhiParserException {
        ExecutionPlanRuntime executionPlanRuntime = new ExecutionPlanRuntime(siddhiContext);
        if (executionPlan.getStreamDefinitionMap() != null) {
            for (StreamDefinition streamDefinition : executionPlan.getStreamDefinitionMap().values()) {
                executionPlanRuntime.defineStream(streamDefinition);
            }
        }
        if (executionPlan.getExecutionElementList() != null) {
            for (ExecutionElement executionElement : executionPlan.getExecutionElementList()) {
                if (executionElement instanceof Query) {
                    executionPlanRuntime.addQuery((Query) executionElement);
                } else {
                    executionPlanRuntime.definePartition((Partition) executionElement);
                }

            }
        }

        executionPlanRuntimeMap.put(executionPlan.getName(), executionPlanRuntime);
        return executionPlanRuntime;
    }

    public void removeExecutionPlan(ExecutionPlan executionPlan) throws SiddhiParserException {
        ExecutionPlanRuntime executionPlanRuntime = executionPlanRuntimeMap.remove(executionPlan.getName());
        Collections.reverse(executionPlan.getExecutionElementList());
        if (executionPlan.getExecutionElementList() != null) {
            for (ExecutionElement executionElement : executionPlan.getExecutionElementList()) {
                if (executionElement instanceof Query){
                    executionPlanRuntime.removeQuery((Query) executionElement);
                } else {
                    executionPlanRuntime.removePartition((Partition) executionElement);
                }

            }
        }
        executionPlanRuntime.removeStreams();
    }

    public void shutdown() {
        siddhiContext.getThreadPoolExecutor().shutdown();
        siddhiContext.getScheduledExecutorService().shutdownNow();

    }

    public byte[] snapshot() {
        return siddhiContext.getSnapshotService().snapshot();
    }

    public void restore(byte[] snapshot) {
        siddhiContext.getSnapshotService().restore(snapshot);
    }

    public SiddhiContext getSiddhiContext() {
        return siddhiContext;
    }


}
