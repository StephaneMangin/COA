package org.istic.coa.tp.interfaces;

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
    void configure();

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
    String getName();
}
