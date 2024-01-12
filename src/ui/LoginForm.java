package ui;

import controller.UserController;
import entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginForm extends JFrame {
    private JPanel loginPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton button;
    private JLabel Email;
    private JLabel Password;

    public LoginForm(Connection connection) {

        setContentPane(this.loginPanel);
        setTitle("KirimMi");
        setSize(600, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        emailField.setText("iyan@gmail.com");
        passwordField.setText("test123");

        button.addActionListener(e -> {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();
            String passwordString = new String(password);

            boolean isEmailValid = isValidEmail(email);

            if (email == null || passwordString.isEmpty()) {
                JOptionPane.showMessageDialog(loginPanel, "Email dan password tidak boleh kosong");
                return;
            }

            if (!isEmailValid) {
                JOptionPane.showMessageDialog(loginPanel, "Format email salah");
                return;

            }

            try {
                UserController userController = new UserController(connection);
                User user = userController.login(email, passwordString);
                if (user == null) {
                    JOptionPane.showMessageDialog(loginPanel, "Email atau password salah");
                } else {
                    setVisible(false);
                    new DashboardScreen(connection);
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        });
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
