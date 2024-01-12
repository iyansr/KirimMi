package ui;

import controller.BarangController;
import entity.Barang;
import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.util.ArrayList;

public class DashboardScreen extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTable table1;
    private JButton tambahPengirimanButton;
    private JLabel loginSebagaiLabel;
    private JButton tambahKurirButton;
    private final Connection connection;

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
            new TambahKuririForm(connection);
        });

    }

    private void createUIComponents() {
        displayBarangTable();
    }

    private void displayBarangTable() {
        try {
            ArrayList<Barang> listBarang = BarangController.getAllBarang(this.connection);

            if (listBarang != null) {
                DefaultTableModel tableModel = getDefaultTableModel(listBarang);

                table1 = new JTable(tableModel);

                table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);


            }
        } catch (Exception error) {
            System.err.print(error.getMessage());
        }
    }

    private static DefaultTableModel getDefaultTableModel(ArrayList<Barang> listBarang) {
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
}
