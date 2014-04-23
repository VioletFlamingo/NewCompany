package main.java.pl.agh.jtp.home01.properties;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */

/**
 * Data type storing salary in convention of integer part and
 * decimal place [consisting of 2 digits].
 */
public class Salary implements Serializable {
    private final int integerPart;
    private final int decimalPlace;

    /**
     * Creates salary from given numbers.
     * It is not allowed to store negative numbers. Every salary that is
     * tries to be created with at least one negative parameter is automatically
     * changed to 0,00.
     * @param integerPart
     * @param decimalPlace
     */
    public Salary(int integerPart, int decimalPlace) {
        if (decimalPlace > 99) {
            integerPart += decimalPlace / 100;
        }

        if (integerPart < 0 || decimalPlace < 0) {
            this.decimalPlace = 0;
            this.integerPart = 0;
        } else {
            this.integerPart = integerPart;
            this.decimalPlace = decimalPlace % 100;
        }
    }

    /**
     * @return integer part of salary
     */
    public int getIntegerPart() {
        return integerPart;
    }

    /**
     * @return decimal place of given salary
     */
    public int getDecimalPlace() {
        return decimalPlace;
    }

    @Override
    public String toString() {
        if (getDecimalPlace()<10) {
            return getIntegerPart() + ",0" + getDecimalPlace();
        }
        return getIntegerPart() + "," + getDecimalPlace();
    }
}
