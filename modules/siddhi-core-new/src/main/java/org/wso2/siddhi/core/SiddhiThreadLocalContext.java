package org.wso2.siddhi.core;

import org.wso2.siddhi.core.event.inner.InnerStreamEventPool;

/**
 * Created by suho on 8/13/14.
 */
public class SiddhiThreadLocalContext {


    public static final ThreadLocal<InnerStreamEventPool> threadLocalStreamEventPool = new ThreadLocal<InnerStreamEventPool>();

    public static void setStreamEventPool(InnerStreamEventPool innerStreamEventPool) {
        threadLocalStreamEventPool.set(innerStreamEventPool);
    }

    public static void clear() {
        threadLocalStreamEventPool.remove();
    }

    public static InnerStreamEventPool getStreamEventPool() {
        return threadLocalStreamEventPool.get();
    }


}
