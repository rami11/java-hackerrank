package misc.easy.twocharacters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoCharacters {

    public static void main(String[] args) {

        int result = alternate("beabeefeab");
        System.out.println(result);

        result = alternate("ab");
        System.out.println(result);
    }

    public static int alternate(String s) {

        char[] chars = s.toCharArray();

        Set<Character> charSet = new HashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }
        List<Character> charList = new ArrayList<>(charSet);

        List<List<Character>> combList = new ArrayList<>();
        for (int i = 0; i < charList.size() - 1; i++) {
            for (int j = i + 1; j < charList.size(); j++) {
                List<Character> comb = new ArrayList<>();
                comb.add(charList.get(i));
                comb.add(charList.get(j));
                combList.add(comb);
            }
        }

        int maxLength = 0;
        for (List<Character> comb : combList) {
            String regex = String.format("[^%s%s]", comb.get(0), comb.get(1));
            String newStr = s.replaceAll(regex, "");
            if (isValid(newStr) && newStr.length() > maxLength) {
                maxLength = newStr.length();
            }
        }

        return maxLength;
    }

    private static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
            set.add(chars[i]);
            set.add(chars[i + 1]);
        }

        return set.size() == 2;
    }
}
