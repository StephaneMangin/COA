package org.istic.coa.tp.concreteArtefacts;

import org.istic.coa.tp.interfaces.Captor;

import java.util.Timer;
import java.util.TimerTask;

public class CaptorScheduleProcessor {

    private Timer timer = new Timer();
    private int max;
    private int min;
    private int step;

    public CaptorScheduleProcessor(int min, int max, int step) {
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public void incrementWithStepByPeriod(Captor captor, double perdiodInMiliSeconds) {
        TimerTask task = new TimerTask() {
            public void run() {
                // Increament value in N by 1 and time by 0.01
                int newValue = captor.getValues().getValue() + step;
                if (newValue >= max) {
                    newValue = min;
                }
                captor.setValues(new CaptorValuesContainer(
                        newValue,
                        captor.getValues().getTime() + 0.01));
                captor.tick();
            }
        };
        timer.schedule(task, 0, (long) perdiodInMiliSeconds);
    }

    public void randomIncrementByPeriod(Captor captor, double perdiodInMiliSeconds) {
        TimerTask task = new TimerTask() {
            public void run() {
                // Increament value in N by 1 and time by 0.01
                captor.setValues(new CaptorValuesContainer(
                        (int)(Math.random() * (max - min) + min),
                        captor.getValues().getTime() + 0.01));
                captor.tick();
            }
        };
        timer.schedule(task, 0, (long) perdiodInMiliSeconds);
    }
}