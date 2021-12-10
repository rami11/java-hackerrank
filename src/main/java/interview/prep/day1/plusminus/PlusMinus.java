package interview.prep.day1.plusminus;

import java.util.List;

public class PlusMinus {

    public static void plusMinus(List<Integer> arr) {

        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        for (int num : arr) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        double positiveRatio = (double) positiveCount / arr.size();
        double negativeRatio = (double) negativeCount / arr.size();
        double zeroRatio = (double) zeroCount / arr.size();
        System.out.printf("%.6f%n", positiveRatio);
        System.out.printf("%.6f%n", negativeRatio);
        System.out.printf("%.6f%n", zeroRatio);
    }
}
