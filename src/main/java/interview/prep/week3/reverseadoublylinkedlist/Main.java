package interview.prep.week3.reverseadoublylinkedlist;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        DoublyListNode<Character> head = generateDoublyLinkedList(List.of('X', 'Y', 'Z'));
        displayLinkedList(head);
    }

    public static <T> DoublyListNode<T> reverse(DoublyListNode<T> head) {

        if (head == null || head.next == null) {
            return head;
        }

        DoublyListNode<T> prev = null;
        DoublyListNode<T> curr = head;

        while (curr != null) {
            DoublyListNode<T> temp = curr.next;
            curr.next = prev;
            curr.prev = temp;

            prev = curr;
            curr = temp;
        }

        return prev;
    }

    // x y
    private static <T> DoublyListNode<T> generateDoublyLinkedList(List<T> elements) {
        DoublyListNode<T> head = null;
        DoublyListNode<T> tail = head;
        for (T element : elements) {

            DoublyListNode<T> node = new DoublyListNode<>(element);

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

    private static <T> void displayLinkedList(DoublyListNode<T> head) {
        DoublyListNode<T> curr = head;
        while (curr.next != null) {
            System.out.printf("%s <-> ", curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}
