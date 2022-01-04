package interview.prep.week2.lonelyindex;

import java.util.List;

public class LonelyIndex {

    public static int lonelyinteger(List<Integer> a) {

        for (int num : a) {

            int i1 = a.indexOf(num);
            int i2 = a.lastIndexOf(num);

            if (i1 == i2) {
                return num;
            }
        }

        return 0;
    }

}
