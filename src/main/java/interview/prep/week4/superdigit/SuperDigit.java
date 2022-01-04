package interview.prep.week4.superdigit;

import java.util.Arrays;

public class SuperDigit {

    public static void main(String[] args) {
        System.out.println(superDigit2("9875", 4));
    }

    public static int superDigit2(String n, int k) {
        if (n.length() == 1) {
            return Integer.parseInt(n);
        }

        int sum = Arrays.stream(n.split("")).mapToInt(Integer::parseInt).sum();
        String str = String.valueOf(sum);
        return superDigit2(str.repeat(k), 1);
    }
}
