//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab05_Has4Odds
{
	//fourOdds will return true if mat contains exactly 4 odd numbers
	//otherwise return false
	public static boolean fourOdds( int[][] mat )
	{
        int countOdd=0;
        for(int[] rows:mat){
            for(int item:rows){
                if(item%2!=0) countOdd++;
            }
        }
        if(countOdd==4) return true;
		return false;
	}
	
    public static void main(String[] args)
    {
        System.out.println("Test Case #1:");
        int[][] things = {{5,2,5},{2,3}};
        System.out.println( "\tYour output >> " + fourOdds( things ) );   //outs false
        System.out.println();
                
        
        System.out.println("Test Case #2:");
        things = new int[][]{{10},{5,2},{10,5,55,1}};           
        System.out.println( "\tYour output >> " + fourOdds( things ) );   //outs true
        System.out.println();
              
        
        System.out.println("Test Case #3:");
        things = new int[][]{{10,0,1},{0,1,10},{1,10,0},{0,10,1},{0,10,0}};    
        System.out.println( "\tYour output >> " + fourOdds( things ) );   //outs true
        System.out.println();
        
        
        System.out.println("Test Case #4:");
        things = new int[][]{{5},{5,5},{5,5,5},{5}};    
        System.out.println( "\tYour output >> " + fourOdds( things ) );   //outs false
        System.out.println();   
        
          
    }
}
