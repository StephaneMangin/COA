package org.istic.coa.tp.interfaces;

/**
 * Define the basis methods for an observer
 *
 * Created by stephane on 06/01/16.
 */
public interface Observer<T> {

    /**
     * Retreive an update from an observable
     *
     * @param subject
     */
    void update(T subject);
}
