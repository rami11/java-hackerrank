package interview.prep.day1.diagonaldifference;

import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {

        List<List<Integer>> input = List.of(
                List.of(11, 2, 4),
                List.of(4, 5, 6),
                List.of(10, 8, -12)
        );

        int result = diagonalDifference(input);
        System.out.println(result);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {

        if (arr == null) {
            throw new IllegalArgumentException();
        }

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;

        for (int i = 0; i < arr.size(); i++) {
            diagonalSum1 += arr.get(i).get(i);
            diagonalSum2 += arr.get(i).get(arr.size() - 1 - i);
        }

        return Math.abs(diagonalSum1 - diagonalSum2);
    }
}
