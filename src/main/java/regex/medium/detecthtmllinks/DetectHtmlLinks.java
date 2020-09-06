package regex.medium.detecthtmllinks;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectHtmlLinks {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testcase5.txt"))) {

            int n = Integer.parseInt(reader.readLine());

            String line;
            while (n-- > 0) {
                line = reader.readLine();
                String htmlLink = extractHtmlLink2(line);
                if (!htmlLink.isEmpty()) {
                    System.out.print(htmlLink);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /*
     * Complicated and unpractical solution
     */
    private static String extractHtmlLink(String str) {
        StringBuilder htmlLink = new StringBuilder();

        String regex = "(?<=\\ba\\shref=\")[^\"]+|[^<>]+(?=</[ab])|</a>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        int i = 0;
        while (m.find()) {
            String group = m.group();
            if (group.equals("</a>")) {
                htmlLink.append("\n");
                i = 0;
            } else {
                if (i % 2 == 0) {
                    htmlLink.append(group).append(",");
                } else {
                    htmlLink.append(group.trim());
                }
                i++;
            }
        }
        return htmlLink.toString();
    }

    /*
    Much better
     */
    private static String extractHtmlLink2(String str) {
        StringBuilder htmlLink = new StringBuilder();

        String regex = "<a href=\"([^\"]*).*?>(?:<.>)?([^<]*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        while (m.find()) {
            htmlLink.append(m.group(1)).append(',').append(m.group(2).trim()).append('\n');
        }
        return htmlLink.toString();
    }
}
