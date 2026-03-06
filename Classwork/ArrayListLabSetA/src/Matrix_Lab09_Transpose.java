//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
//Abbi
public class Matrix_Lab09_Transpose
{
	//transpose will return a new matrix with all the rows of the matrix put into columns 
	// and all the columns of the matrix into rows.
	// Hint: switch the lengths and switch the variables from the loops when inserting values
	//precondition: matrix will be rectangular
	public static int[][] transpose( int[][] mat )
	{
        int[][] arr = new int[mat[0].length][mat.length];
        int rowIdx=0;
        for(int i=0; i< arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=mat[j][i];            }
        }
		return arr;
	}
	
    public static void main(String[] args)
    {
        System.out.println("Test Case #1:");
        int[][] thing1 = new int[][]{{0,1,2},{3,4,5}};
        System.out.println( "\ttranspose( thing1 ) >> " + Arrays.deepToString(transpose( thing1 ) ) );   //outs [[0,3],[1,4],[2,5]]
        System.out.println();
        
        System.out.println("Test Case #2:");
        int[][] thing2 = new int[][]{{5,4,3,2,1},{10,20,30,40,50},{-5,-10,-15,-20,-25}};  
        System.out.println( "\ttranspose( thing2 ) >> " + Arrays.deepToString(transpose( thing2 ) ) );   //outs [[5,10,-5],[4,20,-10],[3,30,-15],[2,40,-20],[1,50,-25]]
        System.out.println();
        
        System.out.println("Test Case #3:");
        int[][] thing3 = new int[][]{{11,12,13}};    
        System.out.println( "\ttranspose( thing3 ) >> " + Arrays.deepToString(transpose( thing3 ) ) );   //outs [[11],[12],[13]]
        
    }
}
