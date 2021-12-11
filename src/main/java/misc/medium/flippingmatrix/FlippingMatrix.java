package misc.medium.flippingmatrix;

import java.util.List;

public class FlippingMatrix {

    public static void main(String[] args) {
        int result = flippingMatrix(List.of(
                List.of(112, 42, 83, 119),
                List.of(56, 125, 56, 49),
                List.of(15, 78, 101, 43),
                List.of(62, 98, 114, 108)
        ));

        System.out.println(result);
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {

        int rows = matrix.size() / 2;
        int cols = matrix.get(0).size() / 2;

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += findMax(row, col, matrix);
            }
        }

        return sum;
    }

    private static int findMax(int row, int col, List<List<Integer>> matrix) {

        int rows = matrix.size();
        int cols = matrix.get(0).size();

        int val1 = matrix.get(row).get(col);
        int val2 = matrix.get(row).get(cols - 1 - col);

        int val3 = matrix.get(rows - 1 - row).get(col);
        int val4 = matrix.get(rows - 1 - row).get(cols - 1 - col);

        return Math.max(Math.max(val1, val2), Math.max(val3, val4));
    }
}
