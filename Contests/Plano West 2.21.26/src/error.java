import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class error{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("error".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        for (int i = 1; i <= times; i++) {
            String s = f.nextLine().trim();
            if(!s.endsWith(";")){
                System.out.println(i+" "+s+";");
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new error().run();
    }
}
