package main.java.pl.agh.jtp.home01.utils;
import main.java.pl.agh.jtp.home01.employees.*;
import main.java.pl.agh.jtp.home01.properties.Task;
import main.java.pl.agh.jtp.home01.visitors.DescriptionVisitor;
import main.java.pl.agh.jtp.home01.visitors.SalaryReportVisitor;

import java.util.Random;
import java.util.Scanner;

/**
 * Provides actions to administrate company.
 */
public class Administration {

    private static Company comp;

    /**
     * Provides main actions on given company.
     * @param company company on which actions are going to be taken
     */
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

    /**
     * Hires the number of employees given as parameter. If given negative number - hires no employees.
     * @param people amount of people to be hired
     */
    private static void hireStaff(int people) {
        if (people<1) {
            people=0;
        }
        for (int i = 0; i < people; i++) {
            if (comp.add(generateEmployee())) {
                System.out.println("Employee added");
            }
        }
    }

    /**
     * Shows on console possible actions that can be taken.
     * Takes the action depending on number typed on console.
     * If number typed is different than options given, exits program.
     */
    private static void administrate() {
        boolean companyExist = true;
        while (companyExist) {
            System.out.println("Choose what do you want to do:");
            System.out.println("(1) hire an employee");
            System.out.println("(2) assign new task to company");
            System.out.println("(3) get the report");
            System.out.println("(4) get description of every employee");
            System.out.println("(5) get average salary");
            System.out.println("(6) exit");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    comp.add(generateEmployee());
                    System.out.println("Employee added");
                    break;
                case 2:
                    giveNewTasks();
                    break;
                case 3:
                    getTheReport();
                    break;
                case 4:
                    getDescription();
                    break;
                case 5:
                    getAverageSalary();
                    break;
                default:
                    companyExist = false;
                    break;
            }
        }
    }

    /**
     * Prints on console report regarding average salary within all of the employees in company.
     */
    private static void getAverageSalary() {
        SalaryReportVisitor salaryReportVisitor = new SalaryReportVisitor();
        comp.accept(salaryReportVisitor);
        System.out.println(salaryReportVisitor.getReport());
    }

    /**
     * Prints on console descriptions of all of the employees in company.
     */
    private static void getDescription() {
        DescriptionVisitor descriptionVisitor = new DescriptionVisitor();
        comp.accept(descriptionVisitor);
        System.out.println(descriptionVisitor.summation(comp));
    }

    /**
     * Generates employee of random type with random characteristics.
     * @return random employee instance
     */
    private static Employee generateEmployee() {
        Random rand = new Random();
        AbstractEmployee employee;
        int whichRole = rand.nextInt(7);
        if (whichRole == 0) {
            employee = EmployeeCreator.createRandomManager();
        } else if (whichRole < 4) {
            employee = EmployeeCreator.createRandomDeveloper();
        } else {
            employee = EmployeeCreator.createRandomTester();
        }
        employee.setTask(new Task(rand.nextInt(24)));
        return employee;
    }

    /**
     * Gives new task to the company dependent on company size.
     */
    private static void giveNewTasks() {
        Random rand = new Random();
        Task task = new Task(rand.nextInt(comp.size()*100)+comp.size());
        comp.assignTaskToCompany(task);
    }

    /**
     * Outputs on console report from every employee in the company.
     */
    private static void getTheReport() {
        comp.getReport();
    }

}
