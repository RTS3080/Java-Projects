import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0, 1);
        list.add(1, 3);
        list.add(1);
        System.out.println(list.getFirst());
        list.offerFirst(7);
        System.out.println(list);
    }
}