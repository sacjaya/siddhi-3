package org.wso2.siddhi.core;

import org.wso2.siddhi.core.event.pool.StreamEventPool;

/**
 * Created by suho on 8/13/14.
 */
public class SiddhiThreadLocalContext {


    public static final ThreadLocal<StreamEventPool> threadLocalStreamEventPool = new ThreadLocal<StreamEventPool>();

    public static void setStreamEventPool(StreamEventPool streamEventPool) {
        threadLocalStreamEventPool.set(streamEventPool);
    }

    public static void clear() {
        threadLocalStreamEventPool.remove();
    }

    public static StreamEventPool getStreamEventPool() {
        return threadLocalStreamEventPool.get();
    }


}
