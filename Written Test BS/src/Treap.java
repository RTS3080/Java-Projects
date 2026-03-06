import java.util.*;

class Treap {
    static class Node {
        int key, priority;
        Node left, right;
        Node(int k) {
            key = k;
            priority = new Random().nextInt();
        }
    }

    Node root;

    Node rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }
    Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) {
            root.left = insert(root.left, key);
            if (root.left.priority > root.priority)
                root = rotateRight(root);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
            if (root.right.priority > root.priority)
                root = rotateLeft(root);
        }
        return root;
    }

    void insert(int key) {
        root = insert(root, key);
    }

    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.key == key) return true;
        if (key < root.key) return search(root.left, key);
        return search(root.right, key);
    }

    boolean search(int key) {
        return search(root, key);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void inorder() {
        inorder(root);
        System.out.println();
    }
}
