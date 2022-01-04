package interview.prep.week4.queueusingtwostacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();
        while (q-- > 0) {

            int type = scanner.nextInt();
            int element = -1;
            switch (type) {
                case 1:
                    element = scanner.nextInt();
                    queue.addLast(element);
                    break;
                case 2:
                    queue.removeFirst();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
            }

        }
    }
}
