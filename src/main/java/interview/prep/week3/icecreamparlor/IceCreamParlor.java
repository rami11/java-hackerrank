package interview.prep.week3.icecreamparlor;

import java.util.*;

/*
a.k.a: two sum problem
 */
public class IceCreamParlor {

    public static void main(String[] args) {

        List<Integer> prices = List.of(1, 4, 5, 3, 2);
        int target = 4;
        List<Integer> result = iceCreamParlor(target, prices);
        System.out.println(result);

        prices = List.of(2, 2, 4, 3);
        target = 4;
        result = iceCreamParlor(target, prices);
        System.out.println(result);
    }

    private static List<Integer> iceCreamParlor(int target, List<Integer> arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            int price = arr.get(i);
            int complement = target - price;
            if (map.containsKey(complement)) {
                return Arrays.asList(map.get(complement), i + 1);
            }
            map.put(price, i + 1);
        }

        return Collections.emptyList();
    }
}
