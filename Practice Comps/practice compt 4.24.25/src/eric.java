import java.util.*;
import java.io.*;

public class eric{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("eric".toLowerCase()+".dat"));
        int cnt = 0;
        while(f.hasNext()){
            cnt++;
            long a = f.nextLong();
            long b = f.nextLong();
            long c = a;
            long d = b;
            int count = 2;
            while(!(c==a && d==b && count!=2)){
                count++;
                long temp = (c+d)%10;
                c = d;
                d = temp;
            }
            System.out.println(count);
//            if(cnt%10 == 0) System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new eric().run();
    }
}
