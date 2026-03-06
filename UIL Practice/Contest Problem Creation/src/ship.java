import java.util.*;
import java.io.*;
import java.awt.*;

public class ship{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ship".toLowerCase()+".dat"));
        while(f.hasNext()){
            int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            String[] combos = new String[]{"012", "021", "102", "120", "201", "210"};
            TreeSet<String> outs = new TreeSet<>();
            if(nums.length==3) {
                for (int i = 0; i < 6; i++) {
                    outs.add("" + nums[combos[i].charAt(0) - '0'] + nums[combos[i].charAt(1) - '0'] + nums[combos[i].charAt(2) - '0']+" ");
                }
            }
            else if (nums.length==2) {
                combos = new String[]{"001", "010", "011", "110", "101", "100"};
                for (int i = 0; i < 6; i++) {
                    outs.add("" + nums[combos[i].charAt(0) - '0'] + nums[combos[i].charAt(1) - '0'] + nums[combos[i].charAt(2) - '0']+" ");
                }
            }else{
                outs.add((""+nums[0]).repeat(3));
            }
            String s= "";
            for(String str : outs){
                s+=str;
            }
            System.out.println(s.trim());

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ship().run();
    }
}
