package org.istic.coa.tp;

import org.istic.coa.tp.interfaces.Capteur;
import org.istic.coa.tp.interfaces.ObserverDeCapteur;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by stephane on 06/01/16.
 */
public class Canal extends AbstractSubject implements Capteur, ObserverDeCapteur {

    private Capteur capteur;

    public Canal(AbstractCapteur capteur) {
        capteur.attach(this);
        this.capteur = capteur;
        System.out.println(this + " initialized for capteur " + capteur);
    }

    public int getValue() {
        return capteur.getValue();
    }

    public void tick() {
        throw new NotImplementedException();
    }
    public void update(Capteur capteur) {
        for (ObserverDeCapteur obs: observers) {
            obs.update(this);
        }
    }
}
