import java.util.*;
import java.io.*;
import java.awt.*;

public class helloworld{

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("helloworld".toLowerCase()+".in"));
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLine().trim());
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new helloworld().run();
    }
}
