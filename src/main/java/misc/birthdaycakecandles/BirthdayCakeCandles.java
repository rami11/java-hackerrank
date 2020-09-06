package misc.birthdaycakecandles;

public class BirthdayCakeCandles {

    public static void main(String[] args) {
        int[] candleLengths = {3, 2, 1, 3};
        System.out.println(birthdayCakeCandles(candleLengths));
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
}
