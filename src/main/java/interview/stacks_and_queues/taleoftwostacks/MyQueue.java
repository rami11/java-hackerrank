package interview.stacks_and_queues.taleoftwostacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue<T> {

    private final Deque<T> elements;

    public MyQueue() {
        elements = new ArrayDeque<>();
    }

    public void enqueue(T element) {
        elements.addLast(element);
    }

    public T dequeue() {
        return elements.pollFirst();
    }

    public T peek() {
        return elements.peek();
    }
}
