package org.istic.coa.tp.diffusionStrategies;

import org.istic.coa.tp.interfaces.DiffusionStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blacknight on 13/03/16.
 */
public abstract class AbstractDiffusionStrategy implements DiffusionStrategy {

    // Keep an eye on names attributed to strategies. To be uniquely referenced.
    private static List<String> names = new ArrayList<String>();
    private String name;

    public AbstractDiffusionStrategy(String name) {
        if (names.contains(name)) {
            throw new ArrayStoreException("This name is already used by another strategy.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[" + this.name + "]";
    }
}
