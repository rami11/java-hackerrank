package statistics.poissondistribution;

import java.io.*;

/*
    A random variable, X, follows Poisson distribution with mean of 2.5.
    Find the probability with which the random variable X is equal to 5.
 */
public class PoissonDistribution1 {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("pd1.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            double mean = Double.parseDouble(reader.readLine().trim());
            int X = Integer.parseInt(reader.readLine().trim());

            writer.write(String.format("%.3f", P(X, mean)));
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Poisson distribution formula
     *
     * @param k      the actual number of successes that occur in a specified region.
     * @param lambda the average number of successes that occur in a specified region.
     * @return Poisson probability,
     * which is the probability of getting exactly k successes when the average number of successes is lambda.
     */
    private static double P(int k, double lambda) {
        double pdf = (Math.pow(lambda, k) * Math.pow(Math.E, -lambda)) / fact(k);
        return Math.round(pdf * 1000d) / 1000d;
    }

    private static int fact(int num) {
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f *= i;
        }
        return f;
    }
}
