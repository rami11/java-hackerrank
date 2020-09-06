package regex.medium.detectemailaddresses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmailAddresses {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testcase1.txt"))) {

            int n = Integer.parseInt(reader.readLine());

            String line;
            StringBuilder strBuilder = new StringBuilder();
            while (n-- > 0) {
                line = reader.readLine();
                strBuilder.append(line).append('\n');
            }
            String text = strBuilder.toString();
            String result = extractEmailAddresses(text);
            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static String extractEmailAddresses(String text) {
        Set<String> addresses = new HashSet<>();

        String regex = "[^\\s]+@[^\\s]+\\.[a-z]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String group = m.group();
            addresses.add(group);
        }
        List<String> list = new ArrayList<>(addresses);
        Collections.sort(list);
        return String.join(";", list);
    }
}
