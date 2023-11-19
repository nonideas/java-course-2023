package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class FileClonerTest {

    private static final String PARENT_PATH = "./src/test/java/edu/hw6/Task2";

    @Test
    void firstCopy() throws IOException {
        var originalFileName = "originalFile.txt";
        var originalFilePath = Paths.get(PARENT_PATH + "/" + originalFileName);

        var clonedFileName = "originalFile - copy.txt";
        var clonedFilePath = Paths.get(PARENT_PATH + "/" + clonedFileName);


        Files.deleteIfExists(originalFilePath);
        Files.deleteIfExists(clonedFilePath);

        Files.createFile(originalFilePath);
        FileCloner.cloneFile(originalFilePath);

        Files.deleteIfExists(originalFilePath);
        Files.deleteIfExists(clonedFilePath);
    }

    @Test
    void secondCopy() throws IOException {
        var originalFileName = "originalFile.txt";
        var originalFilePath = Paths.get(PARENT_PATH + "/" + originalFileName);

        var firstClonedFileName = "originalFile - copy.txt";
        var firstClonedFilePath = Paths.get(PARENT_PATH + "/" + firstClonedFileName);

        var secondClonedFileName = "originalFile - copy (2).txt";
        var secondClonedFilePath = Paths.get(PARENT_PATH + "/" + secondClonedFileName);


        Files.deleteIfExists(originalFilePath);
        Files.deleteIfExists(secondClonedFilePath);

        Files.createFile(originalFilePath);
        FileCloner.cloneFile(originalFilePath);
        FileCloner.cloneFile(originalFilePath);

        Files.deleteIfExists(originalFilePath);
        Files.deleteIfExists(firstClonedFilePath);
        Files.deleteIfExists(secondClonedFilePath);
    }

}
