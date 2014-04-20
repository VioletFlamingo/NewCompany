package lab05;

public abstract class AbstractEmployee implements Employee {
    protected String name;
    protected String role;
    protected Task task;
    protected WorkStrategy strategy;
    protected Integer hoursWorked=0;

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
}