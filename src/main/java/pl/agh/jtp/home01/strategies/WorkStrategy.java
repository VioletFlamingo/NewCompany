package main.java.pl.agh.jtp.home01.strategies;

import java.io.Serializable;

/**
 * Created by Paulina on 19.04.2014.
 */
public interface WorkStrategy extends Serializable {
    int doWork(int work);
}
