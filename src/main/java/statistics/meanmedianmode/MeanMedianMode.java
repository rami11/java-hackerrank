package statistics.meanmedianmode;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MeanMedianMode {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("odd_dataset.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<Integer> list = Stream.of(bufferedReader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            double mean = mean(list);
            bufferedWriter.write(String.valueOf(mean));
            bufferedWriter.newLine();
            double median = median(list);
            bufferedWriter.write(String.valueOf(median));
            bufferedWriter.newLine();
            int mode = mode(list);
            bufferedWriter.write(String.valueOf(mode));
            bufferedWriter.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * MEAN
     */
    private static double mean(List<Integer> list) {
        double mean = 0.0;
        for (Integer element : list) {
            mean += element;
        }
        mean /= list.size();

        return Math.round(mean * 10.0) / 10.0;
    }

    private static double mean2(List<Double> list) {
        return list.stream().mapToDouble(num -> num).average().orElse(Double.NaN);
    }

    /**
     * MEDIAN
     */
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

        return Math.round(median * 10.0) / 10.0;
    }

    private static double median2(List<Double> list) {
        return list.stream()
                .mapToDouble(Double::doubleValue)
                .sorted()
                .skip((list.size() - 1) / 2)
                .limit(2 - list.size() % 2)
                .average()
                .orElse(Double.NaN);
    }

    /**
     * MODE
     */
    private static int mode(List<Integer> list) {
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer type : list) {
            if (map.containsKey(type)) {
                map.put(type, map.get(type) + 1);
            } else {
                map.put(type, 1);
            }
        }

        int max = 0, min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                result = entry.getKey();

                max = entry.getValue();
                min = entry.getKey();
            } else if (entry.getValue() == max && entry.getKey() < min) {
                result = entry.getKey();
                min = entry.getKey();
            }
        }

        return result;
    }

}
