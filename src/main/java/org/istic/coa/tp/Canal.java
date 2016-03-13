package org.istic.coa.tp;

import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.Observer;
import org.istic.coa.tp.interfaces.CaptorObserver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by stephane on 06/01/16.
 */
public class Canal extends AbstractSubject implements Captor, CaptorObserver {

    private Captor captor;

    public Canal(Captor captor) {
        captor.attach(this);
        this.captor = captor;
        System.out.println(this + " initialized for captor " + captor);
    }

    public int getValue() {
        return captor.getValue();
    }

    public void tick() {
        throw new NotImplementedException();
    }

    public void update(Captor captor) {
        for (Observer obs: observers) {
            obs.update(this);
        }
    }
}
