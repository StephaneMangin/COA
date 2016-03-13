import org.istic.coa.tp.Screen;
import org.istic.coa.tp.Canal;
import org.istic.coa.tp.CaptorImpl;
import org.istic.coa.tp.diffusionStrategies.AtomicDiffusionStrategy;
import org.istic.coa.tp.diffusionStrategies.EpocDiffusionStrategy;
import org.istic.coa.tp.diffusionStrategies.SequentialDiffusionStrategy;

/**
 * Created by stephane on 12/01/16.
 */
public class Application {

    public static void main(String[] args) {

        // The capteur
        CaptorImpl capteur1 = new CaptorImpl(new AtomicDiffusionStrategy("atomic"));
        capteur1.addDiffusionStrategy(new SequentialDiffusionStrategy("sequencial"));
        capteur1.addDiffusionStrategy(new EpocDiffusionStrategy("epoque"));

        // First canal
        Canal canal1 = new Canal(capteur1);
        Screen screen1 = new Screen();
        canal1.attach(screen1);

        // Second canal
        Canal canal2 = new Canal(capteur1);
        Screen screen2 = new Screen();
        canal2.attach(screen2);

        // Value generation
        for (int i= 0; i <= 9; i++) {
            if (i >= 6) {
                capteur1.selectDiffuseStrategy("epoque");
            }
            if (i >= 3 && i < 6) {
                capteur1.selectDiffuseStrategy("sequenctial");
            }
            if (i < 3) {
                capteur1.selectDiffuseStrategy("atomic");
            }
            System.out.println("Tick with " + capteur1.getDiffusionStrategy() + " => " + i);
            capteur1.setValue(i);
            capteur1.tick();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
