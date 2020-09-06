package misc.birthdaychocolate;

import java.util.Arrays;
import java.util.List;

public class BirthdayChocolate {

    public static void main(String[] args) {
        System.out.println(birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2));

        System.out.println(birthday(Arrays.asList(1, 1, 1, 1, 1), 3, 2));

        System.out.println(birthday(Arrays.asList(4), 4, 1));
    }

    private static int birthday(List<Integer> s, int d, int m) {
        int result = 0;

        for (int i = 0; i < s.size(); i++) {
            int sum = 0;
            for (int j = i; j < m + i && j < s.size(); j++) {
                sum += s.get(j);
            }
            if (sum == d) {
                result++;
            }
        }

        return result;
    }
}
