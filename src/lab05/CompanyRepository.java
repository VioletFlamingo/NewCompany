package lab05;

import java.io.*;

/**
 * Created by Paulina on 19.04.2014.
 */
public class CompanyRepository {
    private File file;

    public Company load (File file) throws IOException, ClassNotFoundException {
        if(!file.exists()) {
            throw new FileNotFoundException();
        }
        this.file=file;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Company company = (Company) in.readObject();
        in.close();
        return company;
    }

    public void persist(Company company) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(company);
        out.close();
    }
}
