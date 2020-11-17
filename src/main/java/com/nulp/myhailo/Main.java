package com.nulp.myhailo;

import com.nulp.myhailo.cipher.CaeserCipher;

public class Main {
    public static void main(String[] args) {
        String message = "Hello, Myhailo!!! How is it going on?";
        int key = 2;

        String encrypt = CaeserCipher.encrypt(message, key);
        System.out.println(encrypt);

        String decrypt = CaeserCipher.decrypt(encrypt, key);
        System.out.println(decrypt);
    }
}
