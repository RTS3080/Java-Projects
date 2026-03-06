import java.util.*;
import java.io.*;

public class footballv2{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("footballv2".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int n = f.nextInt();
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += i % 2 == 0 ? f.nextInt() : -f.nextInt();
            }
            System.out.println(Math.abs(res));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new footballv2().run();
    }
}
