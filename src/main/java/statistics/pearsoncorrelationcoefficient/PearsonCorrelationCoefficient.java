package statistics.pearsoncorrelationcoefficient;

import java.io.*;
import java.util.Arrays;

public class PearsonCorrelationCoefficient {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("pcc1.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine().trim());
            Double[] X = Arrays.stream(reader.readLine().trim().split(" "))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);
            Double[] Y = Arrays.stream(reader.readLine().trim().split(" "))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            double result = Math.round(pearsonCorrelationCoefficient(X, Y, n) * 1000d) / 1000d;

            writer.write(String.format("%.3f%n", result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double pearsonCorrelationCoefficient(Double[] X, Double[] Y, int n) {
        double meanX = Arrays.stream(X).mapToDouble(Double::valueOf).sum() / n;
        double meanY = Arrays.stream(Y).mapToDouble(Double::valueOf).sum() / n;

        double sigmaX = sigma(X, meanX);
        double sigmaY = sigma(Y, meanY);

        return covariance(X, Y, meanX, meanY, n) / (sigmaX * sigmaY);
    }

    private static double covariance(Double[] X, Double[] Y, int n) {
        return covariance(X, Y, null, null, n);
    }

    private static double covariance(Double[] X, Double[] Y, Double meanX, Double meanY, int n) {
        double mX = meanX == null ? Arrays.stream(X).mapToDouble(Double::valueOf).sum() / n : meanX;
        double mY = meanY == null ? Arrays.stream(Y).mapToDouble(Double::valueOf).sum() / n : meanY;

        double cov = 0d;
        for (int i = 0; i < n; i++) {
            cov += (X[i] - mX) * (Y[i] - mY);
        }
        cov /= n;

        return cov;
    }

    private static double sigma(Double[] X, Double mean) {
        int n = X.length;
        double m = mean == null ?
                Arrays.stream(X).mapToDouble(Double::doubleValue).sum() / n :
                mean;
        return Math.sqrt(Arrays.stream(X).map(x -> Math.pow(x - m, 2))
                .mapToDouble(Double::doubleValue)
                .sum() / n);
    }

    private static double sigma(Double[] X) {
        return sigma(X, null);
    }

}
