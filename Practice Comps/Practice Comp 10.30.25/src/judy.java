import java.util.*;
import java.io.*;
import java.awt.*;

public class judy{
    class Node {
        char val;
        Node l;
        Node r;

        public Node(char val) {
            this.val = val;
        }

        public String toString() {
            String res = val + "";
            if (l != null) {
                res += " " + l;
            } else res += " -";

            if (r != null) {
                res += " " + r;
            } else res += " -";
            return res;
        }
    }

    public int findLast(Node n, int idx ) {
        if (n == null) return Integer.MIN_VALUE;
        if (n.val == 'A') return idx;
        return Math.max(findLast(n.l, idx * 2 + 1), findLast(n.r, idx * 2 + 2));
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("judy".toLowerCase()+".dat"));

        while (f.hasNext()){
            HashMap<Character, Node> map = new HashMap<>();
            HashSet<Character> possibleRoots = new HashSet<>();
            HashSet<Character> nonRoots = new HashSet<>();

            String[] parts = f.nextLine().split(" ");
            for (String part : parts) {
                char val = part.charAt(0);
                char left = part.charAt(1);
                char right = part.charAt(2);

                map.putIfAbsent(val, new Node(val));
                Node par = map.get(val);

                possibleRoots.add(val);

                if (left != '-') {
                    Node l = map.getOrDefault(left, new Node(left));
                    par.l = l;
                    map.put(left, l);
                    nonRoots.add(left);
                }

                if (right != '-') {
                    Node r = map.getOrDefault(right, new Node(right));
                    par.r = r;
                    map.put(right, r);
                    nonRoots.add(right);
                }
            }

            possibleRoots.removeAll(nonRoots);

            // get first item
            char r = possibleRoots.iterator().next();

            System.out.println(findLast(map.get(r), 0));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new judy().run();
    }
}
