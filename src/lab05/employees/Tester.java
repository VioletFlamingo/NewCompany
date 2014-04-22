package lab05.employees;

import lab05.employees.AbstractEmployee;

public class Tester extends AbstractEmployee {

    public Tester (String name, String role) {
        //super(name, role);
        this.setName(name);
        this.setRole(role);
    }


    @Override
    public String toString () {
        return "Tester: " + getName() + " - " + getRole();
    }
}
