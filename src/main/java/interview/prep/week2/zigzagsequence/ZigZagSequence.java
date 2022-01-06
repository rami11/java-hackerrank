package interview.prep.week2.zigzagsequence;

import java.util.Arrays;

public class ZigZagSequence {

    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 4};
        findZigZagSequence(a, 5);
    }

    public static void findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);

        int start = n / 2;
        int end = n - 1;
        while (start <= end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
