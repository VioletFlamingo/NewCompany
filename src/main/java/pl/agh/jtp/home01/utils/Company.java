package main.java.pl.agh.jtp.home01.utils;

import com.sun.istack.internal.NotNull;
import main.java.pl.agh.jtp.home01.employees.CEO;
import main.java.pl.agh.jtp.home01.employees.Employee;
import main.java.pl.agh.jtp.home01.employees.Manager;
import main.java.pl.agh.jtp.home01.employees.TeamManager;
import main.java.pl.agh.jtp.home01.exceptions.CEOAlreadyHiredException;
import main.java.pl.agh.jtp.home01.properties.Task;
import main.java.pl.agh.jtp.home01.visitors.Visitable;
import main.java.pl.agh.jtp.home01.visitors.Visitor;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Paulina on 13.04.2014.
 */

/**
 * Is a type of data structure that allows to store employees. Always contains at least one element.
 */
public class Company extends AbstractCollection<Employee> implements Visitable, Collection<Employee>, Serializable {

    private final CEO companyCEO;
    private List<Employee> employeeList;

    /**
     * Creates company consisting of one employee of type CEO given as parameter.
     * @param head main team manager of type CEO
     */
    public Company(CEO head) {
        employeeList = new ArrayList<Employee>();
        companyCEO = head;
        employeeList.add(head);
    }

    /**
     * Gives information on number of employees in company.
     * @return number of employees in company
     */
    @Override
    public int size() {
        return employeeList.size();
    }

    /**
     * Passes forward visitor given as parameter to employees in the company.
     * @param visitor - ??????
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(companyCEO);
    }

    /**
     * Assigns given task to employees in company.
     * @param task work to be done by employees
     */
    public void assignTaskToCompany(Task task) {
        companyCEO.assign(task);
    }

    public void getReport() {
        companyCEO.reportWork();
    }


    /**
     * Adds to the company given employee if there is a manager that is able to adopt him to his team.
     * CEO can only adopt team managers.
     * If there is no place for given team manager under other team manager, he is assigned to CEO.
     * @param employee person that is going to be hired of type Employee
     * @return information whether adding of given employee finished with success
     */
    @Override
    public boolean add(Employee employee){

        try {
            CheckIfNotAnotherCEO(employee);
        } catch (CEOAlreadyHiredException e) {
            throw new IllegalArgumentException(e);
        }

        Iterator<Employee> it = this.iterator(new Predicate<Employee>() {
            @Override
            public boolean apply(Employee element) {
                return ableToHireAndNotCEO(element);
            }

            private boolean ableToHireAndNotCEO(Employee element) {
                return (element instanceof Manager) && !(element instanceof CEO) && ((Manager) element).canHire();
            }
        });

        if (it.hasNext()) {
            ((Manager) it.next()).hire(employee);
            employeeList.add(employee);
            return true;
        }

        if (employee instanceof Manager && !(employee instanceof CEO)) {
            companyCEO.hire(employee);
            employeeList.add(employee);
            return true;
        }
        System.out.println("Company cannot hire another employee\n");
        return false;
    }

    private void CheckIfNotAnotherCEO(Employee employee) throws CEOAlreadyHiredException {
        if ((employee instanceof CEO)&&companyCEO!=null) {
            throw new CEOAlreadyHiredException();
        }
    }


    /**
     * Gives an iterator on company employees in DFS order. Remove operation does not work.
     * @return iterator on company employees
     */
    @Override
    @NotNull
    public Iterator<Employee> iterator() {
        return new CompanyIterator();
    }


    /**
     * Gives an iterator on company employees that comply with condition given
     * as parameter in DFS order.
     * Remove operation does not work.
     * @return iterator on company employees
     */
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
            this.predicate = predicate;
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
