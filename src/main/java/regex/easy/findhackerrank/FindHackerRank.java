package regex.easy.findhackerrank;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindHackerRank {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();

            while (n-- > 0) {
                String line = scan.nextLine();
                System.out.println(line);

                String regex = "hackerrank";

                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(line);

                while(m.find()) {
                    int start = m.start();
                    int end = m.end();
                    if (start == 0 && end == line.length()) {
                        System.out.println(0);
                    } else if (start == 0) {
                        System.out.println(1);
                    } else if (end == line.length()) {
                        System.out.println(2);
                    } else {
                        System.out.println(-1);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
