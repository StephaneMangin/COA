package org.istic.coa.tp;

import org.istic.coa.tp.Core.utils.CaptorScheduleProcessor;
import org.istic.coa.tp.Core.concreteArtefacts.Display;
import org.istic.coa.tp.Core.concreteArtefacts.Channel;
import org.istic.coa.tp.Core.concreteArtefacts.CaptorImpl;
import org.istic.coa.tp.Core.diffusionStrategies.DiffusionType;

import java.util.concurrent.TimeUnit;

/**
 * Created by stephane on 12/01/16.
 */
public class StandAloneLauncher {

    public static void main(String[] args) {

        // The capteur
        CaptorImpl captor = new CaptorImpl(null);
        captor.setDiffuseStrategy(DiffusionType.ATOMIC);
        CaptorScheduleProcessor process = new CaptorScheduleProcessor(1, 1500, 1);
        process.incrementWithStepByPeriod(captor, 200, TimeUnit.MILLISECONDS);

        // First canal
        Channel channel1 = new Channel(captor);
        Display display1 = new Display(null);
        channel1.setDelay(150);
        channel1.attach(display1);

        // Second canal
        Channel channel2 = new Channel(captor);
        Display display2 = new Display(null);
        channel2.setDelay(600);
        channel2.attach(display2);
    }
}
