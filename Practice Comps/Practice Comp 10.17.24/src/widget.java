import java.util.*;
import java.io.*;

public class widget{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("widget".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int money = f.nextInt();
            int wid = money / f.nextInt();
            int dec = f.nextInt() - 1;
            int total = 0;
            for (int i = wid; i > dec; i -= dec) {
                total++;
            }
            System.out.println(wid + total);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new widget().run();
    }
}
