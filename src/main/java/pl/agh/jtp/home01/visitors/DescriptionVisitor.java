package main.java.pl.agh.jtp.home01.visitors;

import main.java.pl.agh.jtp.home01.employees.Employee;
import main.java.pl.agh.jtp.home01.employees.TeamManager;
import main.java.pl.agh.jtp.home01.utils.Company;

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
