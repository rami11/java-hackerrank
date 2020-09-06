package learnjava.medium.sha256;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testcase0.txt"))) {
            String input = reader.readLine();

            System.out.println(sha256(input));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String sha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(input.getBytes());
            StringBuilder hashText = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                hashText.append(String.format("%02x", bytes[i]));
            }
            return hashText.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
