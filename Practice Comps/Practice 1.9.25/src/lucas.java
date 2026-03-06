import java.util.*;
import java.io.*;

public class lucas{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lucas".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int secSum = 0;
            ArrayList<Integer> nums = new ArrayList<>();
            String[] ln = f.nextLine().split(" ");
            for(String s : ln)
                nums.add(Integer.parseInt(s));
            Collections.sort(nums);
            if(nums.size()>2){
                nums.remove(nums.size()-1);
                nums.remove(0);
            }
            for(int n : nums){
                secSum+=n;
            }
            secSum/=nums.size();
            System.out.printf("%d:%02d\n",secSum/60,secSum%60);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lucas().run();
    }
}
