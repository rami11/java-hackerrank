package interview.prep.week4.balancedbrackets;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class BalancedBrackets {

    public static void main(String[] args) {
        String result = isBalanced("{{[[(())]]}}");
        System.out.println(result);

        result = isBalanced("{[(])}");
        System.out.println(result);
    }

    public static String isBalanced(String s) {

        if (s == null || s.isEmpty()) {
            return "YES";
        }

        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> bracketMap = Map.of(
                '{', '}',
                '(', ')',
                '[', ']'
        );

        char[] brackets = s.toCharArray();
        for (char bracket : brackets) {
            if (bracketMap.containsKey(bracket)) {
                stack.addLast(bracket);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    char openingBracket = stack.removeLast();
                    if (bracketMap.get(openingBracket) != bracket) {
                        return "NO";
                    }
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
