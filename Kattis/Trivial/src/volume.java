import java.util.*;
import java.io.*;

public class volume{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int vol = 7;
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            String ln = f.nextLine();
            if (ln.equals("Skru op!") && vol<10)
                vol++;
            else if(ln.equals("Skru ned!") && vol>0){
                vol--;
            }
//            System.out.println(vol);
        }
//        if(vol<0)
//            vol=0;
//        if(vol>10)
//            vol=10;
        System.out.println(vol);
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new volume().run();
    }
}
