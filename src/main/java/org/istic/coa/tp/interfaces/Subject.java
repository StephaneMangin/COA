package org.istic.coa.tp.interfaces;

/**
 * Created by stephane on 06/01/16.
 */
public interface Subject {
    void attach(ObserverDeCapteur observer);
    void detach(ObserverDeCapteur observer);
}
