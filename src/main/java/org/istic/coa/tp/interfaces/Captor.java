package org.istic.coa.tp.interfaces;

import org.istic.coa.tp.concreteArtefacts.CaptorValuesContainer;

import java.util.HashMap;

/**
 * Define the basics methods for a capteur
 *
 * Created by stephane on 06/01/16.
 */
public interface Captor extends Subject {

    /**
     * Return the value contained in this capteur
     *
     * @return
     */
    ValuesContainer getValues();

    /**
     * Send a request for value updates to each observers
     *
     */
    void tick();

    /**
     * Set the values of this captor
     *
     * @param valuesContainer
     */
    void setValues(ValuesContainer valuesContainer);
}
