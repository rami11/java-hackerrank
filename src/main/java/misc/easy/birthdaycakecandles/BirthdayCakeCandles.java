package misc.easy.birthdaycakecandles;

import java.util.List;

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        int[] candleLengths = {3, 2, 1, 3};
        System.out.println(birthdayCakeCandles(candleLengths));

        System.out.println();

        List<Integer> candleLengths2 = List.of(3, 2, 1, 3);
        System.out.println(birthdayCakeCandles2(candleLengths2));
    }

    private static int birthdayCakeCandles(int[] ar) {
        int tallest = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] >= tallest) {
                tallest = ar[i];
            }
        }
        int candlesBlown = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] >= tallest) {
                candlesBlown++;
            }
        }
        return candlesBlown;
    }

    public static int birthdayCakeCandles2(List<Integer> candles) {

        int maxHeight = candles.stream()
                .mapToInt(Integer::valueOf)
                .max()
                .orElse(-1);

        return maxHeight < 0
                ? 0
                : (int) candles.stream().mapToInt(Integer::valueOf)
                .filter(candle -> candle == maxHeight)
                .count();
    }
}
