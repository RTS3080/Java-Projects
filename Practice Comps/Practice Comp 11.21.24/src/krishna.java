import java.util.*;
import java.io.*;

public class krishna{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("krishna".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long s = f.nextInt();
            long e = f.nextInt();
            long sum = 0;
            for (long i = s; i <= e; i++) {
                sum += i * (i + 1) / 2;
            }
            System.out.println(sum);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new krishna().run();
    }
}
