import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;
import java.io.*;

public class nightcrawler{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("nightcrawler".toLowerCase()+".dat"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String[] coords = f.nextLine().trim().split("\\s+");
            double max = 0;

            for (int i = 0; i < coords.length - 1; i++) {
                String[] c1 = coords[i].replaceAll("[()]", "").split(",");
                double x1 = Double.parseDouble(c1[0]);
                double y1 = Double.parseDouble(c1[1]);

                for (int j = i + 1; j < coords.length; j++) {
                    String[] c2 = coords[j].replaceAll("[()]", "").split(",");
                    double x2 = Double.parseDouble(c2[0]);
                    double y2 = Double.parseDouble(c2[1]);

                    double dx = x1 - x2;
                    double dy = y1 - y2;

                    double dist = dx * dx + dy * dy;
                    max = Math.max(max, dist);
                }
            }

            System.out.printf("%.2f%n", Math.sqrt(max));
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new nightcrawler().run();
    }
}
