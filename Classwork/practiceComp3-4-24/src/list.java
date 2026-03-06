import java.util.*;
import java.io.*;

public class list{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("list".toLowerCase()+".dat"));

        int times = f.nextInt();
        while (times-- > 0) {
            int store = f.nextInt();
            int list = f.nextInt();
            f.nextLine();
            HashMap<String, double[]> map = new HashMap<>();
            for (int i = 0; i < store; i++) {
                double[] obj = new double[2];
                String[] tmp = f.nextLine().trim().split(",\\s*");
                obj[0] = Integer.parseInt(tmp[1]);
                obj[1] = Double.parseDouble(tmp[2]);
                map.put(tmp[0], obj);
            }

            double cost = 0;
            for (int i = 0; i < list; i++) {
                String[] tmp = f.nextLine().trim().split(",\\s*");
                String key = tmp[0];
                double amt = Integer.parseInt(tmp[1]);
                cost += Math.ceil(amt / map.get(key)[0]) * map.get(key)[1];
            }
            System.out.printf("Joe's trip to the store costs him $%.2f%n", cost + (cost * .0625));
        }

        f.close();
    }
}
