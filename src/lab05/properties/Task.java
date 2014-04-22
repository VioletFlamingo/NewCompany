package lab05.properties;

import java.io.Serializable;

public class Task implements Serializable {

    private final int workToDo;

    public Task(int workToDo) {
        this.workToDo = workToDo;
    }

    public int getWorkToDo() {
        return workToDo;
    }
}

