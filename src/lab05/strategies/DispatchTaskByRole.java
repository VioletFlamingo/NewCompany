package lab05.strategies;

import lab05.employees.Employee;
import lab05.employees.TeamManager;
import lab05.properties.Task;

/**
 * Created by Paulina on 13.04.2014.
 */
public class DispatchTaskByRole implements TaskDispatchStrategy {
    @Override
    public void dispatch(Iterable<Employee> employees, Task task) {
        int work = task.getWorkToDo();
        int averageWork = work / numOfManagers(employees) + 1;
        int averageEmployeeWork = averageWork / (size(employees) - numOfManagers(employees));

        for (Employee emp : employees) {
            if (!(emp instanceof TeamManager)) {
                emp.assign(new Task(averageEmployeeWork));
                work -= averageEmployeeWork;
            }
        }

        int averageManagerWork = work / numOfManagers(employees);
        work -= averageManagerWork * numOfManagers(employees);

        for (Employee emp : employees) {
            if (emp instanceof TeamManager) {
                if (work > 0) {
                    emp.assign(new Task(averageManagerWork + 1));
                    work--;
                } else {
                    emp.assign(new Task(averageManagerWork));
                }
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

    private int numOfManagers(Iterable<Employee> employees) {
        int num = 0;
        for (Employee emp : employees) {
            if (emp instanceof TeamManager) {
                num++;
            }
        }
        return num;
    }
}
