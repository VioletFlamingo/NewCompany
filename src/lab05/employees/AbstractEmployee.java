package lab05.employees;

import lab05.*;
import lab05.properties.Report;
import lab05.properties.Salary;
import lab05.properties.Task;
import lab05.strategies.WorkStrategy;

public abstract class AbstractEmployee implements Employee {
    private String name;
    private String role;
    private Task task;
    private WorkStrategy strategy;
    private int hoursWorked;
    private Salary salary;

    AbstractEmployee (){

    }

    public AbstractEmployee (String name, String role, WorkStrategy strategy) {
        this.name=name;
        this.role=role;
        this.strategy=strategy;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setRole(String role) {
        this.role=role;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    @Override
    public String toString() {
        return name + " - " + role;
    }

    public Report getWork() {
        Report report = new Report(hoursWorked);
        return report;
    }

    public void assign(Task task) {
        this.hoursWorked+=strategy.doWork(this.task.getWorkToDo());
        this.task=task;
    }

    public void setTask (Task task) {
        this.task=task;
    }

    public Salary getSalary() {
        return this.salary;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}