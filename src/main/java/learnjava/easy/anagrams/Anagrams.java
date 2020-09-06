package learnjava.easy.anagrams;

import java.util.Arrays;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(isAnagram("Hello", "elhlo"));
    }

    static boolean isAnagram(String a, String b) {
        String[] sortedA = Arrays.stream(a.split(""))
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);
        String[] sortedB = Arrays.stream(b.split(""))
                .map(String::toUpperCase)
                .sorted()
                .toArray(String[]::new);

        return Arrays.equals(sortedA, sortedB);
    }

    /*static boolean isAnagram(String a, String b) {
        char[] arrayA = a.toUpperCase().toCharArray();
        Arrays.sort(arrayA);
        char[] arrayB = b.toUpperCase().toCharArray();
        Arrays.sort(arrayB);
        return Arrays.equals(arrayA, arrayB);
    }*/

    /*static boolean isAnagram(String a, String b) {
        char[] arrayA = a.toUpperCase().toCharArray();
        List<Character> listA = new ArrayList<>();
        for (int i = 0; i < arrayA.length; i++) {
            listA.add(arrayA[i]);
        }
        Collections.sort(listA);

        char[] arrayB = b.toUpperCase().toCharArray();
        List<Character> listB = new ArrayList<>();
        for (int i = 0; i < arrayB.length; i++) {
            listB.add(arrayB[i]);
        }
        Collections.sort(listB);

        return listA.equals(listB);
    }*/

    /*static boolean isAnagram(String a, String b) {
        char[] arrayA = a.toUpperCase().toCharArray();
        sort(arrayA);
        StringBuilder aBuilder = new StringBuilder();
        for (char character : arrayA) {
            aBuilder.append(character);
        }

        char[] arrayB = b.toUpperCase().toCharArray();
        sort(arrayB);
        StringBuilder bBuilder = new StringBuilder();
        for (char character : arrayB) {
            bBuilder.append(character);
        }

        return aBuilder.toString().equals(bBuilder.toString());
    }

    private static char[] sort(char[] array) {
        char temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] > array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }*/
}
