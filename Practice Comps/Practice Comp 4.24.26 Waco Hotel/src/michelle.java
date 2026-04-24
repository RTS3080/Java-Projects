import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class michelle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("michelle".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 1; times <= numTimes; times++){
            String[] numbers = f.nextLine().split(" ");
            int[] nums = new int[numbers.length*2 +2];
            nums[0] = 1;
            nums[nums.length-1] = 50;
            for (int i = 0; i < numbers.length; i++) {
                nums[i * 2 + 1] = Integer.parseInt(numbers[i]);
                nums[i * 2 + 2] = nums[i * 2 + 1]+1;
            }
//            System.out.println(Arrays.toString(nums));
            String str = "";
            String buffer = "";
            while(!buffer.equals("#")){
                str += buffer+" ";
                buffer = f.nextLine();
            }
            str = str.trim();
            String[] words = str.split(" ");
            HashMap<Integer, Integer> map = new HashMap<>();
            int sum = words.length;
            for(String s : words){
                map.putIfAbsent(s.length(), 0);
                map.put(s.length(), map.get(s.length())+1);
            }
//            System.out.println(str);
            System.out.println("Test case #"+times);
            for (int i = 0; i < nums.length-1; i+=2) {
                int count = 0;
                int start = nums[i];
                int end = nums[i+1];
                for (int j = start; j <= end; j++) {
                    count+=map.getOrDefault(j, 0);
                }
                System.out.printf("%02d:%02d -> %-2.0f    %s\n", start, end, 100. * count / sum, "x".repeat((int)Math.round(100. * count / sum)));
            }
            System.out.println("=".repeat(15));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new michelle().run();
    }
}
