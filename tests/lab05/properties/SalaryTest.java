package lab05.properties;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Paulina on 23.04.2014.
 */
public class SalaryTest {

    @Test
    public void checkValueSaving () {
        Salary s1=new Salary(100, 2332);
        Assert.assertEquals(32, s1.getDecimalPlace());
        Assert.assertEquals(123, s1.getIntegerPart());
    }

    @Test
    public void checkNegativeNumber () {
        Salary s1=new Salary(-2, 4);
        Salary s2=new Salary(2, -4);
        Salary s3=new Salary(-2, -4);

        Assert.assertEquals(0, s1.getIntegerPart());
        Assert.assertEquals(0, s1.getDecimalPlace());

        Assert.assertEquals(0, s2.getIntegerPart());
        Assert.assertEquals(0, s2.getDecimalPlace());

        Assert.assertEquals(0, s3.getIntegerPart());
        Assert.assertEquals(0, s3.getDecimalPlace());
    }
}
