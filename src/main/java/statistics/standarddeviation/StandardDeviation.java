package statistics.standarddeviation;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class StandardDeviation {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            /*String[] xs = bufferedReader.readLine().trim().split(" ");
            List<Integer> X = new ArrayList<>();
            for (String s : xs) {
                X.add(Integer.parseInt(s));
            }*/

            Double[] X = Arrays.stream(bufferedReader.readLine().trim().split(" "))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);
            System.out.println(Arrays.asList(X));

            double stdDeviation = sigma(X);
            stdDeviation = Math.round(stdDeviation * 10d) / 10d;
            bufferedWriter.write(String.format("%.1f%n", stdDeviation));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static double standardDeviation(List<Integer> list) {
        double mean = list.stream().mapToInt(Integer::intValue).average().orElse(-1);

        double variance = 0d;
        for (Integer num : list) {
            variance += Math.pow(num - mean, 2);
        }
        variance /= list.size();

        return Math.round(Math.sqrt(variance) * 10d) / 10d;
    }

    private static double sigma(Double[] X) {
        int n = X.length;
        double mean = Arrays.stream(X)
                .mapToDouble(Double::doubleValue)
                .sum() / n;
        return Math.sqrt(Arrays.stream(X)
                .map(x -> Math.pow(x - mean, 2))
                .mapToDouble(Double::doubleValue)
                .sum() / n);
    }
}
