import java.util.*;
import java.io.*;

public class tellingtime{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt();
        int year=f.nextInt();
        f.nextLine();
        while(times-->0){
            String month = f.next();
            String day = f.next();
            int yr = f.nextInt();
            f.nextLine();
            System.out.println(month+" "+day+" "+(yr-year)+" A.S.");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new tellingtime().run();
    }
}
