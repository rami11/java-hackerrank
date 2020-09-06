package statistics.binomialdistribution;

import java.io.*;

public class BinomialDistribution1 {

    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("bd1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            double a = Double.parseDouble(input[0]);
            double b = Double.parseDouble(input[1]);

            double result = method(a, b);
            bufferedWriter.write(String.format("%.3f%n", result));
            bufferedWriter.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static double method(double a, double b) {
        double p = a / (a + b);
        double q = 1 - p;

        double x = C(6, 3) * Math.pow(p, 3) * Math.pow(q, 3);
        double y = C(6, 4) * Math.pow(p, 4) * Math.pow(q, 2);
        double z = C(6, 5) * Math.pow(p, 5) * Math.pow(q, 1);
        double k = C(6, 6) * Math.pow(p, 6) * Math.pow(q, 0);

        return Math.round((x + y + z + k) * 1000d) / 1000d;
    }

    /**
     * Number of combinations
     */
    private static double C(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    /**
     * Number of permutations
     */
    private static double P(int n, int r) {
        return fact(n) / fact(n - r);
    }

    private static int fact(int num) {
        int f = 1;
        for (int i = 1; i <= num; i++) {
            f *= i;
        }
        return f;
    }
}
