import java.util.*;
import java.io.*;

public class prob01{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob01".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextInt()>=70 ?"PASS":"FAIL");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob01().run();
    }
}
