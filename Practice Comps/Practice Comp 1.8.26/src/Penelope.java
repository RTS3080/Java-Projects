import java.util.*;
import java.io.*;
import java.awt.*;

public class Penelope{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Penelope".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            int[] treasure = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] heaters = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(treasure);
            Arrays.sort(heaters);
            int maxDist = -1;
            for (int i = 0; i < treasure.length; i++) {
                int minDist = Integer.MAX_VALUE;
                for (int j = 0; j < heaters.length; j++) {
                    minDist = Math.min(minDist, Math.abs(treasure[i] - heaters[j]));
                }
                maxDist = Math.max(maxDist, minDist);
            }
            System.out.println(maxDist);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Penelope().run();
    }
}
