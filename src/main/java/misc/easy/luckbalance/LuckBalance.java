package misc.easy.luckbalance;

import java.util.Arrays;

public class LuckBalance {

    public static void main(String[] args) {
        int[][] contests = {{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}};
        System.out.println(luckBalance(3, contests));
    }

    private static int luckBalance(int k, int[][] contests) {

        Arrays.sort(contests, (el1, el2) -> el2[0] - el1[0]);

        int luckBalance = 0;
        for (int[] contest : contests) {
            if (contest[1] == 0 || (contest[1] == 1 && k-- > 0)) {
                luckBalance += contest[0];
            } else {
                luckBalance -= contest[0];
            }
        }

        return luckBalance;
    }
}
