public class Queue<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {

        T val;
        Node next;

        Node(T obj) {
            val = obj;
            next = null;
        }
    }

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T obj) {
        if (size == 0) {
            head = new Node(obj);
            tail = head;
        } else {
            tail.next = new Node(obj);
            tail = tail.next;
        }
        size++;
    }

    public T dequeue() {
        T result = null;
        if (size > 0) {
            result = head.val;
            if (size == 1) {
                head = tail = null;
            } else {
                head = head.next;
            }
            size--;
        }
        return result;
    }

    public String toString() {
        String left = "[ ";
        String right = " ]";
        StringBuilder s = new StringBuilder();
        Node n = head;
        s.append(left);
        while (n != null) {
            s.append(n.val);
            s.append(' ');
            n = n.next;
        }
        s.append(right);
        return s.toString();
    }
}


