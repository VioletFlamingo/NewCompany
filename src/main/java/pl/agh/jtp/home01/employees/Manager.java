package main.java.pl.agh.jtp.home01.employees;

public interface Manager extends Employee {

    public void hire(Employee employee);

    public boolean canHire();
}

