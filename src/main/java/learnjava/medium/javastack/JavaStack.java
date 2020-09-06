package learnjava.medium.javastack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new FileReader("input3.txt"))) {
            while (sc.hasNext()) {
                String input = sc.next();

                System.out.println(isBalanced(input));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
