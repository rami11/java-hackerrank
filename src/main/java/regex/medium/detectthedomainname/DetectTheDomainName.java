package regex.medium.detectthedomainname;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectTheDomainName {

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

            String regex = "(?<=://)(?:www\\.)?([^/?\"()]+\\.[a-z]{2,})";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(text);

            Set<String> set = new HashSet<>();
            while (m.find()) {
                String group = m.group(1);
                set.add(group);
            }

            List<String> list = new ArrayList<>(set);
            Collections.sort(list);
            System.out.println(String.join("\n", list));
            System.out.println(list.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
