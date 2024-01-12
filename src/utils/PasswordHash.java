package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
    public static String hashPassword(String password) {
        try {
            // Get an instance of the MD5 message digest algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Update the digest with the input string
            md.update(password.getBytes());

            // Get the hash bytes
            byte[] hashBytes = md.digest();

            // Convert the hash bytes to a hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte hashByte : hashBytes) {
                String hex = Integer.toHexString(0xff & hashByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static boolean comparePassword(String originalPassword, String hashedPassword) {
        try {
            String currentPassword = hashPassword(originalPassword);
            assert currentPassword != null;
            return currentPassword.equals(hashedPassword);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
