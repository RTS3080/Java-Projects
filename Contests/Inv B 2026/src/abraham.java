import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class abraham{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("abraham".toLowerCase()+".dat"));
        int count =0;
        int times=f.nextInt(); f.nextLine();
        for(int i = 0; i < times; i++){
            String ln = f.next();
            if(ln.equals("Abraham")){
                count++;
            }
        }
        System.out.println(count);
        System.out.println(count > times/2. ? "Honest Abe" : "Better find a hobby");
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new abraham().run();
    }
}
