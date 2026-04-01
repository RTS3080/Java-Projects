import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class josephus{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("josephus".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numChildren = f.nextInt();
            int[] children = new int[numChildren];
            for (int i = 0; i < children.length; i++) {
                children[i] = i;
            }

            int target = f.nextInt();
            int numKilled = 0;
            int pos = 0;
            int count = 0;
            while(numKilled < target){
                
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new josephus().run();
    }
}
