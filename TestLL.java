public class TestLL {
    public static void main(String[] args) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        for (int i = 9; i >= 0; i--) {
            l2.addFirst(i);
        }
        System.out.println("Testing add()");
        System.out.println(l);
        System.out.println("Testing addFirst()");
        System.out.println(l2);
        System.out.println("Removing 9, 5, 0");
        l.remove(9);
        l.remove(5);
        l.remove(0);
        System.out.println(l);

    }
}
