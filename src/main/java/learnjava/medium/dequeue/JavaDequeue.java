package learnjava.medium.dequeue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class JavaDequeue {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(new FileReader("input2.txt"))) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            Deque<Integer> deque = new ArrayDeque<>();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                int num = scan.nextInt();
                deque.add(num);
                array[i] = num;
            }
            System.out.println(deque);

            System.out.println("With dequeue Java 7 (Caused timeout)");
            method1(array, n, m);

            System.out.println("With dequeue Java 8 (Caused timeout)");
            method2(array, n, m);

            System.out.println("With HashSet (Caused timeout)");
            method3(array, n, m);

            System.out.println("From discussion");
            method(array, n, m);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void method(int[] array, int n, int m) {
        long start = System.currentTimeMillis();
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            deque.add(array[i]);
            set.add(array[i]);

            if (deque.size() == m) {
                if (set.size() > max) {
                    max = set.size();
                }
                int first = deque.remove();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    /*
    With dequeue Java 7 (Caused timeout)
     */
    private static void method1(int[] array, int n, int m) {
        long start = System.currentTimeMillis();
        int max = 0;
        for (int i = 0; i <= n - m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = i; j < i + m; j++) {
                dq.add(array[j]);
            }
            int count = 0;
            while (!dq.isEmpty()) {
                int num = dq.getFirst();
                while (dq.removeFirstOccurrence(num)) ;
                count++;
                if (count > max) {
                    max = count;
                }
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    /*
    With dequeue Java 8 (Caused timeout)
     */
    private static void method2(int[] array, int n, int m) {
        long start = System.currentTimeMillis();
        int max = 0;
        for (int i = 0; i <= n - m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = i; j < i + m; j++) {
                dq.add(array[j]);
            }
            int count = (int) dq.stream().distinct().count();
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }

    /*
    With HashSet (Caused timeout)
     */
    private static void method3(int[] array, int n, int m) {
        long start = System.currentTimeMillis();
        int max = 0;
        for (int i = 0; i <= n - m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + m; j++) {
                set.add(array[j]);
            }
            int count = set.size();
            if (count > max) {
                max = count;
            }
        }
        System.out.println(max);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
    }
}
