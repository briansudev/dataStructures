public class Stack<T> {
    private Node head;
    private int size;

    private class Node {

        T val;
        Node next;

        Node(T obj) {
            val = obj;
            next = null;
        }
    }

    public Stack() {
        head = null;
        size = 0;
    }

    public void push(T obj) {
        Node item = new Node(obj);
        item.next = head;
        head = item;
        size++;
    }

    public T pop() {
        if (size > 0) {
            T result = head.val;
            head = head.next;
            size--;
            return result;
        }
        return null;
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
