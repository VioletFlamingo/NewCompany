package lab05.employees;

import lab05.properties.Salary;

public class Developer extends AbstractEmployee {

    public Developer (String name, String role) {
        this.setName(name);
        this.setRole(role);
    }

    @Override
    public String toString () {
        return "Developer: " + getName() + " - " + getRole();
    }

    @Override
    public Salary getSalary() {
        return null;
    }
}