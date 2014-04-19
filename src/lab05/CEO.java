package lab05;

/**
 * Created by Paulina on 19.04.2014.
 */

/**
 * CEO inherits from TeamManager. Only one instance of this class can be created.
 */

public class CEO extends TeamManager{

    private static boolean CEOExists=false;

    private CEO(TaskDispatchStrategy strategy) {
        super(100, strategy);
    }

    /**
     * If CEO is not already hired returns CEO.
     * @return CEO
     * @throws CEOAlreadyHiredException
     */
    public static CEO hireCEO () throws CEOAlreadyHiredException {
        if (CEOExists) {
            throw new CEOAlreadyHiredException();
        }
        CEOExists=true;
        return new CEO(new DispatchEqually());
    }
}
