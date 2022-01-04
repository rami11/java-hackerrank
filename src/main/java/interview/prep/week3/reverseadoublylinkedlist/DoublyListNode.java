package interview.prep.week3.reverseadoublylinkedlist;

public class DoublyListNode<T> {
    public T data;
    public DoublyListNode<T> next;
    public DoublyListNode<T> prev;

    public DoublyListNode(T data) {
        this.data = data;
    }
}
