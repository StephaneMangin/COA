package org.istic.coa.tp.diffusionStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by stephane on 12/01/16.
 */
public class SequentialDiffusionStrategy extends AbstractDiffusionStrategy {

    private static List<Callable> calls = new ArrayList<>();

    public SequentialDiffusionStrategy(DiffusionType type) {
        super(type);
    }

    public void execute() {
        // If callables left, there are lost
        calls.clear();
        clients.forEach(observer -> calls.add(() -> observer.update(this)));
        calls.forEach(voidCallable -> {
            try {
                // Active wait for all callables to be called
                voidCallable.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
