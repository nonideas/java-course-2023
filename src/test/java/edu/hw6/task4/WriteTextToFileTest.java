package edu.hw6.task4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WriteTextToFileTest {
    private static final String FILE_PATH = "./src/test/java/edu/hw6/task4/testFile.txt";

    @Test
    void solution_should_writeDateToFile() throws IOException {
        var message = "Programming is learned by writing programs. ― Brian Kernighan";

        WriteTextToFile.writeData(FILE_PATH, message);

        String recordedMessage;
        try (Scanner sc = new Scanner(new File(FILE_PATH))) {
            recordedMessage = sc.nextLine();
        }
        Assertions.assertEquals(recordedMessage, message);
    }
}
