import java.util.*;
import java.io.*;

public class mission{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        long sum = 0;
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            sum+=f.nextInt();
        }
        System.out.println(sum == 0?"SAFE":"NOT SAFE");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mission().run();
    }
}
