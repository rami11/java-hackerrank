package learnjava.medium.tagcontentextractor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new FileReader("input3.txt"))) {
            int testCases = Integer.parseInt(in.nextLine());
            while (testCases-- > 0) {
                String line = in.nextLine();

                Pattern pattern = Pattern.compile("<(.+)>([^<>/]+)</\\1>");
                Matcher matcher = pattern.matcher(line);
                int i = 0;
                while (matcher.find()) {
                    System.out.println(matcher.group(2));
                    i++;
                }
                if (i == 0) {
                    System.out.println("None");
                }
            }
        }
    }


}
