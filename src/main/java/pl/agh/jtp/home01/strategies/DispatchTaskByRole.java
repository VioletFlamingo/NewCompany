package main.java.pl.agh.jtp.home01.strategies;

import main.java.pl.agh.jtp.home01.employees.Employee;
import main.java.pl.agh.jtp.home01.employees.TeamManager;
import main.java.pl.agh.jtp.home01.properties.Task;

/**
 * Created by Paulina on 13.04.2014.
 */
public class DispatchTaskByRole implements TaskDispatchStrategy {
    @Override
    public void dispatch(Iterable<Employee> employees, Task task) {

        int numberOfManagers = numOfManagers(employees);
        int numberOfEmployees = size(employees);
        int averageEmployeeWork;

        int work = task.getWorkToDo();
        int averageWork = work / (numberOfManagers + 1);
        if (numberOfEmployees!=numberOfManagers) {
            averageEmployeeWork = averageWork / (numberOfEmployees - numberOfManagers);
        } else {
            averageEmployeeWork = averageWork / numberOfEmployees;
        }


        for (Employee emp : employees) {
            if (!(emp instanceof TeamManager)) {
                emp.assign(new Task(averageEmployeeWork));
                work -= averageEmployeeWork;
            }
        }

        if (numberOfManagers!=0) {
            int averageManagerWork = work / numberOfManagers;
            work -= averageManagerWork * numberOfManagers;

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
