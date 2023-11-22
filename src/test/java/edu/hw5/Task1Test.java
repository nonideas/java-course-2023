package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Task1Test {
    @Test
    void testCalculateAverageDuration() {
        String input = """
            2022-03-12, 20:20 - 2022-03-12, 23:50
            2022-04-01, 21:30 - 2022-04-02, 01:20""";

        String output = "3ч 40м";

        Assertions.assertEquals(output, Task1.calculateAverageDuration(input));
    }
}
