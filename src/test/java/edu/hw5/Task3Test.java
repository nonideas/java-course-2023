package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Optional;

public class Task3Test {
    @Test
    void testDashDate1() {
        var date = Optional.of(LocalDate.of(2020, 10, 10));
        Assertions.assertEquals(date, Task3.parseDate("2020-10-10"));
    }

    @Test
    void testDashDate2() {
        var date = Optional.of(LocalDate.of(2020, 1, 1));
        Assertions.assertEquals(date, Task3.parseDate("2020-1-1"));
    }

    @Test
    void testDashDate3() {
        var date = Optional.of(LocalDate.of(2020, 1, 10));
        Assertions.assertEquals(date, Task3.parseDate("2020-1-10"));
    }

    @Test
    void testDashDate4() {
        var date = Optional.of(LocalDate.of(2020, 10, 10));
        Assertions.assertEquals(date, Task3.parseDate("20-10-10"));
    }

    @Test
    void testSlashDate1() {
        var date = Optional.of(LocalDate.of(2020, 10, 10));
        Assertions.assertEquals(date, Task3.parseDate("10/10/2020"));
    }

    @Test
    void testSlashDate2() {
        var date = Optional.of(LocalDate.of(2020, 1, 1));
        Assertions.assertEquals(date, Task3.parseDate("1/1/2020"));
    }

    @Test
    void testSlashDate3() {
        var date = Optional.of(LocalDate.of(2020, 1, 10));
        Assertions.assertEquals(date, Task3.parseDate("10/1/2020"));
    }

    @Test
    void testSlashDate4() {
        var date = Optional.of(LocalDate.of(2020, 10, 10));
        Assertions.assertEquals(date, Task3.parseDate("10/10/20"));
    }

    @Test
    void testTomorrow() {
        var date = Optional.of(LocalDate.now().plusDays(1));
        Assertions.assertEquals(date, Task3.parseDate("tomorrow"));
    }

    @Test
    void testToday() {
        var date = Optional.of(LocalDate.now());
        Assertions.assertEquals(date, Task3.parseDate("today"));
    }

    @Test
    void testYesterday() {
        var date = Optional.of(LocalDate.now().minusDays(1));
        Assertions.assertEquals(date, Task3.parseDate("yesterday"));
    }

    @Test
    void testDaysAgo1() {
        var date = Optional.of(LocalDate.now().minusDays(1));
        Assertions.assertEquals(date, Task3.parseDate("1 day ago"));
    }

    @Test
    void testDaysAgo2234() {
        var date = Optional.of(LocalDate.now().minusDays(2234));
        Assertions.assertEquals(date, Task3.parseDate("2234 day ago"));
    }
}
