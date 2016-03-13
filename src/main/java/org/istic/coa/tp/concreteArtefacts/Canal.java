package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.implementationHelpers.AbstractSubject;
import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.Observer;
import org.istic.coa.tp.interfaces.CaptorObserver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by stephane on 06/01/16.
 */
public class Canal extends AbstractSubject implements Captor, CaptorObserver {

    private Captor captor;
    private int delay;

    /**
     * Constrcutor
     *
     * @param captor connected to
     */
    public Canal(Captor captor) {
        captor.attach(this);
        this.captor = captor;
        System.out.println(this + " initialized for captor " + captor);
    }

    public int getValue() throws InterruptedException {
        int value = captor.getValue();
        Thread.sleep(delay);
        return value;
    }

    /**
     * Returns the delay in milliseconds
     *
     * @return
     */
    public int getDelay() {
        return delay;
    }

    public void tick() {
        throw new NotImplementedException();
    }

    public void update(Captor captor) {
        for (Observer obs: observers) {
            obs.update(this);
        }
    }

    /**
     * Configure the transmission delay in milliseconds
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
}
