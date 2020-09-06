package statistics.poissondistribution;

/*
    The manager of a industrial plant is planning to buy a machine of either type A or type B.
    For each day’s operation:

    - The number of repairs, X, that machine A needs is a Poisson random variable with mean 0.88.
      The daily cost of operating A is CA = 160 + 40X**2.
    - The number of repairs, Y, that machine B needs is a Poisson random variable with mean 1.55.
      The daily cost of operating B is CB = 128 + 40Y**2.
    Assume that the repairs take a negligible amount of time
    and the machines are maintained nightly to ensure that they operate like new at the start of each day.
    Find and print the expected daily cost for each machine.
*/

import java.io.*;

public class PoissonDistribution2 {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("pd2.txt"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            String[] means = reader.readLine().trim().split(" ");
            double meanA = Double.parseDouble(means[0]);
            double meanB = Double.parseDouble(means[1]);

            writer.write(String.format("%.3f%n", machineA(meanA)));
            writer.write(String.format("%.3f%n", machineB(meanB)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double machineA(double mean) {
        double CA = 160 + 40 * (mean + Math.pow(mean, 2));
        return Math.round(CA * 1000d) / 1000d;
    }

    private static double machineB(double mean) {
        double CB = 128 + 40 * (mean + Math.pow(mean, 2));
        return Math.round(CB * 1000d) / 1000d;
    }

}
