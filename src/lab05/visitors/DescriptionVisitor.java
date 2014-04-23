package lab05.visitors;

import lab05.employees.Employee;
import lab05.employees.TeamManager;
import lab05.properties.Salary;
import lab05.utils.Company;

/**
 * Created by Paulina on 23.04.2014.
 */
public class DescriptionVisitor implements Visitor{

    public String summation (Company company) {
        return "Number of employees: "+company.size()+"\n\n";
    }

    @Override
    public void visit(Employee employee) {
        System.out.println(employee.toString());
    }

    public void visit(TeamManager manager) {
        System.out.println(manager.toString());
        for (Employee e : manager) {
            e.accept(this);
        }
    }
}
