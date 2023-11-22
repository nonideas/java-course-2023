package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final int BAD_DAY = 13;

    private Task2() {
    }

    public static List<LocalDate> getAllFriday13th(int year) {
        List<LocalDate> fridays = new ArrayList<>();

        LocalDate date = LocalDate.of(year, 1, 1);

        while (true) {
            date = getNextFriday13th(date);
            if (date.getYear() != year) {
                break;
            }
            fridays.add(date);
        }
        return fridays;
    }

    public static LocalDate getNextFriday13th(LocalDate date) {
        var curDate = date;
        do {
            curDate = curDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        } while (curDate.getDayOfMonth() != BAD_DAY);

        return curDate;
    }
}
