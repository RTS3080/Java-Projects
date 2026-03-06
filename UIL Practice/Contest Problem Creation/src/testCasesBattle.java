import java.util.*;
import java.io.*;
import java.awt.*;

public class testCasesBattle{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        Random r = new Random();
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int len = r.nextInt(1, 100);
            String s = "";
            for (int i = 0; i < len; i++) {
                s+=(r.nextInt(0, 1000))+" ";
            }
            System.out.println(s.trim());
            s="";
            for (int i = 0; i < len; i++) {
                s+=(r.nextInt(0, 1000))+" ";
            }
            System.out.println(s.trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new testCasesBattle().run();
    }
}
