package interview.stacks_and_queues.taleoftwostacks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(new FileReader("input.txt"));
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
