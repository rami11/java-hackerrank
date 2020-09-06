package interview.warmup.countingvalleys;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CountingValleys {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader("testcase0.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String s = scanner.nextLine();

            int result = countingValleys2(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
    }

    private static int countingValleys(int n, String s) {
        int altitude = 0, count = 0;
        boolean isUp = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') {
                isUp = true;
                altitude++;
            } else if (s.charAt(i) == 'D') {
                isUp = false;
                altitude--;
            }
            if (altitude == 0 && isUp) {
                count++;
            }
        }
        return count;
    }

    private static int countingValleys2(int n, String s) {
        int altitude = 0, count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') {
                if (altitude == -1) {
                    count++;
                }
                altitude++;
            } else if (s.charAt(i) == 'D') {
                altitude--;
            }
        }
        return count;
    }
}
