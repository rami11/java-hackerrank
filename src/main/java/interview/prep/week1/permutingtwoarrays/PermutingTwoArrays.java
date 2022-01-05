package interview.prep.week1.permutingtwoarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PermutingTwoArrays {

    public static void main(String[] args) {

        List<Integer> array1 = new ArrayList<>(List.of(4, 4, 3, 2, 1, 4, 4, 3, 2, 4));
        List<Integer> array2 = new ArrayList<>(List.of(2, 3, 0, 1, 1, 3, 1, 0, 0, 2));
        int k = 4;

        String result = twoArrays(k, array1, array2);
        System.out.println(result);
    }

    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {

        Collections.sort(A);
        B.sort(Comparator.reverseOrder());

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                return "NO";
            }
        }

        return "YES";
    }
}
