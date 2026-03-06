import java.util.*;
import java.io.*;

public class jedi{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jedi".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int red = f.nextInt();
            int green = f.nextInt();
            int blue = f.nextInt();

            if(red==0){
                System.out.println("Get them!");
            }
            else if(red>0 && blue>0 && green<=0){
                System.out.println("Get them!");
            }
            else System.out.println("Protect the Federation");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jedi().run();
    }
}
