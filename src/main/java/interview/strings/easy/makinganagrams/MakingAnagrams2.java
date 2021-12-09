package interview.strings.easy.makinganagrams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingAnagrams2 {

    public static int makingAnagrams(String s1, String s2) {

        Map<Character, Integer> charToCount1 = countChars(s1);
        Map<Character, Integer> charToCount2 = countChars(s2);
        Set<Character> charSet = new HashSet<>();

        int result = 0;
        String s = s1 + s2;
        for (char c : s.toCharArray()) {
            if (!charSet.contains(c)) {
                result += Math.abs(charToCount1.getOrDefault(c, 0) - charToCount2.getOrDefault(c, 0));
                charSet.add(c);
            }
        }

        return result;
    }

    private static Map<Character, Integer> countChars(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (charToCount.containsKey(c)) {
                charToCount.put(c, charToCount.get(c) + 1);
            } else {
                charToCount.put(c, 1);
            }
        }

        return charToCount;
    }
}
