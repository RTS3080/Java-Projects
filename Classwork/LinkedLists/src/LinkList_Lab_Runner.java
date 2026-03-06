import java.util.LinkedList;

public class LinkList_Lab_Runner
{
   public static void main(String[] args)
   {
		int[] cases = { 90, 90, 87, 33, 24, 22, 22, 22, 221, 455, 11, -90, 3, 4, 22, 6, 7, -9, 100, 300, 300};
		
		//make a new LinkList_Lab 
		LinkList_Lab<Integer> list = new LinkList_Lab<>();
		
		//for each loop through cases		
		for( int item : cases )
		{
			//add each value from case to the list

			list.add( item );
			System.out.println( list );

			//print the list after each add
         //should print like a triangle
		}


			
		//print the list after all adds
	   System.out.println(list);
	   System.out.println();
		
		//call doubleFirst
	   list.doubleFirst();
		//print the list
	   System.out.println(list);
		
		//call doubleLast
	   list.doubleLast();
		//print the list
	   System.out.println(list);
		
		
		//call find to search for a particular value
	   System.out.println(list.find(3));
		//call find again to search for a value that is not in the list
	   System.out.println(list.find(-2));
		//for each loop through cases
			//delete each value from the list
	   for( int item : cases ){
		   list.delete(item);
		   System.out.println(list);
	   }
//	   list.delete(3);
//	   System.out.println(list);
//
//	   list.deleteAll(90);
//	   System.out.println(list);
			//print the list after each delete
         //should print out like a triangle
	   LinkedList<String>a = new LinkedList<>();
   }
}
