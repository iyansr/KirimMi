package ui;

import entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;

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
    private JTable pengirimanTable;
    private JButton buttonRefreshPengiriman;
    private final Connection connection;
    private DefaultTableModel barangTableModel;
    private DefaultTableModel kurirTabelModel;
    private DefaultTableModel pengirimanTableModel;

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
            TableBarang.refreshBarang(connection, barangTableModel);
        });

        tambahPengirimanButton.addActionListener(e -> {
            new TambahPengirimanForm();
        });

        kurirRefresh.addActionListener(e -> {
            TableKurir.refreshKurir(connection, kurirTabelModel);
        });

        buttonRefreshPengiriman.addActionListener(e -> {
            TablePengiriman.refresh(connection, pengirimanTableModel);
        });

    }

    private void createUIComponents() {
        displayBarangTable();
        displayKurirTable();
        displayPengirimanTable();
    }

    private void displayBarangTable() {
        TableResult tableBarangResult = TableBarang.displayBarangTable(connection);
        if (tableBarangResult != null) {
            tableBarang = tableBarangResult.getTable();
            barangTableModel = tableBarangResult.getTableModel();
        }
    }

    private void displayKurirTable() {
        TableResult tableKurirResult = TableKurir.displayKurirTable(connection);
        if (tableKurirResult != null) {
            tableKurir = tableKurirResult.getTable();
            kurirTabelModel = tableKurirResult.getTableModel();
        }
    }

    private void displayPengirimanTable() {
        TableResult table = TablePengiriman.displayTable(connection);
        if (table != null) {
            pengirimanTable = table.getTable();
            pengirimanTableModel = table.getTableModel();
        }
    }


}
