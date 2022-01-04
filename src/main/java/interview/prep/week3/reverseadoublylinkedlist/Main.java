package interview.prep.week3.reverseadoublylinkedlist;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Node<Character> head = generateDoublyLinkedList(List.of('X', 'Y', 'Z'));
        displayLinkedList(head);
    }

    public static <T> Node<T> reverse(Node<T> head) {

        if (head == null) {
            return null;
        }

        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {
            Node<T> temp = curr.next;
            curr.next = prev;
            curr.prev = temp;

            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // x y
    private static <T> Node<T> generateDoublyLinkedList(List<T> elements) {
        Node<T> head = null;
        Node<T> tail = head;
        for (T element : elements) {

            Node<T> node = new Node<>(element);

            if (head == null) {
                head = node;
            } else {
                node.prev = tail;
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }

    private static <T> void displayLinkedList(Node<T> head) {
        Node<T> curr = head;
        while (curr.next != null) {
            System.out.printf("%s <-> ", curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}
