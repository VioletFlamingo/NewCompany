package lab05;

import lab05.employees.AbstractEmployee;
import lab05.employees.Employee;
import lab05.employees.TeamManager;
import lab05.properties.Salary;

import java.util.Iterator;

/**
 * Created by Paulina on 21.04.2014.
 */
public class SalaryReportVisitor implements Visitor{

    int sumInteger, sumDecimal;
    int numOfEmp;

    public String getReport() {
        if (sumDecimal>99) {
            int tmp = sumDecimal;
            sumDecimal=tmp%100;
            sumInteger+=tmp/100;
        }

        int intDivided=sumInteger*100/numOfEmp;
        int averageDec=intDivided%100;
        int averageInt=intDivided / 100;
        averageDec+=sumDecimal/numOfEmp;

        if (averageDec>99) {
            int tmp=averageDec;
            averageDec=tmp%100;
            averageInt+=tmp/100;
        }
        return "Average salary is: "+new Salary(averageInt, averageDec);
    }


    @Override
    public void visit(Employee employee) {
        Salary s = employee.getSalary();
        sumInteger+=s.getIntegerPart();
        sumDecimal+=s.getDecimalPlace();
        numOfEmp++;
    }

    public void visit(TeamManager manager) {
        Salary s = manager.getSalary();
        sumInteger+=s.getIntegerPart();
        sumDecimal+=s.getDecimalPlace();
        numOfEmp++;
        for (Employee e : manager) {
            e.accept(this);
        }
    }

}
