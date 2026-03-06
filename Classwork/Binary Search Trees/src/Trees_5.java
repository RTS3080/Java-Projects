//class Tree
//{
//	Node root;
//
//	public Tree()
//	{
//		root = null;
//	}
//
//	public void add( Comparable o )
//	{
//		root = add( o, root );
//	}
//
//	private Node add( Comparable o, Node n )
//	{
//		//complete this method
//		return n;
//	}
//
//
//	public void inOrder()
//	{
//	   inOrder( root );
//	}
//
//	private void inOrder( Node t )
//   {
//      if( t != null)
//      {
//         inOrder( t.left );
//         System.out.print( t.data + " "  );
//         inOrder( t.right );
//      }
//   }
//}
//
//public class Trees_6
//{
//   public static void main(String[] args)
//   {
//   	int[] cases = {23, 56, 89, 11, 33 };
//      Tree test = new Tree();
//      for( int item : cases )
//      {
//         test.add( item );
//      }
//      test.inOrder();    //should print 11 23 33 56 89
//   }
//}
