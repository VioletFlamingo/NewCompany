package lab05;

import javax.sql.rowset.Predicate;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Paulina on 13.04.2014.
 */
public class Company implements Visitable {
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

    public Iterator<Employee> iterator(Predicate<Employee> predicate) {
        return null;
    }

    /**
     * Creates company and adds first employee
     * @param head
     */
    public Company (Employee head) {
        employeeCollection.add(head);
    }
}
