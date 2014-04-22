package lab05.visitors;

import lab05.employees.Employee;
import lab05.employees.TeamManager;

import java.io.Serializable;

/**
 * Created by Paulina on 13.04.2014.
 */
public interface Visitor extends Serializable {
    void visit(Employee employee);

    void visit(TeamManager manager);
}
