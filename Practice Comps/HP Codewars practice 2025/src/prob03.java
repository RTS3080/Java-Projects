import java.util.*;
import java.io.*;

public class prob03{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob03".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s  = f.nextLine().trim();
            String end = s.replaceAll("\\d+", "");
            String nums = s.replaceAll("[a-zA-Z]", "");
            switch(nums.charAt(nums.length()-1)){
                case '1' -> end = "st";
                case '2' -> end = "nd";
                case '3' -> end = "rd";
                default -> end = "th";
            }
            System.out.println(nums+end);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob03().run();
    }
}
