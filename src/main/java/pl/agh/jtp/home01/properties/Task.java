package main.java.pl.agh.jtp.home01.properties;

import java.io.Serializable;

public class Task implements Serializable {

    private final int workToDo;

    public Task(int workToDo) {
        this.workToDo = workToDo;
    }

    /**
     * @return units of work in given task
     */
    public int getWorkToDo() {
        return workToDo;
    }
}

