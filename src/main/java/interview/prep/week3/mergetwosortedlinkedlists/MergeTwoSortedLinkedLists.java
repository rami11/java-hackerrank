package interview.prep.week3.mergetwosortedlinkedlists;

import java.util.List;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {

        SinglyListNode<Integer> head1 = generateLinkedList(List.of(2, 4, 6, 10));
        SinglyListNode<Integer> head2 = generateLinkedList(List.of(1, 3, 5));
        displayLinkedList(head1);
        displayLinkedList(head2);

        System.out.println();
        System.out.println("Merge:");

        SinglyListNode<Integer> mergedHead = mergeLists(head1, head2);
        displayLinkedList(mergedHead);
    }

    private static <T extends Comparable<T>> SinglyListNode<T> mergeLists(SinglyListNode<T> head1, SinglyListNode<T> head2) {

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        SinglyListNode<T> head = null;
        SinglyListNode<T> tail = head;

        SinglyListNode<T> curr1 = head1;
        SinglyListNode<T> curr2 = head2;
        while (curr1 != null && curr2 != null) {

            SinglyListNode<T> node;
            if (curr1.data.compareTo(curr2.data) <= 0) {
                node = new SinglyListNode<>(curr1.data);
                curr1 = curr1.next;
            } else {
                node = new SinglyListNode<>(curr2.data);
                curr2 = curr2.next;
            }

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }

        while (curr1 != null) {
            SinglyListNode<T> node = new SinglyListNode<>(curr1.data);
            curr1 = curr1.next;
            tail.next = node;
            tail = node;
        }

        while (curr2 != null) {
            SinglyListNode<T> node = new SinglyListNode<>(curr2.data);
            curr2 = curr2.next;
            tail.next = node;
            tail = node;
        }

        return head;
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
