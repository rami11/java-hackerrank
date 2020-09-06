package statistics.weightedmean;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WeightedMean {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("odd_dataset.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            /*List<Integer> x = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> w = Arrays.stream(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());*/

            String[] sx = bufferedReader.readLine().trim().split(" ");
            List<Integer> x = new ArrayList<>();
            for (String s : sx) {
                x.add(Integer.parseInt(s));
            }


            String[] sw = bufferedReader.readLine().trim().split(" ");
            List<Integer> w = new ArrayList<>();
            for (String s : sw) {
                w.add(Integer.parseInt(s));
            }

            double mean = weightedMean(x, w);
            bufferedWriter.write(String.valueOf(mean));
            bufferedWriter.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static double weightedMean(List<Integer> x, List<Integer> w) throws IllegalArgumentException {
        if (x.size() != w.size()) {
            throw new IllegalArgumentException("The data and weight lists must have the same size.");
        }

        double wMean = 0d;
        int sumW = 0;
        for (int i = 0; i < x.size(); i++) {
            wMean += x.get(i) * w.get(i);
            sumW += w.get(i);
        }
        wMean /= sumW;

        return Math.round(wMean * 10d) / 10d;
    }


}
