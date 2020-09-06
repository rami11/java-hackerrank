package interview.arrays.newyearchaos;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NewYearChaos {

    /*
    Using bubble sort
    Too slow O(n**2)
     */
    static void minimumBribes2(int[] q) {
        int count = 0;
        for (int i = 0; i < q.length; i++) {
            for (int j = i; j < q.length; j++) {
                if (q[i] > q[j]) {
                    if (q[i] > q[j] + 2) {
                        System.out.println("Too chaotic");
                        return;
                    } else {
                        int temp = q[i];
                        q[i] = q[j];
                        q[j] = temp;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    // Right solution
    static void minimumBribes(int[] q) {
        int count = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            System.out.println("Person: " + q[i]);
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                System.out.println("i: " + i + ", j: " + j);
                if (q[j] > q[i]) {
                    count++;
                    System.out.println("Count: " + count);
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("testcase1.txt"))) {
            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                int n = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] q = new int[n];

                String[] qItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < n; i++) {
                    int qItem = Integer.parseInt(qItems[i]);
                    q[i] = qItem;
                }

                minimumBribes(q);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}