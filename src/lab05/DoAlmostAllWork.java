package lab05;

import java.util.Random;

/**
 * Created by Paulina on 19.04.2014.
 */
public class DoAlmostAllWork implements WorkStrategy {
    public int doWork(int work) {
        Random rand = new Random();
        return (rand.nextInt(20)+80)*work/100;
    }
}
