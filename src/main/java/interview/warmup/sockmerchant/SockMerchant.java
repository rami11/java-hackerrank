package interview.warmup.sockmerchant;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("testcase0.txt"))) {
            int n = scan.nextInt();

            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = scan.nextInt();
            }
            System.out.println(sockMerchant(n, ar));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(ar[i]) == null) {
                map.put(ar[i], 1);
            } else {
                map.put(ar[i], map.get(ar[i]) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            /*count += entry.getValue() / 2;*/
            count += entry.getValue() >> 1; //bitwise right shift by 1
        }
        return count;
    }

}
