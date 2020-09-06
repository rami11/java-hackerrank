package learnjava.easy.javainterface;

import java.util.stream.IntStream;

public class MyCalculator implements AdvancedArithmetic {
    /*@Override
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }*/

    @Override
    public int divisor_sum(int n) {
        return IntStream.rangeClosed(1, n).filter(num -> n % num == 0).sum();
    }
}
