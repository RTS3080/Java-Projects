import java.util.*;
import java.io.*;

public class Jacob{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Jacob".toLowerCase()+".dat"));
        long times=f.nextLong(); f.nextLine();
        while(times-->0){
            long p=f.nextLong(),w=2;
            double r=3;
            boolean flag=false;
            while(p-->0){
                r+=(flag?-1.0:1.0)*(4.0/(w*(w+1)*(w+2)));
                w+=2;
                flag=!flag;
            }
            System.out.printf("%.13f\n",r);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Jacob().run();
    }
}
