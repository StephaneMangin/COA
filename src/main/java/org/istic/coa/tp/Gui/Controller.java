package org.istic.coa.tp.Gui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.istic.coa.tp.Core.concreteArtefacts.CaptorImpl;
import org.istic.coa.tp.Core.concreteArtefacts.Channel;
import org.istic.coa.tp.Core.concreteArtefacts.CaptorScheduleProcessor;
import org.istic.coa.tp.Core.concreteArtefacts.Display;
import org.istic.coa.tp.Core.diffusionStrategies.DiffusionType;
import org.istic.coa.tp.Gui.ObservableValues.CaptorObservableTime;
import org.istic.coa.tp.Gui.ObservableValues.CaptorObservableValue;
import org.istic.coa.tp.Gui.ObservableValues.DisplayObservableTime;
import org.istic.coa.tp.Gui.ObservableValues.DisplayObservableValue;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    @FXML TextField valueCaptor;
    @FXML Text valueA;
    @FXML Text valueB;

    @FXML Text timeCaptor;
    @FXML Text timeA;
    @FXML Text timeB;

    @FXML RadioButton atomic;
    @FXML RadioButton sequential;
    @FXML RadioButton epoc;

    Channel channelA;
    Channel channelB;
    CaptorImpl captor = new CaptorImpl();
    Display displayA = new Display();
    Display displayB = new Display();
    CaptorScheduleProcessor processor = new CaptorScheduleProcessor(1, 1500, 1);

    public Controller() {
        // Define the strategy and launch the captor processor
        captor.setDiffuseStrategy(DiffusionType.SEQUENTIAL);
        processor.incrementWithStepByPeriod(captor, 200);

        // First canal
        channelA = new Channel(captor);
        channelA.setDelay(150);
        channelA.attach(displayA);

        // Second canal
        channelB = new Channel(captor);
        channelB.setDelay(600);
        channelB.attach(displayB);
    }

    @FXML
    public void setAtomicDiffusion(Event event) {
        captor.setDiffuseStrategy(DiffusionType.ATOMIC);
    }

    @FXML
    public void setSequentialDiffusion(Event event) {
        captor.setDiffuseStrategy(DiffusionType.SEQUENTIAL);
    }

    @FXML
    public void setEpocDiffusion(Event event) {
        captor.setDiffuseStrategy(DiffusionType.EPOC);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Bind all variables with each concreate artefacts
        valueCaptor.textProperty().bind(new CaptorObservableValue(captor));
        valueA.textProperty().bind(new DisplayObservableValue(displayA));
        valueB.textProperty().bind(new DisplayObservableValue(displayB));
        timeCaptor.textProperty().bind(new CaptorObservableTime(captor));
        timeA.textProperty().bind(new DisplayObservableTime(displayA));
        timeB.textProperty().bind(new DisplayObservableTime(displayB));
    }
}
