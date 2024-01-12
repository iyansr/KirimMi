package controller;

import db.DBConnection;
import entity.User;
import utils.PasswordHash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserController {

    private final Connection connection;

    public UserController(Connection connection) throws Exception {
        this.connection = connection;
    }

    public User login(String email, String password) {
        try {
            System.out.print("Connection: ");
            System.out.println(connection);
            String hashedPassword = PasswordHash.hashPassword(password);
            String query = "select id, nama, email from user where email = ? and hashed_password = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, hashedPassword);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("Hased password: " + hashedPassword);

            if (rs.next()) {
                int userId = rs.getInt("id");
                String userName = rs.getString("nama");
                String userEmail = rs.getString("email");

                return new User(userId, userName, userEmail);
            } else {
                return null; // No matching user found
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return null;
        }
    }
}
