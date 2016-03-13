package org.istic.coa.tp.diffusionStrategies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by stephane on 12/01/16.
 */
public class SequentialDiffusionStrategy extends AbstractDiffusionStrategy {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

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
        clients.forEach(observer -> executorService.submit(() -> observer.update(captor)));
    }
}
