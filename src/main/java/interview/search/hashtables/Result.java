package interview.search.hashtables;

import java.util.*;
import java.util.stream.Collectors;

public class Result {

    public static void whatFlavors(List<Integer> cost, int money) {
        Map<Integer, Integer> saved = new HashMap<>();
        for (int i = 0; i < cost.size(); i++) {
            int n = cost.get(i);
            if (saved.containsKey(money - n)) {
                System.out.println(saved.get(money - n) + " " + (i + 1));
                return;
            }
            saved.put(n, i + 1);
        }
    }

    /**
     * Brute force
     * @param cost
     * @param money
     */
    public static void whatFlavors2(List<Integer> cost, int money) {
        Map<Integer, List<Integer>> groupByCost = fromListToIndicesGroupByItem(cost);
        List<Integer> costs = new ArrayList<>(groupByCost.keySet());
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < costs.size(); i++) {
            for (int j = i; j < costs.size(); j++) {
                int cost1 = costs.get(i);
                int cost2 = costs.get(j);
                if (cost1 + cost2 == money) {
                    result.add(groupByCost.get(cost1).get(0));
                    groupByCost.get(cost1).remove(0);
                    result.add(groupByCost.get(cost2).get(0));
                    groupByCost.get(cost2).remove(0);
                    System.out.println(result.stream().sorted().map(Object::toString).collect(Collectors.joining(" ")));
                    return;
                }
            }
        }
    }


    private static Map<Integer, List<Integer>> fromListToIndicesGroupByItem(List<Integer> items) {
        Map<Integer, List<Integer>> itemToIndices = new HashMap<>();

        for (int i = 0; i < items.size(); i++) {
            int item = items.get(i);
            if (itemToIndices.get(item) == null) {
                itemToIndices.put(item, new ArrayList<>(Collections.singletonList(i + 1)));
            } else {
                itemToIndices.get(item).add(i + 1);
            }
        }
        return itemToIndices;
    }
}
