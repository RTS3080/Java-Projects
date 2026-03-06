import java.util.*;
import java.io.*;

public class dryRun{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int tot = 0;
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            tot+=Integer.parseInt(f.nextLine().split("\\s+")[2]);
        }
        System.out.println("There are "+tot+" wolves!");
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new dryRun().run();
    }
}
