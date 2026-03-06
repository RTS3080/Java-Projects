import java.util.*;
import java.io.*;

public class tackled{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("tackled".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println("ANTHONY LI TACKLED BY "+f.nextLine().trim().toUpperCase()+"!!!!!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tackled().run();
    }
}
