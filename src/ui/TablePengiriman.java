package ui;

import controller.PengirimanController;
import entity.Pengiriman;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;

public class TablePengiriman {

    public static TableResult displayTable(Connection connection) {
        try {
            ArrayList<Pengiriman> listPengiriman = PengirimanController.listPengiriman(connection);

            DefaultTableModel barangTableModel;
            JTable tableBarang;

            if (listPengiriman != null) {
                barangTableModel = getTableModel(listPengiriman);
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

    private static DefaultTableModel getTableModel(ArrayList<Pengiriman> listPengiriman) {
        String[] columnNames = {"ID Pengiriman", "Kode Pengiriman", "Nama Barang", "Berat", "Harga", "Nama Penerima", "Nama Pengirim", "Status", "Deskripsi", "Nama Kurir"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 1);

        for (Pengiriman pengiriman : listPengiriman) {
            Object[] rowData = {
                    pengiriman.getIdPengiriman(),
                    pengiriman.getKode(),
                    pengiriman.getNamaBarang(),
                    pengiriman.getBeratBarang(),
                    pengiriman.getHarga(),
                    pengiriman.getNamaPenerima(),
                    pengiriman.getNamaPengirim(),
                    pengiriman.getStatusBarang(),
                    pengiriman.getDeskripsiBarang(),
                    pengiriman.getNamaKurir()
            };
            tableModel.addRow(rowData);
        }
        return tableModel;
    }

    public static void refresh(Connection connection, DefaultTableModel tableModel) {
        ArrayList<Pengiriman> listPengiriman = PengirimanController.listPengiriman(connection);

        if (listPengiriman != null) {
            tableModel.setRowCount(0);
            for (Pengiriman pengiriman : listPengiriman) {
                Object[] rowData = {
                        pengiriman.getIdPengiriman(),
                        pengiriman.getKode(),
                        pengiriman.getNamaBarang(),
                        pengiriman.getBeratBarang(),
                        pengiriman.getNamaPenerima(),
                        pengiriman.getNamaPengirim(),
                        pengiriman.getStatusBarang(),
                        pengiriman.getDeskripsiBarang(),
                        pengiriman.getNamaKurir()
                };
                tableModel.addRow(rowData);
            }
        }

    }
}
