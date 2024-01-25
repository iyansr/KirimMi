package controller;

import dto.BarangDTO;
import dto.PelangganDTO;
import entity.Barang;

import java.sql.*;
import java.util.ArrayList;

public class BarangController {

    public static ArrayList<Barang> getAllBarang(Connection connection) {
        try {
            String query = "select " +
                    "barang.id as id_barang, " +
                    "barang.nama as nama_barang, " +
                    "barang.berat as berat_barang, " +
                    "barang.status as status_barang, " +
                    "barang.deskripsi as deskripsi_barang, " +
                    "pengirim.nama as nama_pengirim, " +
                    "penerima.nama as nama_penerima " +
                    "from barang " +
                    "join pelanggan as pengirim on barang.id_pengirim = pengirim.id " +
                    "join pelanggan as penerima on barang.id_penerima = penerima.id";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            ArrayList<Barang> listBarang = new ArrayList<>();


            while (rs.next()) {
                int id = rs.getInt("id_barang");
                String nama = rs.getString("nama_barang");
                double berat = rs.getDouble("berat_barang");
                String status = rs.getString("status_barang");
                String deskripsi = rs.getString("deskripsi_barang");
                String namaPengirim = rs.getString("nama_pengirim");
                String namaPenerima = rs.getString("nama_penerima");

                Barang barang = new Barang(id, nama, berat, namaPenerima, namaPengirim, status, deskripsi);

                listBarang.add(barang);
            }

            return listBarang;
        } catch (Exception error) {
            error.printStackTrace();
            System.err.println(error.getMessage());
            return null;
        }
    }

    public static int addBarang(Connection connection, BarangDTO barang, int idPenerima, int idPelanggan) {
        try {

            String query = "insert into barang (nama, berat, id_penerima, id_pengirim, status, deskripsi) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, barang.getNama());
            statement.setDouble(2, barang.getBerat());
            statement.setInt(3, idPenerima);
            statement.setInt(4, idPelanggan);
            statement.setString(5, barang.getStatus());
            statement.setString(6, barang.getDeskripsi());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Gagal membuat barang");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();

            int generatedKey;
            if (generatedKeys.next()) {
                generatedKey = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Gagal membuat barang");
            }
            return generatedKey;
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return -1;
        }
    }
}
