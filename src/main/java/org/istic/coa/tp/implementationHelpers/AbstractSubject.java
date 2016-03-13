package org.istic.coa.tp.implementationHelpers;

import org.istic.coa.tp.interfaces.Observer;
import org.istic.coa.tp.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by stephane on 06/01/16.
 */
public abstract class AbstractSubject implements Subject {

    protected List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }
    public void detach(Observer observer) {
        observers.remove(observer);
    }
    public List<Observer> getObservers() {
        return observers;
    }
}
