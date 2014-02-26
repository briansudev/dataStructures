public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
    }
}
