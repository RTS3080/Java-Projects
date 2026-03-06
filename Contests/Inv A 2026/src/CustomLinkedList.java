import java.io.Serializable;

public class CustomLinkedList implements Serializable {
    public static final long serialVersionUID = 1L;

    static class Node implements Serializable {
        public static final long serialVersionUID = 1L;

        private int value;
        private Node next;
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head, tail;

    public CustomLinkedList() {
        head = null;
        tail = null;
    }

    public void add(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    private Node recur(Node prev, Node cur) {
        Node n = new Node(cur.value, prev);
        if (cur.next == null) {
            return n;
        }

        return recur(n, cur.next);
    }

    public CustomLinkedList reverse() {
        if (head == null) {
            return null;
        }

        Node newHead = recur(null, head);
        CustomLinkedList reversed = new CustomLinkedList();
        reversed.head = newHead;
        reversed.tail = newHead;
        while (reversed.tail.next != null) {
            reversed.tail = reversed.tail.next;
        }

        return reversed;
    }

    @Override
    public String toString() {
        return "";
    }
}