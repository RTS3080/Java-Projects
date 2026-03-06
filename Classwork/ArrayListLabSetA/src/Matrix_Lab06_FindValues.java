//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab06_FindValues
{
	//findSmallest will return the smallest 
	//value in the matrix
	public static int findSmallest( int[][] mat )
	{
		int smallest = mat[0][0];
		for(int[] rows: mat){
			for(int item:rows){
				smallest=Math.min(item,smallest);
			}
		}
		return smallest;
	}
	
	//findSmallestOdd will return the smallest odd 
	//value in the matrix
	public static int findSmallestOdd( int[][] mat )
	{
		int smallest =mat[0][0];
		for(int[] row:mat){
			for(int item:row){
				if(item%2!=0){
					smallest=Math.min(item,smallest);
				}
			}
		}
		return smallest;
	}
	
	//findLargest will return the largest 
	//value in the matrix
	public static int findLargest( int[][] mat )
	{
		int largest =mat[0][0];
		for(int[] rows: mat){
			for(int item:rows){
				largest=Math.max(item,largest);
			}
		}
		return largest;
	}
	
	//findLargestEven will return the largest even
	//value in the matrix
	public static int findLargestEven( int[][] mat )
	{
		int largest =mat[0][0];
		for(int[] row:mat){
			for(int item:row){
				if(item%2==0){
					largest=Math.max(item,largest);
				}
			}
		}
		return largest;
	}
	
    public static void main(String[] args)
    {
        int[][] things = {{212,2,3},{10,9,8},{212,4,5,7,8},{13,122,3,671,57,7}};
        System.out.println( findSmallest( things ) );       //outs 2
        System.out.println( findSmallestOdd( things ) );    //outs 3
        System.out.println( findLargest( things ) );        //outs 671
        System.out.println( findLargestEven( things ) );    //outs 212
    }
}
