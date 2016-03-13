package org.istic.coa.tp.diffusionStrategies;

import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.DiffusionStrategy;
import org.istic.coa.tp.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract some behaviors of a diffusion system
 * Such as configuration and diffusion types
 *
 * Created by blacknight on 13/03/16.
 */
public abstract class AbstractDiffusionStrategy implements DiffusionStrategy {

    private DiffusionType type;
    protected List<Observer> clients = new ArrayList<>();
    protected Captor captor;

    public AbstractDiffusionStrategy(DiffusionType type) {
        this.type = type;
    }

    @Override
    public DiffusionType getDiffusionType() {
        return type;
    }

    @Override
    public String toString() {
        return "DiffusionStrategy[" + type + "]";
    }

    @Override
    public void configure(Captor captor, List<Observer> clients) {
        this.captor = captor;
        this.clients = clients;
    }
}
