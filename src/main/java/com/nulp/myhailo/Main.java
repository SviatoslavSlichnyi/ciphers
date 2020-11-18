package com.nulp.myhailo;

import com.nulp.myhailo.cipher.*;
import com.nulp.myhailo.path.CipherPath;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        doCaeserCipher();
        doTranspositionCipher();
        doSubstitutionCipher();
        doXorCipher();
    }

    private static void doCaeserCipher() throws IOException {
        final int key = 13;
        final String message = FileUtils.readFromFile(CipherPath.MESSAGE_FILE);

        Cipher caeserCipher = new CaeserCipher(key);

        String encrypt = caeserCipher.encrypt(message);
        FileUtils.writeIntoFile(CipherPath.CAESAR.ENCRYPTED_FILE, encrypt);

        final String encryptedFileMsg = FileUtils.readFromFile(CipherPath.CAESAR.ENCRYPTED_FILE);
        String decrypt = caeserCipher.decrypt(encryptedFileMsg);
        FileUtils.writeIntoFile(CipherPath.CAESAR.DECRYPTED_FILE, decrypt);

        System.out.println("doCaeserCipher: DONE");
    }

    private static void doTranspositionCipher() throws IOException {
        final String key = "password";
        final String message = FileUtils.readFromFile(CipherPath.MESSAGE_FILE);

        Cipher caeserCipher = new TranspositionCipher(key);

        String encrypt = caeserCipher.encrypt(message);
        FileUtils.writeIntoFile(CipherPath.TRANSPOSITION.ENCRYPTED_FILE, encrypt);

        final String encryptedFileMsg = FileUtils.readFromFile(CipherPath.TRANSPOSITION.ENCRYPTED_FILE);
        String decrypt = caeserCipher.decrypt(encryptedFileMsg);
        FileUtils.writeIntoFile(CipherPath.TRANSPOSITION.DECRYPTED_FILE, decrypt);

        System.out.println("doTranspositionCipher: DONE");
    }

    private static void doSubstitutionCipher() throws IOException {
        final String key = "password";
        final String message = FileUtils.readFromFile(CipherPath.MESSAGE_FILE);

        Cipher caeserCipher = new SubstitutionCipher(key);

        String encrypt = caeserCipher.encrypt(message);
        FileUtils.writeIntoFile(CipherPath.SUBSTITUTION.ENCRYPTED_FILE, encrypt);

        final String encryptedFileMsg = FileUtils.readFromFile(CipherPath.SUBSTITUTION.ENCRYPTED_FILE);
        String decrypt = caeserCipher.decrypt(encryptedFileMsg);
        FileUtils.writeIntoFile(CipherPath.SUBSTITUTION.DECRYPTED_FILE, decrypt);

        System.out.println("doSubstitutionCipher: DONE");
    }

    private static void doXorCipher() throws IOException {
        final String key = "password";
        final String message = FileUtils.readFromFile(CipherPath.MESSAGE_FILE);

        Cipher caeserCipher = new XorCipher(key);

        String encrypt = caeserCipher.encrypt(message);
        FileUtils.writeIntoFile(CipherPath.XOR.ENCRYPTED_FILE, encrypt);

        final String encryptedFileMsg = FileUtils.readFromFile(CipherPath.XOR.ENCRYPTED_FILE);
        String decrypt = caeserCipher.decrypt(encryptedFileMsg);
        FileUtils.writeIntoFile(CipherPath.XOR.DECRYPTED_FILE, decrypt);

        System.out.println("doXorCipher: DONE");
    }
}
