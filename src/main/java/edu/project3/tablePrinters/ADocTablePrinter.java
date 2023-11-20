package edu.project3.tablePrinters;

import edu.project3.Table;
import org.apache.logging.log4j.LogManager;

import java.util.Map;

public class ADocTablePrinter extends TablePrinter {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    @Override
    public void printTable(Table table, int amount, String header) {
        if (!header.isEmpty()) {
            LOGGER.info("= " + header);
        }

        LOGGER.info("|===");

        printColumnNames(table);
        printTableItems(table, amount);

        LOGGER.info("|===");
    }

    private void printColumnNames(Table table) {
        Map<String, Integer> columnLengths = table.getAllColumnLengths();
        LOGGER.info(buildColumnString(table.getColumns(), columnLengths));
        LOGGER.info("|");
    }

    private void printTableItems(Table table, int amount) {
        for (int line = 0; line < Math.min(amount, table.getSize()); line++) {
            Map<String, String> row = table.getTableRows().get(line);
            LOGGER.info(buildRowString(row, table.getAllColumnLengths()));
        }
    }
}
