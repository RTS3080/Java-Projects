public class Node
{
   Comparable data;
   Node left;
   Node right;

   public Node( Comparable data, Node left, Node right)
   {
      this.data = data;
      this.left = left;
      this.right = right;
   }

   public String toString()
   {
      return "" + data + " " + left + " " + right;
   }
}
