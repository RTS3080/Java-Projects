import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class testing{

    public void run() throws FileNotFoundException{
        Scanner f = new Scanner(new File("Testing"));
        int[] nums = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        nums = Arrays.stream(nums).map(s -> (int) Math.pow(s,2)).toArray();
        System.out.println(Arrays.toString(nums)+"\n");
        int a = Arrays.stream(nums).sum();
        System.out.println(a+"\n");
        double[] dubs = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        dubs = Arrays.stream(dubs).map(s -> Math.round(Math.pow(s,2)*100.0)/100.0).toArray();
        System.out.println(Arrays.toString(dubs));

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new testing().run();
    }
}
