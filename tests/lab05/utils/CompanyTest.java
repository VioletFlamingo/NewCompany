package lab05.utils;

import junit.framework.Assert;
import lab05.employees.*;
import lab05.properties.Salary;
import lab05.strategies.DispatchEqually;
import lab05.strategies.DoAllWork;
import org.junit.Test;

import java.util.Iterator;

/**
 * Created by Paulina on 22.04.2014.
 */
public class CompanyTest {
    @Test
    public void oneAddedTestSize() throws Exception {
        CEO c=CEO.hireCEO();
        Company comp=new Company(c);
        Assert.assertEquals(1, comp.size());
    }

    @Test
    public void twoAddedTestSize() throws Exception {
        CEO c=CEO.hireCEO();
        Company comp=new Company(c);
        Manager m = new TeamManager("Pan Jan", "Manager", new Salary(12, 0), new DoAllWork(), 10, new DispatchEqually());
        comp.add(m);
        Assert.assertEquals(2, comp.size());
        Iterator<Employee> it = comp.iterator();
        Assert.assertEquals(c, it.next());
        Assert.assertEquals(m, it.next());
    }

    @Test
    public void addFirstEmployeeFailed () throws Exception {
        CEO c=CEO.hireCEO();
        Company comp=new Company(c);
        Employee e = new Developer("Pan Jan", "Dev", new Salary(12, 0), new DoAllWork());
        comp.add(e);
        Assert.assertEquals(1, comp.size());
        Iterator<Employee> it = comp.iterator();
        Assert.assertEquals(c, it.next());
        Assert.assertEquals(false, it.hasNext());
    }
}
