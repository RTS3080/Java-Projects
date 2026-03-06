public class LinkedLists_1
{
   public static void main(String[] args)
   {
      Node bob = new Node(35, null,null);
      System.out.println( bob );

      Node ann = new Node(17, bob,null);
      System.out.println( ann );

      Node sue = new Node(41, ann,bob);
      System.out.println( sue );
   }
}
