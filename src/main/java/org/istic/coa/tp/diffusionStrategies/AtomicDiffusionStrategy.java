package org.istic.coa.tp.diffusionStrategies;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by stephane on 06/01/16.
 */
public class AtomicDiffusionStrategy extends AbstractDiffusionStrategy {

    public AtomicDiffusionStrategy(DiffusionType type) {
        super(type);
    }

    /**
     * Atomic distribution.
     *
     * No data can be lost.
     *
     */
    public void execute() {
        clients.forEach(observer -> observer.update(captor));
    }
}
