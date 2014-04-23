package main.java.pl.agh.jtp.home01.properties;

import java.io.Serializable;

/**
 * Data type storing units of work done.
 */
public class Report implements Serializable {

    private final int workDone;

    /**
     * Creates report consisting of work units given as parameter.
     * @param workDone units of work that are going to be reported
     */
    public Report(int workDone) {
        this.workDone = workDone;
    }

    /**
     * @return number of units of work done from the report
     */
    public int getWorkDone() {
        return workDone;
    }

}

