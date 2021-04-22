package misc.easy.betweentwosets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetweenTwoSets {

    public static void main(String[] args) {
        System.out.println(getTotalX(Arrays.asList(2, 4), Arrays.asList(16, 32, 96))); // 3

        System.out.println(getTotalX(Arrays.asList(1), Arrays.asList(100))); // 9
    }

    private static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> elementsBetween = new ArrayList<>();

        int multipleA = a.get(a.size() - 1);
        while (multipleA <= b.get(b.size() - 1)) {
            boolean okA = true;
            boolean okB = true;
            for (int num : a) {
                if (multipleA % num != 0) {
                    okA = false;
                    break;
                }
            }
            if (okA) {
                for (int num : b) {
                    if (num % multipleA != 0) {
                        okB = false;
                        break;
                    }
                }
            }
            if (okA && okB) {
                elementsBetween.add(multipleA);
            }
            multipleA++;
        }
        return elementsBetween.size();
    }
}
