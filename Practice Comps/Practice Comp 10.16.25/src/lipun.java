import java.util.*;
import java.io.*;
import java.awt.*;

public class lipun{
    public static class Node {
        char v;
        Node l;
        Node r;

        public Node(char v) {
            this.v = v;
        }

        public String toString() {
            return v + "";
        }
    }

    public Node addNode(char v, Node node) {
        if (node == null) return new Node(v);
        if (Character.compare(v, node.v) <= 0) {
            node.l = addNode(v, node.l);
        } else node.r = addNode(v, node.r);
        return node;
    }

    public int depth(Node root) {
        int depth = 0;
        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
//                System.out.println(q);
                Node n = q.poll();
                if (n.l != null) {
                    q.add(n.l);
                } if (n.r != null) {
                    q.add(n.r);
                }
            }
            depth++;
        } return depth;
    }

    public int countLeaf(Node n) {
        if (n == null) return 0;
        if (n.l == null && n.r == null) return 1;
        return countLeaf(n.l) + countLeaf(n.r);
    }

    public int countExt(Node n) {
        if (n == null) return 1;
        return countExt(n.l) + countExt(n.r);
    }

    public int intLength(Node root) {
        int depth = 0;
        int res = 0;

        LinkedList<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            res += size * depth++;
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (n.l != null) {
                    q.add(n.l);
                } if (n.r != null) {
                    q.add(n.r);
                }
            }
        } return res;
    }

    public int extLength(Node n, int d) {
        if (n == null) return d;
        d++;
        return extLength(n.l, d) + extLength(n.r, d);
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lipun".toLowerCase()+".dat"));

        while (f.hasNext()) {
            char[] word = f.next().toCharArray();
            Node root = new Node(word[0]);
            for (int i = 1; i < word.length; i++) {
                addNode(word[i], root);
            }

            System.out.println((depth(root) - 1) + " " + countLeaf(root) + " " + countExt(root) + " " + intLength(root) + " " + extLength(root, 0));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lipun().run();
    }
}
