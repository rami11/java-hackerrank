package algorithms.strings.palindromeindex;

public class PalindromeIndex {

    public static void main(String[] args) {
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
    }

    public static int palindromeIndex(String s) {

        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            if (chars[left] != chars[right]) {
                return chars[left + 1] == chars[right] ? left : right;
            }

            left++;
            right--;
        }

        return -1;
    }

}
