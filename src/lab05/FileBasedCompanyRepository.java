package lab05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Paulina on 19.04.2014.
 */
public class FileBasedCompanyRepository {
    final CompanyRepository repository;
    final Company company;
    final File companyID;

    public FileBasedCompanyRepository() throws IOException, ClassNotFoundException {
        repository = getCompanyRepository();
        companyID = askForFileName();
        company = repository.load(companyID);
    }

    private CompanyRepository getCompanyRepository() {
        return new CompanyRepository();
    }

    private File askForFileName () {
        System.out.println("Enter file name:");
        Scanner scanner = new Scanner(System.in);
        return new File(scanner.nextLine()+".xml");
    }
}
