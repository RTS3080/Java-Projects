import java.util.*;
import java.io.*;

public class Chuanli{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Chuanli".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            StringBuilder s = new StringBuilder(f.nextLine());
            System.out.println(s.reverse());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Chuanli().run();
    }
}
