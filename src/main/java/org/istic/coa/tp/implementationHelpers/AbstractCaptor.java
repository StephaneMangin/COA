package org.istic.coa.tp.implementationHelpers;

import org.istic.coa.tp.interfaces.AsyncCaptor;
import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.Observer;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

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

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
