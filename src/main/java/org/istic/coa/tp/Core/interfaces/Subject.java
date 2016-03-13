package org.istic.coa.tp.Core.interfaces;

/**
 * Define the basis methods for a subject to be observed
 *
 * Created by stephane on 06/01/16.
 */
public interface Subject {

    /**
     * Add an observer
     *
     * @param observer
     */
    void attach(Observer observer);

    /**
     * Remove an observer
     *
     * @param observer
     */
    void detach(Observer observer);
}
