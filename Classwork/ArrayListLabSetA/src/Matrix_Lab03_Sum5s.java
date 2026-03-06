//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;


public class Matrix_Lab03_Sum5s
{
	//sum5s will sum up all of the 5s in the matrix
	public static int sum5s( int[][] mat )
	{
        int sum=0;
        for(int[] row: mat){
            for(int item:row){
                if(item==5) sum+=item;
            }
        }
		return sum;
	}
	
    public static void main(String[] args)
    {
        System.out.println("Test Case #1:");
        int[][] things = {{5,5,5},{2,3}};
        System.out.println( "\tYour output >> " + sum5s( things ) );   //outs 15
        System.out.println();
                
        System.out.println("Test Case #2:");
        things = new int[][]{{10},{1,2},{-8,3,7,5,5}}; 
        System.out.println( "\tYour output >> " + sum5s( things ) );   //outs 10
        System.out.println();          
              
        System.out.println("Test Case #3:");
        things = new int[][]{{10,5,10},{5,10,10},{10,10,5},{5}};    
        System.out.println( "\tYour output >> " + sum5s( things ) );   //outs 20
        System.out.println(); 
        
        System.out.println("Test Case #4:");
        things = new int[][]{{5},{5,5},{5,5,5},{10}};    
        System.out.println( "\tYour output >> " + sum5s( things ) );   //outs 30
        System.out.println(); 
        
        System.out.println("Test Case #5:");
        things = new int[][]{{3},{5,2},{5,5},{10,2,3,4,5,5}};           
        System.out.println( "\tYour output >> " + sum5s( things ) );   //outs 25
        System.out.println();            
    }
}
