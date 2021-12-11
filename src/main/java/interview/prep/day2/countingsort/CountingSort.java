package interview.prep.day2.countingsort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountingSort {

    public static void main(String[] args) {

        List<Integer> result = countingSort(List.of(1, 2, 3, 2, 1));
        System.out.println(result);
    }

    public static List<Integer> countingSort(List<Integer> arr) {

        int[] freqArray = new int[4];

        for (int num : arr) {
            freqArray[num]++;
        }

        return Arrays.stream(freqArray).boxed().collect(Collectors.toList());
    }
}
