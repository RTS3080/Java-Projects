import java.util.*;
import java.io.*;
import java.awt.*;

public class mole{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("mole".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        int[][] vals = new int[times][3];
        for (int i = 0; i < times; i++) {
            f.next();
            vals[i][0] = f.nextInt();
            vals[i][1] = f.nextInt();
            vals[i][2] = f.nextInt();

        }

        String[] str = "HEIGHT WEIGHT LIFTED".split(" ");
        System.out.println("--------------------");
        System.out.println("|      |MIN|MAX|AVG|");
        for (int i = 0; i < 3; i++) {
            int min = Integer.MAX_VALUE;
            int max = -1;
            int avg = 0;
            for(int j= 0; j < vals.length; j++){
                int val = vals[j][i];
                if(val < min) min = val;
                if(val > max) max = val;
                avg += val;
            }
            avg/=times;
            System.out.printf("|%s|%d|%d|%d|\n", str[i], min, max, avg);
        }
        System.out.println("--------------------");

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new mole().run();
    }
}
