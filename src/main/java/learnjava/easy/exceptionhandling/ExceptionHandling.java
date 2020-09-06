package learnjava.easy.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExceptionHandling {

    public static final MyCalculator my_calculator = new MyCalculator();

    public static void main(String[] args) {

        try (Scanner in = new Scanner(new FileReader("testcase0.txt"))) {
            while (in.hasNextInt()) {
                int n = in.nextInt();
                int p = in.nextInt();

                try {
                    System.out.println(my_calculator.power(n, p));
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
