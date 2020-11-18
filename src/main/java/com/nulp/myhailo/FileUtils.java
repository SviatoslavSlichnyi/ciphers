package com.nulp.myhailo;

import com.nulp.myhailo.path.CipherPath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class FileUtils {

    // initialize folders
    static {
        String filesFolderPath = CipherPath.ROOT_FOLDER + File.separator + CipherPath.FILES_FOLDER;
        File filesFolder = new File(filesFolderPath);

        if (!filesFolder.exists()) {
            createFolderIfNotExist(filesFolder);
            createMessageTxtFile();
        }

        final String[] cipherFolders = CipherPath.cipherFolders;
        for (String cipherFolderName : cipherFolders) {
            createFolderIfNotExist(new File(cipherFolderName));
        }
    }

    private static void createFolderIfNotExist(File folder) {
        if (!folder.exists()) {
            final boolean wasCreated = folder.mkdir();

            // check if folder was successfully created
            //      else throw an exception
            if (!wasCreated) {
                try {
                    throw new IOException(String.format("folder with name %s was not created.", folder.getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createMessageTxtFile() {
        File messageTxt = new File(CipherPath.MESSAGE_FILE);
        try {
            if (!messageTxt.createNewFile()) {
                throw new IOException(String.format("file %s was not created.", messageTxt.getName()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(final String path)
            throws FileNotFoundException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException(String.format("file in path \"%s\" was not found.", path));
        }

        Scanner read = new Scanner(file);
        StringBuilder sb = new StringBuilder();
        while (read.hasNextLine()) {
            sb.append(read.nextLine()).append('\n');
        }
        read.close();
        return sb.toString();
    }

    public static void writeIntoFile(String path, String text) throws IOException {
        File file = new File(path);

        // creation of a new file
        final boolean doesNotFileExists = file.createNewFile();

        // file exists
        if (!doesNotFileExists) {
            // than delete it
            final boolean wasDeletedSuccessfully = file.delete();

            // If some problems occur while deleting a file
            if (!wasDeletedSuccessfully) {
                throw new FileAlreadyExistsException(
                        String.format("file with name %s was not deleted successfully", file.getName()));
            }
        }

        FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.close();
    }
}
