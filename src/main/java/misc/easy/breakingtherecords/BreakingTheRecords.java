package misc.easy.breakingtherecords;

import java.util.ArrayList;
import java.util.List;

public class BreakingTheRecords {

    public static void main(String[] args) {

        int[] scores1 = {10, 5, 20, 20, 4, 5, 2, 25, 1};
        displayArray(breakingRecords(scores1));


        int[] scores2 = {3, 4, 21, 36, 10, 28, 35, 5, 24, 42};
        displayArray(breakingRecords(scores2));

        List<Integer> scores11 = List.of(10, 5, 20, 20, 4, 5, 2, 25, 1);
        System.out.println(breakingRecords2(scores11));

        List<Integer> scores22 = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);
        System.out.println(breakingRecords2(scores22));
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

    public static List<Integer> breakingRecords2(List<Integer> scores) {
        List<Integer> output = new ArrayList<>();
        if (scores == null || scores.isEmpty()) {
            return output;
        }
        int maxScore = scores.get(0);
        int minScore = scores.get(0);
        int maxCount = 0;
        int minCount = 0;
        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score < minScore) {
                minScore = score;
                minCount++;
            } else if (score > maxScore) {
                maxScore = score;
                maxCount++;
            }
        }
        output.add(maxCount);
        output.add(minCount);
        return output;
    }


    private static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
