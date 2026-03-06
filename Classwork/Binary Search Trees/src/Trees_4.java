public class Trees_4
{
   public static void inOrder( Node t )
   {
      if( t != null)
      {
         inOrder( t.left );
         System.out.println( t.data );
         inOrder( t.right );
      }
   }

   public static void main(String[] args)
   {
      Node pat = new Node( 77, null, null );
      Node sam = new Node( 11, null, null );
      Node wil = new Node( 44, sam, pat );

      inOrder( wil );
   }
}
