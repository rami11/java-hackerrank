package learnjava.medium.onedarray.one;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class OneDArray1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
            int n = scanner.nextInt();

            int[] array = new int[n];
            int i = 0;
            while (n-- > 0) {
                array[i++] = scanner.nextInt();
            }
            Arrays.stream(array).forEach(element -> System.out.print(element + " "));

        } catch (FileNotFoundException | NumberFormatException e) {
            System.err.println(e.getMessage());
        }
    }

}
