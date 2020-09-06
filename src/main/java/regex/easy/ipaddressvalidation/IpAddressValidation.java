package regex.easy.ipaddressvalidation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidation {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = Integer.parseInt(scan.nextLine());

            String line;
            for (int i = 0; i < n; i++) {
                line = scan.nextLine();
                checkIpAddress(line);
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static boolean isIpV4(String str) {
        String v4Regex =
                "^((\\d|\\d\\d|1\\d\\d|2[0-5][0-5])\\.){3}(\\d|\\d\\d|1\\d\\d|2[0-5][0-5])$";
        Pattern p = Pattern.compile(v4Regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private static boolean isIpV6(String str) {
        String v6Regex = "^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}$";
        Pattern p = Pattern.compile(v6Regex);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    private static void checkIpAddress(String str) {
        if (isIpV4(str)) {
            System.out.println("IPv4");
        } else if (isIpV6(str)) {
            System.out.println("IPv6");
        } else {
            System.out.println("Neither");
        }
    }
}
