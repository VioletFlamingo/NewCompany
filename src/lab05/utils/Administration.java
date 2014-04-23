package lab05.utils;
import lab05.employees.*;
import lab05.properties.Task;
import lab05.visitors.DescriptionVisitor;
import lab05.visitors.SalaryReportVisitor;

import java.util.Random;
import java.util.Scanner;

public class Administration {

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
            System.out.println("(6) get average salary");
            System.out.println("(7) exit");
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
                    getAverageSalary();
                    break;
                case 7:
                default:
                    companyExist = false;
                    break;
            }
        }
    }

    public static void getAverageSalary () {
        SalaryReportVisitor salaryReportVisitor = new SalaryReportVisitor();
        comp.accept(salaryReportVisitor);
        System.out.println(salaryReportVisitor.getReport());
    }

    public static void getDescription() {
        DescriptionVisitor descriptionVisitor = new DescriptionVisitor();
        comp.accept(descriptionVisitor);
        System.out.println(descriptionVisitor.summation(comp));
    }

    public static Employee generateEmployee() {
        Random rand = new Random();
        AbstractEmployee employee;
        int whichRole = rand.nextInt(11);
        if (whichRole == 0) {
            employee = EmployeeCreator.createRandomManager();
        } else if (whichRole < 6) {
            employee = EmployeeCreator.createRandomDeveloper();
        } else {
            employee = EmployeeCreator.createRandomTester();
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

}
