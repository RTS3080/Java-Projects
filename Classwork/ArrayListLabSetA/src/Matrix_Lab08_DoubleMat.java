//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab08_DoubleMat
{
	//make a new matrix the same size as the old one
	//double all value from mat when placing them
	//in the new matrix
	public static int[][] doubleMat( int[][] mat )
	{
        int[][] arr = new int[mat.length][mat[0].length];
        int rowIdx =0;
        for(int[] row:mat){
            int colIdx = 0;
            for(int items: row){
                arr[rowIdx][colIdx]=items*2;
                colIdx++;
            }
            rowIdx++;
        }
	   return arr;
	}
	
	
    public static void main(String[] args)
    {
        int[][] x = {{2,1},{6,8}};        
        
        System.out.println( Arrays.deepToString( doubleMat( x ) ) );   //outs  [[4,2],[12,16]]
                
        
        int[][] z = {{2,1,3,5},{6,8,4,7}};   
        System.out.println( Arrays.deepToString( doubleMat( z ) ) );   //outs  [[4,2,6,10],[12,16,8,14]]
        
        
        int[][] t = {{2,1,3,8,4,7},{1,1,2,2,6,6}};   
        System.out.println( Arrays.deepToString( doubleMat( t ) ) );    //outs  [[4,2,6,16,8,14],[2,2,4,4,12,12]]
 
    }
}
