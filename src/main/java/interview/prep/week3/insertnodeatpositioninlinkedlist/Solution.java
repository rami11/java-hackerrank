package interview.prep.week3.insertnodeatpositioninlinkedlist;

public class Solution {

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode curr = head;

        for (int i = 0; i < position; i++) {
            prev = curr;
            curr = curr.next;
        }

        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (prev == null) {
            head = node;
        } else {
            prev.next = node;
            node.next = curr;
        }

        return head;
    }
}
