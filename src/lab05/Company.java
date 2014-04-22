package lab05;

import lab05.employees.CEO;
import lab05.employees.Employee;
import lab05.employees.Manager;
import lab05.employees.TeamManager;
import lab05.properties.Task;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Paulina on 13.04.2014.
 */
public class Company extends AbstractCollection<Employee> implements Visitable, Collection<Employee>, Serializable {

    private CEO companyCEO;
    private List<Employee> employeeList;

    public Company(CEO head) {
        employeeList = new ArrayList<Employee>();
        companyCEO = head;
        add(companyCEO);
    }

    @Override
    public int size() {
        return employeeList.size();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(companyCEO);
    }


    /**
     *
     * @param employee
     * @return
     */
    @Override
    public boolean add(Employee employee) {
        Iterator<Employee> it = this.iterator(new Predicate<Employee>() {
            @Override
            public boolean apply(Employee element) {
                if (ableToHireAndNotCEO(element)) {
                    return true;
                }
                return false;
            }

            private boolean ableToHireAndNotCEO(Employee element) {
                return (element instanceof Manager)&&!(element instanceof CEO)&&((Manager) element).canHire();
            }
        });

        while (it.hasNext()) {
            ((Manager)it.next()).hire(employee);
            employeeList.add(employee);
            return true;
        }
        if (employee instanceof Manager) {
            companyCEO.hire(employee);
            employeeList.add(employee);
            return true;
        }
        return false;
    }



    @Override
    public Iterator<Employee> iterator() {
        return new CompanyIterator();
    }

    public Iterator<Employee> iterator(Predicate<Employee> predicate) {
        return new PredicateCompanyIterator(predicate);
    }

    class CompanyIterator implements Iterator<Employee> {
        Stack<Employee> employeeStack = new Stack<Employee>();

        private void addToStack(Employee emp) {
            if (emp instanceof TeamManager) {
                for (Employee subordinate : (TeamManager) emp) {
                    addToStack(subordinate);
                }
            }
            employeeStack.push(emp);
        }

        CompanyIterator() {
            addToStack(companyCEO);
        }

        @Override
        public boolean hasNext() {
            return !employeeStack.empty();
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

    class PredicateCompanyIterator implements Iterator<Employee> {
        Stack<Employee> employeeStack = new Stack<Employee>();
        Predicate<Employee> predicate;

        private void addToStack(Employee emp) {
            if (emp instanceof TeamManager) {
                for (Employee subordinate : (TeamManager) emp) {
                    addToStack(subordinate);
                }
            }
            if (predicate.apply(emp)) {
                employeeStack.push(emp);
            }
        }

        PredicateCompanyIterator(Predicate<Employee> predicate) {
            this.predicate=predicate;
            addToStack(companyCEO);
        }

        @Override
        public boolean hasNext() {
            return !employeeStack.empty();
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
