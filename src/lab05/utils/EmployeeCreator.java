package lab05.utils;

import lab05.employees.*;
import lab05.properties.Salary;
import lab05.strategies.*;
import java.util.Random;

/**
 * Created by Paulina on 23.04.2014.
 */

public class EmployeeCreator {

    private static String names[] = {"Adam", "Bella", "Charlie", "Donald", "Elisabeth", "Fabian", "Gabriel", "Hercules"};
    private static String surnames[] = {"Anderson", "Black", "Cooper", "Duck", "Elliot", "Fast", "Green", "Hood"};
    private static String testerJobs[] = {"testing software", "testing latest program"};
    private static String developerJobs[] = {"developing game", "fixing bugs"};
    private static Salary managerSalary[] = {new Salary(19999, 99), new Salary(10000, 0), new Salary(9500, 0)};
    private static Salary employeeSalary[] = {new Salary(9999, 99), new Salary(7000, 0), new Salary(4500, 0)};
    private static WorkStrategy workStrategies[] = {new DoAllWork(), new DoAlmostAllWork()};
    private static TaskDispatchStrategy dispatchStrategies[] = {new DispatchEqually(), new DispatchTaskByRole()};


    public static TeamManager createRandomManager () {
        return new TeamManager(createRandomName(), "Manager", createRandomManagerSalary(),
                createWorkStrategy(), teamCardinality(), createDispatchStrategy());
    }

    public static Developer createRandomDeveloper () {
        return new Developer(createRandomName(), createRandomDeveloperJob(),
                createRandomEmployeeSalary(),
                createWorkStrategy());
    }

    public static Tester createRandomTester () {
        return new Tester(createRandomName(), createRandomTesterJob(),
                createRandomEmployeeSalary(),
                createWorkStrategy());
    }


    private static String createRandomName() {
        Random rand = new Random();
        return names[rand.nextInt(names.length)] + " " + surnames[rand.nextInt(surnames.length)];
    }

    private static Salary createRandomManagerSalary () {
        Random rand = new Random();
        return managerSalary[rand.nextInt(managerSalary.length)];
    }

    private static Salary createRandomEmployeeSalary () {
        Random rand = new Random();
        return employeeSalary[rand.nextInt(employeeSalary.length)];
    }

    private static WorkStrategy createWorkStrategy () {
        Random rand = new Random();
        return workStrategies[rand.nextInt(workStrategies.length)];
    }

    private static TaskDispatchStrategy createDispatchStrategy () {
        Random rand = new Random();
        return dispatchStrategies[rand.nextInt(dispatchStrategies.length)];
    }

    private static String createRandomDeveloperJob () {
        Random rand = new Random();
        return developerJobs[rand.nextInt(developerJobs.length)];
    }

    private static String createRandomTesterJob () {
        Random rand = new Random();
        return testerJobs[rand.nextInt(testerJobs.length)];
    }

    private static int teamCardinality() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }
}
