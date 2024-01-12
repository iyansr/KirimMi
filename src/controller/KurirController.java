package controller;

import dto.KurirDTO;
import entity.Kurir;

import java.sql.*;
import java.util.ArrayList;

public class KurirController {

    public static ArrayList<Kurir> getAllKurir(Connection connection) {
        try {
            String query = "select * from kurir";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<Kurir> listKurir = new ArrayList<>();

            while (resultSet.next()) {
                Kurir kurir = new Kurir(
                        resultSet.getInt("id"),
                        resultSet.getString("nama"),
                        resultSet.getString("jenis_kendaraan"),
                        resultSet.getString("plat_no"),
                        resultSet.getString("no_hp")
                );

                listKurir.add(kurir);
            }
            return listKurir;

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static int addKurir(Connection connection, KurirDTO kurirDTO) {
        try {
            String query = "insert into kurir (nama, jenis_kendaraan, plat_no, no_hp) values (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, kurirDTO.getNama());
            statement.setString(2, kurirDTO.getJenisKendaraan());
            statement.setString(3, kurirDTO.getPlatNomor());
            statement.setString(4, kurirDTO.getNoHp());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Gagal membuat kurir");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();

            int generatedKey;
            if (generatedKeys.next()) {
                generatedKey = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Gagal membuat kurir");
            }
            return generatedKey;
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return -1;
        }
    }

}
