package regex.easy.buildastackexchangescraper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackExchangeScraper {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testcase2.txt"))) {
            StringBuilder strBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                strBuilder.append(line).append('\n');
            }

            String input = strBuilder.toString();

            String regex = "(?<=question-summary-)\\d+|(?<=(question-hyperlink)\">)[^\\<]+|(?<=(relativetime)\">)[^\\<]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(input);

            int i = 0;
            List<String> list = new ArrayList<>();
            while (m.find()) {
                list.add(m.group());
                i++;
                if (i == 3) {
                    System.out.println(String.join(";", list));
                    list.clear();
                    i = 0;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
