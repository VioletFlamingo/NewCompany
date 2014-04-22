package lab05.employees;

public interface Manager extends Employee {

    public void hire(Employee employee);

    public void fire(int which);

    public boolean canHire();
}

