package misc.easy.divisiblesumpairs;

public class DivisibleSumPairs {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 6, 1, 2};
        System.out.println(divisibleSumPairs(6, 3, a));
    }

    private static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((ar[i] + ar[j]) % k == 0) result++;
            }
        }

        return result;
    }
}
