import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob15{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob15".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
        int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(nums).max().getAsInt();
        int[] fib = new int[max];
        fib[0] = nums[0];
        fib[1] = nums[1];
        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i-1] + fib[i-2]);
        }
        String str = ""+fib[0]+fib[1];
        for (int i = 2; i < fib.length; i++) {
            str+=fib[i];
        }
//        System.out.println(str);
        String out ="";
        for(int i = 2; i< nums.length; i++){
            out+=str.charAt(nums[i]-1)+" ";
        }
        System.out.println(out.trim());
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob15().run();
    }
}
