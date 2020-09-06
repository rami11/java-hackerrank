package regex.medium.identifyingcomments;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IdentifyingComments {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase4.txt"))) {
            String line;
            StringBuilder textBuilder = new StringBuilder();
            while (scan.hasNext()) {
                line = scan.nextLine();
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();

            String regex = "//[^\\n]*|/\\*.*?\\*/";
            Pattern p = Pattern.compile(regex, Pattern.DOTALL);
            Matcher m = p.matcher(text);
            while (m.find()) {
                String group = m.group();
                String[] array = group.split("\n");

                String comment = Arrays.stream(array)
                        .map(String::trim)
                        .collect(Collectors.joining("\n"));

                System.out.println(comment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
