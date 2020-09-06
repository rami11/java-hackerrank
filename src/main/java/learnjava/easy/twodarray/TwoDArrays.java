package learnjava.easy.twodarray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class TwoDArrays {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("input2.txt"))) {
            int[][] array = new int[6][6];
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split(" ");
                for (int j = 0; j < lineArray.length; j++) {
                    array[i][j] = Integer.parseInt(lineArray[j]);
                }
                i++;
            }

            Arrays.stream(array).forEach(row -> {
                Arrays.stream(row).forEach(cell -> System.out.print(cell + " "));
                System.out.println();
            });

            System.out.println("The hourglass which has the largest sum:");
            System.out.println(largestHourglassSum(array));

        } catch (IOException | IndexOutOfBoundsException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static int largestHourglassSum(int[][] array) {
        int m = array.length, n = array[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i + 2 < m; i++) {
            for (int j = 0; j + 2 < n; j++) {
                int sum = array[i][j] + array[i + 2][j];
                sum += array[i][j + 1] + array[i + 1][j + 1] + array[i + 2][j + 1];
                sum += array[i][j + 2] + array[i + 2][j + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


}
