package interview.strings.easy.alternatingcharacters;

public class AlternatingCharacters {

    public static int alternatingCharacters(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static int alternatingCharacters2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();
        char prev = chars[0];

        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            if (curr == prev) {
                count++;
            }
            prev = curr;
        }

        return count;
    }
}
