package org.istic.coa.tp;

import org.istic.coa.tp.diffusionStrategies.DiffusionStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Define a real capteur with diffusion strategy included
 *
 * Created by stephane on 06/01/16.
 */
public class CaptorImpl extends AbstractCaptor {

    private List<DiffusionStrategy> diffuseStrategies = new ArrayList<DiffusionStrategy>();
    private DiffusionStrategy diffuseStrategy;

    public CaptorImpl(DiffusionStrategy strategy) {
        System.out.println(this + "initialized with default value " + value);
        addDiffusionStrategy(strategy);
        selectDiffuseStrategy(strategy.getName());
    }

    public void addDiffusionStrategy(DiffusionStrategy diffusionStrategy) {
        diffuseStrategies.add(diffusionStrategy);
    }

    public void selectDiffuseStrategy(String name) {
        // Names are uniquely tested inside the diffusion abstraction
        diffuseStrategies.forEach(strategy -> {
            if (name.equals(strategy.getName())) {
                diffuseStrategy = strategy;
            }
        });
    }

    public DiffusionStrategy getDiffusionStrategy() {
        return diffuseStrategy;
    }
}
