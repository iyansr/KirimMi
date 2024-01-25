package ui;

import controller.KurirController;
import entity.Kurir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;

public class TableKurir {

    public static TableResult displayKurirTable(Connection connection) {
        try {
            ArrayList<Kurir> listKurir = KurirController.getAllKurir(connection);
            DefaultTableModel tableModel;
            JTable table;

            if (listKurir != null) {
                tableModel = getDefaultKurirTableModel(listKurir);
                table = new JTable(tableModel);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                return new TableResult(table, tableModel);
            }
            return null;
        } catch (Exception error) {
            System.err.print(error.getMessage());
            return null;
        }
    }

    private static DefaultTableModel getDefaultKurirTableModel(ArrayList<Kurir> listKurir) {
        String[] columnNames = {"ID", "Nama Kurir", "Jenis Kendaraan", "Plat Nomor", "Nomor HP"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Kurir kurir : listKurir) {
            Object[] rowData = {
                    kurir.getId(),
                    kurir.getNama(),
                    kurir.getJenisKendaraan(),
                    kurir.getPlatNo(),
                    kurir.getNoHp()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public static void refreshKurir(Connection connection, DefaultTableModel tableModel) {
        ArrayList<Kurir> listKurir = KurirController.getAllKurir(connection);

        if (listKurir != null) {
            tableModel.setRowCount(0);
            for (Kurir kurir : listKurir) {
                Object[] rowData = {
                        kurir.getId(),
                        kurir.getNama(),
                        kurir.getJenisKendaraan(),
                        kurir.getPlatNo(),
                        kurir.getNoHp()
                };
                tableModel.addRow(rowData);
            }
        }
    }
}
