package edu.project3.statsPrinter;

import edu.project3.Table;
import edu.project3.logWorkers.LogAnalyser;
import edu.project3.tablePrinters.TablePrinter;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class StatsPrinter {

    private final LogAnalyser logAnalyser = new LogAnalyser();
    private final TablePrinter tablePrinter;

    public StatsPrinter(TablePrinter tablePrinter) {
        this.tablePrinter = tablePrinter;
    }

    public void printOverallInfo(Table logs, List<String> sources, LocalDate from, LocalDate to) {
        Table overallInfoTable = new Table(List.of(
            Map.of("metrics", "Files", "value", sources.toString()),
            Map.of("metrics", "Start date", "value", from.toString()),
            Map.of("metrics", "End date", "value", to.toString()),
            Map.of("metrics", "Requests", "value", String.valueOf(logAnalyser.getRequestsAmount(logs))),
            Map.of("metrics", "Average response size", "value", String.valueOf(logAnalyser.getAverageResponseSize(logs)))
        ));
        tablePrinter.printTable(overallInfoTable, 0, "Overall information");
    }

    public void printTheMostPopularResources(Table logs, int maxLinesInTable) {
        Table resourcesTable = logAnalyser.getTheMostPopularResources(logs, maxLinesInTable, "");
        tablePrinter.printTable(resourcesTable, 0, "The most popular resources");
    }

    public void printTheMostPopularStatuses(Table logs, int maxLinesInTable) {
        Table statusesTable = logAnalyser.getTheMostPopularStatuses(logs, maxLinesInTable);
        tablePrinter.printTable(statusesTable, 0, "The most popular statuses");
    }

    public void printTheMostHighLoadedDays(Table logs, int maxLinesInTable) {
        Table daysTable = logAnalyser.getTheMostHighLoadedDays(logs, maxLinesInTable);
        tablePrinter.printTable(daysTable, 0, "The most highloaded days");
    }

    public void printTheMostActiveUsers(Table logs, int maxLinesInTable) {
        Table usersTable = logAnalyser.getTheMostActiveUsers(logs, maxLinesInTable);
        tablePrinter.printTable(usersTable, 0, "The most active users");
    }
}
