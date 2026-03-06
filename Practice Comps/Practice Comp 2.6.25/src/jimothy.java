import java.util.*;
import java.io.*;

public class jimothy{
    String pre, post, in, rev;

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jimothy".toLowerCase()+".dat"));
        int times = f.nextInt(); f.nextLine();
        for(int abcd = 1; abcd <= times; abcd++){
            System.out.println("TEST CASE #"+abcd+":");
            bst b = new bst();
            pre = "";
            post = "";
            in = "";
            rev = "";
            String[] ln = f.nextLine().split("\\s+");
            for(String s : ln){
                b.add(s);
            }
            b.preOrder(b.root);
            b.inOrder(b.root);
            b.postOrder(b.root);
            b.revOrder(b.root);

            System.out.println("PRE-ORDER TRAVERSAL: "+pre.trim());
            System.out.println("IN-ORDER TRAVERSAL: "+in.trim());
            System.out.println("POST-ORDER TRAVERSAL: "+post.trim());
            System.out.println("REVERSE-ORDER TRAVERSAL: "+rev.trim());

        }

        f.close();
    }

    class bst{
        Node root;
        public bst(){
            root = null;
        }
        public void add(String s){
            if(root==null){
                root = new Node(s,null,null);
            }
            else {
                Node n = root;
                while (n != null) {
                    if (s.compareTo(n.s) <= 0) {
                        if(n.l == null){
                            n.l = new Node(s,null,null);
                            return;
                        }
                        n = n.l;
                    }
                    else{
                        if(n.r == null){
                            n.r = new Node(s,null,null);
                            return;
                        }
                        n = n.r;
                    }
                }
//            n = new Node(s,null,null);
                return;
            }
        }
        void inOrder(Node n){
            if(n==null){
                return;
            }

            inOrder(n.l);
            in += n.s+" ";
            inOrder(n.r);
        }
        void postOrder(Node n){
            if(n==null){
                return;
            }
            postOrder(n.l);
            postOrder(n.r);
            post+=n.s+" ";
        }
        void revOrder(Node n){
            if(n==null){
                return;
            }
            revOrder(n.r);
            rev += n.s+" ";
            revOrder(n.l);
        }

        void preOrder(Node n){
            if(n==null){
                return;
            }
            pre += n.s+" ";
            preOrder(n.l);
            preOrder(n.r);
        }
    }
    class Node{
        String s;
        Node r;
        Node l;
        public Node(String s, Node r, Node l){
            this.s = s;
            this.r = r;
            this.l = l;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        new jimothy().run();
    }
}

