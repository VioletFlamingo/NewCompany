package lab05;

public class Main {
    public static void main(String[] args) {
        //Administration administration = new Administration(Integer.parseInt(args[0]));
        //administration.administrate();
        try {
            Company company = new Company(CEO.hireCEO());
        } catch (CEOAlreadyHiredException e) {
            e.printStackTrace();
        }
    }
}
