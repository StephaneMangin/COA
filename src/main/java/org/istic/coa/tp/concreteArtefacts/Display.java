package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.interfaces.AsyncCaptor;
import org.istic.coa.tp.interfaces.Observer;
import org.istic.coa.tp.interfaces.ValuesContainer;

/**
 * Define a visualizer for values
 *
 * Created by stephane on 06/01/16.
 */
public class Display implements Observer<AsyncCaptor> {

    protected String name;
    private Integer value = 0;
    private Double time = 0.0;
    private static int identifier = 0;

    public Display() {
        name = "Screen_" + ++identifier;
    }

    public Void update(AsyncCaptor captor) {
        try {
            ValuesContainer container = captor.getValues().get();
            value = container.getValue();
            if (time <= container.getTime()) {
                time = container.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this + " receive value=" + value + " with time=" + time);
        return null;
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

    /**
     * Returns the internal time related value of this screen
     *
     * @return
     */
    public Double getTime() {
        return time;
    }
}
