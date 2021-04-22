package misc.easy.comparetriplets;

import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

    public static void main(String[] args) {
        List<Integer> result = compareTriplets(Arrays.asList(6, 8, 12), Arrays.asList(7, 9, 15));

        System.out.println(result);
    }

    private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        Integer[] result = {0, 0};
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                result[0]++;
            } else if (a.get(i) < b.get(i)) {
                result[1]++;
            }
        }
        return Arrays.asList(result);
    }

}
