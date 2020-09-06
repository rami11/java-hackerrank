package statistics.normaldistribution;

import java.io.*;

/*
In a certain plant, the time taken to assemble a car is a random variable, X,
having a normal distribution with a mean of 20 hours and a standard deviation of 2 hours.
What is the probability that a car can be assembled at this plant in:

1. Less than 19.5 hours?
2. Between 20 and 22 hours?
 */

public class NormalDistribution1 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nd1.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] firstLine = reader.readLine().trim().split(" ");
            double mean = Double.parseDouble(firstLine[0]);
            double stdDeviation = Double.parseDouble(firstLine[1]);

            double a = Double.parseDouble(reader.readLine().trim());

            String[] thirdLine = reader.readLine().trim().split(" ");
            double b1 = Double.parseDouble(thirdLine[0]);
            double b2 = Double.parseDouble(thirdLine[1]);

            writer.write(String.format("%.3f%n", question1(mean, stdDeviation, a)));
            writer.write(String.format("%.3f", question2(mean, stdDeviation, b1, b2)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double question1(double mean, double sigma, double a) {
        double result = simpson(0, a, 10000, mean, sigma);
        return Math.round(result * 1000d) / 1000d;
    }

    private static double question2(double mean, double sigma, double a, double b) {
        double result = simpson(a, b, 10000, mean, sigma);
        return Math.round(result * 1000d) / 1000d;
    }

    private static double simpson(double a, double b, int n, double mean, double sigma) {
        int i, z;
        double h, s;

        n = n + n;
        s = pdf(mean, sigma, a) * pdf(mean, sigma, b);
        h = (b - a) / n;
        z = 4;

        for (i = 1; i < n; i++) {
            s = s + z * pdf(mean, sigma, a + i * h);
            z = 6 - z;
        }
        return (s * h) / 3;
    }

    private static double pdf(double mean, double sigma, double x) {
        return (1 / (sigma * Math.sqrt(2 * Math.PI))) *
                Math.pow(Math.E, -Math.pow(x - mean, 2) / (2 * Math.pow(sigma, 2)));
    }
}
