package edu.project3;

import edu.project3.logWorkers.LogAnalyser;
import edu.project3.logWorkers.LogParser;
import edu.project3.statsPrinter.StatsPrinter;
import edu.project3.tablePrinters.ADocTablePrinter;
import edu.project3.tablePrinters.MarkdownTablePrinter;
import edu.project3.tablePrinters.TablePrinter;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class PrintInfo {
    private static final List<String> sources = new ArrayList<>();
    private static LocalDate from = null;
    private static LocalDate to = null;

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    private static TablePrinter tablePrinter = new MarkdownTablePrinter();

    private static final int maxLinesInTable = 5;

    private PrintInfo() {
    }

    public static void main(String[] params) {
        parseParams(params);

        List<String> nonParsedLogs = LogParser.combineLogs(sources);
        if (nonParsedLogs.isEmpty()) {
            LOGGER.info("No logs passed to program");
            return;
        }
        Table logs = LogParser.parseAllLogs(nonParsedLogs);
        logs = LogAnalyser.getDateConstrainedLogs(logs, from, to);

        StatsPrinter statsPrinter = new StatsPrinter(tablePrinter);
        statsPrinter.printOverallInfo(logs, sources, from, to, maxLinesInTable);
        LOGGER.info("");
        statsPrinter.printTheMostPopularStatuses(logs, maxLinesInTable);
        LOGGER.info("");
        statsPrinter.printTheMostHighLoadedDays(logs, maxLinesInTable);
        LOGGER.info("");
        statsPrinter.printTheMostActiveUsers(logs, maxLinesInTable);
        LOGGER.info("");
        statsPrinter.printTheMostPopularStatuses(logs, maxLinesInTable);
    }

    private static void parseParams(String[] params) {
        int i = 0;
        while (i != params.length) {
            switch (params[i]) {
                case "--from":
                    from = LocalDate.parse(params[i + 1]);
                    break;

                case "--to":
                    to = LocalDate.parse(params[i + 1]);
                    break;

                case "--format":
                    if (params[i + 1].equals("adoc")) {
                        tablePrinter = new ADocTablePrinter();
                    }
                    break;

                case "--path":
                    while (i + 1 != params.length && !params[i + 1].equals("--from")
                        && !params[i + 1].equals("--format") && !params[i + 1].equals("--lines")) {
                        i++;
                        sources.add(params[i]);
                    }
                    break;
                default:
                    break;
            }
            i++;
        }
    }
}
