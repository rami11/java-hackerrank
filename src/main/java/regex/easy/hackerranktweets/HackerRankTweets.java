package regex.easy.hackerranktweets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankTweets {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = Integer.parseInt(scan.nextLine());

            String regex = "hackerrank";
            Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

            String line;
            int count = 0;
            while (n-- > 0) {
                line = scan.nextLine();
                Matcher m = p.matcher(line);

                while (m.find()) {
                    count++;
                }
            }
            System.out.println("Count: " + count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

