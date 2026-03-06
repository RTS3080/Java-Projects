import java.util.*;
import java.io.*;

public class cynthia{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("cynthia".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            double a = f.nextDouble();
            double b = f.nextDouble();
            double c = f.nextDouble();
            ArrayList<Double> nums = new ArrayList<>();
            double one =((a+b)/2)*c;
            double two = ((a+c)/2)*b;
            double three = ((c+b)/2)*a;

            double max = Math.max(one, two);
            max = Math.max(max, three);
            System.out.printf("%,.2f\n", max);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new cynthia().run();
    }
}
