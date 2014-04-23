package main.java.pl.agh.jtp.home01.utils;

import main.java.pl.agh.jtp.home01.employees.*;
import main.java.pl.agh.jtp.home01.properties.Salary;
import main.java.pl.agh.jtp.home01.strategies.*;
import java.util.Random;

/**
 * Created by Paulina on 23.04.2014.
 */

/**
 * Class can be used to create employees of several types.
 */
public class EmployeeCreator {

    private static final String[] names = {"Adam", "Bella", "Charlie", "Donald", "Elisabeth", "Fabian", "Gabriel", "Hercules"};
    private static final String[] surnames = {"Anderson", "Black", "Cooper", "Duck", "Elliot", "Fast", "Green", "Hood"};
    private static final String[] testerJobs = {"testing software", "testing latest program"};
    private static final String[] developerJobs = {"developing game", "fixing bugs"};
    private static final Salary[] managerSalary = {new Salary(19999, 99), new Salary(10000, 0), new Salary(9500, 0)};
    private static final Salary[] employeeSalary = {new Salary(9999, 99), new Salary(7000, 0), new Salary(4500, 0)};
    private static final WorkStrategy[] workStrategies = {new DoAllWork(), new DoAlmostAllWork()};
    private static final TaskDispatchStrategy[] dispatchStrategies = {new DispatchEqually(), new DispatchTaskByRole()};

    /**
     * Creates team manager with random characteristics.
     * @return random team manager
     */
    public static TeamManager createRandomManager () {
        return new TeamManager(createRandomName(), "Manager", createRandomManagerSalary(),
                createWorkStrategy(), teamCardinality(), createDispatchStrategy());
    }

    /**
     * Creates developer with random characteristics.
     * @return random developer
     */
    public static Developer createRandomDeveloper () {
        return new Developer(createRandomName(), createRandomDeveloperJob(),
                createRandomEmployeeSalary(),
                createWorkStrategy());
    }

    /**
     * Creates tester with random characteristics.
     * @return random tester
     */
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
