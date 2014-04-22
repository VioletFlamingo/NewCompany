package lab05.employees;

import lab05.properties.Salary;
import lab05.strategies.WorkStrategy;

public class Tester extends AbstractEmployee {

    public Tester(String name, String role, Salary salary, WorkStrategy strategy) {
        super(name, role, salary, strategy);
    }


    @Override
    public String toString() {
        return "Tester: " + getName() + " - " + getRole();
    }
}
