package main.java.pl.agh.jtp.home01.exceptions;

/**
 * Created by Paulina on 19.04.2014.
 */
public class CEOAlreadyHiredException extends Exception {
    public CEOAlreadyHiredException() {
    }

    public CEOAlreadyHiredException(String msg) {
        super(msg);
    }
}
