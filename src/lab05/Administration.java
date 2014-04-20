package lab05;

import java.util.Random;
import java.util.Scanner;

public class Administration {

    protected String names []= {"Adam", "Bella", "Charlie", "Donald", "Elisabeth", "Fabian", "Gabriel", "Hercules"};
    protected String surnames []= {"Anderson", "Black", "Cooper", "Duck", "Elliot", "Fast", "Green", "Hood"};
    protected String testerJobs []= {"testing software", "testing latest program"};
    protected String developerJobs []= {"developing game", "fixing bugs"};
    protected Salary managerSalary []= {new Salary (19999, 99), new Salary(10000, 0), new Salary(9500, 0)};
    protected Salary employeeSalary []= {new Salary (9999, 99), new Salary(7000, 0), new Salary(4500, 0)};



    public static void takeActions() {

    }

    /*
    Administration (int people) {
        System.out.println("Establishing company of " + people + " employees:");
        getManager(people-1);
        hireStaff(people - 1);
        giveNewTasks();
        manager.describeStaff();
    }

    public void getManager(int people) {
        manager= new TeamManager(people);
        manager.setName("Bill Gates");
        manager.setRole("CEO");
    }

    public void hireStaff(int people) {
        for (int i=0; i<people; i++) {
            this.hire();
        }
    }

    public void administrate () {
        boolean companyExist=true;
        while (companyExist==true) {
            System.out.println("Choose what do you want to do:");
            System.out.println("(1) hire an employee");
            System.out.println("(2) fire an employee");
            System.out.println("(3) give new tasks to employees");
            System.out.println("(4) get the report");
            System.out.println("(5) get description of every employee");
            System.out.println("(6) exit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1: hire(); break;
                case 2: fire(); break;
                case 3: giveNewTasks(); break;
                case 4: getTheReport(); break;
                case 5: getDescription(); break;
                case 6:
                default: companyExist=false; break;
            }
        }
    }

    public void hire() {
        if(manager.canHire()==true) {
            Random rand = new Random();
            String name = names[rand.nextInt(names.length)]+ " ";
            name += surnames[rand.nextInt(surnames.length)];
            String job;
            AbstractEmployee employee;
            if (rand.nextInt(2)==0) {
                job=developerJobs[rand.nextInt(developerJobs.length)];
                employee = new Developer(name, job);
                Task task = new Task(rand.nextInt(24));
                employee.setTask(task);
                manager.hire(employee);
            }
            else {
                job=testerJobs[rand.nextInt(testerJobs.length)];
                employee = new Tester(name, job);
                Task task = new Task(rand.nextInt(24));
                employee.setTask(task);
                manager.hire(employee);
            }
        }

    }

    public void fire() {
        if (manager.canFire()) {
            int employedWorkers=manager.getNumberOfEmployedPeople();
            System.out.println("Which worker to fire? (1 - " +employedWorkers+")");
            Scanner scanner = new Scanner(System.in);
            int which = scanner.nextInt();
            if (which<=employedWorkers && which>=1) {
                manager.fire(which-1);
            }
        }
    }

    public void assignManager() {
        Random rand = new Random();
        Task task= new Task(rand.nextInt(24)+1);
        manager.assign(task);
    }

    public void giveNewTasks() {
        assignManager();
        manager.assign();
    }

    public void getTheReport() {
        manager.reportWork();
    }

    public void getDescription() {
        manager.describeStaff();
    }
    */

    public void hire () {

    }
}
