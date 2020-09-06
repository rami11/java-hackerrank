package regex.easy.detecthtmlattributes;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlAttributes {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase1.txt"))) {
            int n = scan.nextInt();
            scan.nextLine();

            String line;
            StringBuilder textBuilder = new StringBuilder();
            while (n-- > 0) {
                line = scan.nextLine();
                textBuilder.append(line).append("\n");
            }
            String text = textBuilder.toString();

            detectHtmlAttributes(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void detectHtmlAttributes(String text) {
        String regex = "((?<=<)[\\w]+)|([a-z]+(?==[\"']))";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        Map<String, Set<String>> map = new TreeMap<>();
        String currentTag = "";
        while (m.find()) {
            String tag = m.group(1);
            String attribute = m.group(2);
            if (tag != null) {
                currentTag = tag;
                if (!map.containsKey(tag)) {
                    map.put(currentTag, new TreeSet<>());
                }
            } else if (attribute != null) {
                Set<String> set = map.get(currentTag);
                set.add(attribute);
                map.put(currentTag, set);
            }
        }
        Set<String> resultList = new TreeSet<>();
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String l = entry.getKey() + ":";
            l += String.join(",", entry.getValue());
            resultList.add(l);
        }
        resultList.forEach(System.out::println);
    }
}
