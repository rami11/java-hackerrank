package regex.easy.findsubword;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubWord {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = Integer.parseInt(scan.nextLine());

            List<String> sentences = new ArrayList<>();
            String sentence;
            while (n-- > 0) {
                sentence = scan.nextLine();
                sentences.add(sentence);
            }
            String paragraph = String.join("\n", sentences);

            int q = Integer.parseInt(scan.nextLine());
            String query;
            while (q-- > 0) {
                query = scan.nextLine();
                System.out.println(countSubWords(paragraph, query));
            }

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static int countSubWords(String str, String query) {
        int count = 0;
        String regex = "(?<=\\w)" + query + "(?=\\w)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while (m.find()) {
            count++;
        }
        return count;
    }
}
