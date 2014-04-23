package main.java.pl.agh.jtp.home01.employees;

import main.java.pl.agh.jtp.home01.properties.Salary;
import main.java.pl.agh.jtp.home01.strategies.WorkStrategy;

public class Tester extends AbstractEmployee {

    public Tester(String name, String role, Salary salary, WorkStrategy strategy) {
        super(name, role, salary, strategy);
    }

    @Override
    public String toString() {
        return "Tester: " + getName() + " - " + getRole();
    }
}
