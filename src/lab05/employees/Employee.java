package lab05.employees;

import lab05.Report;
import lab05.properties.Salary;
import lab05.properties.Task;
import lab05.Visitable;

public interface Employee extends Visitable {
    String getName();
    String getRole();

    void assign(Task task);

    Report getWork();

    Salary getSalary();
}

