import java.util.*;
public class BinarySearchTreeLab {
   public Node root;

   //constructor
   public BinarySearchTreeLab(Node r) {
      root = r;
   }

   public BinarySearchTreeLab() {
      root = null;
   }

   public BinarySearchTreeLab(Comparable d, Node r, Node l) {
      root = new Node(d, r, l);
   }

   //add method
   public Comparable add(Comparable d) {
      if (root == null) {
         root = new Node(d, null, null);
         return d;
      }
      Node n = root;
      while (n != null) {
         if (d.compareTo(n.data) < 0) {
            if (n.left == null) {
               n.left = new Node(d, null, null);
               return n.data;
            }
            n = n.left;
         } else {
            if (n.right == null) {
               n.right = new Node(d, null, null);
               return n.data;
            }
            n = n.right;
         }
      }
      return null;
   }

   public String preOrder() {
      return preOrder(root);
      
   }

   private String preOrder( Node n) {
      if(n == null) return "";
      return n.data+" "+preOrder(n.left)+preOrder(n.right);

   }

   public String inOrder() {
      return inOrder(root);
   }

   private String inOrder(Node n) {
      if (n == null)
         return "";
      return inOrder(n.left)+n.data+" "+inOrder(n.right);
   }

   public String postOrder() {
      return postOrder("", root);
   }

   private String postOrder(String s, Node n) {
      if (n == null) return "";
      return postOrder(s, n.left)+postOrder(s, n.right)+" "+n.data;
   }

   public String reverseOrder() {
      return reverseOrder(root);
   }

   private String reverseOrder(Node n) {
      if (n == null) return "";
      return reverseOrder(n.right)+n.data+" "+reverseOrder(n.left);
   }
   public Comparable smallest() {
      return smallest(root);
   }
   public Comparable smallest(Node node){
      if(node == null) return null;
      Comparable small = node.data;
      Node n = node;
      while(n != null){
         if(n.data.compareTo(small) < 0){
            small = n.data;
         }
         n = n.left;
      }
      return small;
   }
   public Comparable largest() {
      return largest(root);
   }
   public Comparable largest(Node node){
      Comparable larg = node.data;
      Node n = node;
      while(n != null){
         if(n.data.compareTo(larg) > 0){
            larg = n.data;
         }
         n = n.right;
      }
      return larg;
   }
   public Comparable remove(Comparable d) {
      if (root == null) return null;

      Comparable deleted = d;
      root = remove(d, root);

      return deleted;
   }


   public Node remove(Comparable d, Node n){
      if(n == null) return null;
      if(d.compareTo(n.data) > 0){
         n.right =  remove(d, n.right);
      }
      else if(d.compareTo(n.data) < 0){
         n.left =  remove(d, n.left);
      }
      else {
         if (n.right == null) {
            return n.left;
         }
         if (n.left == null) {
            return n.right;
         }
         Node temp = n.right;

         while (temp != null && temp.left != null) {
            temp = temp.left;
         }
         n.data = temp.data;
         n.right = remove(temp.data, n.right);
      }

      return n;
   }
   public int sumNodes(){
      return sumNodes(root);
   }

   public int sumNodes(Node node){
      if(node == null) return 0;
      return sumNodes(node.left) + sumNodes(node.right)+(int)node.data;
   }

   public int find(Comparable d){
      Node n = root;
      if(n.data.equals(d)){
         return 0;
      }
      int m =Math.min(find(d,n.left,1),find(d,n.right,1));
      return m==Integer.MAX_VALUE?-1:m;
   }
   private int find(Comparable d, Node n,int count){
      if(n==null) return Integer.MAX_VALUE;
      if(n.data.equals(d)){
         return count;
      }
      return Math.min(find(d,n.left,count+1),find(d,n.right,count+1));
   }

   public int countLeaves(){
      if(root == null) return 0;
      return countLeaves(root);
   }
   private int countLeaves(Node n){
      if(n == null) return 0;
      if(n.left == null && n.right == null) return 1;
      return countLeaves(n.left)+countLeaves(n.right);
   }

   public String levelOrder(){
      if(root == null) return "";
      Queue<Node> q = new LinkedList<>();
      String s = "";
      q.add(root);
      while(!q.isEmpty()){
         Node n = q.poll();
         if(n == null) continue;
         q.add(n.left);
         q.add(n.right);
         s+=n.data+" ";
      }
      return s.trim();
   }


   public boolean isBST(){
      if(root == null) return false;
      return isBST(root);
   }
   private boolean isBST(Node n)
   {
      if(n == null) return true;
      if(n.left == null && n.right == null) return true;
      if(n.left != null && n.left.data.compareTo(n.data) > 0) return false;
      if(n.right != null && n.right.data.compareTo(n.data) <= 0) return false;
      return isBST(n.left) && isBST(n.right);
   }


   public int getHeight(){
      if(root == null) return 0;
      return getHeight(root) -1;
   }
   private int getHeight(Node n){
      if(n == null) return 0;
      return 1 + Math.max(getHeight(n.left), getHeight(n.right));
   }

   public int countNodes(){
      if(root == null) return 0;
      return countNodes(root);
   }
   private int countNodes(Node n){
      if(n == null) return 0;
      return 1 + countNodes(n.left) + countNodes(n.right);
   }

   public int getWidth(){
      if(root == null) return 0;
      Queue<Node> nodes = new LinkedList<>();
      Queue<Integer> counts = new LinkedList<>();
      int[] levs = new int[getHeight()+1];
      nodes.add(root);
      counts.add(0);
      while(!nodes.isEmpty()){
         Node n = nodes.poll();
         int c = counts.poll();
         if(n == null) continue;
         levs[c]++;
         nodes.add(n.left);
         counts.add(c+1);
         nodes.add(n.right);
         counts.add(c+1);
      }
      int max = 0;
      for(int i = 0; i < levs.length; i++){
         if(levs[i] > max) max = levs[i];
      }
      return max;
   }

   public boolean isFull(){
      return isFull(root);
   }
   private boolean isFull(Node n){
      if(n == null) return true;
      int kids = 0;
      if(n.left == null) kids++;
      if(n.right == null) kids++;
      if(kids == 1) return false;
      return isFull(n.left) && isFull(n.right);
   }

   public int getDiameter(){
      if(root == null) return 0;
      return getDiameter(root);
   }
   private int getDiameter(Node n){
      if(n == null) return 0;
      return Math.max(Math.max(getHeight(n.left) + getHeight(n.right),
              getDiameter(n.left)),getDiameter(n.right));
   }

   public boolean isComplete(){
      return isComplete(root, 0, countNodes());
   }

   public boolean isComplete(Node node, int idx, int size) {
      return node == null || idx < size && isComplete(node.left, idx * 2 + 1, size) && isComplete(node.right, idx * 2 + 2, size);
   }


	 /*
	    70   -  add + traversals -> inOrder, preorder, postOrder, revOrder
	    
        80   -  70  + remove, smallest, largest, find
        
        90   -  80  + sumNodes, countLeaves, levelOrder traversal [ use a Q ]

	95   -  90  + isBST [ is the tree a binary search tree ]
        
        100  -  90  + getHeight, getWidth, isFull, and isComplete

	105  -  100 + getDiameter

        STILL NEED: isComplete, remove,
    */

}