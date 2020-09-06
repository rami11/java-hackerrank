package misc.verybigsum;

import java.util.Arrays;

public class VeryBigSum {

    public static void main(String[] args) {

    }

    static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).reduce(Long::sum).orElse(0);
    }
}
