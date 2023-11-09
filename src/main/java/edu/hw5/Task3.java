package edu.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Task3 {
    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String dateString) {
        return parseDashDate(dateString);
    }

    private static Optional<LocalDate> parseDashDate(String dateString) {
        if (!dateString.matches("\\d{1,4}-\\d{1,2}-\\d{1,2}")) {
            return parseSlashDate(dateString);
        }

        String[] lengths = dateString.split("-");

        var pattern = DateTimeFormatter
            .ofPattern(
                "y".repeat(lengths[0].length()) + "-"
                    + "M".repeat(lengths[1].length()) + "-"
                    + "d".repeat(lengths[2].length())
            );

        return Optional.of(LocalDate.parse(dateString, pattern));
    }

    private static Optional<LocalDate> parseSlashDate(String dateString) {
        if (!dateString.matches("\\d{1,2}/\\d{1,2}/\\d{1,4}")) {
            return parseOneWordDate(dateString);
        }

        String[] lengths = dateString.split("/");

        var pattern = DateTimeFormatter
            .ofPattern(
                "d".repeat(lengths[0].length()) + "/"
                    + "M".repeat(lengths[1].length()) + "/"
                    + "y".repeat(lengths[2].length())
            );

        return Optional.of(LocalDate.parse(dateString, pattern));
    }

    private static Optional<LocalDate> parseOneWordDate(String dateString) {
        if (!dateString.matches("\\w*")) {
            return parseNDaysAgo(dateString);
        }
        return switch (dateString) {
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            default -> parseNDaysAgo(dateString);
        };
    }

    private static Optional<LocalDate> parseNDaysAgo(String dateString) {
        if (!dateString.matches("\\d+ (day)s? ago")) {
            return Optional.empty();
        }
        var days = Long.parseLong(dateString.split(" ")[0]);

        return Optional.of(LocalDate.now().minusDays(days));
    }
}
