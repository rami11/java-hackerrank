package statistics.interquartilerange;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InterQuartileRange {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("even_dataset.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] xs = bufferedReader.readLine().trim().split(" ");
            List<Integer> X = new ArrayList<>();
            for (String s : xs) {
                X.add(Integer.parseInt(s));
            }

            String[] fs = bufferedReader.readLine().trim().split(" ");
            List<Integer> F = new ArrayList<>();
            for (String s : fs) {
                F.add(Integer.parseInt(s));
            }

            double iqr = interQuartileRange(X, F);
            bufferedWriter.write(String.valueOf(iqr));
            bufferedWriter.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static List<Integer> constructS(List<Integer> X, List<Integer> F) throws IllegalArgumentException {
        if (X.size() != F.size()) {
            throw new IllegalArgumentException("Data and frequency sets must have the same size.");
        }

        List<Integer> S = new ArrayList<>();
        for (int i = 0; i < X.size(); i++) {
            for (int j = 0; j < F.get(i); j++) {
                S.add(X.get(i));
            }
        }
        S.sort(Comparator.comparingInt(Integer::intValue));

        return S;
    }

    private static double interQuartileRange(List<Integer> X, List<Integer> F) {
        List<Integer> S = constructS(X, F);
        double[] range = quartileRange(S);

        double firstQuartile = range[0];
        double thirdQuartile = range[1];

        return thirdQuartile - firstQuartile;
    }

    private static double[] quartileRange(List<Integer> S) {
        double[] range = new double[2];
        int n = S.size();

        int lowerLastIndex, upperFirstIndex;
        if (n % 2 == 0) {
            lowerLastIndex = n / 2;
            upperFirstIndex = n / 2;
        } else {
            lowerLastIndex = n / 2;
            upperFirstIndex = n / 2 + 1;
        }

        List<Integer> lowerSet = S.subList(0, lowerLastIndex);
        List<Integer> upperSet = S.subList(upperFirstIndex, n);

        range[0] = median(lowerSet);
        range[1] = median(upperSet);

        return range;
    }

    private static double median(List<Integer> list) {
        double median;

        list.sort(Comparator.comparingInt(Integer::intValue));

        if (list.size() % 2 == 0) {
            int m1 = list.get(list.size() / 2);
            int m2 = list.get(list.size() / 2 - 1);

            median = (m1 + m2) / 2.0;
        } else {
            median = list.get(list.size() / 2);
        }

        return Math.round(median * 10d) / 10d;
    }
}
