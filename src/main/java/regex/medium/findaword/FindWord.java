package regex.medium.findaword;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindWord {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase1.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();

            StringBuilder textBuilder = new StringBuilder();
            while (n-- > 0) {
                String line = scan.nextLine();
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();

            int t = scan.nextInt();
            while (t-- > 0) {
                String word = scan.next();

                String regex = "\\b" + word + "\\b";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(text);

                int count = 0;
                while (m.find()) {
                    count++;
                }
                System.out.println(count);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
