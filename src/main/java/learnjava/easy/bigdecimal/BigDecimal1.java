package learnjava.easy.bigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimal1 {

    public static void main(String[] args) {
        String[] s = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};

        insertionSort(s);

        System.out.println(Arrays.asList(s));
    }

    private static void insertionSort(String[] s) {
        int j;
        for (int i = 0; i < s.length; i++) {
            j = i;
            while (j > 0 && new BigDecimal(s[j - 1]).compareTo(new BigDecimal(s[j])) < 0) {
                String temp = s[j];
                s[j] = s[j - 1];
                s[j - 1] = temp;
                j--;
            }
        }
    }

}
