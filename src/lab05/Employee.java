package lab05;

public interface Employee extends Visitable{
    String getName();
    String getRole();

    void assign(Task task);

    Report getWork();

    Salary getSalary();
}

