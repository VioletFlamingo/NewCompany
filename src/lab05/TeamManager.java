package lab05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TeamManager extends AbstractEmployee implements Manager, Iterable<Employee>{
    private List<Employee> employees = new ArrayList<Employee>();
    private int numberOfPlaces;
    private int numberOfEmployees=0;
    private TaskDispatchStrategy strategy;
    private Salary salary;

    TeamManager (int newStaff, TaskDispatchStrategy strategy, Salary salary) {
        this.numberOfPlaces=newStaff;
        this.strategy=strategy;
        this.salary=salary;
    }

    public boolean canHire() {
        if(numberOfPlaces==numberOfEmployees) {
            System.out.println("Company cannot hire another employee\n");
            return false;
        }
        return true;
    }


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public boolean canFire() {
        if(numberOfEmployees<1) {
            System.out.println("There are no employees to be fired");
            return false;
        }
        return true;
    }

    /*
    public void fire(int which) {
        employees[which]=employees[numberOfEmployees-1];
        employees[numberOfEmployees-1]=null;
        numberOfEmployees--;
    }*/

    public void fire(int which) {

    }

    public void assign() {
        for(Employee emp: employees) {
            Random rand = new Random();
            emp.assign(new Task(rand.nextInt(24)+1));
        }
    }

    public void assign(Task task) {
        this.hoursWorked+=this.task.getWorkToDo();
        this.task=task;
    }

    @Override
    public Salary getSalary() {
        return salary;
    }

    public void reportWork(){
        System.out.println(this.getName() + ": "
                + this.getWork().getWorkDone() + " hours worked as " +this.getRole());
        for(Employee e : employees) {
            if (e instanceof TeamManager) {
                ((TeamManager) e).reportWork();
            }
            System.out.println(e.getName() + ": " + e.getWork().getWorkDone() + " hours worked "+e.getRole());
        }
    }

    public int getNumberOfEmployedPeople() {
        return this.numberOfEmployees;
    }

    public void describeStaff() {
        System.out.println(this.toString());
        for(Employee e : employees) {
            System.out.println(e.toString());
        }
        System.out.print("\n");
    }

    @Override
    public String toString () {
        return "Manager: " + name + " role: " + role;
    }

    @Override
    public Iterator<Employee> iterator() {
        return null;
    }
}

