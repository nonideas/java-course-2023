package edu.project3.tablePrinters;

import edu.project3.Table;
import java.util.Map;
import java.util.Set;

public abstract class TablePrinter {

    public abstract void printTable(Table table, int amount, String header);

    protected String centerString(String input, int size) {
        return String.format(
            "%" + size + "s", String.format("%-" + (input.length() + (size - input.length()) / 2) + "s", input)
        );
    }

    protected String buildColumnString(Set<String> columnLengths) {
        StringBuilder result = new StringBuilder("|");

        for (String column : columnLengths) {
            result.append(centerString(column, column.length())).append("|");
        }

        return result.toString();
    }

    protected String buildRowString(Map<String, String> row, Set<String> columns) {
        StringBuilder result = new StringBuilder("|");

        for (Map.Entry<String, String> entry : row.entrySet()) {
            String cellValue = entry.getValue() != null ? entry.getValue() : "null";
            int columnLen = columns.size();
            result.append(centerString(cellValue, columnLen)).append("|");
        }

        return result.toString();
    }
}
