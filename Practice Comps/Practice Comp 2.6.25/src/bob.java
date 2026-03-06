import java.util.*;
import java.io.*;

public class bob{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("bob".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            ArrayList<Long> nums = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                nums.add(f.nextLong());
            }
            Collections.sort(nums);
            System.out.println(nums.get(0) * nums.get(1) + nums.get(2)+ nums.get(3)*nums.get(4));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new bob().run();
    }
}
