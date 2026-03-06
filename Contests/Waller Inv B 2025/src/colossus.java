import java.util.*;
import java.io.*;

public class colossus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("colossus".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLong()>10000 ? "Lunk Alarm!!":"Hulk here we come.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new colossus().run();
    }
}
