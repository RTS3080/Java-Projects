import java.util.*;
import java.io.*;

public class jason{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("jason".toLowerCase()+".dat"));

        String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] daysPerMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] avgRainFall = new int[12];

        int max = 0;
        for (int i = 0; i < 12; i++) {
            double tot = 0;
            for (int j = 0; j < daysPerMonth[i]; j++) {
                tot += f.nextDouble();
            }
            avgRainFall[i] = (int) Math.round(tot / daysPerMonth[i]);
            max = Math.max(max, avgRainFall[i]);
        }

        char[][] hist = new char[max][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < avgRainFall[i]; j++) {
                hist[j][i] = '*';
            }
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 12; j++) {
                if (hist[i][j] != '*') hist[i][j] = ' ';
            }
        }

        for (int i = max - 1; i >= 0; i--) {
            String str = " ";
            for (int j = 0; j < 12; j++) {
                str += ("" + hist[i][j]).repeat(5) + " ";
            }
            System.out.println(str);
        }

        System.out.println(" " + Arrays.toString(months).replaceAll("\\s+", "").replaceAll("\\W", " ").trim().replaceAll(" ", "   "));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new jason().run();
    }
}
