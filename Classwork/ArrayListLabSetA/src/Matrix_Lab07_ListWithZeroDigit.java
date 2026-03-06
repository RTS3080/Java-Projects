//YOUR NAME
//CLASS PERIOD

//212 Cy Woods

import java.util.*;
public class Matrix_Lab07_ListWithZeroDigit
{
	//fun will return a list of all numbers with a 0 digit
	//you MUST call has0
	public static List<Integer> fun( int[][] mat )
	{
        List<Integer> arr = new ArrayList<>();

        for (int[] row : mat) {
            for (int item : row) {
                if (has0(item)) {
                    arr.add(item);
                }
            }
        }

        return arr;
	}
	
	//has0 will return true if the number has a 0 in it anywhere
	public static boolean has0( int num )
	{
        while (num > 0) {
            if (num % 10 == 0) {
                return true;
            }
            num /= 10;
        }
        return false;
	}
	
    public static void main(String[] args)
    {
        System.out.println("Test Case #1:");
        int[][] a = {{212,2,3,42},{555,91,8123,813}};
        System.out.println( "\tYour output >> " + fun( a ) );  //outs [] 
        System.out.println();
        
        System.out.println("Test Case #2:");
        int[][] b = {{212,21121,3011},{100,901,811}, {0, 13, 97}};
        System.out.println( "\tYour output >> " + fun( b ) );  //outs [3011, 100, 901, 0] 
        System.out.println();
              
    }
}
