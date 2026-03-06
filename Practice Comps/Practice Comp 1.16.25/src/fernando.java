import java.util.*;
import java.io.*;

public class fernando{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("fernando".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int n=f.nextInt();
            int bad = f.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = n; i>0;i--){
                if(n%i==0){
                    String s =i+"";
                    if(!s.contains(bad+""))
                        nums.add(Integer.parseInt(s));
                }
            }
            Collections.sort(nums);
            if(nums.size()==0)
                System.out.println("NONE");
            else{
                for(int a : nums){
                    System.out.print(a+" ");
                }
                System.out.println();
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new fernando().run();
    }
}
