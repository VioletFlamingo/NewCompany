package lab05;

public class Tester extends AbstractEmployee {

    public Tester (String name, String role) {
        //super(name, role);
        this.setName(name);
        this.setRole(role);
    }


    @Override
    public String toString () {
        return "Tester: " + name + " - " + role;
    }
}
