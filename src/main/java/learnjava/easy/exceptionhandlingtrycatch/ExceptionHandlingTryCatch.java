package learnjava.easy.exceptionhandlingtrycatch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingTryCatch {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            System.out.println(x / y);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.err.println(e.getClass().getName());
        } catch (ArithmeticException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
