package controller;

import java.security.NoSuchAlgorithmException;
import model.util.EncryptMD5;

public class TesteMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String nome = "Gedalias";
        
        EncryptMD5 encrypt = new EncryptMD5();
        
        System.out.println(encrypt.encrypt(nome));
    }
    
}
