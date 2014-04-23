package main.java.pl.agh.jtp.home01.strategies;

import main.java.pl.agh.jtp.home01.employees.Employee;
import main.java.pl.agh.jtp.home01.properties.Task;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface TaskDispatchStrategy extends Serializable {
    void dispatch(Iterable<Employee> employees, Task task);
}
