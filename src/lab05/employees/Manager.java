package lab05.employees;

import lab05.employees.Employee;

public interface Manager extends Employee {

    public void hire(Employee employee);
    public void fire(int which);

    public boolean canHire();
}

