import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class lune{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lune".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int numVals = f.nextInt();
            int numQueries = f.nextInt();
            int[] nums = new int[numVals];
            int[] prefix = new int[numVals+1];
            for (int i = 0; i < numVals; i++) {
                nums[i] = f.nextInt();
            }
            int n = 0;
            for (int i = 0; i < numVals; i++) {
                n^=nums[i];
                prefix[i] = n;
            }
            for (int i = 0; i < numQueries; i++) {
                int a= f.nextInt();
                int b= f.nextInt();
                int idx = a - 1;
                int xor;
                if (idx == -1) {
                    xor = 0;
                } else xor = prefix[idx];
                System.out.println(prefix[b] ^ xor);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new lune().run();
    }
}
