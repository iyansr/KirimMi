package ui;

import controller.KurirController;
import controller.PengirimanController;
import dto.BarangDTO;
import dto.PelangganDTO;
import entity.Kurir;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.util.ArrayList;

public class TambahPengirimanForm extends JFrame {
    private JPanel panel1;
    private JTextField hpPenerima;
    private JTextField namaPenerima;
    private JTextField alamatPenerima;
    private JTextField kotaPenerima;
    private JTextField kecamatanPenerima;
    private JTextField namaPengirim;
    private JTextField hpPengirim;
    private JTextField alamatPengirim;
    private JTextField kotaPengirim;
    private JTextField kecamatanPengirim;
    private JComboBox<Kurir> kurirBox;
    private JTextField namaBarang;
    private JTextField beratBarang;
    private JTextField deskripsiTextField;
    private JButton createButton;

    private int idKurir;

    private final Connection connection;

    public TambahPengirimanForm(Connection connection) throws HeadlessException {
        this.connection = connection;
        setTitle("Tambah Pengiriman");
        setSize(1280, 720);
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        kurirBox.addActionListener(e -> {
            Kurir selectedKurir = (Kurir) kurirBox.getSelectedItem();
            if (selectedKurir != null) {
                idKurir = selectedKurir.getId();
            }
        });

        createButton.addActionListener(e -> {
            createPengiriman();
//            System.out.println("FIRED");
        });
    }

    private void createUIComponents() {
        // Retrieve Kurir data
        ArrayList<Kurir> kurirs = KurirController.getAllKurir(this.connection);

        if (kurirs != null) {
            JComboBox<Kurir> kBox = new JComboBox<>();
            DefaultComboBoxModel<Kurir> model = new DefaultComboBoxModel<>(kurirs.toArray(new Kurir[0]));
            kBox.setModel(model);
            kurirBox = kBox;
        } else {
            System.out.println("Failed to retrieve Kurir data");
        }
    }

    private void createPengiriman() {
        PelangganDTO penerima = new PelangganDTO(
                this.namaPenerima.getText(),
                this.hpPenerima.getText(),
                this.alamatPenerima.getText(),
                this.kotaPenerima.getText(),
                this.kecamatanPenerima.getText()
        );

        PelangganDTO pengirim = new PelangganDTO(
                this.namaPengirim.getText(),
                this.hpPengirim.getText(),
                this.alamatPengirim.getText(),
                this.kotaPengirim.getText(),
                this.kecamatanPengirim.getText()
        );

        try {
            PengirimanController.addPengiriman(
                    this.connection,
                    penerima,
                    pengirim,
                    idKurir,
                    1,
                    this.namaBarang.getText(),
                    this.beratBarang.getText(),
                    this.deskripsiTextField.getText()
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1, "Gagal Tambah Pengiriman");
            System.out.println(e.getMessage());

        }

    }
}
