package interview.arrays.twodarrayds;

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
    }

    private static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE, sum;

        for (int row = 0; row < arr.length - 2; row++) {
            for (int col = 0; col < arr[0].length - 2; col++) {
                sum = 0;
                for (int k = col; k < col + 3; k++) {
                    sum += arr[row][k];
                }
                sum += arr[row + 1][col + 1];
                for (int k = col; k < col + 3; k++) {
                    sum += arr[row + 2][k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
