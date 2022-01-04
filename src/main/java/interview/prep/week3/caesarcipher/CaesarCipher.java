package interview.prep.week3.caesarcipher;

public class CaesarCipher {

    public static void main(String[] args) {

        String input = "D3q4";
        String result = caesarCipher(input, 0);
        System.out.println(input);
        System.out.println(result);

        System.out.println();

        input = "Always-Look-on-the-Bright-Side-of-Life";
        result = caesarCipher(input, 5);
        System.out.println(input);
        System.out.println(result);
    }

    public static String caesarCipher(String s, int k) {
        if (k <= 0) {
            return s;
        }

        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder cipherTextBuilder = new StringBuilder();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            char cipherChar = Character.isUpperCase(c)
                    ? alphabetUpper.charAt((alphabetUpper.indexOf(c) + k) % 26)
                    : alphabetLower.charAt((alphabetLower.indexOf(c) + k) % 26);

            cipherTextBuilder.append(Character.isLetter(c) ? cipherChar : c);
        }

        return cipherTextBuilder.toString();
    }
}
