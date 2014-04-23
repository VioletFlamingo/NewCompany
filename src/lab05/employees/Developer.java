package lab05.employees;

import lab05.properties.Salary;
import lab05.strategies.WorkStrategy;

public class Developer extends AbstractEmployee {

    public Developer(String name, String role, Salary salary, WorkStrategy strategy) {
        super(name, role, salary, strategy);
    }

    @Override
    public String toString() {
        return "Developer: " + getName() + " - " + getRole();
    }
}