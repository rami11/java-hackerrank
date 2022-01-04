package interview.prep.week2.diagonaldifference;

import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            diagonalSum1 += arr.get(i).get(i);
            diagonalSum2 += arr.get(i).get(arr.size() - 1 - i);
        }

        return Math.abs(diagonalSum1 - diagonalSum2);
    }
}
