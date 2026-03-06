//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab01_countevens
{
	//isOdd, returns true if a number is odd, otherwise it returns false
   public static boolean isOdd( int num ){
      return num % 2 != 0;
   }
   
   
   //countEvens will return the count of all even numbers in mat
   // Try using a for each loop, since you only need to see if the value is even
	//return 0 if there are no evens
   //use the isOdd method
	public static int countEvens( int[][] mat )
	{
        int count=0;
        for (int[] row:mat) {
            for(int item: row){
                if(isOdd(item)==false) count++;
            }
        }

		
      return count;
	}
	
    public static void main(String[] args)
    {
        int[][] things = {{5,5,5},{2,3}};
        System.out.println( "\tYour output >> " + countEvens( things ) );   //outs 1
        System.out.println();
                
        things = new int[][]{{10},{5,2},{10,5,5}};           
        System.out.println( "\tYour output >> " + countEvens( things ) );		//outs 3
        System.out.println();  
        
        things = new int[][]{{10,10,10},{10,10,10},{10,10,10},{10,10,10},{10,10,10}};    
        System.out.println( "\tYour output >> " + countEvens( things ) );    	//outs 15
        System.out.println();
        
        things = new int[][]{{5},{5,5},{5,5,5},{5}};    
        System.out.println( "\tYour output >> " + countEvens( things ) );    	//outs 0       
    }
}
