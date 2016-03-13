package org.istic.coa.tp.Core.concreteArtefacts;

import org.istic.coa.tp.Core.diffusionStrategies.AtomicDiffusionStrategy;
import org.istic.coa.tp.Core.diffusionStrategies.DiffusionType;
import org.istic.coa.tp.Core.diffusionStrategies.EpocDiffusionStrategy;
import org.istic.coa.tp.Core.diffusionStrategies.SequentialDiffusionStrategy;
import org.istic.coa.tp.Core.implementationHelpers.AbstractCaptor;
import org.istic.coa.tp.Core.interfaces.DiffusionStrategy;
import org.istic.coa.tp.Gui.Controller;

/**
 * Define a real capteur with diffusion strategy included
 *
 * Created by stephane on 06/01/16.
 */
public class CaptorImpl extends AbstractCaptor {

    private final Controller controller;
    private DiffusionStrategy diffuseStrategy;

    public CaptorImpl(Controller controller) {
        System.out.println(this + " initialized");
        this.controller = controller;
    }

    public void setDiffuseStrategy(DiffusionType type) {
        switch (type) {
            case ATOMIC:
                diffuseStrategy = new AtomicDiffusionStrategy(DiffusionType.ATOMIC);
                break;
            case EPOC:
                diffuseStrategy = new EpocDiffusionStrategy(DiffusionType.EPOC);
                break;
            case SEQUENTIAL:
                diffuseStrategy = new SequentialDiffusionStrategy(DiffusionType.SEQUENTIAL);
                break;
        }
        diffuseStrategy.configure(this, observers);
    }

    public DiffusionStrategy getDiffusionStrategy() {
        return diffuseStrategy;
    }

    @Override
    public void tick() {
        System.out.println("Tick with " + getDiffusionStrategy() + "with value " + values);
        diffuseStrategy.execute();
        if (controller != null) {
            controller.update(this);
        }
    }
}
