package lab05.utils;

import lab05.exceptions.CEOAlreadyHiredException;

import java.io.IOException;


/**
 * ???????
 */
public class Main {

    public static void main(String[] args) {
        try {
            FileBasedCompanyRepository myCompany = new FileBasedCompanyRepository();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (CEOAlreadyHiredException e) {
            e.printStackTrace();
        }
    }
}
