package regex.easy.utopianidentificationnumber;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtopianIdentificationNumber {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();

            while (n-- > 0) {
                String line = scan.nextLine();
                String regex = "^[a-z]{0,3}\\d{2,8}[A-Z]{3,}$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                System.out.println(m.matches() ? "VALID" : "INVALID");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
