package interview.prep.week1.pangrams;

import java.util.HashSet;
import java.util.Set;

public class Pangrams {

    public static void main(String[] args) {

        String input = "We promptly judged antique ivory buckles for the next prize";
        System.out.println(pangrams(input));

        input = "We promptly judged antique ivory buckles for the prize";
        System.out.println(pangrams(input));
    }

    public static String pangrams(String s) {

        if (s == null || s.length() < 26) {
            return "not pangram";
        }

        Set<Character> alphabets = new HashSet<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                alphabets.add(Character.toLowerCase(c));
            }
        }

        return alphabets.size() >= 26 ? "pangram" : "not pangram";
    }
}
