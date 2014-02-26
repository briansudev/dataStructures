/** An implementation of a linked list that keeps track
 * of the head and the tail. */
public class LinkedList<T> {

    public Node _head;
    public Node _tail;
    public int _size;

    private class Node {

        private T _val;
        private Node _next;

        Node(T d) {
            _val = d;
            _next = null;
        }
    }

    public LinkedList() {
        _head = null;
        _tail = null;
        _size = 0;
    }

    public Node add(T obj) {
        if (_size == 0) {
            _head = new Node(obj);
            _tail = _head;
        } else {
            _tail._next = new Node(obj);
            _tail = _tail._next;
        }
        _size++;
        return _head;
    }

    public Node addFirst(T obj) {
        if (_size == 0) {
            _head = new Node(obj);
            _tail = _head;
        } else {
            Node first = new Node(obj);
            first._next = _head;
            _head = first;
        }
        _size++;
        return _head;
    }

    public T remove(int index) {
        if (index > _size - 1) {
            return null;
        } else {
            T result;
            if (index == 0) {
                result = _head._val;
                _head = _head._next;
                return result;
            } 

            Node n = _head;
            for (int i = 0; i < index - 1; i++) {
                n = n._next;
            }
            result = n._next._val;
            if (index == _size - 1) {
                n._next = null;
            } else {
                n._next = n._next._next;
            }
            return result;
        }
                
    }

    public String toString() {
        final String left = "[ ";
        final String right = " ]";
        StringBuilder s = new StringBuilder();
        s.append(left);
        Node n = _head;
        while (n != null) {
            s.append(n._val);
            s.append(' ');
            n = n._next;
        }
        s.append(right);
        return s.toString();
    }


}



