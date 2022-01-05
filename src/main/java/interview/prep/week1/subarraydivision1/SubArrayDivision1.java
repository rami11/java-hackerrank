package interview.prep.week1.subarraydivision1;

import java.util.List;

public class SubArrayDivision1 {

    public static void main(String[] args) {

        List<Integer> s = List.of(1, 2, 1, 3, 2);
        int d = 3;
        int m = 2;
        int result = birthday(s, d, m);
        System.out.println(result);

        s = List.of(1, 1, 1, 1, 1, 1);
        d = 3;
        m = 2;
        result = birthday(s, d, m);
        System.out.println(result);
    }

    public static int birthday(List<Integer> s, int d, int m) {

        int count = 0;
        for (int i = 0; i <= s.size() - m; i++) {

            int sum = s.get(i);
            for (int j = i + 1; j < i + m; j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                count++;
            }
        }

        return count;
    }

}
