
import db.DBConnection;
import ui.LoginForm;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) throws Exception {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        new LoginForm(connection);
    }
}