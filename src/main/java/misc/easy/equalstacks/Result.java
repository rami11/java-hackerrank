package misc.easy.equalstacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Result {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        if (h1.isEmpty() || h2.isEmpty() || h3.isEmpty()) {
            return 0;
        }

        int sumH1 = h1.stream().mapToInt(Integer::intValue).sum();
        int sumH2 = h2.stream().mapToInt(Integer::intValue).sum();
        int sumH3 = h3.stream().mapToInt(Integer::intValue).sum();

        if (sumH1 == sumH2 && sumH1 == sumH3) {
            return sumH1;
        }

        Function<List<Integer>, BiFunction<Integer, Integer, Integer>> reduce = (list) -> (sumList, min) -> {
            if (sumList > min) {
                int firstElement = list.get(0);
                list.remove(0);
                if (list.isEmpty()) {
                    return 0;
                } else {
                    sumList -= firstElement;
                    return sumList;
                }
            }
            return sumList;
        };

        int minSum = Collections.min(Arrays.asList(sumH1, sumH2, sumH3));

        while (true) {
            sumH1 = reduce.apply(h1).apply(sumH1, minSum);
            if (sumH1 == 0) return 0;
            minSum = Math.min(sumH1, minSum);

            sumH2 = reduce.apply(h2).apply(sumH2, minSum);
            if (sumH2 == 0) return 0;
            minSum = Math.min(sumH2, minSum);

            sumH3 = reduce.apply(h3).apply(sumH3, minSum);
            if (sumH3 == 0) return 0;
            minSum = Math.min(sumH3, minSum);

            if (sumH1 == sumH2 && sumH1 == sumH3) {
                return minSum;
            }
        }
    }

}
