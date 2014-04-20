package lab05;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Administration administration = new Administration(Integer.parseInt(args[0]));
        //administration.administrate();

        /*
        try {
            Company company = new Company(CEO.hireCEO());
        } catch (CEOAlreadyHiredException e) {
            e.printStackTrace();
        }
        */
        try {
            FileBasedCompanyRepository myCompany = new FileBasedCompanyRepository();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
