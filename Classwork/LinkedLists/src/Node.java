public class Node <E>
{
   E value;
   Node next;
   Node prev;

   public Node( E v, Node n, Node p)
   {
      value = v;
      next = n;
      prev = p;
   }


   public String toString()
   {
      System.out.println(value);
      return "" + value + " " + next;
   }
}
