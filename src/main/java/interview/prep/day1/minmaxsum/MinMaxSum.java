package interview.prep.day1.minmaxsum;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MinMaxSum {

    public static void main(String[] args) {
        miniMaxSum(List.of(5, 5, 5, 5, 5));
    }

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);

        long minSum = IntStream.range(0, arr.size() - 1).mapToLong(arr::get).sum();
        long maxSum = IntStream.range(1, arr.size()).mapToLong(arr::get).sum();

        System.out.printf("%d %d%n", minSum, maxSum);
    }

    public static void miniMaxSumOld(List<Integer> arr) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int el : arr) {

            if (el > max) {
                max = el;
            }

            if (el < min) {
                min = el;
            }
        }

        long sumMin = 0;
        long sumMax = 0;
        if (min == max) {

            for (int i = 0; i < arr.size() - 1; i++) {
                sumMin += arr.get(i);
                sumMax += arr.get(i);
            }

        } else {

            for (int el : arr) {
                if (el != max) {
                    sumMin += el;
                }
                if (el != min) {
                    sumMax += el;
                }
            }

        }

        System.out.printf("%d %d%n", sumMin, sumMax);
    }
}
