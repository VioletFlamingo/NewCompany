package main.java.pl.agh.jtp.home01.employees;

import main.java.pl.agh.jtp.home01.properties.Report;
import main.java.pl.agh.jtp.home01.properties.Salary;
import main.java.pl.agh.jtp.home01.properties.Task;
import main.java.pl.agh.jtp.home01.visitors.Visitable;

import java.io.Serializable;

public interface Employee extends Visitable, Serializable {
    String getName();

    String getRole();

    void assign(Task task);

    Report getWork();

    Salary getSalary();
}

