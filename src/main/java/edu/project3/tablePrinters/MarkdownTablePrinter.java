package edu.project3.tablePrinters;

import edu.project3.Table;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class MarkdownTablePrinter extends TablePrinter {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    @Override
    public void printTable(Table table, int amount, String header) {
        if (!header.isEmpty()) {
            LOGGER.info("#### " + header);
        }

        printColumnNames(table);
        printHeadSeparator(table);
        printTableItems(table, amount);
    }

    private void printColumnNames(Table table) {
        Map<String, Integer> columnLengths = table.getAllColumnLengths();
        LOGGER.info(buildColumnString(table.getColumns(), columnLengths));
    }

    private void printHeadSeparator(Table table) {
        Map<String, Integer> columnLengths = table.getAllColumnLengths();
        LOGGER.info(buildSeparator(columnLengths.keySet(), columnLengths));
    }

    private void printTableItems(Table table, int amount) {
        for (int line = 0; line < Math.min(amount, table.getSize()); line++) {
            Map<String, String> row = table.getTableRows().get(line);
            LOGGER.info(buildRowString(row, table.getAllColumnLengths()));
        }
    }

    private String buildSeparator(Iterable<String> columns, Map<String, Integer> columnLengths) {
        StringBuilder result = new StringBuilder("|");

        for (String column : columns) {
            int columnLen = columnLengths.get(column);
            result.append(":-").append("-".repeat(columnLen - 2)).append("-:").append(":|");
        }

        return result.toString();
    }
}
