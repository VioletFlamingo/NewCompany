package main.java.pl.agh.jtp.home01.strategies;

import main.java.pl.agh.jtp.home01.employees.Employee;
import main.java.pl.agh.jtp.home01.properties.Task;

/**
 * Created by Paulina on 13.04.2014.
 */
public class DispatchEqually implements TaskDispatchStrategy {
    @Override
    public void dispatch(Iterable<Employee> employees, Task task) {
        int work = task.getWorkToDo();
        int averageWork = work / size(employees);
        work -= size(employees) * averageWork;
        for (Employee emp : employees) {
            if (work > 0) {
                emp.assign(new Task(averageWork + 1));
                work--;
            } else {
                emp.assign(new Task(averageWork));
            }
        }
    }

    private int size(Iterable<Employee> employees) {
        int size = 0;
        for (Employee ignored : employees) {
            size++;
        }
        return size;
    }
}
