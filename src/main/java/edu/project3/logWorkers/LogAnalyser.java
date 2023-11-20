package edu.project3.logWorkers;

import edu.project3.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogAnalyser {

    public int getRequestsAmount(Table logs) {
        return logs.getSize();
    }

    public Table getTheMostPopularResources(Table logs, int amount, String request) {
        List<Map<String, String>> sortedLogs = logs.getTableRows().stream()
            .filter(row -> row.get("request_type") != null && row.get("request_type").equals(request))
            .map(row -> Map.of("resource", row.get("request"), "value", "1"))
            .collect(Collectors.groupingBy(m -> m.get("resource"), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(amount)
            .map(entry -> Map.of("resource", entry.getKey(), "value", entry.getValue().toString()))
            .collect(Collectors.toList());

        return new Table(sortedLogs);
    }

    public Table getTheMostPopularStatuses(Table logs, int amount) {
        List<Map<String, String>> sortedLogs = logs.getTableRows().stream()
            .filter(row -> row.get("status") != null)
            .map(row -> Map.of("status", row.get("status"), "responses", "1"))
            .collect(Collectors.groupingBy(m -> m.get("status"), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(amount)
            .map(entry -> Map.of("status", entry.getKey(), "responses", entry.getValue().toString()))
            .collect(Collectors.toList());

        return new Table(sortedLogs);
    }

    public double getAverageResponseSize(Table logs) {
        List<Map<String, String>> validRows = logs.getTableRows().stream()
            .filter(row -> row.get("body_bytes_sent") != null)
            .toList();

        if (validRows.isEmpty()) {
            return 0.0;
        }

        double totalSize = validRows.stream()
            .mapToDouble(row -> Double.parseDouble(row.get("body_bytes_sent")))
            .sum();

        return totalSize / validRows.size();
    }

    public Table getTheMostHighLoadedDays(Table logs, int amount) {
        List<Map<String, String>> sortedLogs = logs.getTableRows().stream()
            .filter(row -> row.get("time_local") != null)
            .map(row -> LocalDateTime.parse(row.get("time_local"), DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z")).toLocalDate())
            .collect(Collectors.groupingBy(date -> date, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<LocalDate, Long>comparingByValue().reversed())
            .limit(amount)
            .map(entry -> Map.of("day", entry.getKey().toString(), "requests", entry.getValue().toString()))
            .collect(Collectors.toList());

        return new Table(sortedLogs);
    }

    public Table getTheMostActiveUsers(Table logs, int amount) {
        List<Map<String, String>> sortedLogs = logs.getTableRows().stream()
            .filter(row -> row.get("remote_addr") != null)
            .map(row -> row.get("remote_addr").equals("localhost") ? "127.0.0.1" : row.get("remote_addr"))
            .collect(Collectors.groupingBy(ip -> ip, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(amount)
            .map(entry -> Map.of("user_ip", entry.getKey(), "requests", entry.getValue().toString()))
            .collect(Collectors.toList());

        return new Table(sortedLogs);
    }

    public Table getDateConstrainedLogs(Table logs, LocalDate from, LocalDate to) {
        List<Map<String, String>> constrainedLogs = new ArrayList<>();

        for (Map<String, String> row : logs.getTableRows()) {
            if (row.get("time_local") != null) {
                LocalDate logDate = LocalDateTime.parse(row.get("time_local"), DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z"))
                    .toLocalDate();

                if ((from == null || !logDate.isBefore(from)) && (to == null || !logDate.isAfter(to))) {
                    constrainedLogs.add(row);
                }
            }
        }

        return new Table(constrainedLogs);
    }
}
