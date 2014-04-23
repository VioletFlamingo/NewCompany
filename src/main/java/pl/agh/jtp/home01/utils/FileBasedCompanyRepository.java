package main.java.pl.agh.jtp.home01.utils;

import main.java.pl.agh.jtp.home01.employees.CEO;
import main.java.pl.agh.jtp.home01.exceptions.CEOAlreadyHiredException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Paulina on 19.04.2014.
 */

/**
 * Manages company repository.
 */
public class FileBasedCompanyRepository {
    final CompanyRepository repository;
    final Company company;
    final File companyID;

    /**
     * Takes main actions connected with working on company.
     * If file from which we want to load company exists - loads company and allows user to work on it.
     * Otherwise creates new company.
     * After all actions on company are finished, saves company in file given before.
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws CEOAlreadyHiredException
     */
    public FileBasedCompanyRepository() throws IOException, ClassNotFoundException, CEOAlreadyHiredException {
        repository = getCompanyRepository();
        companyID = askForFileName();
        if (companyID.exists()) {
            company = repository.load(companyID);
        } else {
            if(!companyID.createNewFile()) {
                throw new IOException();
            }
            company = new Company(CEO.hireCEO());
        }
        Administration.takeActions(company);
        repository.persist(company, companyID);
    }

    private CompanyRepository getCompanyRepository() {
        return new CompanyRepository();
    }

    /**
     * Collects information on name of file from which company is about to be loaded.
     * @return file of .ser type from typed name
     */
    public static File askForFileName() {
        System.out.println("Enter file name:");
        Scanner scanner = new Scanner(System.in);
        return new File(scanner.nextLine() + ".ser");
    }
}
