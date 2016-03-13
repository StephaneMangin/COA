package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.diffusionStrategies.AtomicDiffusionStrategy;
import org.istic.coa.tp.diffusionStrategies.DiffusionType;
import org.istic.coa.tp.diffusionStrategies.EpocDiffusionStrategy;
import org.istic.coa.tp.diffusionStrategies.SequentialDiffusionStrategy;
import org.istic.coa.tp.implementationHelpers.AbstractCaptor;
import org.istic.coa.tp.interfaces.DiffusionStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Define a real capteur with diffusion strategy included
 *
 * Created by stephane on 06/01/16.
 */
public class CaptorImpl extends AbstractCaptor {

    private DiffusionType diffuseType;
    private DiffusionStrategy diffuseStrategy;

    public CaptorImpl() {
        System.out.println(this + " initialized with default value " + value);
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
        System.out.println("Tick with " + getDiffusionStrategy() + " => " + ++value);
        diffuseStrategy.execute();
    }
}
