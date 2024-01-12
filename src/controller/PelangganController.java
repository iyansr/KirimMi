package controller;

import db.DBConnection;
import dto.BarangDTO;
import dto.PelangganDTO;
import entity.Pelanggan;

import java.sql.*;
import java.util.ArrayList;

public class PelangganController {
    private final Connection connection;

    public PelangganController() throws Exception {
        DBConnection db = new DBConnection();
        this.connection = db.getConnection();
    }

    public ArrayList<Pelanggan> getAllPelanggan() throws SQLException {
        try {
            String query = "select * from pelanggan";
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            ArrayList<Pelanggan> listPelanggan = new ArrayList<>();

            while (rs.next()) {
                Pelanggan pelanggan = new Pelanggan(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("no_hp"),
                        rs.getString("alamat"),
                        rs.getString("kota"),
                        rs.getString("kecamatan")
                );
                listPelanggan.add(pelanggan);
            }

            return listPelanggan;
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return null;
        } finally {
            this.connection.close();
        }
    }

    public int addPelanggan(PelangganDTO pelangganDTO) {
        try {
            String query = "insert into pelanggan (nama, no_hp, alamat, kota, kecamatan) values (?, ?, ?, ?, ?)";
            PreparedStatement statement = this.connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, pelangganDTO.getNama());
            statement.setString(2, pelangganDTO.getNoHp());
            statement.setString(3, pelangganDTO.getAlamat());
            statement.setString(4, pelangganDTO.getKota());
            statement.setString(5, pelangganDTO.getKecamatan());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Gagal membuat pelanggan");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();

            int generatedKey;
            if (generatedKeys.next()) {
                generatedKey = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Gagal membuat pelanggan");
            }
            return generatedKey;
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return 0;
        }
    }
}
