import org.istic.coa.tp.concreteArtefacts.CaptorScheduleProcessor;
import org.istic.coa.tp.concreteArtefacts.Display;
import org.istic.coa.tp.concreteArtefacts.Canal;
import org.istic.coa.tp.concreteArtefacts.CaptorImpl;
import org.istic.coa.tp.diffusionStrategies.DiffusionType;

/**
 * Created by stephane on 12/01/16.
 */
public class Application {

    public static void main(String[] args) {

                // The capteur
        CaptorImpl captor = new CaptorImpl();
        captor.setDiffuseStrategy(DiffusionType.SEQUENTIAL);
        CaptorScheduleProcessor process = new CaptorScheduleProcessor(1, 1500, 1);
        process.randomIncrementByPeriod(captor, 200);

        // First canal
        Canal canal1 = new Canal(captor);
        Display display1 = new Display();
        canal1.setDelay(150);
        canal1.attach(display1);

        // Second canal
        Canal canal2 = new Canal(captor);
        Display display2 = new Display();
        canal2.setDelay(600);
        canal2.attach(display2);
    }
}
