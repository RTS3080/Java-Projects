import java.util.*;
import java.io.*;
import java.awt.*;

public class Chen{
    boolean[][][] dp;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Chen".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine().trim();
            String[] split = ln.split(" ");
            dp = new boolean[split.length][split.length][split.length];
        }
        f.close();
    }

    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Chen().run();
    }
}
