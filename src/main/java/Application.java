import org.istic.coa.tp.AbstractCapteur;
import org.istic.coa.tp.Afficheur;
import org.istic.coa.tp.Canal;
import org.istic.coa.tp.CapteurImpl;
import org.istic.coa.tp.diffusionStrategies.AlgoDiffusion;
import org.istic.coa.tp.diffusionStrategies.DiffusionAtomique;
import org.istic.coa.tp.diffusionStrategies.DiffusionEpoque;
import org.istic.coa.tp.diffusionStrategies.DiffusionSequencielle;
import org.istic.coa.tp.interfaces.Capteur;

import java.util.Random;

/**
 * Created by stephane on 12/01/16.
 */
public class Application {

    public static void main(String[] args) {

        Afficheur afficheur1 = new Afficheur();
        Afficheur afficheur2 = new Afficheur();

        AbstractCapteur capteur1 = new CapteurImpl(0);
        capteur1.setAlgoDiffusions("atomic", new DiffusionAtomique());
        capteur1.setAlgoDiffusions("sequencial", new DiffusionSequencielle());
        capteur1.setAlgoDiffusions("epoc", new DiffusionEpoque());
        capteur1.selectAlgoDiffusion("atomic");

        AbstractCapteur capteur2 = new CapteurImpl(0);
        capteur2.setAlgoDiffusions("atomic", new DiffusionAtomique());
        capteur2.setAlgoDiffusions("sequencial", new DiffusionSequencielle());
        capteur2.setAlgoDiffusions("epoc", new DiffusionEpoque());
        capteur2.selectAlgoDiffusion("atomic");

        Canal canal1 = new Canal(capteur1);
        canal1.attach(afficheur1);
        Canal canal2 = new Canal(capteur2);
        canal2.attach(afficheur2);

        for (int i= 0; i < 1000; i++) {
            System.out.println("Tick : " + i);
            capteur1.setValue(new Random(i).nextInt());
            capteur1.tick();
            capteur2.setValue(new Random(i).nextInt());
            capteur2.tick();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
