package lab05.strategies;

import lab05.properties.Task;
import lab05.employees.Employee;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface TaskDispatchStrategy {
    void dispatch(Iterable<Employee> employees, Task task);
}
