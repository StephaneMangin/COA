package org.istic.coa.tp.Core.interfaces;

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
    Void update(T subject);
}
