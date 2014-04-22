package lab05.employees;

import lab05.Visitor;
import lab05.properties.Salary;
import lab05.properties.Task;
import lab05.strategies.TaskDispatchStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamManager extends AbstractEmployee implements Manager, Iterable<Employee> {
    private List<Employee> employees;
    private int numberOfPlaces;
    private int numberOfEmployees = 0;
    private TaskDispatchStrategy strategy;
    private Salary salary;

    public TeamManager(int newStaff, TaskDispatchStrategy strategy, Salary salary) {
        employees = new ArrayList<Employee>();
        this.numberOfPlaces = newStaff;
        this.strategy = strategy;
        this.salary = salary;
    }

    public boolean canHire() {
        if (numberOfPlaces <= numberOfEmployees) {
            System.out.println("Company cannot hire another employee\n");
            return false;
        }
        return true;
    }


    public void hire(Employee employee) {
        employees.add(employee);
        numberOfEmployees++;
    }

    /*
    public boolean canFire() {
        if (numberOfEmployees < 1) {
            System.out.println("There are no employees to be fired");
            return false;
        }
        return true;
    }
    */

    /*
    public void fire(int which) {
        employees[which]=employees[numberOfEmployees-1];
        employees[numberOfEmployees-1]=null;
        numberOfEmployees--;
    }*/

    public void fire(int which) {

    }

    /*
    public void assign() {
        for(Employee emp: employees) {
            Random rand = new Random();
            emp.assign(new Task(rand.nextInt(24)+1));
        }
    }
    */

    @Override
    public void assign(Task task) {
        if (employees.isEmpty()) {
            this.setTask(task);
            return;
        }

        int work = task.getWorkToDo();
        work /= 10;
        if (work < 1 && task.getWorkToDo() > 0) {
            work = 1;
        }
        this.setTask(task);
        strategy.dispatch(employees, new Task(task.getWorkToDo() - work));
    }



    @Override
    public Salary getSalary() {
        return salary;
    }

    public void reportWork() {
        System.out.println(this.getName() + ": "
                + this.getWork().getWorkDone() + " hours worked as " + this.getRole());
        for (Employee e : employees) {
            if (e instanceof TeamManager) {
                ((TeamManager) e).reportWork();
            }
            System.out.println(e.getName() + ": " + e.getWork().getWorkDone() + " hours worked " + e.getRole());
        }
    }

    public int getNumberOfEmployedPeople() {
        return this.numberOfEmployees;
    }

    public void describeStaff() {
        System.out.println(this.toString());
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
        System.out.print("\n");
    }

    @Override
    public String toString() {
        return "Manager: " + getName() + " role: " + getRole();
    }


    @Override
    public Iterator<Employee> iterator() {
        final Iterator<Employee> iterator = employees.iterator();
        return new Iterator<Employee>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Employee next() {
                return iterator.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

