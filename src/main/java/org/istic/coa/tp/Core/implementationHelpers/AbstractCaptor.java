package org.istic.coa.tp.Core.implementationHelpers;

import org.istic.coa.tp.Core.concreteArtefacts.CaptorValuesContainer;
import org.istic.coa.tp.Core.interfaces.Captor;
import org.istic.coa.tp.Core.interfaces.ValuesContainer;

/**
 * Created by stephane on 06/01/16.
 */
public abstract class AbstractCaptor extends AbstractSubject implements Captor {

    protected String name;
    protected ValuesContainer values = new CaptorValuesContainer(0, 0.0);

    private static int identifier = 0;

    public AbstractCaptor() {
        name = "Capteur_" + ++identifier;
    }

    @Override
    public ValuesContainer getValues() {
        return values;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void setValues(ValuesContainer valuesContainer) {
        values = valuesContainer;
    }
}
