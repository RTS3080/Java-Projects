import java.util.*;
import java.io.*;

public class Michal{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Michal".toLowerCase()+".dat"));
        String[][] nums = new String[3][10];
        String a = " _ =   = _ = _ =   = _ = _ = _ = _ = _ \n" +
                "| |=  |= _|= _|=|_|=|_ =|  =  |=|_|=|_|\n" +
                "|_|=  |=|_ = _|=  |= _|=|_|=  |=|_|=  |\n";
        Scanner scan = new Scanner(a);
        for (int i = 0; i < 3; i++) {
            nums[i] = scan.nextLine().split("=");
//            System.out.println(Arrays.toString(nums[i]));
        }
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s= f.nextLine().trim();
            int[] n = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();


            System.out.println("*".repeat(s.length()*3 +2));
//            System.out.println("*"+" ".repeat(s.length()*3)+"*");
            for (int i = 0; i < 3; i++) {
                System.out.print("*");
                for(int j : n){
//                    System.out.println(i+" "+(j));
                    System.out.print(nums[i][j]);
                }
                System.out.println("*");
            }
            System.out.println("*"+" ".repeat(s.length()*3)+"*");
            System.out.println("*".repeat(s.length()*3 +2));

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Michal().run();
    }
}
