package learnjava.medium.md5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new FileReader("input2.txt"))) {

            String s = in.nextLine();
            System.out.println(s);

            System.out.println(md5(s));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String md5(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bytes = messageDigest.digest(input.getBytes());

            StringBuilder hashText = new StringBuilder();
            for (byte b : bytes) {
                hashText.append(String.format("%02x", b));
            }
            return hashText.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
