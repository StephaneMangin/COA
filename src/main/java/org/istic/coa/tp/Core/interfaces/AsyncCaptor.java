package org.istic.coa.tp.Core.interfaces;


import java.util.concurrent.Future;

/**
 * Define the basics methods for a capteur
 *
 * Created by stephane on 06/01/16.
 */
public interface AsyncCaptor extends Subject {

    /**
     * Return the value contained in this capteur
     *
     * @return
     */
    Future<ValuesContainer> getValues();

    /**
     * Send a request for value updates to each observers
     *
     */
    void tick();
}
