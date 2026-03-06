import java.util.*;
import java.io.*;

public class arti{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("arti".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int d = f.nextInt();
            System.out.printf(d+" %.3f\n",Math.sqrt(d));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new arti().run();
    }
}
