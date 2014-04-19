package lab05;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Paulina on 13.04.2014.
 */
public class Company {
    Collection<Employee> employeeCollection = new AbstractCollection<Employee>() {
        @Override
        public Iterator<Employee> iterator() {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    };
}
