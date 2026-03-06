import java.util.*;
import java.io.*;
import java.awt.*;

public class kalyani{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kalyani".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] nums = new String[100];
            Arrays.fill(nums, f.next());

            int ranges = f.nextInt();
            for (int i = 0; i < ranges; i++) {
                int start = (int) (f.nextDouble() * 10);
                int end = (int) (f.nextDouble() * 10);
                Arrays.fill(nums, start, end, f.next());
            }

            int idx = 0;
            while (idx < 100) {
                int end = idx + 1;
                while (end < 100 && nums[idx].equals(nums[end])) {
                    end++;
                }

                System.out.printf("%.1f %.1f " + nums[idx], idx * .1, (end - 1) * .1);
                System.out.println();
                idx = end;
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kalyani().run();
    }
}
