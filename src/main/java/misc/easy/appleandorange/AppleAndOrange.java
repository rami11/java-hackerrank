package misc.easy.appleandorange;

import java.util.Arrays;
import java.util.List;

public class AppleAndOrange {

    public static void main(String[] args) {
        int[] apples = {-2, 2, 1};
        int[] oranges = {5, -6};

        countApplesAndOranges(7, 11, 5, 15, apples, oranges);

        System.out.println();

        List<Integer> appleList = List.of(-2, 2, 1);
        List<Integer> orangeList = List.of(5, -6);

        countApplesAndOranges2(7, 11, 5, 15, appleList, orangeList);
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

    public static void countApplesAndOranges2(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

        int appleCount = (int) apples.stream()
                .mapToInt(apple -> a + apple)
                .filter(apple -> apple >= s && apple <= t)
                .count();

        int orangeCount = (int) oranges.stream()
                .mapToInt(orange -> b + orange)
                .filter(orange -> orange >= s && orange <= t)
                .count();

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
