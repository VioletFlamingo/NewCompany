package main.java.pl.agh.jtp.home01.utils;

import main.java.pl.agh.jtp.home01.exceptions.CEOAlreadyHiredException;

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
