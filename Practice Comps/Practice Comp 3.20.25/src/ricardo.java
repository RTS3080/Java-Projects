import java.util.*;
import java.io.*;

public class ricardo{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ricardo".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        for(int abc = 1; abc<=times; abc++){
            String ln = f.nextLine().trim();
            String[] strs = ln.split(",");
            long plans = 1;
            for (int i = 0; i < strs.length; i++) {
                String[] workouts = strs[i].split("\\|");
                plans *= workouts.length;
            }
            if(strs.length == 0) plans = 0;
            System.out.printf("Case #%d: %d\n",abc, plans);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ricardo().run();
    }
}
