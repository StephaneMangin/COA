package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.interfaces.AsyncCaptor;
import org.istic.coa.tp.interfaces.Observer;

import java.util.concurrent.ExecutionException;

/**
 * Define a visualizer for values
 *
 * Created by stephane on 06/01/16.
 */
public class Display implements Observer<AsyncCaptor> {

    protected String name;
    private int value = 0;
    private static int identifier = 0;

    public Display() {
        name = "Screen_" + ++identifier;
    }

    public void update(AsyncCaptor captor) {
        try {
            value = captor.getValue().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this + " receive value " + value);
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the internal value of this screen
     *
     * @return
     */
    public int getValue() {
        return value;
    }
}
