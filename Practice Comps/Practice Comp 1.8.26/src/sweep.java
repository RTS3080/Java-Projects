import java.util.*;
import java.io.*;
import java.awt.*;

public class sweep{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sweep".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine();
            int start = ln.indexOf("0");
            int end = ln.lastIndexOf("0");
            int count = 0;
            while(start < end){
                if(ln.charAt(start)=='1'){
                    count++;
                }
                start++;
            }
            System.out.println(count);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sweep().run();
    }
}
