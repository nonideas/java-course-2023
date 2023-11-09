package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

public class Task2Test {
    @Test
    void testAllFriday13th2024() {
        List<LocalDate> dates = Task2.getAllFriday13th(2024);

        LocalDate output1 = LocalDate.of(2024, 9, 13);
        LocalDate output2 = LocalDate.of(2024, 12, 13);

        Assertions.assertEquals(output1, dates.get(0));
        Assertions.assertEquals(output2, dates.get(1));
    }

    @Test
    void testAllFriday13th1925() {
        List<LocalDate> dates = Task2.getAllFriday13th(1925);

        LocalDate output1 = LocalDate.of(1925, 2, 13);
        LocalDate output2 = LocalDate.of(1925, 3, 13);
        LocalDate output3 = LocalDate.of(1925, 11, 13);

        Assertions.assertEquals(output1, dates.get(0));
        Assertions.assertEquals(output2, dates.get(1));
        Assertions.assertEquals(output3, dates.get(2));
    }

    @Test
    void testNextFriday13th() {
        LocalDate input1 = LocalDate.of(1925, 1, 13);
        LocalDate input2 = LocalDate.of(1925, 3, 12);
        LocalDate input3 = LocalDate.of(1925, 3, 13);

        LocalDate output1 = LocalDate.of(1925, 2, 13);
        LocalDate output2 = LocalDate.of(1925, 3, 13);
        LocalDate output3 = LocalDate.of(1925, 11, 13);

        Assertions.assertEquals(output1, Task2.getNextFriday13th(input1));
        Assertions.assertEquals(output2, Task2.getNextFriday13th(input2));
        Assertions.assertEquals(output3, Task2.getNextFriday13th(input3));
    }
}
