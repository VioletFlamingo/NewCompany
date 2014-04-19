package lab05;

public class Developer extends AbstractEmployee {

    public Developer (String name, String role) {
        this.setName(name);
        this.setRole(role);
    }

    @Override
    public String toString () {
        return "Developer: " + name + " - " + role;
    }

    @Override
    public Salary getSalary() {
        return null;
    }
}