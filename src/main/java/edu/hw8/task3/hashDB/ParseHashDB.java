package edu.hw8.task3.hashDB;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParseHashDB {
    private static final String DEFAULT_FILE_PATH = "./src/main/java/edu/hw8/task3/hashDB/hash.txt";

    private ParseHashDB() {
    }

    public static Map<String, String> loadHash() {
         return loadHash(DEFAULT_FILE_PATH);
    }

    public static Map<String, String> loadHash(String filePath) {
        Map<String, String> usersByHash = new HashMap<>();
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                usersByHash.put(data[1], data[0]);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return usersByHash;
    }
}
