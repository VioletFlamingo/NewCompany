package lab05;

import lab05.employees.CEO;
import lab05.exceptions.CEOAlreadyHiredException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Paulina on 19.04.2014.
 */
public class FileBasedCompanyRepository {
    final CompanyRepository repository;
    final Company company;
    final File companyID;

    public FileBasedCompanyRepository() throws IOException, ClassNotFoundException, CEOAlreadyHiredException {
        repository = getCompanyRepository();
        companyID = askForFileName();
        if (companyID.exists()) {
            company = repository.load(companyID);
        } else {
            companyID.createNewFile();
            company = new Company(CEO.hireCEO());
        }
            Administration.takeActions();
            repository.persist(company, companyID);
    }

    private CompanyRepository getCompanyRepository() {
        return new CompanyRepository();
    }

    public static File askForFileName () {
        System.out.println("Enter file name:");
        Scanner scanner = new Scanner(System.in);
        return new File(scanner.nextLine()+".ser");
    }
}
