package org.istic.coa.tp;

import org.istic.coa.tp.diffusionStrategies.AlgoDiffusion;
import org.istic.coa.tp.interfaces.Capteur;
import org.istic.coa.tp.interfaces.ObserverDeCapteur;
import org.istic.coa.tp.interfaces.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stephane on 06/01/16.
 */
public abstract class AbstractCapteur extends AbstractSubject implements Capteur {

    protected int value;
    private Map<String, AlgoDiffusion> algoDiffusions = new HashMap<String, AlgoDiffusion>();
    private AlgoDiffusion algoDiffusion;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setAlgoDiffusions(String name, AlgoDiffusion algoDiffusion) {
        this.algoDiffusions.put(name, algoDiffusion);
    }

    public void selectAlgoDiffusion(String name) {
        this.algoDiffusion = algoDiffusions.get(name);
    }

}
