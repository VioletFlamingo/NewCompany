package lab05.utils;

import java.io.*;

/**
 * Created by Paulina on 19.04.2014.
 */
public class CompanyRepository {
    public Company load(File file) throws IOException, ClassNotFoundException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Company company = (Company) in.readObject();
        in.close();
        return company;
    }

    public void persist(Company company, File file) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(company);
        out.close();
    }
}
