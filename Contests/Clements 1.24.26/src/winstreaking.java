import java.util.*;
import java.io.*;

public class winstreaking{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("winstreaking".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            long a = f.nextLong()/ 2;
            long b = (a * (a-1))/2;
            System.out.println(b);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new winstreaking().run();
    }
}
