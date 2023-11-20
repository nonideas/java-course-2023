package edu.project3.tablePrinters;

import edu.project3.Table;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;

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
        Set<String> columnLengths = table.getAllColumnLengths();
        LOGGER.info(buildColumnString(columnLengths));
    }

    private void printHeadSeparator(Table table) {
        Set<String> columnLengths = table.getAllColumnLengths();
        LOGGER.info(buildSeparator(columnLengths));
    }

    private void printTableItems(Table table, int amount) {
        for (int line = 0; line < Math.min(amount, table.getSize()); line++) {
            Map<String, String> row = table.getTableRows().get(line);
            LOGGER.info(buildRowString(row, table.getAllColumnLengths()));
        }
    }

    private String buildSeparator(Set<String> columns) {
        StringBuilder result = new StringBuilder("|");

        for (String column : columns) {
            int columnLen = column.length();
            result.append(":-").append("-".repeat(columnLen - 1)).append(":|");
        }

        return result.toString();
    }
}
