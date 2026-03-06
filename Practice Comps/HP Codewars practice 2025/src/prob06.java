import java.util.*;
import java.io.*;

public class prob06{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob06".toLowerCase()+".in.txt"));
        int[] worths = {8,4,2,1};
        int times=f.nextInt(); f.nextLine();
        while(times-->0) {
            String[] ln = f.nextLine().split(" ");
            boolean[] working = new boolean[ln.length];
            for (int i = 0; i < ln.length; i++) {
                if (ln[i].equals("WORKING")) {
                    working[i] = true;
                } else {
                    working[i] = false;
                }
            }
            int tot = 0;
            for (int i = 0; i < working.length; i++) {
                if (!working[i]) {
                    tot += worths[i];
                }
            }
            int right = tot / 4;
            int left = tot % 4;
            String[] colors = {"off", "red", "green", "blue"};
            String r = colors[right];
            String l = colors[left];
            System.out.println(r + " " + l);
        }

        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new prob06().run();
    }
}
