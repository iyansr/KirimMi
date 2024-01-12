package ui;

import controller.BarangController;
import controller.KurirController;
import entity.Barang;
import entity.Kurir;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;

public class DashboardScreen extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTable tableBarang;
    private JButton tambahPengirimanButton;
    private JLabel loginSebagaiLabel;
    private JButton tambahKurirButton;
    private JButton refreshButton;
    private JTable tableKurir;
    private JButton kurirRefresh;
    private final Connection connection;
    private DefaultTableModel barangTableModel;
    private DefaultTableModel kurirTabelModel;

    public DashboardScreen(Connection connection, User user) {
        this.connection = connection;
        setContentPane(panel1);
        loginSebagaiLabel.setText("Login Sebagai: " + user.getNama());
        tambahPengirimanButton.setSize(80, 32);
        setSize(1280, 720);
        tabbedPane1.requestFocusInWindow();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        tambahKurirButton.addActionListener(e -> {
            new TambahKurirForm(connection);
        });

        refreshButton.addActionListener(e -> {
            barangTableModel.fireTableDataChanged();
        });

        kurirRefresh.addActionListener(e -> {
            refreshKurir();
        });

    }

    private void createUIComponents() {
        displayBarangTable();
        displayKurirTable();
    }

    private void displayBarangTable() {
        try {
            ArrayList<Barang> listBarang = BarangController.getAllBarang(this.connection);

            if (listBarang != null) {
                barangTableModel = getDefaultBarangTableModel(listBarang);
                tableBarang = new JTable(barangTableModel);
                tableBarang.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            }
        } catch (Exception error) {
            System.err.print(error.getMessage());
        }
    }

    private DefaultTableModel getDefaultBarangTableModel(ArrayList<Barang> listBarang) {
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

    private void displayKurirTable() {
        try {
            ArrayList<Kurir> listKurir = KurirController.getAllKurir(this.connection);

            if (listKurir != null) {
                kurirTabelModel = getDefaultKurirTableModel(listKurir);
                tableKurir = new JTable(kurirTabelModel);
                tableKurir.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

            }
        } catch (Exception error) {
            System.err.print(error.getMessage());
        }
    }

    private DefaultTableModel getDefaultKurirTableModel(ArrayList<Kurir> listKurir) {
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
    

    private void refreshKurir() {
        ArrayList<Kurir> listKurir = KurirController.getAllKurir(this.connection);

        if (listKurir != null) {
            kurirTabelModel.setRowCount(0);
            for (Kurir kurir : listKurir) {
                Object[] rowData = {
                        kurir.getId(),
                        kurir.getNama(),
                        kurir.getJenisKendaraan(),
                        kurir.getPlatNo(),
                        kurir.getNoHp()
                };
                kurirTabelModel.addRow(rowData);
            }
        }
    }
}
