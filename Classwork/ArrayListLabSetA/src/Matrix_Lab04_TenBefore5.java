//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab04_TenBefore5
{
	//has10Before5 will return true if a 10 is found 
	//anywhere in the matrix before a 5
	//return false otherwise
	public static boolean has10Before5( int[][] mat )
	{
        boolean isFound =false;
        boolean tenFound=false;
        for(int[] row: mat){
            isFound =false;

            for(int item: row){
                if(item==10&&isFound==false) tenFound=true;
                if(item==5) isFound=true;
            }
        }
		return (isFound==true&&tenFound==true);
	}
	
    public static void main(String[] args)
    {
        System.out.println("Test Case #1:");
        int[][] things = {{5,5,5},{2,3}};
        System.out.println( "\tYour output >> " + has10Before5( things ) );   //outs false
        System.out.println();
                
        System.out.println("Test Case #2:");
        things = new int[][]{{10},{1,2},{-8,3,7,5,5}}; 
        System.out.println( "\tYour output >> " + has10Before5( things ) );   //outs true
        System.out.println();          
              
        System.out.println("Test Case #3:");
        things = new int[][]{{10,10,10},{10,10,10},{10,10,10},{10,10,10}};    
        System.out.println( "\tYour output >> " + has10Before5( things ) );   //outs false
        System.out.println(); 
        
        System.out.println("Test Case #4:");
        things = new int[][]{{5},{5,5},{5,5,5},{10}};    
        System.out.println( "\tYour output >> " + has10Before5( things ) );   //outs false
        System.out.println(); 
        
        System.out.println("Test Case #5:");
        things = new int[][]{{3},{5,2},{5,5},{10,2,3,4,5,5}};           
        System.out.println( "\tYour output >> " + has10Before5( things ) );   //outs true
        System.out.println();            
    }
}
