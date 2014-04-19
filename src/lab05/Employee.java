package lab05;

public interface Employee {
    String getName();
    String getRole();

    void assign(Task task);

    Report getWork();

    Salary getSalary();
}

