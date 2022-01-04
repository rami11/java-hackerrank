package interview.prep.week3.reversealinkedlist;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SinglyListNode<String> head = generateLinkedList(List.of("A", "C", "D"));
        displayLinkedList(head);

        SinglyListNode<String> reversed = reverseLinkedList(head);
        displayLinkedList(reversed);
        //---

        System.out.println();

        //--
        SinglyListNode<Integer> head2 = generateLinkedList(List.of(1, 2, 3));
        displayLinkedList(head2);

        SinglyListNode<Integer> reversed2 = reverseLinkedListRec(head2);
        displayLinkedList(reversed2);
    }

    private static <T> SinglyListNode<T> reverseLinkedListRec(SinglyListNode<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        SinglyListNode<T> prev = reverseLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    // x -> y -> z
    private static <T> SinglyListNode<T> reverseLinkedList(SinglyListNode<T> head) {

        if (head == null || head.next == null) {
            return head;
        }

        SinglyListNode<T> prev = null;
        SinglyListNode<T> curr = head;

        while (curr != null) {

            SinglyListNode<T> temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }

    private static <T> SinglyListNode<T> generateLinkedList(List<T> elements) {
        SinglyListNode<T> head = null;
        SinglyListNode<T> tail = head;
        for (T element : elements) {

            SinglyListNode<T> node = new SinglyListNode<>(element);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        return head;
    }

    private static <T> void displayLinkedList(SinglyListNode<T> head) {
        SinglyListNode<T> curr = head;
        while (curr.next != null) {
            System.out.printf("%s -> ", curr.data);
            curr = curr.next;
        }
        System.out.println(curr.data);
    }
}
