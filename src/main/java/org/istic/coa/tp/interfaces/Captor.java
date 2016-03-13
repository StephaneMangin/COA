package org.istic.coa.tp.interfaces;

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
    int getValue() throws InterruptedException;

    /**
     * Send a request for value updates to each observers
     *
     */
    void tick();
}
