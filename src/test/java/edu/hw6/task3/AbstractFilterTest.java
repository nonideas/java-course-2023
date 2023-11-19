package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class AbstractFilterTest {
    private static final Path TEST_FILES_PATH = Paths.get("./src/test/java/edu/hw6/Task3/testFiles/");

    @Test
    void testFilters() throws IOException {
        var correctFileName = "testFile1.txt";
        DirectoryStream.Filter<Path> filter = MyFilters.isRegularFile()
            .and(MyFilters.isReadable())
            .and(MyFilters.isWritable())
            .and(MyFilters.magicNumber('1'))
            .and(MyFilters.largerThan(5))
            .and(MyFilters.globMatcher("txt"))
            .and(MyFilters.regexMatches(".*test.*"));

        var returnedFiles = new ArrayList<String>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(TEST_FILES_PATH, filter)) {
            entries.forEach(filePath ->
                returnedFiles.add(
                    filePath.getFileName().toString()
                )
            );
        }

        Assertions.assertThat(returnedFiles).containsExactly(correctFileName);
    }
}
