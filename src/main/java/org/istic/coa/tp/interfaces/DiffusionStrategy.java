package org.istic.coa.tp.interfaces;

import org.istic.coa.tp.diffusionStrategies.DiffusionType;

import java.util.List;

/**
 * Define the basis methods for a diffusion algorythm
 *
 * Created by stephane on 06/01/16.
 */
public interface DiffusionStrategy {

    /**
     * Prepare all the necesserary for a complete working algo
     *
     */
    void configure(Captor captor, List<Observer> clients);

    /**
     * Execute the algo with parameters specified inside the configure method
     *
     */
    void execute();

    /**
     * Identifies this algo
     *
     * @return
     */
    DiffusionType getDiffusionType();
}
