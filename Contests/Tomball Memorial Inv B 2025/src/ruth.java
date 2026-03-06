import java.util.*;
import java.io.*;

public class ruth{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ruth".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int[] walls = Arrays.stream(f.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int l = 1;
            int r = walls.length - 2;
            int maxl = walls[0];
            int maxr = walls[walls.length - 1];
            int sand = 0;


            while (l <= r) {
                if (maxl < maxr) {
                    int sum = Math.min(maxl, maxr) - walls[l];
                    sand += Math.max(sum, 0);
                    maxl = Math.max(maxl, walls[l++]);
                    continue;
                }

                int sum = Math.min(maxl, maxr) - walls[r];
                sand += Math.max(sum, 0);
                maxr = Math.max(maxr, walls[r--]);
            }

            System.out.println(sand);
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new ruth().run();
    }
}
