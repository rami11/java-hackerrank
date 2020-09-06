package regex.easy.sayinghi;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SayingHi {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();

            while (n-- > 0) {
                String line = scan.nextLine();

                String regex = "^[hH][iI]\\s[^dD]";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                if (m.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
