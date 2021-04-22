package misc.easy.appleandorange;

import java.util.Arrays;

public class AppleAndOrange {

    public static void main(String[] args) {
        int[] apples = {-2, 2 ,1};
        int[] oranges = {5, -6};

        countApplesAndOranges(7, 11, 5, 15, apples, oranges);
    }

    private static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        // calc apple positions
        for (int i = 0; i < apples.length; i++) {
            apples[i] += a;
        }
        // calc orange positions
        for (int i = 0; i < oranges.length; i++) {
            oranges[i] += b;
        }
        int[] result = new int[2];
        for (int pos : apples) {
            if (pos >= s && pos <= t) {
                result[0]++;
            }
        }
        for (int pos : oranges) {
            if (pos >= s && pos <= t) {
                result[1]++;
            }
        }
        Arrays.stream(result).forEach(System.out::println);
    }
}
