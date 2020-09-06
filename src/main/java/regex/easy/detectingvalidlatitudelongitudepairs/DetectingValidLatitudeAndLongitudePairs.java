package regex.easy.detectingvalidlatitudelongitudepairs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectingValidLatitudeAndLongitudePairs {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testcase0.txt"))) {
            int n = Integer.parseInt(reader.readLine());

            String first = "[+-]?((90(\\.0+)?)|(([1-8]\\d)|(\\d))(\\.\\d+)?)";
            String second = "[+-]?((180(\\.0+)?)|((1[0-7]\\d)|(\\d\\d)|(\\d))(\\.\\d+)?)";

            String regex = "\\(" + first + ", " + second + "\\)";

            Pattern p = Pattern.compile(regex);

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                System.out.println(line);
                Matcher m = p.matcher(line);

                System.out.println(m.matches() ? "Valid" : "Invalid");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
