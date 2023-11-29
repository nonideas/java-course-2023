package edu.project3.statsPrinter;

import edu.project3.Table;
import edu.project3.logWorkers.LogAnalyser;
import edu.project3.tablePrinters.TablePrinter;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class StatsPrinter {
    private final TablePrinter tablePrinter;

    public StatsPrinter(TablePrinter tablePrinter) {
        this.tablePrinter = tablePrinter;
    }

    @SuppressWarnings("MultipleStringLiterals")
    public void printOverallInfo(Table logs, List<String> sources, LocalDate from, LocalDate to, int maxLinesInTable) {
        Table overallInfoTable = new Table(List.of(
            Map.of("metrics", "Files", "value", sources.toString()),
            Map.of("metrics", "Start date", "value", from != null ? from.toString() : ""),
            Map.of("metrics", "End date", "value", to != null ? to.toString() : ""),
            Map.of("metrics", "Requests", "value", String.valueOf(LogAnalyser.getRequestsAmount(logs))),
            Map.of("metrics", "Average response size", "value",
                String.valueOf(LogAnalyser.getAverageResponseSize(logs)))
        ));
        tablePrinter.printTable(overallInfoTable, maxLinesInTable, "Overall information");
    }

    public void printTheMostPopularResources(Table logs, int maxLinesInTable) {
        Table resourcesTable = LogAnalyser.getTheMostPopularResources(logs, maxLinesInTable, "");
        tablePrinter.printTable(resourcesTable, maxLinesInTable, "The most popular resources");
    }

    public void printTheMostPopularStatuses(Table logs, int maxLinesInTable) {
        Table statusesTable = LogAnalyser.getTheMostPopularStatuses(logs, maxLinesInTable);
        tablePrinter.printTable(statusesTable, maxLinesInTable, "The most popular statuses");
    }

    public void printTheMostHighLoadedDays(Table logs, int maxLinesInTable) {
        Table daysTable = LogAnalyser.getTheMostHighLoadedDays(logs, maxLinesInTable);
        tablePrinter.printTable(daysTable, maxLinesInTable, "The most highloaded days");
    }

    public void printTheMostActiveUsers(Table logs, int maxLinesInTable) {
        Table usersTable = LogAnalyser.getTheMostActiveUsers(logs, maxLinesInTable);
        tablePrinter.printTable(usersTable, maxLinesInTable, "The most active users");
    }
}
