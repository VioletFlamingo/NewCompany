package main.java.pl.agh.jtp.home01.visitors;

import main.java.pl.agh.jtp.home01.employees.Employee;
import main.java.pl.agh.jtp.home01.employees.TeamManager;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface Visitor extends Serializable {
    void visit(Employee employee);

    void visit(TeamManager manager);
}
