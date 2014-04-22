package lab05.properties;

import java.io.Serializable;

public class Report implements Serializable {

    private final int workDone;

    public Report(int workDone) {
        this.workDone = workDone;
    }

    public int getWorkDone() {
        return workDone;
    }

}

