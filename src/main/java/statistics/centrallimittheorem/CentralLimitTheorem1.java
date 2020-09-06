package statistics.centrallimittheorem;

import statistics.normaldistribution.NormalDistribution2;

import java.io.*;

/*
    A large elevator can transport a maximum of 9800 pounds.
    Suppose a load of cargo containing 49 boxes must be transported via the elevator.
    The box weight of this type of cargo follows a distribution
    with a mean of 205 pounds and a standard deviation of 15 pounds.
    Based on this information, what is the probability that all 49 boxes can be safely loaded
    into the freight elevator and transported?
*/

public class CentralLimitTheorem1 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("clt1.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int X = Integer.parseInt(reader.readLine().trim());
            int n = Integer.parseInt(reader.readLine().trim()); // sample size (the number of boxes in a cargo)
            double mean = Double.parseDouble(reader.readLine().trim());
            double sigma = Double.parseDouble(reader.readLine().trim());

            writer.write(String.format("%.4f%n", solution(X, n, mean, sigma)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double solution(int X, int n, double mean, double sigma) {
        double sampleMean = mean * n;
        double sampleStdDeviation = sigma * Math.sqrt(n);

        double result = cdf(X, sampleMean, sampleStdDeviation);

        return Math.round(result * 10000d) / 10000d; // round to a scale of 4 decimal places
    }

    /**
     * Cumulative distribution function
     */
    private static double cdf(double x, double mean, double sigma) {
        return (1 / 2d) * (1 + erf((x - mean) / (sigma * Math.sqrt(2))));
    }

    /**
     * The error function for the Cumulative distribution function
     */
    private static double erf(double z) {
        return (2 / Math.sqrt(Math.PI)) * simpsonIntegration(0, z, x -> Math.pow(Math.E, -Math.pow(x, 2)));
    }

    private static double simpsonIntegration(double a, double b, Function f) {
        int n = 100000;

        int i, z;
        double h, s;

        n = n + n;
        s = f.f(a) * f.f(b);
        h = (b - a) / n;
        z = 4;

        for (i = 1; i < n; i++) {
            s = s + z * f.f(a + i * h);
            z = 6 - z;
        }
        return (s * h) / 3;
    }

    interface Function {
        double f(double x);
    }

}
