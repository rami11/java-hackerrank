package interview.prep.week4.mergetwosortedlinkedlists;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {

        List<Integer> result = merge(List.of(1, 2, 3), List.of(3, 4));
        System.out.println(result);

        System.out.println();

        result = merge(List.of(4, 5, 6), List.of(1, 2, 10));
        System.out.println(result);
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> output = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {

            int element1 = list1.get(i);
            int element2 = list2.get(j);

            if (element1 < element2) {
                output.add(element1);
                i++;
            } else {
                output.add(element2);
                j++;
            }
        }

        while (i < list1.size()) {
            output.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            output.add(list2.get(j));
            j++;
        }

        return output;
    }
}
