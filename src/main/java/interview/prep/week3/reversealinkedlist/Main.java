package interview.prep.week3.reversealinkedlist;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Node<String> head = generateLinkedList(List.of("A", "C", "D"));
        displayLinkedList(head);

        Node<String> reversed = reverseLinkedList(head);
        displayLinkedList(reversed);
        //---

        System.out.println();

        //--
        Node<Integer> head2 = generateLinkedList(List.of(1, 5, 1, 2, 3, 4, 5));
        displayLinkedList(head2);

        Node<Integer> reversed2 = reverseLinkedList(head2);
        displayLinkedList(reversed2);
    }

    // x -> y -> z
    private static <T> Node<T> reverseLinkedList(Node<T> head) {

        if (head == null) {
            return null;
        }

        Node<T> prev = null;
        Node<T> curr = head;

        while (curr != null) {

            Node<T> temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }

    private static <T> Node<T> generateLinkedList(List<T> elements) {
        Node<T> head = null;
        Node<T> tail = head;
        for (T element : elements) {

            Node<T> node = new Node(element);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }

    private static <T> void displayLinkedList(Node<T> head) {
        Node<T> curr = head;
        while (curr.next != null) {
            System.out.printf("%s -> ", curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}
