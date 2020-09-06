package regex.easy.detecthtmltags;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DetectHtmlTags {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase1.txt"))) {
            int n = Integer.parseInt(scan.nextLine());

            String line;
            Set<String> tagNameSet = new HashSet<>();
            while (n-- > 0) {
                line = scan.nextLine();
                Set<String> set = findTagNames(line);
                tagNameSet.addAll(set);
            }
            String result = tagNameSet.stream().sorted().collect(Collectors.joining(";"));
            System.out.println(result);

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static Set<String> findTagNames(String str) {
        Set<String> tagNames = new HashSet<>();
        String regex = "(?<=<)\\w+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            tagNames.add(m.group());
        }
        return tagNames;
    }

}
