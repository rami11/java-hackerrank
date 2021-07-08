package interview.arrays.twodarrayds;

import java.util.Arrays;
import java.util.List;

public class TwoDArrayDS {

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 1, 1, 0, 0, 0}, {0, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}
        };

        System.out.println(hourglassSum(arr1));

        int[][] arr2 = {
                {-9, -9, -9, 1, 1, 1}, {0, -9, 0, 4, 3, 2}, {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0}, {0, 0, 0, -2, 0, 0}, {0, 0, 1, 2, 4, 0}
        };
        System.out.println(hourglassSum(arr2));

        List<List<Integer>> arr3 = Arrays.asList(
                Arrays.asList(-9, -9, -9, 1, 1, 1),
                Arrays.asList(0, -9, 0, 4, 3, 2),
                Arrays.asList(-9, -9, -9, 1, 2, 3),
                Arrays.asList(0, 0, 8, 6, 6, 0),
                Arrays.asList(0, 0, 0, -2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)
        );
        System.out.println(hourglassSum2(arr3));
    }

    private static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE, sum;
        for (int row = 0; row < arr.length - 2; row++) {
            for (int col = 0; col < arr[0].length - 2; col++) {
                sum = 0;
                for (int k = col; k < col + 3; k++) {
                    sum += arr[row][k];
                    sum += arr[row + 2][k];
                }
                sum += arr[row + 1][col + 1];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int hourglassSum2(List<List<Integer>> arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.size() - 3; i++) {
            for (int j = 0; j < arr.get(0).size() - 3; j++) {
                int sum = 0;
                for (int k = j; k < j + 3; k++) {
                    sum += arr.get(i).get(k);
                    sum += arr.get(i + 2).get(k);
                }
                sum += arr.get(i + 1).get(j + 1);
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
