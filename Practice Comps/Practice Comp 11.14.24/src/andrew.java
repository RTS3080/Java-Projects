import java.util.*;
import java.io.*;

public class andrew{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("andrew".toLowerCase()+".dat"));
        HashMap<Integer,String> nums = new HashMap<>();
        nums.put(2,"TWO");
        nums.put(3,"THREE");
        nums.put(4,"FOUR");
        nums.put(5,"FIVE");
        nums.put(6,"SIX");
        nums.put(7,"SEVEN");
        nums.put(8,"EIGHT");
        nums.put(9,"NINE");
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.print("ONE ");
            int num = f.nextInt();
            for(int i = 2;i<10;i++){
                if(num%i==0){
                    System.out.print(nums.get(i)+" ");
                }
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new andrew().run();
    }
}
