import java.util.*;
import java.io.*;
import java.awt.*;

public class D{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("D.txt"));
        int times=f.nextInt();
        while(times-->0) {
            int len = f.nextInt();
            int quers = f.nextInt(); f.nextLine();
            long[] vals = Arrays.stream(f.nextLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            for(int ab = 1; ab <= quers; ab++) {
                int spot = f.nextInt();
                long val = vals[spot];
                int count = 0;
                for (int i = 0; i < spot; i++) {
                    if(vals[i] < val){
                        count++;
                    }
                }
                System.out.println(ab+" "+count);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new D().run();
    }
}
