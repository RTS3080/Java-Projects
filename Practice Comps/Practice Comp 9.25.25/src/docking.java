import java.util.*;
import java.io.*;
import java.awt.*;

public class docking{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("docking".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            boolean b = true;
            for (int i = 0; i < 8; i++) {
                String s = f.next().trim();
                b&=s.equals("Y");
            }
            System.out.println(b?"No, it's necessary":"Don't let me leave Murph");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new docking().run();
    }
}
