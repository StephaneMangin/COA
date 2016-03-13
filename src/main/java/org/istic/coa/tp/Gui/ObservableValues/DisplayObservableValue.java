package org.istic.coa.tp.Gui.ObservableValues;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableStringValue;
import org.istic.coa.tp.Core.concreteArtefacts.Display;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blacknight on 13/03/16.
 */
public class DisplayObservableValue implements ObservableStringValue {

    private final Display display;
    List<ChangeListener<? super String>> changeListenerList = new ArrayList<>();
    List<InvalidationListener> invalidationListenerList = new ArrayList<>();

    public DisplayObservableValue(Display display) {
        this.display = display;
    }

    @Override
    public String get() {
        return getValue();
    }

    @Override
    public void addListener(ChangeListener<? super String> listener) {
        changeListenerList.add(listener);
    }

    @Override
    public void removeListener(ChangeListener<? super String> listener) {
        changeListenerList.remove(listener);
    }

    @Override
    public String getValue() {
        return String.valueOf(display.getValue());
    }

    @Override
    public void addListener(InvalidationListener listener) {
        invalidationListenerList.add(listener);
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        invalidationListenerList.remove(listener);
    }
}
