package statistics.normaldistribution;

/*
The final grades for a Physics exam taken by a large group of students
have a mean of 70 and a standard deviation of 10.
If we can approximate the distribution of these grades by a normal distribution, what percentage of the students:

1. Scored higher than 80 (i.e., have a grade > 80)?
2. Passed the test (i.e., have a grade >= 60)?
3. Failed the test (i.e., have a grade < 60)?
Find and print the answer to each question on a new line, rounded to a scale of 2 decimal places.
*/

import java.io.*;

public class NormalDistribution2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("nd2.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] firstLine = reader.readLine().trim().split(" ");
            double mean = Double.parseDouble(firstLine[0]);
            double sigma = Double.parseDouble(firstLine[1]);

            int excellentGrade = Integer.parseInt(reader.readLine().trim());
            int thresholdGrade = Integer.parseInt(reader.readLine().trim());

            writer.write(String.format("%.2f%n", percentageStudentsExcellent(mean, sigma, excellentGrade)));
            writer.write(String.format("%.2f%n", percentageStudentsPassed(mean, sigma, thresholdGrade)));
            writer.write(String.format("%.2f%n", percentageStudentsFailed(mean, sigma, thresholdGrade)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double percentageStudentsExcellent(double mean, double sigma, int excellentGrade) {
        double result = 1 - cdf(excellentGrade, mean, sigma);
        return Math.round(result * 10000d) / 100d;
    }

    private static double percentageStudentsPassed(double mean, double sigma, int thresholdGrade) {
        double result = 1 - cdf(thresholdGrade, mean, sigma);
        return Math.round(result * 10000d) / 100d;
    }

    private static double percentageStudentsFailed(double mean, double sigma, int thresholdGrade) {
        double result = cdf(thresholdGrade, mean, sigma);
        return Math.round(result * 10000d) / 100d;
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

    interface Function {
        double f(double x);
    }
}
