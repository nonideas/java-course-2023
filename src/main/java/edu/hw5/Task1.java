package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    private Task1() {
    }

    public static String calculateAverageDuration(String inputDurations) {
        String[] durations = inputDurations.split("\n");

        Duration averageDuration = Duration.ZERO;

        for (String duration : durations) {
            averageDuration = averageDuration.plus(getDuration(duration));
        }
        averageDuration = averageDuration.dividedBy(durations.length);

        long house = averageDuration.toHours();
        long minutes = averageDuration.minusHours(house).toMinutes();

        return house + "ч " + minutes + "м";
    }

    private static Duration getDuration(String duration) {
        String[] dateTimes = duration.split(" - ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

        LocalDateTime startTime = LocalDateTime.parse(dateTimes[0], formatter);
        LocalDateTime endTime = LocalDateTime.parse(dateTimes[1], formatter);

        return Duration.between(startTime, endTime);
    }
}
