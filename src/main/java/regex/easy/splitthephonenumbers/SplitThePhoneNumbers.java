package regex.easy.splitthephonenumbers;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitThePhoneNumbers {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();

            String line;
            while (n-- > 0) {
                line = scan.nextLine();

                String regex = "^(\\d{1,3})[-\\s](\\d{1,3})[-\\s](\\d{4,10})$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);
                if (m.find()) {
                    String countryCode = m.group(1);
                    String localAreaCode = m.group(2);
                    String number = m.group(3);
                    System.out.printf("CountryCode=%s,LocalAreaCode=%s,Number=%s%n", countryCode, localAreaCode, number);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
