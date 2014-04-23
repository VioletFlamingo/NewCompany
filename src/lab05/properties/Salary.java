package lab05.properties;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */
public class Salary implements Serializable {
    private final int integerPart;
    private final int decimalPlace;

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


    public int getIntegerPart() {
        return integerPart;
    }


    public int getDecimalPlace() {
        return decimalPlace;
    }

    @Override
    public String toString() {
        return getIntegerPart() + "," + getDecimalPlace();
    }
}
