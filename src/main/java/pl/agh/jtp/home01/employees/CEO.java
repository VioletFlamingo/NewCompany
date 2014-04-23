package main.java.pl.agh.jtp.home01.employees;

/**
 * Created by Paulina on 19.04.2014.
 */

import main.java.pl.agh.jtp.home01.properties.Salary;
import main.java.pl.agh.jtp.home01.strategies.DispatchEqually;
import main.java.pl.agh.jtp.home01.strategies.DoAllWork;
import main.java.pl.agh.jtp.home01.strategies.TaskDispatchStrategy;

/**
 * CEO inherits from TeamManager.
 */
public class CEO extends TeamManager {
    private CEO(TaskDispatchStrategy strategy) {
        super("Bill Gates", "Manager of whole world", new Salary(50000, 0), new DoAllWork(), 100, strategy);
    }

    /**
     * Returns CEO with that dispatches work equally.
     * @return CEO
     */
    public static CEO hireCEO(){
        return new CEO(new DispatchEqually());
    }


}
