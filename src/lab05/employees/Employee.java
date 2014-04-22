package lab05.employees;

import lab05.properties.Report;
import lab05.properties.Salary;
import lab05.properties.Task;
import lab05.Visitable;

import java.io.Serializable;

public interface Employee extends Visitable, Serializable {
    String getName();
    String getRole();

    void assign(Task task);

    Report getWork();

    Salary getSalary();
}

