package misc.breakingtherecords;

public class BreakingTheRecords {

    public static void main(String[] args) {

        int[] scores1 = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        displayArray(breakingRecords(scores1));


        int[] scores2 = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
        displayArray(breakingRecords(scores2));
    }

    private static int[] breakingRecords(int[] scores) {
        int[] result = {0, 0};

        int min = scores[0];
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                result[0]++;
            }
            if (scores[i] < min) {
                min = scores[i];
                result[1]++;
            }
        }
        return result;
    }

    private static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
