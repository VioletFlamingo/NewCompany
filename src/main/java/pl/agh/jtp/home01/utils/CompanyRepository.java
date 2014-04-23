package main.java.pl.agh.jtp.home01.utils;

import java.io.*;

/**
 * Created by Paulina on 19.04.2014.
 */
public class CompanyRepository {

    /**
     * Loads saved company state form given file.
     * @param file document from which company is about to be loaded
     * @return loaded company
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Company load(File file) throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Company company = (Company) in.readObject();
        in.close();
        return company;
    }

    /**
     * Saves company state in file.
     * @param company company that we want to save
     * @param file document in which company is going to be saved
     * @throws IOException
     */
    public void persist(Company company, File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(company);
        out.close();
    }
}
