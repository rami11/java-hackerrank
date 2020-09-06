package statistics.binomialdistribution;

import java.io.*;

/*
    A manufacturer of metal pistons finds that, on average, 12% of the pistons they manufacture are rejected
    because they are incorrectly sized. What is the probability that a batch of 10 pistons will contain:
    - No more than 2 rejects?   0.891
    - At least 2 rejects?       0.342
*/

public class BinomialDistribution2 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("bd2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]); // percentage of defective pistons
            int y = Integer.parseInt(input[1]); // size of the current batch of pistons)

            double pmf1 = probabilityMassFunction(x / 100d, y, 2);
            double pmf2 = probabilityMassFunction2(x / 100d, y, 2);

            bufferedWriter.write(String.format("%.3f%n", pmf1));
            bufferedWriter.write(String.format("%.3f%n", pmf2));
            bufferedWriter.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // - No more than 2 rejects?
    private static double probabilityMassFunction(double p, int n, int r) {
        double q = 1 - p;

        double pmf = 0d;
        for (int i = 0; i <= r; i++) {
            pmf += C(n, i) * Math.pow(p, i) * Math.pow(q, n - i);
        }

        return Math.round(pmf * 1000d) / 1000d;
    }

    // - At least 2 rejects?
    private static double probabilityMassFunction2(double p, int n, int r) {
        double q = 1 - p;

        double pmf = 0d;
        for (int i = r; i <= n; i++) {
            pmf += C(n, i) * Math.pow(p, i) * Math.pow(q, n - i);
        }

        return Math.round(pmf * 1000d) / 1000d;
    }

    /**
     * Number of combinations
     */
    private static double C(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    private static int fact(int num) {
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f *= i;
        }
        return f;
    }
}
