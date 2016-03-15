package org.istic.coa.tp.Core.diffusionStrategies;

import com.sun.corba.se.impl.orbutil.threadpool.WorkQueueImpl;
import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;

import java.util.concurrent.*;

/**
 * Created by stephane on 12/01/16.
 */
public class SequentialDiffusionStrategy extends AbstractDiffusionStrategy {

    private static BlockingQueue queue = new LinkedBlockingQueue<>();
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 1000, 30, TimeUnit.SECONDS, queue);

    public SequentialDiffusionStrategy(DiffusionType type) {
        super(type);
    }

    /**
     * Sequential calls
     *
     * All calls are processed once. Loosing next calls if not finished
     *
     * Data can be lost.
     *
     */
    public void execute() {
        if (queue.isEmpty()) {
            executorService.submit(() -> clients.forEach(observer -> observer.update(captor)));
        }
    }
}
