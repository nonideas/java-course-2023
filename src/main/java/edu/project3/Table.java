package edu.project3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {
    private List<Map<String, String>> rows;

    public Table(List<Map<String, String>> rows) {
        this.rows = new ArrayList<>(rows);
        initializeColumns();
    }

    public List<Map<String, String>> getTableRows() {
        return rows;
    }

    public List<String> getColumns() {
        return columns;
    }

    public int getSize() {
        return rows.size();
    }

    private List<String> columns;

    private void initializeColumns() {
        columns = new ArrayList<>();
        if (!rows.isEmpty()) {
            Map<String, String> firstRow = rows.get(0);
            columns.addAll(firstRow.keySet());
            for (Map<String, String> row : rows) {
                columns.addAll(row.keySet());
            }
        }
    }

    public void addAll(List<Map<String, String>> newRows) {
        List<Map<String, String>> mutableRows = new ArrayList<>(rows);
        mutableRows.addAll(newRows);
        rows = new ArrayList<>(mutableRows);
    }

    public void add(Map<String, String> newRow) {
        List<Map<String, String>> mutableRows = new ArrayList<>(rows);
        mutableRows.add(newRow);
        rows = new ArrayList<>(mutableRows);
    }

    public Map<String, Integer> getAllColumnLengths() {
        Map<String, Integer> result = new HashMap<>();
        for (String column : columns) {
            result.put(column, getColumnLength(column));
        }
        return result;
    }

    public int getColumnLength(String column) {
        if (!columns.contains(column)) {
            throw new IllegalArgumentException("No such column");
        }

        int maxLength = 0;
        for (Map<String, String> row : rows) {
            String value = row.get(column);
            int length = (value != null) ? value.length() : 4;
            maxLength = Math.max(maxLength, length);
        }
        return Math.max(maxLength, column.length());
    }

    public String getCell(int line, String column) {
        Map<String, String> row = rows.get(line);
        return row.get(column);
    }
}

