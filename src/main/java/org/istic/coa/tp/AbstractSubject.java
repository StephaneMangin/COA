package org.istic.coa.tp;

import org.istic.coa.tp.interfaces.Observer;
import org.istic.coa.tp.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

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
}
