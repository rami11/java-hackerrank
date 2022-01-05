package interview.prep.week2.sockmerchant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {

    public static void main(String[] args) {
        List<Integer> array = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int result = sockMerchant(array.size(), array);
        System.out.println(result);
    }

    public static int sockMerchant(int n, List<Integer> ar) {

        Map<Integer, Integer> colorToCountMap = new HashMap<>();

        for (int color : ar) {
            if (colorToCountMap.containsKey(color)) {
                colorToCountMap.put(color, colorToCountMap.get(color) + 1);
            } else {
                colorToCountMap.put(color, 1);
            }
        }

        return colorToCountMap.values()
                .stream()
                .reduce(0, (acc, count) -> acc + count / 2);
    }
}
