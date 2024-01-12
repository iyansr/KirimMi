package ui;

import controller.KurirController;
import dto.KurirDTO;

import javax.swing.*;
import java.sql.Connection;

public class TambahKuririForm extends JFrame {
    private JTextField namaField;
    private JTextField noHpField;
    private JTextField platNoField;
    private JTextField jkField;
    private JPanel panel1;
    private JButton simpanButton;

    private final Connection connection;

    public TambahKuririForm(Connection connection) {
        this.connection = connection;
        setSize(720, 320);
        setTitle("Tambah Kurir");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);

        simpanButton.addActionListener(e -> {
            saveKurir();
        });
    }

    private void saveKurir() {
        try {
            String nama = namaField.getText();
            String noHp = noHpField.getText();
            String platNo = platNoField.getText();
            String jenisKendaraan = jkField.getText();
            System.out.println("Nama Kurir: " + nama.isEmpty());


            if (nama.isEmpty() || noHp.isEmpty() || platNo.isEmpty() || jenisKendaraan.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Semua Field Harus diisi");
                return;
            }

            KurirDTO kurirDTO = new KurirDTO(nama, jenisKendaraan, platNo, noHp);

            int result = KurirController.addKurir(this.connection, kurirDTO);
            if (result != -1) {
                JOptionPane.showMessageDialog(panel1, "Berhasil Tambah Kurir");
                setVisible(false);
                dispose();
            } else {
                JOptionPane.showMessageDialog(panel1, "Gagal Tambah Kurir");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel1, "Gagal Tambah Kurir");

        }
    }


}
