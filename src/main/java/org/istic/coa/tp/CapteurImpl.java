package org.istic.coa.tp;

import org.istic.coa.tp.diffusionStrategies.AlgoDiffusion;
import org.istic.coa.tp.diffusionStrategies.DiffusionAtomique;
import org.istic.coa.tp.diffusionStrategies.DiffusionEpoque;
import org.istic.coa.tp.diffusionStrategies.DiffusionSequencielle;
import org.istic.coa.tp.interfaces.Capteur;
import org.istic.coa.tp.interfaces.ObserverDeCapteur;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephane on 06/01/16.
 */
public class CapteurImpl extends AbstractCapteur {

    private List<Canal> canaux;

    public CapteurImpl(int initValue) {
        this.value = initValue;
        System.out.println(this + "initialized with default value " + value);
    }

    public void tick() {
        System.out.println(this + " has ticked with value " + value);
        for (ObserverDeCapteur obs: observers) {
            obs.update(this);
        }
    }

}
