package org.istic.coa.tp.implementationHelpers;

import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.Observer;

/**
 * Created by stephane on 06/01/16.
 */
public abstract class AbstractCaptor extends AbstractSubject implements Captor {

    protected String name;
    protected int value = 0;

    private static int identifier = 0;

    public AbstractCaptor() {
        name = "Capteur_" + ++identifier;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }


    public void tick() {
        for (Observer obs: observers) {
            obs.update(this);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
