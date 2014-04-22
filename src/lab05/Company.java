package lab05;

import lab05.employees.CEO;
import lab05.employees.Employee;

import javax.sql.rowset.Predicate;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Paulina on 13.04.2014.
 */
public class Company implements Visitable, Iterable<Employee> {
    private CEO companyCEO;
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

    public Company (CEO head) {
        companyCEO=head;
        employeeCollection.add(companyCEO);
    }

    @Override
    public Iterator<Employee> iterator() {
        /*
        Stack<Employee> employeeStack = new Stack<Employee>();
        addToStack(companyCEO);

        private void addToStack(Employee emp) {
            if (emp instanceof TeamManager) {
                for (Employee subordinate : ....) {
                    addToStack(subordinate);
                }
            }
            employeeStack.push(emp);
        }
        */

        return new Iterator<Employee>() {
            @Override
            public boolean hasNext() {
                if (employeeStack.empty()) {
                    return false;
                }
                return true;
            }

            @Override
            public Employee next() {
                return employeeStack.pop();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(companyCEO);
    }
}
