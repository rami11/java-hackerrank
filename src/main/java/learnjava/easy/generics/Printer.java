package learnjava.easy.generics;

import java.util.Arrays;

public class Printer {

    <T> void printArray(T[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }
}
