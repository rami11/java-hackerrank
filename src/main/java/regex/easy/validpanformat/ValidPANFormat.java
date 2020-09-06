package regex.easy.validpanformat;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPANFormat {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = scan.nextInt();

            while (n-- > 0) {
                String pan = scan.next();
                System.out.println(isValidPan(pan) ? "YES" : "NO");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidPan(String str) {
        String regex = "^[A-Z]{5}\\d{4}[A-Z]$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        return m.matches();
    }
}
