package learnjava.easy.substringcomparisons;

public class SubstringComparisons {

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }

    private static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        String subStr;
        for (int i = 0; i < s.length() - k + 1; i++) {
            subStr = s.substring(i, i + k);
            if (subStr.compareTo(smallest) < 0) {
                smallest = subStr;
            }
            if (subStr.compareTo(largest) > 0) {
                largest = subStr;
            }
        }

        return smallest + "\n" + largest;
    }
}
