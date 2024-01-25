package ui;

import controller.BarangController;
import controller.KurirController;
import entity.Barang;
import entity.Kurir;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;

public class TableBarang {
    public static TableResult displayBarangTable(Connection connection) {
        try {
            ArrayList<Barang> listBarang = BarangController.getAllBarang(connection);

            DefaultTableModel barangTableModel;
            JTable tableBarang;

            if (listBarang != null) {
                barangTableModel = getDefaultBarangTableModel(listBarang);
                tableBarang = new JTable(barangTableModel);
                tableBarang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

                return new TableResult(tableBarang, barangTableModel);
            }
            return null;
        } catch (Exception error) {
            System.err.print(error.getMessage());
            return null;
        }
    }

    private static DefaultTableModel getDefaultBarangTableModel(ArrayList<Barang> listBarang) {
        String[] columnNames = {"ID", "Nama Barang", "Berat", "Nama Penerima", "Nama Pengirim", "Status", "Deskripsi"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 1);

        for (Barang barang : listBarang) {
            Object[] rowData = {
                    barang.getId(),
                    barang.getNama(),
                    barang.getBerat(),
                    barang.getPenerima(),
                    barang.getPengirim(),
                    barang.getStatus(),
                    barang.getDeskripsi()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public static void refreshBarang(Connection connection, DefaultTableModel tableModel) {
        ArrayList<Barang> listBarang = BarangController.getAllBarang(connection);

        if (listBarang != null) {
            tableModel.setRowCount(0);
            for (Barang barang : listBarang) {
                Object[] rowData = {
                        barang.getId(),
                        barang.getNama(),
                        barang.getBerat(),
                        barang.getPenerima(),
                        barang.getPengirim(),
                        barang.getStatus(),
                        barang.getDeskripsi()
                };
                tableModel.addRow(rowData);
            }
        }
    }
}
