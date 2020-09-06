package statistics.quartiles;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Quartiles {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("even_dataset.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] sx = bufferedReader.readLine().trim().split(" ");
            Integer[] x = new Integer[sx.length];
            for (int i = 0; i < sx.length; i++) {
                x[i] = Integer.parseInt(sx[i]);
            }

            int[] quartiles = quartiles(x, n);
            for (int i = 0; i < quartiles.length; i++) {
                bufferedWriter.write(String.valueOf(quartiles[i]));
                bufferedWriter.newLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int[] quartiles(Integer[] dataset, int n) {
        int[] quartiles = new int[3];

        Arrays.sort(dataset, Comparator.comparingInt(Integer::intValue));

        int lowerLastIndex, upperFirstIndex;
        if (n % 2 == 0) {
            lowerLastIndex = n / 2 ;
            upperFirstIndex = n / 2;
        } else {
            lowerLastIndex = n / 2;
            upperFirstIndex = n / 2 + 1;
        }

        List<Integer> lowerSet = Arrays.asList(dataset).subList(0, lowerLastIndex);
        List<Integer> mainSet = Arrays.asList(dataset);
        List<Integer> upperSet = Arrays.asList(dataset).subList(upperFirstIndex, n);

        quartiles[0] = median(lowerSet);
        quartiles[1] = median(mainSet);
        quartiles[2] = median(upperSet);

        return quartiles;
    }

    private static int median(List<Integer> list) {
        int median;

        list.sort(Comparator.comparingInt(Integer::intValue));

        if (list.size() % 2 == 0) {
            int m1 = list.get(list.size() / 2);
            int m2 = list.get(list.size() / 2 - 1);

            median = (m1 + m2) / 2;
        } else {
            median = list.get(list.size() / 2);
        }

        return median;
    }
}
