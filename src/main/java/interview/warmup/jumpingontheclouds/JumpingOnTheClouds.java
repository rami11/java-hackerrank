package interview.warmup.jumpingontheclouds;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class JumpingOnTheClouds {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new FileReader("testcase0.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] c = new int[n];

            String[] cItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }

            int result = jumpingOnClouds(c);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }


    }

    private static int jumpingOnClouds(int[] c) {
        int i = 0, count = 0;
        while (i < c.length - 1) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                i += 2;
            } else if (i + 1 < c.length && c[i + 1] == 0) {
                i++;
            }
            count++;
        }
        return count;
    }
}
