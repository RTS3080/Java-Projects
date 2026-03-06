import java.util.*;
import java.io.*;

public class gan{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("gan.dat"));
        final double pi = Math.PI;
        double[] ln = Arrays.stream(f.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
//        ln[0] = 100;
        double[][] nums = new double[ln.length][4];
        for (int i = 0; i < ln.length; i++) {
            nums[i][0] = 2 * pi * ln[i];
            nums[i][1] = pi*ln[i]*ln[i];
            nums[i][2] = pi*ln[i]*ln[i]*4;
            nums[i][3] = pi*ln[i]*ln[i]*ln[i]*4/3.;
        }
        System.out.println("-".repeat(38));
        for (int i = 0; i < ln.length; i++) {
            System.out.printf("%2d %8.1f % 8.1f % 8.1f %8.1f\n", (int)ln[i], nums[i][0], nums[i][1], nums[i][2], nums[i][3]);
        }
        System.out.println("-".repeat(38));

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new gan().run();
    }
}
