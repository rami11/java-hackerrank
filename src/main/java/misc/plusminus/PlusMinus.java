package misc.plusminus;

public class PlusMinus {

    public static void main(String[] args) {
        int[] array = {-4, 3, -9, 0, 4, 1};
        plusMinus(array);
    }

    private static void plusMinus(int[] arr) {
        int negatives = 0, positives = 0, zeroes = 0;
        for (int value : arr) {
            if (value < 0) {
                negatives++;
            } else if (value > 0) {
                positives++;
            } else {
                zeroes++;
            }
        }
        System.out.printf("%.6f\n", positives / (double) arr.length);
        System.out.printf("%.6f\n", negatives / (double) arr.length);
        System.out.printf("%.6f\n", zeroes / (double) arr.length);
    }
}
