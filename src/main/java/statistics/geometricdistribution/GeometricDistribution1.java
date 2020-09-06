package statistics.geometricdistribution;

import java.io.*;

/*
    The probability that a machine produces a defective product is 1/3.
    What is the probability that the 1st defect is found during the 5th inspection?

    0.066
 */
public class GeometricDistribution1 {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("gd1.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] input = bufferedReader.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]); //numerator
            int y = Integer.parseInt(input[1]); //denominator

            double p = ((double) x / y); //probability of a defect

            //the inspection we want the probability of being the first defect for
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            bufferedWriter.write(String.format("%.3f", F(n, p)));
            bufferedWriter.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Geometric Distribution Formula
    private static double F(int n, double p) {
        return Math.pow(1 - p, n - 1) * p;
    }
}
