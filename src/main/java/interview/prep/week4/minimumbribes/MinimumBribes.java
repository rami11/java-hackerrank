package interview.prep.week4.minimumbribes;

import java.util.List;

public class MinimumBribes {

    public static void minimumBribesNaive(List<Integer> q) {

        int bribes = 0;
        boolean tooChaotic = false;
        for (int i = 0; i < q.size(); i++) {

            int person = q.get(i);

            int bribesToAdd = 0;
            for (int j = i + 1; j < q.size(); j++) {
                int prevPerson = q.get(j);
                if (person > prevPerson) {
                    bribesToAdd++;
                }
            }
            if (bribesToAdd > 2) {
                tooChaotic = true;
                break;
            }
            bribes += bribesToAdd;
        }

        System.out.println(tooChaotic ? "Too chaotic" : bribes);
    }
}