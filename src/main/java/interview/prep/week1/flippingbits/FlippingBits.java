package interview.prep.week1.flippingbits;

public class FlippingBits {

    public static void main(String[] args) {

        long input = 2147483647;
        long result = flippingBits(input);
        System.out.println(result);

        input = 0;
        result = flippingBits(input);
        System.out.println(result);
    }

    public static long flippingBits(long n) {

        String binary = decimalToBinary(n);

        String output = binary.replaceAll("0", "2")
                .replaceAll("1", "0")
                .replaceAll("2", "1");

        return binaryToDecimal(output);
    }

    public static String decimalToBinary(long decimal) {

        StringBuilder strBuilder = new StringBuilder();
        while (decimal > 0) {
            strBuilder.insert(0, decimal % 2);

            decimal /= 2;
        }

        return String.format("%32s", strBuilder).replaceAll(" ", "0");
    }

    private static long binaryToDecimal(String binary) {
        char[] chars = binary.toCharArray();
        long output = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                output += Math.pow(2, chars.length - 1 - i);
            }
        }
        return output;
    }
}
