package interview.prep.day1.contingsort;

import java.util.ArrayList;
import java.util.List;

public class CountingSort {

    public static void main(String[] args) {

        List<Integer> input = new ArrayList<>(List.of(
                1, 1, 3, 2, 1
        ));

        List<Integer> result = countingSort(input);
        System.out.println(result);
    }

    public static List<Integer> countingSort(List<Integer> arr) {

        final int capacity = 100;
        List<Integer> output = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            output.add(0);
        }

//        generate output list with java stream (slower)
//        List<Integer> output = Stream.generate(() -> 0)
//                .limit(100)
//                .collect(Collectors.toList());

        for (int element : arr) {
            if (element < 100) {
                output.set(element, output.get(element) + 1);
            }
        }

        return output;
    }
}
