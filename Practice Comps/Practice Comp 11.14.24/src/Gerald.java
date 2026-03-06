import java.util.*;
import java.io.*;

public class Gerald{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("Gerald".toLowerCase()+".dat"));

        int sum = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(in.hasNext()) {
            int value = Integer.parseInt(in.next());

            min = Math.min(min, value);
            max = Math.max(max, value);
            sum += value;
            count++;
        }
        System.out.println("COUNT:" + count);
        System.out.println("SMALLEST:" + min);
        System.out.println("LARGEST:" + max);
        System.out.printf("MEAN:%.1f",sum / (double)count);
    }




    public static void main(String[] args) throws FileNotFoundException{
        new Gerald().run();
    }
}
