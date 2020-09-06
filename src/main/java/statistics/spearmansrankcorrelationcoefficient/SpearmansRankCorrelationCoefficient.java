package statistics.spearmansrankcorrelationcoefficient;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpearmansRankCorrelationCoefficient {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("srcc.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine().trim());
            Double[] X = Arrays.stream(reader.readLine().trim().split(" "))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);
            Double[] Y = Arrays.stream(reader.readLine().trim().split(" "))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            double result = Math.round(spearmansRankCorrelationCoefficient(X, Y, n) * 1000d) / 1000d;

            writer.write(String.format("%.3f%n", result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double spearmansRankCorrelationCoefficient(Double[] X, Double[] Y, int n) {
        Integer[] rankX = ranks(X);
        Integer[] rankY = ranks(Y);

        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += Math.pow(rankX[i] - rankY[i], 2);
        }
        double result = 1 - (6 * sumD) / (n * (Math.pow(n, 2) - 1));

        return Math.round(result * 1000d) / 1000d;
    }

    /**
     * Get the Rank X
     *
     * @param X Random variable
     * @return An Array of ranks of X
     */
    private static Integer[] ranks(Double[] X) {
        int n = X.length;
        Integer[] rankX = new Integer[n];
        Double[] sortedX = Arrays.stream(X)
                .sorted()
                .toArray(Double[]::new);

        Map<Double, Integer> rankToX = new HashMap<>();
        for (int i = 0; i < sortedX.length; i++) {
            rankToX.put(sortedX[i], i + 1);
        }
        for (int i = 0; i < n; i++) {
            rankX[i] = rankToX.get(X[i]);
        }
        return rankX;
    }
}
