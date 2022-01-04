package interview.prep.week1.matchingstrings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingStrings {

    public static void main(String[] args) {
        System.out.println(matchingStrings(List.of("ab", "ab", "abc"), List.of("ab", "abc", "bc")));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        int[] output = new int[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String query = queries.get(i);

            for (String string : strings) {
                if (query.equals(string)) {
                    output[i] += 1;
                }
            }

        }

        return Arrays.stream(output).boxed().collect(Collectors.toList());
    }
}
