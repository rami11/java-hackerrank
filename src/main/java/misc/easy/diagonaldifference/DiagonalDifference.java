package misc.easy.diagonaldifference;

public class DiagonalDifference {

    public static void main(String[] args) {
        int[][] array = {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};

        System.out.println(diagonalDifference(array));
    }

    private static int diagonalDifference(int[][] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    sum1 += arr[i][j];
                }
                if (i == arr.length - j - 1) {
                    sum2 += arr[i][j];
                }
            }
        }
        return Math.abs(sum1 - sum2);
    }
}
