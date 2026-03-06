//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab02_onlyTens
{
	//count10, will count all the 10s in the given array
   public static int count10( int[] ray ){
       int count=0;
       for(int item: ray){
           if(item==10) count++;
       }
      return count;
   }
   
   
   //containsOnly2Tens will return true if mat contains only 2 tens
   //use the count10 method
	//return false otherwise
	public static boolean containsOnly2Tens( int[][] mat )
	{
        int no10 =0;
        for(int[] row:mat){
            if(count10(row)>=1){
                no10++;
            }
        }

		return (no10==2);
	}
	
	//containsATen will return true if each array (row) contains a 10
   //use the count10 method
	//return false otherwise
	public static boolean containsATen( int[][] mat )
	{
        int no10 =0;
        for(int[] row:mat){
            if(count10(row)>=1){
                no10++;
            }
        }
        if(no10>=mat.length) return true;

		return false;
	}
	
    public static void main(String[] args)
    {
        System.out.println("Test Case #1:");
        int[][] things = {{5,5,5},{2,3}};
        System.out.println( "\t\tYour output >> " + containsOnly2Tens( things ) );   //outs false
        System.out.println( "\t\tYour output >> " + containsATen( things ) );   //outs false  
        System.out.println();
        
        System.out.println("Test Case #2:");
        things = new int[][]{{5,10,7,12},{2,10,3}};
        System.out.println( "\t\tYour output >> " + containsOnly2Tens( things ) );   //outs true
        System.out.println( "\t\tYour output >> " + containsATen( things ) );   //outs true 
        System.out.println();
        
        System.out.println("Test Case #3:");
        things = new int[][]{{10},{5,2,0},{10,5,5}};
        System.out.println( "\t\tYour output >> " + containsOnly2Tens( things ) );   //outs true
        System.out.println( "\t\tYour output >> " + containsATen( things ) );   //outs false 
        System.out.println();           
      
        
        System.out.println("Test Case #4:");
        things = new int[][]{{10,0,1},{1,0,10},{0,10,1}};
        System.out.println( "\t\tYour output >> " + containsOnly2Tens( things ) );   //outs false
        System.out.println( "\t\tYour output >> " + containsATen( things ) );   //outs true 
        System.out.println();     

        
        System.out.println("Test Case #5:");
        things = new int[][]{{10},{5,10},{5,10,5},{10}};
        System.out.println( "\t\tYour output >> " + containsOnly2Tens( things ) );   //outs false
        System.out.println( "\t\tYour output >> " + containsATen( things ) );   //outs true
        System.out.println();     

    }
}
