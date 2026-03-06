import java.util.*;
import java.io.*;

public class vectors{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("vectors".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] ln = f.nextLine().split(" ");
            for(int i=0; i<ln.length; i++){
                ln[i] = ln[i].replaceAll("[()]+","");
            }
            int totX = 0;
            int totY = 0;
            for(String s : ln){
                String[] nums = s.split(",");
                int start = Integer.parseInt(nums[0]);
                int end = Integer.parseInt(nums[1]);
                totX+=start;
                totY+=end;
            }
            System.out.println("("+totX+","+totY+")");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new vectors().run();
    }
}
