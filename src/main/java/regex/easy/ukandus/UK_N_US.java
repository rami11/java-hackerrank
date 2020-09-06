package regex.easy.ukandus;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UK_N_US {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("input.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();
            StringBuilder textBuilder = new StringBuilder();
            while (n-- > 0) {
                String line = scan.nextLine();
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();

            int t = scan.nextInt();
            scan.nextLine();
            while (t-- > 0) {
                String word = scan.nextLine();
                String[] ww = word.split("ou");
                String w1 = ww[0];
                String w2 = ww[1];

                String regex = "\\b" + w1 + "(ou|o)" + w2 + "\\b";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(text);
                int count = 0;
                while (m.find()) {
                    count++;
                }
                System.out.println(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
