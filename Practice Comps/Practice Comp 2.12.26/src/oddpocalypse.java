import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class oddpocalypse{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("oddpocalypse".toLowerCase()+".dat"));
        while(f.hasNext()){
            int a = f.nextInt();
            if(floorMod(a, 2) == 1){
                System.out.println(a);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new oddpocalypse().run();
    }
}
