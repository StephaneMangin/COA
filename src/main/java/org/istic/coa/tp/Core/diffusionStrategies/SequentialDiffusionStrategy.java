package org.istic.coa.tp.Core.diffusionStrategies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by stephane on 12/01/16.
 */
public class SequentialDiffusionStrategy extends AbstractDiffusionStrategy {

    private ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(100);

    public SequentialDiffusionStrategy(DiffusionType type) {
        super(type);
    }

    /**
     * Sequential calls
     *
     * All calls are processed once but list of calls is flushed between each execute calls
     *
     * Data can be lost.
     *
     */
    public void execute() {
        if (executorService.getActiveCount() == 0) {
            clients.forEach(observer -> executorService.submit(() -> observer.update(captor)));
        }
    }
}
