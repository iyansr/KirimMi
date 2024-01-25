package utils;

import java.util.Random;

public class RandomString {
    public static String generateRandomString() {
        int length = 10;
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // Generate a random character (uppercase letter or digit)
            char randomChar = (char) (random.nextInt(26) + 'A'); // Uppercase letter
            if (random.nextBoolean()) {
                randomChar = (char) (random.nextInt(10) + '0'); // Digit
            }

            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}