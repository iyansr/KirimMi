package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;

public class DBConnection {

    private final static String url = "jdbc:mysql://127.0.0.1:3306/kirimmi_db";
    private final static String user = "root";
    private final static String password = "root";

    public Connection getConnection() throws Exception {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLClientInfoException e) {
            System.err.println("Gagal Execute Command\n");
            System.err.println(e.toString());
            return null;
        }
    }

}
