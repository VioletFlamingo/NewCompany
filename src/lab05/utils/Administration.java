package lab05.utils;

import lab05.employees.*;
import lab05.properties.Salary;
import lab05.properties.Task;
import lab05.strategies.*;

import java.util.Random;
import java.util.Scanner;

public class Administration {

    protected static String names[] = {"Adam", "Bella", "Charlie", "Donald", "Elisabeth", "Fabian", "Gabriel", "Hercules"};
    protected static String surnames[] = {"Anderson", "Black", "Cooper", "Duck", "Elliot", "Fast", "Green", "Hood"};
    protected static String testerJobs[] = {"testing software", "testing latest program"};
    protected static String developerJobs[] = {"developing game", "fixing bugs"};
    protected static Salary managerSalary[] = {new Salary(19999, 99), new Salary(10000, 0), new Salary(9500, 0)};
    protected static Salary employeeSalary[] = {new Salary(9999, 99), new Salary(7000, 0), new Salary(4500, 0)};
    private static WorkStrategy workStrategies[] = {new DoAllWork(), new DoAlmostAllWork()};
    private static TaskDispatchStrategy dispatchStrategies[] = {new DispatchEqually(), new DispatchTaskByRole()};
    private static Company comp;

    public static void takeActions(Company company) {
        comp = company;
        hireStaff(askForNumOfEmployees());
        administrate();
    }


    private static int askForNumOfEmployees() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many employees do you want to hire?");
        int number = input.nextInt();
        if (number < 1) {
            return 0;
        }
        return number;
    }

    public static void hireStaff(int people) {
        for (int i = 0; i < people; i++) {
            if (comp.add(generateEmployee())) {
                System.out.println("Employee added");
            }
        }
    }

    public static void administrate() {
        boolean companyExist = true;
        while (companyExist) {
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
                case 1:
                    comp.add(generateEmployee());
                    System.out.println("Employee added");
                    break;
                case 2:
                    fire();
                    break;
                case 3:
                    giveNewTasks();
                    break;
                case 4:
                    getTheReport();
                    break;
                case 5:
                    getDescription();
                    break;
                case 6:
                default:
                    companyExist = false;
                    break;
            }
        }
    }

    public static Employee generateEmployee() {
        Random rand = new Random();
        String name = names[rand.nextInt(names.length)] + " ";
        name += surnames[rand.nextInt(surnames.length)];
        AbstractEmployee employee;
        int whichRole = rand.nextInt(11);
        if (whichRole == 0) {
            employee = new TeamManager(name, "Manager", managerSalary[rand.nextInt(managerSalary.length)],
                    workStrategies[rand.nextInt(workStrategies.length)],
                    rand.nextInt(10) + 1, dispatchStrategies[rand.nextInt(dispatchStrategies.length)]);
        } else if (whichRole < 6) {
            employee = new Developer(name, developerJobs[rand.nextInt(developerJobs.length)],
                    employeeSalary[rand.nextInt(managerSalary.length)],
                    workStrategies[rand.nextInt(workStrategies.length)]);
        } else {
            employee = new Tester(name, testerJobs[rand.nextInt(testerJobs.length)],
                    employeeSalary[rand.nextInt(managerSalary.length)],
                    workStrategies[rand.nextInt(workStrategies.length)]);
        }
        employee.setTask(new Task(rand.nextInt(24)));
        return employee;
    }

    public static void fire() {
        /*
        if (manager.canFire()) {
            int employedWorkers=manager.getNumberOfEmployedPeople();
            System.out.println("Which worker to fire? (1 - " +employedWorkers+")");
            Scanner scanner = new Scanner(System.in);
            int which = scanner.nextInt();
            if (which<=employedWorkers && which>=1) {
                manager.fire(which-1);
            }
        }
        */
    }


    public static void giveNewTasks() {
        //assignManager();
        //manager.assign();
    }

    public static void getTheReport() {
        //manager.reportWork();
    }

    public static void getDescription() {
        //manager.describeStaff();
    }

}
