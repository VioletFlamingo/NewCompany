package lab05.employees;

/**
 * Created by Paulina on 19.04.2014.
 */

import lab05.exceptions.CEOAlreadyHiredException;
import lab05.properties.Salary;
import lab05.strategies.DispatchEqually;
import lab05.strategies.DoAllWork;
import lab05.strategies.TaskDispatchStrategy;

/**
 * CEO inherits from TeamManager. CEO is a singleton class.
 */

public class CEO extends TeamManager {

    private static CEO ceo;

    private CEO(TaskDispatchStrategy strategy) {
        super("Bill Gates", "Manager of whole world", new Salary(50000, 0), new DoAllWork(), 100, strategy);
    }

    /**
     * If CEO is not already hired returns CEO.
     *
     * @return CEO
     * @throws lab05.exceptions.CEOAlreadyHiredException
     */
    public static CEO hireCEO() throws CEOAlreadyHiredException {
        if (ceo == null) {
            ceo = new CEO(new DispatchEqually());
            return ceo;
        }
        throw new CEOAlreadyHiredException();
    }
}
