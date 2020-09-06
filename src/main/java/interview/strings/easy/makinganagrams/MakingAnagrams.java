package interview.strings.easy.makinganagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MakingAnagrams {

    public static int makeAnagrams(String a, String b) {
        Map<Character, Integer> charToCountA = getCharacterToCount(a);
        Map<Character, Integer> charToCountB = getCharacterToCount(b);

        int similar = 0;
        for (Map.Entry<Character, Integer> entryA : charToCountA.entrySet()) {
            for (Map.Entry<Character, Integer> entryB : charToCountB.entrySet()){
                if (entryA.getKey() == entryB.getKey()) {
                    similar += entryA.getValue() + entryB.getValue() - Math.abs(entryA.getValue() - entryB.getValue());
                    break;
                }
            }
        }
        return a.length() + b.length() - similar;
    }

    private static Map<Character, Integer> getCharacterToCount(String str) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Set<Character> keySet = charToCount.keySet();
            if (keySet.contains(str.charAt(i))) {
                int c = charToCount.get(str.charAt(i));
                charToCount.put(str.charAt(i), ++c);
            } else {
                charToCount.put(str.charAt(i), 1);
            }
        }
        return charToCount;
    }
}
