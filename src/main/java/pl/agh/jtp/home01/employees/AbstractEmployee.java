package main.java.pl.agh.jtp.home01.employees;

import main.java.pl.agh.jtp.home01.properties.Report;
import main.java.pl.agh.jtp.home01.properties.Salary;
import main.java.pl.agh.jtp.home01.properties.Task;
import main.java.pl.agh.jtp.home01.strategies.WorkStrategy;
import main.java.pl.agh.jtp.home01.visitors.Visitor;

import java.io.Serializable;

public abstract class AbstractEmployee implements Employee, Serializable {
    private String name;
    private String role;
    private Task task;
    private WorkStrategy strategy;
    private int hoursWorked;
    private Salary salary;

    public AbstractEmployee(String name, String role, Salary salary, WorkStrategy strategy) {
        this.name = name;
        this.role = role;
        this.salary=salary;
        this.strategy = strategy;
        this.task = new Task(0);
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
        this.hoursWorked += strategy.doWork(this.task.getWorkToDo());
        this.task = task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Salary getSalary() {
        return this.salary;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}