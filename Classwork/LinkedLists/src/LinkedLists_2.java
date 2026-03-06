public class LinkedLists_2
{
   public static void main(String[] args)
   {
      Node bob = new Node(35, null);
      Node ann = new Node(17, bob);
      Node sue = new Node(41, ann);
      Node curr = sue;
      while( curr != null)
      {
         System.out.println( curr.value );
         curr = curr.next;
         //why is this loop broken
         //add in the needed code here
      }
   }
}
