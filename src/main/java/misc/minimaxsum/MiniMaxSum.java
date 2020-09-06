package misc.minimaxsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiniMaxSum {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        Integer[] array1 = {1, 2, 3, 4, 5};
        miniMaxSum(array);
        miniMaxSum1(array1);
    }

    private static void miniMaxSum(int[] arr) {
        List<Long> sums = new ArrayList<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    sum += arr[j];
                }
            }
            sums.add(sum);
        }

        System.out.println(
                sums.stream().min(Long::compareTo).orElse(0L) + " " +
                        sums.stream().max(Long::compareTo).orElse(0L));
    }

    private static void miniMaxSum1(Integer[] arr) {
        Arrays.sort(arr);
        long min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min += arr[i];
        }
        long max = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            max += arr[i];
        }
        System.out.println(min + " " + max);
    }
}
