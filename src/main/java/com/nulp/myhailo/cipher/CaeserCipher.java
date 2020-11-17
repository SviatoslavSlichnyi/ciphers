package com.nulp.myhailo.cipher;

import com.sun.xml.internal.ws.util.StringUtils;

public class CaeserCipher {
    public static String encrypt(String msg, int key) {
        if (msg.isEmpty() || key == 0) {
            return msg;
        }

        StringBuilder ciphertext = new StringBuilder();
        char alphabet;
        for (int i = 0; i < msg.length(); i++) {
            // Shift one character at a time
            alphabet = msg.charAt(i);

            // if alphabet lies between a and z
            if (alphabet >= 'a' && alphabet <= 'z') {
                // key alphabet
                alphabet = (char) (alphabet + key);
                // if key alphabet greater than 'z'
                if (alphabet > 'z') {
                    // reshift to starting position
                    alphabet = (char) (alphabet + 'a' - 'z' - 1);
                }
                ciphertext.append(alphabet);
            }

            // if alphabet lies between 'A' and 'Z'
            else if (alphabet >= 'A' && alphabet <= 'Z') {
                // key alphabet
                alphabet = (char) (alphabet + key);

                // if key alphabet greater than 'Z'
                if (alphabet > 'Z') {
                    //reshift to starting position
                    alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                }
                ciphertext.append(alphabet);
            } else {
                ciphertext.append(alphabet);
            }

        }

        return ciphertext.toString();
    }

    public static String decrypt(String msg, int key) {
        if (msg.isEmpty() || key == 0) {
            return msg;
        }

        StringBuilder decryptMessage = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            // Shift one character at a time
            char alphabet = msg.charAt(i);
            // if alphabet lies between a and z
            if (alphabet >= 'a' && alphabet <= 'z') {
                // key alphabet
                alphabet = (char) (alphabet - key);

                // key alphabet lesser than 'a'
                if (alphabet < 'a') {
                    //reshift to starting position
                    alphabet = (char) (alphabet - 'a' + 'z' + 1);
                }
                decryptMessage.append(alphabet);
            }
            // if alphabet lies between A and Z
            else if (alphabet >= 'A' && alphabet <= 'Z') {
                // key alphabet
                alphabet = (char) (alphabet - key);

                //key alphabet lesser than 'A'
                if (alphabet < 'A') {
                    // reshift to starting position
                    alphabet = (char) (alphabet - 'A' + 'Z' + 1);
                }
                decryptMessage.append(alphabet);
            } else {
                decryptMessage.append(alphabet);
            }
        }
        return decryptMessage.toString();
    }
}
