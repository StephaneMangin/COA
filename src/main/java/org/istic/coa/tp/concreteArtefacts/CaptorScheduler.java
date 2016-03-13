package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.interfaces.Captor;

import java.util.Timer;
import java.util.TimerTask;

public class CaptorScheduler {

    private Timer timer = new Timer();

    public void activate(final Captor captor, double perdiodInMiliSeconds) {
        TimerTask task = new TimerTask() {
            public void run() {
                // Increament value in N by 1 and time by 0.01
                captor.setValues(new CaptorValuesContainer(
                        captor.getValues().getValue() + 1,
                        captor.getValues().getTime() + 0.01));
                captor.tick();
            }
        };
        timer.schedule(task, 0, (long) perdiodInMiliSeconds);
    }
}