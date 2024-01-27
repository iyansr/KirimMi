package controller;

import dto.BarangDTO;
import dto.PelangganDTO;
import entity.Pengiriman;
import utils.RandomString;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

public class PengirimanController {


    public static ArrayList<Pengiriman> listPengiriman(Connection connection) {
        try {
            String query =
                    "select " +
                            "pengiriman.id as id_pengiriman, " +
                            "pengiriman.kode as kode_pengiriman, " +
                            "pengiriman.tanggal as tanggal_kirim, " +
                            "pengiriman.total as total, " +
                            "pengirim.nama as nama_pengirim, " +
                            "penerima.nama as nama_penerima, " +
                            "barang.nama as nama_barang, " +
                            "barang.berat as berat_barang, " +
                            "barang.status as status_barang, " +
                            "barang.deskripsi as deskripsi_barang, " +
                            "kurir.nama as nama_kurir, " +
                            "user.nama as nama_admin " +
                            "from pengiriman " +
                            "join user on pengiriman.id_admin = user.id " +
                            "join barang on pengiriman.id_barang = barang.id " +
                            "join kurir on pengiriman.id_kurir = kurir.id " +
                            "join pelanggan as pengirim on barang.id_pengirim = pengirim.id " +
                            "join pelanggan as penerima on barang.id_penerima = penerima.id";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<Pengiriman> listPengiriman = new ArrayList<>();

            while (resultSet.next()) {
                int idPengiriman = resultSet.getInt("id_pengiriman");
                String kodePengiriman = resultSet.getString("kode_pengiriman");
                String tanggalKirim = resultSet.getString("tanggal_kirim");
                String namaPengirim = resultSet.getString("nama_pengirim");
                String namaPenerima = resultSet.getString("nama_penerima");
                String namaBarang = resultSet.getString("nama_barang");
                double beratBarang = resultSet.getDouble("berat_barang");
                String statusBarang = resultSet.getString("status_barang");
                String deskripsi = resultSet.getString("deskripsi_barang");
                String namaKurir = resultSet.getString("nama_kurir");
                String namaAdmin = resultSet.getString("nama_admin");
                int total = resultSet.getInt("total");

                Pengiriman pengiriman = new Pengiriman();
                pengiriman.setIdPengiriman(idPengiriman);
                pengiriman.setBeratBarang(beratBarang);
                pengiriman.setDeskripsiBarang(deskripsi);
                pengiriman.setKode(kodePengiriman);
                pengiriman.setTanggalKirim(tanggalKirim);
                pengiriman.setNamaPengirim(namaPengirim);
                pengiriman.setNamaPenerima(namaPenerima);
                pengiriman.setNamaBarang(namaBarang);
                pengiriman.setStatusBarang(statusBarang);
                pengiriman.setNamaKurir(namaKurir);
                pengiriman.setNamaAdmin(namaAdmin);
                pengiriman.setHarga(total);

                listPengiriman.add(pengiriman);

            }

            return listPengiriman;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void addPengiriman(
            Connection connection,
            PelangganDTO penerima,
            PelangganDTO pengirim,
            int idKurir,
            int idAdmin,
            String namabarang,
            String beratBarang,
            String deskripsi
    ) throws SQLException {

        try {
            connection.setAutoCommit(false);
            int idPenerima = PelangganController.addPelanggan(connection, penerima);
            int idPengirim = PelangganController.addPelanggan(connection, pengirim);

            BarangDTO barang = new BarangDTO(namabarang,
                    Double.parseDouble(beratBarang),
                    idPenerima,
                    idPengirim,
                    "Menunggu Kurir", deskripsi);

            int idBarang = BarangController.addBarang(connection, barang, idPenerima, idPengirim);

            System.out.println(idPenerima);
            System.out.println(idPengirim);
            System.out.println(idBarang);
            System.out.println(idAdmin);
            System.out.println(idKurir);

            String query = "insert into pengiriman (id_barang, id_kurir, total, kode, id_admin, tanggal) values (?, ?, ?, ?, ?, ?)";
            Calendar cal = Calendar.getInstance();
            Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idBarang);
            statement.setInt(2, idKurir);
            statement.setInt(3, Integer.parseInt(beratBarang) * 20000);
            statement.setString(4, RandomString.generateRandomString());
            statement.setInt(5, idAdmin);
            statement.setTimestamp(6, timestamp);
            statement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            connection.rollback();
            System.err.println(e.getMessage());
        } finally {
            connection.setAutoCommit(true);
        }

    }
}
