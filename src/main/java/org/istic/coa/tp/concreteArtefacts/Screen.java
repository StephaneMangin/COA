package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.CaptorObserver;

/**
 * Created by stephane on 06/01/16.
 */
public class Screen implements CaptorObserver {

    protected String name;
    private int value;
    private static int identifier = 0;

    public Screen() {
        name = "Screen_" + ++identifier;
    }

    public void update(Captor captor) {
        try {
            value = captor.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " receive value " + value);
    }

    @Override
    public String toString() {
        return name;
    }
}
