package regex.medium.programminglanguagedetection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgrammingLanguageDetection {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("python.txt"))) {
            String line;
            StringBuilder textBuilder = new StringBuilder();
            while (scan.hasNext()) {
                line = scan.nextLine();
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();

            String regex = "(\\s*import\\s+.+;)|(\\s*#include<.+>)|(def\\s+.+:|print\\s+.+)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);

            if (m.find()) {
                String group1 = m.group(1);
                String group2 = m.group(2);
                String group3 = m.group(3);

                if (group1 != null) {
                    System.out.println("Java");
                } else if (group2 != null) {
                    System.out.println("C");
                } else if (group3 != null) {
                    System.out.println("Python");
                } else {
                    System.out.println("Something else.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
