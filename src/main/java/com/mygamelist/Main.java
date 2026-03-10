package com.mygamelist;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import jakarta.xml.bind.JAXBException;

public class Main {
    private static final String FILE = "/gameList.xml";

    public static void main(String[] args) {
        try(InputStream inputStream = Main.class.getResourceAsStream(FILE)) {
            // Create a temp file
            Path tempFile = Files.createTempFile("resource-", ".tmp");
            tempFile.toFile().deleteOnExit();

            // Copy resource content to temp file
            Files.copy(inputStream, tempFile, REPLACE_EXISTING);

            // Now you have a real File object
            File file = tempFile.toFile();
            ManagerUI managerUI = new ManagerUI(file);
            managerUI.start();
        } catch (IOException | JAXBException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
