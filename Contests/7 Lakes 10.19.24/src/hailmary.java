import java.util.*;
import java.io.*;

public class hailmary{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("hailmary".toLowerCase()+".in"));
        int t=f.nextInt();
        f.nextLine();
        while(t-->0){
            int[] cor =Arrays.stream(f.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x1 = cor[0], y1 = cor[1], x2 = cor[2], y2 = cor[3];
            double dist = Math.sqrt(Math.pow((Math.abs(x1-x2)),2) + Math.pow((Math.abs(y1-y2)),2));
            System.out.println(dist<=46?"Spartans Win!":"Spartans Lose :(");
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new hailmary().run();
    }
}
