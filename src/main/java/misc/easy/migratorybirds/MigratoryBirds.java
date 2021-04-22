package misc.easy.migratorybirds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3)));

        System.out.println(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));

        System.out.println(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 4, 3)));
    }

    private static Integer migratoryBirds(List<Integer> arr) {
        int result = 0;

        Map<Integer, Integer> types = new HashMap<>();
        for (Integer type : arr) {
            if (types.containsKey(type)) {
                types.put(type, types.get(type) + 1);
            } else {
                types.put(type, 1);
            }
        }

        int max = 0, min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : types.entrySet()) {
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
