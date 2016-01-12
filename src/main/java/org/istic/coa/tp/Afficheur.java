package org.istic.coa.tp;

import org.istic.coa.tp.interfaces.Capteur;
import org.istic.coa.tp.interfaces.ObserverDeCapteur;

/**
 * Created by stephane on 06/01/16.
 */
public class Afficheur implements ObserverDeCapteur {

    public void update(Capteur c) {
        System.out.println(this + " got value " + c.getValue());
    }
}
