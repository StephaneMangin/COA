package org.istic.coa.tp.Core.diffusionStrategies;


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
