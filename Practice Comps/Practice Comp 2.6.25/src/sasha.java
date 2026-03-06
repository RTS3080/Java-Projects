import java.util.*;
import java.io.*;

public class sasha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sasha".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int size = f.nextInt();
            int[] walls = new int[size];
            int[] stored = new int[size];

            for (int i = 0; i < size; i++) {
                walls[i] = f.nextInt();
            }

            Arrays.fill(stored, 0);

            int l = 1;
            int r = size - 2;
            int maxl = walls[l - 1];
            int maxr = walls[r + 1];

            while (l <= r) {
                if (walls[l] < maxr) {
                    stored[l] = Math.max(0, maxl - walls[l]);
                    maxl = Math.max(maxl, walls[l]);
                    l++;
                } else {
                    stored[r] = Math.max(0, maxr - walls[r]);
                    maxr = Math.max(maxr, walls[r]);
                    r--;
                }
            }

            int bucket = 0;
            int sum = 0;
            String res = "";
            for (int i = 0; i < stored.length; i++) {
                if (stored[i] == 0) {
                    if (bucket != 0) {
                        res += bucket + " ";
                        bucket = 0;
                    }
                }
                else bucket += stored[i];
                sum += stored[i];
            }

            if (sum == 0) {
                System.out.println("Dry as a Bone...");
            } else {
                System.out.println(res + sum);
            }
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sasha().run();
    }
}
