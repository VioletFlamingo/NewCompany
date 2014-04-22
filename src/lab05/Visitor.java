package lab05;

import lab05.employees.Employee;
import lab05.employees.TeamManager;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface Visitor {
    void visit(Employee employee);
    void visit(TeamManager manager);
}
