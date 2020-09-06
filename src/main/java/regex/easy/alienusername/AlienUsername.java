package regex.easy.alienusername;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienUsername {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = Integer.parseInt(scan.nextLine());
            String username;
            while (n-- > 0) {
                username = scan.nextLine();
                System.out.println(isAlien(username) ? "VALID" : "INVALID");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAlien(String username) {
        String regex = "^[._]\\d+[a-zA-Z]*_?$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        return m.matches();
    }
}
