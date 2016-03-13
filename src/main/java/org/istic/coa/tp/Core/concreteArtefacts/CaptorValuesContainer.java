package org.istic.coa.tp.Core.concreteArtefacts;

import org.istic.coa.tp.Core.interfaces.ValuesContainer;

/**
 * Created by blacknight on 13/03/16.
 */
public class CaptorValuesContainer implements ValuesContainer {

    private Integer value;
    private Double time;

    public CaptorValuesContainer(Integer value, Double time) {
        this.value = value;
        this.time = time;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Double getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ValueContainer[" + value + "|" + time + "]";
    }
}
