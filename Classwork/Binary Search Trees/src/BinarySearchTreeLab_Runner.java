import java.util.*;

public class BinarySearchTreeLab_Runner
{
   public static void main(String[] args)
   {
		int[] cases = { 90, 10, 87, 33, 24, 56, 22, 66, 221, 455, 11, -90, 3, 4, 5, 6, 7, -9, 100, 200, 300};
//       String s = "4 2 6 1 3 5 7 ";
//       int[] cases = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
		BinarySearchTreeLab b = new BinarySearchTreeLab();
        for(int i : cases){
            b.add(i);
        }
		//for each loop through cases
			//add each value from case to the tree
			//print the tree after each add
       System.out.println(cases.length);
       System.out.println("Preorder: "+b.preOrder());
       System.out.println("Inorder: "+b.inOrder());
       System.out.println("Postorder: "+b.postOrder());
       System.out.println("Reverseorder: "+b.reverseOrder());
		//print the tree after all adds
			//use in order
			//use pre order
			//use post order
			//use reverse order
       System.out.println("Inorder: "+b.inOrder());
       System.out.println("Preorder: "+b.preOrder());
       System.out.println("Level Order: "+b.levelOrder());
       System.out.println("Sum Nodes: "+b.sumNodes());
       System.out.print("Remove: ");
       for(int i : cases){
           System.out.print(b.remove(i)+" ");
       }
       System.out.println();
//       System.out.println(b.remove(221));
       System.out.println("Level Order: "+b.levelOrder());
       for(int i : cases){
           b.add(i);
       }
		//for each loop through cases

       System.out.println("Actual sum: "+Arrays.stream(cases).sum());
       System.out.println("Sum Nodes: "+b.sumNodes());
       for(int i : cases){
           System.out.print(i+":"+b.find(i)+" ");
       }
       System.out.println();
       System.out.println("Num Leaves: "+b.countLeaves());
       System.out.println("isBST: "+b.isBST());
       System.out.println("Level Order: "+b.levelOrder());
       System.out.println("Get Height: "+b.getHeight());
       System.out.println("Get Width: "+b.getWidth());
       System.out.println("Is Full: "+b.isFull());
       System.out.println("Diameter: "+b.getDiameter());
       System.out.println("Is Complete: "+b.isComplete());
			//delete each value from the tree
			//print the tree after each add				

   }
}
