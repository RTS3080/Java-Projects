import java.util.*;
import java.io.*;
import java.awt.*;

public class kate{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("kate".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine().trim()+" ";
            ln = ln.replaceAll("x ", "x^1 ");
            String[] split= ln.split(" ");
            ln = "";
            for(String s : split){
                if(s.matches("\\d+(.\\d*)?")){
                    s = s+"x^0";
                }
                ln+=s+" ";
            }
            ln = ln.replaceAll(" ", "");
            String[] nums = ln.split("(?=[+\\-])");

            double[][] n = new double[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                String[] sp = nums[i].split("x\\^");
                n[i][0] = Double.parseDouble(sp[0]);
                n[i][1] = Double.parseDouble(sp[1]);
//                System.out.println(n[i][0]+" "+n[i][1]);
            }
            double start = f.nextDouble();
            double end = f.nextDouble();
            double step = f.nextDouble(); f.nextLine();
            double area = 0;
            for(double d = start; d<end; d+=step){
                for (int i = 0; i < n.length; i++) {
                    double y = n[i][0] * Math.pow(d, n[i][1]);
                    area+=y*step;
                }
//                System.out.println(area+" "+d);
            }
            System.out.printf("%.2f\n", area);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new kate().run();
    }
}
