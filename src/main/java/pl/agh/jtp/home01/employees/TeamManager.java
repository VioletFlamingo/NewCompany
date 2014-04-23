package main.java.pl.agh.jtp.home01.employees;

import main.java.pl.agh.jtp.home01.properties.Salary;
import main.java.pl.agh.jtp.home01.properties.Task;
import main.java.pl.agh.jtp.home01.strategies.TaskDispatchStrategy;
import main.java.pl.agh.jtp.home01.strategies.WorkStrategy;
import main.java.pl.agh.jtp.home01.visitors.Visitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamManager extends AbstractEmployee implements Manager, Iterable<Employee>, Serializable{
    private List<Employee> employees;
    private int numberOfPlaces;
    private int numberOfEmployees = 0;
    private TaskDispatchStrategy dStrategy;
    private Salary salary;

    public TeamManager(String name, String role, Salary salary, WorkStrategy wStrategy, int newStaff, TaskDispatchStrategy dStrategy) {
        super(name, role, salary, wStrategy);
        employees = new ArrayList<Employee>();
        this.numberOfPlaces = newStaff;
        this.dStrategy = dStrategy;
        this.salary = salary;
    }

    public boolean canHire() {
        return numberOfPlaces > numberOfEmployees;
    }


    public void hire(Employee employee) {
        employees.add(employee);
        numberOfEmployees++;
    }


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
        super.assign(new Task(work));
        dStrategy.dispatch(employees, new Task(task.getWorkToDo() - work));
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

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Manager: " + getName() + " - managing team of:  " + getNumberOfEmployees();
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

