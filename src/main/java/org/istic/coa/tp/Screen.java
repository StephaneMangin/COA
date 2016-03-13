package org.istic.coa.tp;

import org.istic.coa.tp.interfaces.Captor;
import org.istic.coa.tp.interfaces.CaptorObserver;

/**
 * Created by stephane on 06/01/16.
 */
public class Screen implements CaptorObserver {

    protected String name;
    private static int identifier = 0;

    public Screen() {
        name = "Afficheur_" + ++identifier;
    }

    public void update(Captor c) {
        System.out.println(this + " got value " + c.getValue());
    }

    @Override
    public String toString() {
        return name;
    }
}
