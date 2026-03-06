import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class probA{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        //Scanner f = new Scanner(new File("probA".toLowerCase()+".in"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(f.nextLine().trim());
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new probA().run();
    }
}
