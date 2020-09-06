package learnjava.easy.primalitytest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class PrimalityTest {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
            String n = scanner.nextLine();
            BigInteger bigN = new BigInteger(n);

            System.out.println(isPrime(bigN) ? "prime" : "not prime");

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(BigInteger n) {
        return n.isProbablePrime(1);
    }

}
