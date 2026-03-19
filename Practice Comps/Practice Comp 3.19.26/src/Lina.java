import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class Lina{
    int diameter = 0;
    int leaves = 0;

    class Node {
        String val;
        Node l, r;

        public Node(String v) {
            val = v;
        }

        public String toString() {
            return val;
        }
    }

    public int getDepth(Node n) {
        if (n == null) return -1;

        if (n.l == null && n.r == null) {
            leaves++;
            return 0;
        }

        int left = getDepth(n.l) + 1;
        int right = getDepth(n.r) + 1;

        diameter = Math.max(diameter, left + right);
        return Math.max(left, right);
    }

    public int getWidth(Node root) {
        LinkedList<Node> q = new LinkedList<>();

        q.add(root);

        int res = 1;

        while (!q.isEmpty()) {
            int width = q.size();
            res = Math.max(width, res);

            for (int i = 0; i < width; i++) {
                Node n = q.poll();

                if (n.l != null) q.add(n.l);
                if (n.r != null) q.add(n.r);
            }
        }

        return res;
    }

    public Node build(String[] vals) {
        Node root = new Node(vals[0]);

        for (int i = 1; i < vals.length; i++) {
            String str = vals[i];

            Node cur = root;

            while (true) {
                if (str.compareTo(cur.val) <= 0) {
                    if (cur.l == null) {
                        cur.l = new Node(str);
                        break;
                    } cur = cur.l;
                } else {
                    if (cur.r == null) {
                        cur.r = new Node(str);
                        break;
                    } cur = cur.r;
                }
            }
        } return root;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Lina".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));

        int numTimes=f.nextInt();f.nextLine();

        for(int times = 0; times < numTimes; times++){
            System.out.println("TEST CASE #" + (1 + times) + ":");

            diameter = 0;
            leaves = 0;

            Node root = build(f.nextLine().trim().split(" "));

            int width = getWidth(root);
            int height = getDepth(root);

            System.out.println("DIAMETER OF THE TREE: " + diameter);
            System.out.println("WIDTH OF THE TREE: " + width);
            System.out.println("HEIGHT OF THE TREE: " + height);
            System.out.println("NUMBER OF LEAVES IN THE TREE: " + leaves);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Lina().run();
    }
}
