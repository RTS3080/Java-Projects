import java.util.*;
import java.io.*;

public class shadower{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("shadower".toLowerCase()+".in"));
        int nums = f.nextInt();
        int max = -1;
        int sum = 0;
        for (int i = 0; i < nums; i++) {
            int a = f.nextInt();
            max = Math.max(max, a);
            sum += a;
        }
        System.out.println(sum - max);
        f.close();

    }



    public static void main(String[] args) throws FileNotFoundException{
        new shadower().run();
    }
}
