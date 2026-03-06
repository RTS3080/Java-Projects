import java.util.*;
import java.io.*;
import java.awt.*;

public class xor{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("xor".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int a = f.nextInt();
            long out = 0l;
            for (int i = 0; i < a; i++) {
                out^=f.nextLong();
            }
            System.out.println(out);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new xor().run();
    }
}
