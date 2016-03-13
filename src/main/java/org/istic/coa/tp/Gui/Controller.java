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
import org.istic.coa.tp.Core.interfaces.Captor;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    @FXML TextField valueCaptor;
    @FXML Text valueA;
    @FXML Text valueB;
    @FXML Text valueC;
    @FXML Text valueD;
    @FXML Text valueE;

    @FXML Text timeCaptor;
    @FXML Text timeA;
    @FXML Text timeB;
    @FXML Text timeC;
    @FXML Text timeD;
    @FXML Text timeE;

    @FXML RadioButton atomic;
    @FXML RadioButton sequential;
    @FXML RadioButton epoc;

    Channel channelA;
    Channel channelB;
    Channel channelC;
    Channel channelD;
    Channel channelE;
    CaptorImpl captor = new CaptorImpl(this);
    Display displayA = new Display(this);
    Display displayB = new Display(this);
    Display displayC = new Display(this);
    Display displayD = new Display(this);
    Display displayE = new Display(this);
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
        channelB.setDelay(250);
        channelB.attach(displayB);

        // Third canal
        channelC = new Channel(captor);
        channelC.setDelay(600);
        channelC.attach(displayC);

        // Fourth canal
        channelD = new Channel(captor);
        channelD.setDelay(1200);
        channelD.attach(displayD);

        // Fifth canal
        channelE = new Channel(captor);
        channelE.setDelay(2500);
        channelE.attach(displayE);
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

    }

    public void update(Display display) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (valueA != null && timeA != null) {
            if (display.equals(displayA)) {
                valueA.setText(String.valueOf(display.getValue()));
                timeA.setText(String.valueOf(df.format(captor.getValues().getTime())));

            }
        }
        if (valueB != null && timeB != null) {
            if (display.equals(displayB)) {
                valueB.setText(String.valueOf(display.getValue()));
                timeB.setText(String.valueOf(df.format(captor.getValues().getTime())));
            }
        }
        if (valueC != null && timeC != null) {
            if (display.equals(displayC)) {
                valueC.setText(String.valueOf(display.getValue()));
                timeC.setText(String.valueOf(df.format(captor.getValues().getTime())));
            }
        }
        if (valueD != null && timeD != null) {
            if (display.equals(displayD)) {
                valueD.setText(String.valueOf(display.getValue()));
                timeD.setText(String.valueOf(df.format(captor.getValues().getTime())));
            }
        }
        if (valueE != null && timeE != null) {
            if (display.equals(displayE)) {
                valueE.setText(String.valueOf(display.getValue()));
                timeE.setText(String.valueOf(df.format(captor.getValues().getTime())));
            }
        }
    }

    public void update(Captor captor) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (valueCaptor != null && timeCaptor != null) {
            valueCaptor.setText(String.valueOf(captor.getValues().getValue()));
            timeCaptor.setText(String.valueOf(df.format(captor.getValues().getTime())));
        }
    }
}
