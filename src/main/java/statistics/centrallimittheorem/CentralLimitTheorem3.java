package statistics.centrallimittheorem;

import java.io.*;

/*
    You have a sample of 100 values from a population with mean 500 and with standard deviation 80.
    Compute the interval that covers the middle 95% of the distribution of the sample mean;
    in other words, compute A and B such that P(A < x < B) = 0.95. Use the value of z = 1.96.
    Note that z is the z-score.

    z-score(1.96) = .9750


    484.32
    515.68
 */

public class CentralLimitTheorem3 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("clt3.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            int n = Integer.parseInt(reader.readLine().trim());
            double mean = Integer.parseInt(reader.readLine().trim());
            double sigma = Double.parseDouble(reader.readLine().trim());
            double percentage = Double.parseDouble(reader.readLine().trim());
            double z = Double.parseDouble(reader.readLine().trim());

            double[] bound = solution(percentage, z, n, mean, sigma);
            writer.write(String.format("%.2f%n", bound[0]));
            writer.write(String.format("%.2f%n", bound[1]));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double[] solution(double percentage, double z, int n, double mean, double sigma) {
        double[] result = new double[2];

        double sig = sigma / Math.sqrt(n);

        double A = mean - z * sig;
        double B = mean + z * sig;

        result[0] = Math.round(A * 100d) / 100d;
        result[1] = Math.round(B * 100d) / 100d;


        if (percentage != Math.round((cdf(B, mean, sig) - cdf(A, mean, sig)) * 100d) / 100d) {
            return null;
        }

        return result;
    }

    private static double cdf(double x, double mean, double sigma) {
        return (1 / 2d) * (1 + erf((x - mean) / (sigma * Math.sqrt(2))));
    }

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
