package org.istic.coa.tp;

import org.istic.coa.tp.interfaces.ObserverDeCapteur;
import org.istic.coa.tp.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephane on 06/01/16.
 */
public abstract class AbstractSubject implements Subject {

    protected List<ObserverDeCapteur> observers = new ArrayList<ObserverDeCapteur>();

    public void attach(ObserverDeCapteur observer) {
        observers.add(observer);
    }
    public void detach(ObserverDeCapteur observer) {
        observers.remove(observer);
    }
}
