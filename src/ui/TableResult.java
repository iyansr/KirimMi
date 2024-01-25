package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableResult {
    private final JTable table;
    private final DefaultTableModel tableModel;

    public TableResult(JTable table, DefaultTableModel tableModel) {
        this.table = table;
        this.tableModel = tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
