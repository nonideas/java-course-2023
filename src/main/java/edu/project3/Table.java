package edu.project3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Table {
    private List<Map<String, String>> rows;

    public Table(List<Map<String, String>> rows) {
        this.rows = new ArrayList<>(rows);
        initializeColumns();
    }

    public List<Map<String, String>> getTableRows() {
        return rows;
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

    public void add(Map<String, String> newRow) {
        List<Map<String, String>> mutableRows = new ArrayList<>(rows);
        mutableRows.add(newRow);
        rows = new ArrayList<>(mutableRows);
    }

    public Set<String> getAllColumnLengths() {
        return new HashSet<>(columns);
    }
}

