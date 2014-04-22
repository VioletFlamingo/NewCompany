package lab05.strategies;

import lab05.properties.Task;
import lab05.employees.Employee;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface TaskDispatchStrategy extends Serializable {
    void dispatch(Iterable<Employee> employees, Task task);
}
