package com.nulp.myhailo.path;

import java.io.File;

public class CipherPath {
    public static final String ROOT_FOLDER = ".";
    public static final String FILES_FOLDER = ROOT_FOLDER + File.separator + "files" + File.separator;
    public static final String MESSAGE_FILE = FILES_FOLDER + "message.txt";

    public static final String[] cipherFolders = {
            FILES_FOLDER + "caeser",
            FILES_FOLDER + "transposition",
            FILES_FOLDER + "substitution",
            FILES_FOLDER + "xor"
    };

    public static class CAESAR {
        public static final String ENCRYPTED_FILE = cipherFolders[0] + File.separator + "encrypted.txt";
        public static final String DECRYPTED_FILE = cipherFolders[0] + File.separator + "decrypted.txt";
    }

    public static class TRANSPOSITION {
        public static final String ENCRYPTED_FILE = cipherFolders[1] + File.separator + "encrypted.txt";
        public static final String DECRYPTED_FILE = cipherFolders[1] + File.separator + "decrypted.txt";
    }

    public static class SUBSTITUTION {
        public static final String ENCRYPTED_FILE = cipherFolders[2] + File.separator + "encrypted.txt";
        public static final String DECRYPTED_FILE = cipherFolders[2] + File.separator + "decrypted.txt";
    }

    public static class XOR {
        public static final String ENCRYPTED_FILE = cipherFolders[3] + File.separator + "encrypted.txt";
        public static final String DECRYPTED_FILE = cipherFolders[3] + File.separator + "decrypted.txt";
    }
}
