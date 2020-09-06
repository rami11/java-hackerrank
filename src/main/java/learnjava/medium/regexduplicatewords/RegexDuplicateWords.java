package learnjava.medium.regexduplicatewords;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDuplicateWords {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("input2.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine().trim());

            /*Pattern p = Pattern.compile("\\b(?i)(\\w+)(\\s+\\1)+\\b", Pattern.CASE_INSENSITIVE);*/

            /*for (int i = 0; i < n; i++) {
                String line = reader.readLine().trim();
                String noRepeatLine = line.replaceAll(p.pattern(), "$1");
                writer.write(noRepeatLine);
                writer.newLine();
            }*/

            Pattern p = Pattern.compile("\\b(\\w+)(\\s+\\1)+\\b", Pattern.CASE_INSENSITIVE);

            for (int i = 0; i < n; i++) {
                String line = reader.readLine().trim();
                Matcher m = p.matcher(line);
                while (m.find()) {
                    line = line.replaceAll(m.group(), m.group(1));
                }
                writer.write(line);
                writer.newLine();
            }


        } catch (IOException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }


}
